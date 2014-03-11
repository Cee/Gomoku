package gomoku.netgame;

import gomoku.constants.Constants;
import gomoku.gamepanel.DialogCreator;
import gomoku.language.Language;
import gomoku.main.Gomoku;
import gomoku.netgame.GomokuServer.RuleThread;
import gomoku.netgame.NetGamePanel.CheckThread;
import gomoku.netgame.NetGamePanel.GiveupThread;
import gomoku.netgame.NetGamePanel.RetractThread;
import gomoku.netgame.NetGamePanel.WaitingThread;
import gomoku.sound.Media;
import gomoku.sound.Sound;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
public class GomokuClient extends NetGamePanel  {
	private static final long serialVersionUID = 1L;
	private String host="localhost";
	int ifRetract = 0;
	public GomokuClient(String ipString) {	
		host = ipString;
		myplayer=2;
		otherplayer=1;
		jbtStart.addMouseListener(new StartListener());
		jbtReturn.addMouseListener(new ReturnListener());
		jbtRetract.addMouseListener(new RetractListener());
		jbtGiveup.addMouseListener(new GiveupListener());
		jbtReview.addMouseListener(new ReviewListener());
		jbtNext.addMouseListener(new NextListener());
		jbtLast.addMouseListener(new LastListener());
		jbtAnimation.addMouseListener(new AnimationListener());
		jbtExit.addMouseListener(new ExitListener());
		guiboard.addBG();
		connectToServer();
		new ChatThread().start();
	}
	class CheckThread extends Thread {
		public void run() {
			while (!guiboard.isWin){
				try {
					sleep(200);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			jbtStart.setEnabled(true);
			jbtRetract.setEnabled(false);
			jbtGiveup.setEnabled(false);
			jbtReview.setEnabled(true);
		}
	}
	class StartListener implements MouseListener {

			
		int x = jbtStart.getX();
		int y = jbtStart.getY();

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtStart.isEnabled()){
				Media.playSound(Sound.gamechoose);

				try {
					socket.getOutputStream().write(1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				GameTime++;
				chessBoard.initial();
				guiboard.renew();			
				firstplayer=1;
				jbtStart.setEnabled(false);
				jbtGiveup.setEnabled(true);
				jbtReview.setEnabled(false);
				new RuleThread().start();
				new CheckThread().start();
				new RetractThread().start();
				new GiveupThread().start();
			}
			else {
				Media.playSound(Sound.enable);
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			jbtStart.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtStart.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtStart.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtStart.setLocation(x,y);
			
		}	
	}	
	public void connectToServer() {
		try {
			socket = new Socket(host,7676);
			retractSocket = new Socket(host,7677);
			giveupSocket= new Socket(host,7678);
			chatSocket = new Socket(host,7679);
		} catch (Exception e) {
			DialogCreator.oneButtonDialog("Error", "IP错误或者主机未建立");
			Gomoku.menuPanel.setVisible(true);
			this.setVisible(false);
		}		
	}
	class RuleThread extends Thread{
		int Model;
		public void run() {
			try {
				firstplayer=socket.getInputStream().read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (firstplayer==1) {
				while (guiboard.step<=3) {
					try {
						sleep(100);
						int row, column;
					    row = socket.getInputStream().read();
					    column = socket.getInputStream().read();
						guiboard.SetIcon(new Integer[]{row,column,guiboard.color});
						guiboard.check(row, column);
					    guiboard.step++;	
					} catch (InterruptedException | IOException e) {
						e.printStackTrace();
					}
				}
				String Select=player2.choose();
				if (Select.equals(Language.DOMORE)){
				    guiboard.isClicked=false;
					try {
						socket.getOutputStream().write(0);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					guiboard.AddListener();
					while (guiboard.step<=5) {
						try {
							sleep(100);
							if (guiboard.isClicked){
								System.out.println(guiboard.step);
								socket.getOutputStream().write(guiboard.SendRow);
								socket.getOutputStream().write(guiboard.SendColumn);
								guiboard.isClicked=false;
							}
						   
						} catch (InterruptedException | IOException e) {
							e.printStackTrace();
						}
					}
					try {
						otherColor=socket.getInputStream().read();
						myColor=socket.getInputStream().read();
						guiboard.activeplayer=socket.getInputStream().read();
						startThread();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if (Select.equals(Language.CHOOSEBLACK)){
					try {
						socket.getOutputStream().write(1);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					myColor=Constants.BLACK;
					otherColor=Constants.WHITE;
					try {
						socket.getOutputStream().write(myColor);
						socket.getOutputStream().write(otherColor);
						guiboard.activeplayer=1;
						socket.getOutputStream().write(guiboard.activeplayer);
					} catch (IOException e) {
						e.printStackTrace();
					}
					startThread();
				}
				else if (Select.equals(Language.CHOOSEWHITE)){
					try {
						socket.getOutputStream().write(1);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					myColor=Constants.WHITE;
					otherColor=Constants.BLACK;
					try {
						socket.getOutputStream().write(myColor);
						socket.getOutputStream().write(otherColor);
						guiboard.activeplayer=2;
						socket.getOutputStream().write(guiboard.activeplayer);
					} catch (IOException e) {
						e.printStackTrace();
					}
					startThread();
				}
			} else if (firstplayer==2){
				guiboard.AddListener();
				while (guiboard.step<=3) {
					try {
						sleep(100);
						if (guiboard.isClicked) {
							socket.getOutputStream().write(guiboard.SendRow);
							socket.getOutputStream().write(guiboard.SendColumn);
							guiboard.isClicked=false;
						}
					} catch (InterruptedException | IOException e) {
						e.printStackTrace();
					}
				}
			 try {
				Model=socket.getInputStream().read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 if (Model==0) {
					while (guiboard.step<=5) {
						try {
							sleep(100);
							int row, column;
						    row = socket.getInputStream().read();
						    column = socket.getInputStream().read();
							guiboard.SetIcon(new Integer[]{row,column,guiboard.color});
							guiboard.check(row, column);
						    guiboard.step++;				
						} catch (InterruptedException | IOException e) {
							e.printStackTrace();
						}
					}
					String Select = player2.chooseagain();
					if (Select.equals(Language.CHOOSEBLACK)) {
						myColor=Constants.BLACK;
						otherColor=Constants.WHITE;
						try {
							socket.getOutputStream().write(myColor);
							socket.getOutputStream().write(otherColor);
							guiboard.activeplayer=1;
							socket.getOutputStream().write(guiboard.activeplayer);

						} catch (IOException e) {
							e.printStackTrace();
						}

						startThread();
					} else if (Select.equals(Language.CHOOSEWHITE)) {
						myColor=Constants.WHITE;
						otherColor=Constants.BLACK;
						try {
							socket.getOutputStream().write(myColor);
							socket.getOutputStream().write(otherColor);
							guiboard.activeplayer=2;
							socket.getOutputStream().write(guiboard.activeplayer);
							

						} catch (IOException e) {
							e.printStackTrace();
						}

						startThread();
					}
			 }else if(Model==1) {
					try {
						otherColor=socket.getInputStream().read();
						myColor=socket.getInputStream().read();
						guiboard.activeplayer=socket.getInputStream().read();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					startThread();
				}
			 
			}
			new TimeThread().start();
			ImageIcon player1 = new ImageIcon(myColor==Constants.BLACK?Language.BLACK:Language.WHITE);
			ImageIcon player2 = new ImageIcon(myColor==Constants.WHITE?Language.BLACK:Language.WHITE);
			jlbPlayer1.setIcon(player1);
			jlbPlayer2.setIcon(player2);
		}
	}
	public void startThread() {
		new NetThread(this).start();
		new RemindThread().start();

	}
	
}

