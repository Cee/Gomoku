package gomoku.netgame;

import gomoku.chesshandle.ChessBoard;
import gomoku.chesshandle.ReviewHandle;
import gomoku.gamepanel.DialogCreator;
import gomoku.language.Language;
import gomoku.main.Gomoku;
import gomoku.option.newOptionPanel;
import gomoku.player.HumanPlayer;
import gomoku.sound.Media;
import gomoku.sound.Sound;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.Reader;

import javax.naming.ldap.HasControls;
import javax.swing.JOptionPane;

public class NetGamePanel extends NetUIPanel{
	private static final long serialVersionUID = 1L;
	protected boolean myTurn ;
	protected int myColor ;
	protected int otherColor ;
	protected ChessBoard chessBoard = new ChessBoard();
	protected int rowSelected;
	protected int columnSelected;
	protected boolean continueToPlay = true;
	protected boolean waiting ;
	protected int myplayer;
	protected int otherplayer;	
	protected int firstplayer=1;
	int hasClient = 0;

	int ifRetract = 0;
	int time = 180;
	int GameTime=0;
	protected HumanPlayer player1 = new HumanPlayer("玩家1");
	protected HumanPlayer player2 = new HumanPlayer("玩家2");
	ReviewHandle reviewHandle = new ReviewHandle();
	public void exit(){
		guiboard.isWin=true;
		this.setVisible(false);
		Gomoku.menuPanel.setVisible(true);
		guiboard.color=1;
	}
	class ExitListener implements MouseListener {
		int x = jbtExit.getX();
		int y = jbtExit.getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.goback);

			System.exit(0);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtExit.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtExit.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtExit.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtExit.setLocation(x,y);
			
		}
	}
	class ReturnListener implements MouseListener {
		int x = jbtReturn.getX();
		int y = jbtReturn.getY();

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtReturn.isEnabled()){
				Media.playSound(Sound.goback);
				exit();				
			}
			else {
				Media.playSound(Sound.enable);
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtReturn.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtReturn.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtReturn.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtReturn.setLocation(x,y);
			
		}	
	}
	class GiveupListener implements MouseListener {

		int x = jbtGiveup.getX();
		int y = jbtGiveup.getY();

		@Override
		public void mouseClicked(MouseEvent event) {
			if (jbtGiveup.isEnabled()){
				Media.playSound(Sound.gamechoose);

				DialogCreator.oneButtonDialog(Language.LaoCao,Language.DontGiveUp);
				//int n = JOptionPane.showConfirmDialog(null, Language.MakeSureToGiveUp, Language.GiveUpTitle, JOptionPane.YES_NO_OPTION);
				int n;
				n = DialogCreator.twoButtonDialog(Language.GiveUpTitle, Language.MakeSureToGiveUp, Language.OK, Language.CANCEL);
				if (n == 2) {
					//JOptionPane.showConfirmDialog(null, Language.PraiseSentence, Language.Praise, JOptionPane.DEFAULT_OPTION);
					DialogCreator.oneButtonDialog(Language.Praise, Language.PraiseSentence);
				} else {
					try {
						giveupSocket.getOutputStream().write(1);
					} catch (IOException e) {
						e.printStackTrace();
					}//JOptionPane.showConfirmDialog(null, Language.Disappointment+Language.PLAYER+guiboard.activeplayer+Language.GiveUpTitle, Language.BadPhenomenon, JOptionPane.DEFAULT_OPTION);
					DialogCreator.oneButtonDialog(Language.BadPhenomenon, Language.Disappointment+Language.PLAYER+guiboard.activeplayer+Language.GiveUpTitle);
					guiboard.changeplayer();
					guiboard.isWin=true;
					guiboard.removeListener();
					
					guiboard.removeListener();
				}	
			}
			else {
				Media.playSound(Sound.enable);
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtGiveup.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtGiveup.setLocation(x-2,y-2);

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtGiveup.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtGiveup.setLocation(x,y);
			
		}
	}
	class GiveupThread extends Thread {
		public void run() {
			try {
				giveupSocket.getInputStream().read();
			} catch (IOException e) {
				DialogCreator.oneButtonDialog("Sorry","断开连接,请点击返回");
				guiboard.activeplayer=myplayer;
			}		
			guiboard.isWin=true;
			guiboard.removeListener();
			DialogCreator.oneButtonDialog("Winner！", guiboard.color==1?Language.BLACKWIN:Language.WHITEWIN);
		}
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
			hasClient=0;
			jbtStart.setEnabled(true);
			jbtRetract.setEnabled(false);
			jbtGiveup.setEnabled(false);
			jbtReview.setEnabled(true);
			new WaitingThread().start();
		}
	}
	class WaitingThread extends Thread {
		public void run() {
			while (hasClient == 0) {
				try {
					hasClient = socket.getInputStream().read();
				} catch (IOException e) {
					break;
				}
				DialogCreator.oneButtonDialog("已准备", "玩家已准备就绪");
			}
		}
	}
	class RetractListener implements MouseListener {
		
		int x = jbtRetract.getX();
		int y = jbtRetract.getY();
			
				
			

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtRetract.isEnabled()){
				if (guiboard.Retractable) {
					Media.playSound(Sound.gamechoose);

					try {
						guiboard.Retractable=false;
						retractSocket.getOutputStream().write(3);
						System.out.println("传出去了");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		
				}	
			}
			else {
				Media.playSound(Sound.enable);
			}
			
		}	

		@Override
		public void mousePressed(MouseEvent e) {
			jbtRetract.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtRetract.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtRetract.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtRetract.setLocation(x,y);
			
		}	
	}
	class RetractThread extends Thread {
		public void run() {
			while (!guiboard.isWin) {
				if (!guiboard.Retractable) {
					jbtRetract.setEnabled(false);
				} else {
					jbtRetract.setEnabled(true);
				}
				try {
					ifRetract=retractSocket.getInputStream().read();
				} catch (IOException e) {
					break;
				}
				if (ifRetract==3) {
					int canRetract=DialogCreator.twoButtonDialog("悔棋", "对方要求悔棋！", "OK", "没门！", 1);
					if (canRetract==1){

						try {
							retractSocket.getOutputStream().write(1);
						} catch (IOException e) {
							e.printStackTrace();
						}
						int historysize = guiboard.getHistory().size();
						Integer temp[] = guiboard.getHistory().get(historysize-1);
						guiboard.netunset();					
							guiboard.SendRow=temp[0];
							guiboard.SendColumn=temp[1];
							guiboard.isClicked=true;
							guiboard.changecolor();
					} else if (canRetract==2){
						try {
							retractSocket.getOutputStream().write(0);
						} catch (IOException e) {
							break;
						}
					}

				}else if (ifRetract==1){
						DialogCreator.oneButtonDialog("Congratulations", "对方同意悔棋");
						guiboard.netunset();
				}else  if (ifRetract==0){
					DialogCreator.oneButtonDialog("Sorry", "对方拒绝悔棋");
				}
			}
		}
	}
	/**
	 * 
	 * @author luck
	 *@version 2013.3.30
	 * 复盘监听
	 */
	public class ReviewListener implements MouseListener {
		int x =jbtReview.getX();
		int y = jbtReview.getY();

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtReview.isEnabled()){
				Media.playSound(Sound.gamechoose);

				Reviewpanel.setVisible(true);
				guiboard.refresh();
				guiboard.removeListener();		
			}
			else {
				Media.playSound(Sound.enable);
			}
						
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtReview.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtReview.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtReview.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtReview.setLocation(x,y);
			
		}
		
	}
	public class NextListener implements MouseListener {
		int x = jbtNext.getX();
		int y = jbtNext.getY();
		

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtNext.isEnabled()){
				Media.playSound(Sound.gamechoose);

				Integer temp[] = reviewHandle.next(guiboard.getHistory());
				if (temp != null) {
					guiboard.SetIcon(temp);
				}			
			}
			else {
				Media.playSound(Sound.enable);
			}
					
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtNext.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtNext.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtNext.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtNext.setLocation(x,y);
			
		}	
	
	}
	/**
	 * 
	 * @author luck
	 *@version 2013.3.30
	 * 锟斤拷一锟斤拷
	 */
	public class LastListener implements MouseListener {
		int x = jbtLast.getX();
		int y = jbtLast.getY();

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtLast.isEnabled()){
				Media.playSound(Sound.gamechoose);

				Integer temp[] = reviewHandle.last(guiboard.getHistory());
				if (temp != null) {
					guiboard.removeIcon(temp);
				}				
			}
			else {
				Media.playSound(Sound.enable);
			}
			
		}


		@Override
		public void mousePressed(MouseEvent e) {
			jbtLast.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtLast.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtLast.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtLast.setLocation(x,y);
			
		}	
	}
	class ChatThread extends Thread{
		public void run(){
			
				InputStreamReader streamReader;
				while (true){
					try {
						streamReader = new InputStreamReader(chatSocket.getInputStream());					
						BufferedReader reader = new BufferedReader(streamReader);
						String eachline;
						while ((eachline=reader.readLine())!=null){
							new BarrageThread(eachline).start();	
						}
//						eachline=reader.readLine();
						
						
					} catch (IOException e) {
						break;
					}	
				}
		}
	}
	/**
	 * 
	 * @author luck
	 *@version 2013.3.30
	 * 锟斤拷锟斤拷
	 */
	public class AnimationListener implements MouseListener {
		int x = jbtAnimation.getX();
		int y = jbtAnimation.getY();
		class ReviewThread extends Thread {
			public void run() {
				
				int size = guiboard.getHistory().size();
				for (int i = 0; i < size; i++) {
					try {
						Integer temp[] = reviewHandle.next(guiboard.getHistory());
						if (temp != null) {
							guiboard.SetIcon(temp);
						}

						Thread.sleep(500);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				jbtAnimation.setEnabled(true);
				jbtNext.setEnabled(true);
				jbtLast.setEnabled(true);
			}
		}
		@Override
		
		public void mouseClicked(MouseEvent e) {
			if(jbtAnimation.isEnabled()){
				Media.playSound(Sound.gamechoose);

				guiboard.refresh();
				reviewHandle.setSequence(0);
				jbtNext.setEnabled(false);
				jbtLast.setEnabled(false);
				jbtAnimation.setEnabled(false);
				new ReviewThread().start();	
			}
			else {
				Media.playSound(Sound.enable);
			}
			
						
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtAnimation.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtAnimation.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtAnimation.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtAnimation.setLocation(x,y);
			
		}	
	}			
		/**
		 * 
		 * @author luck
		 * 用于计时的线程
		 */
		class TimeThread extends Thread {
			public void run() {
				int gameTime = GameTime;
				int totaltime = time;
				int number1=0;
				int number2=0;	
				while (!guiboard.isWin) {
					while (guiboard.activeplayer == 1) {
						jlbClock1.setText(time+"");
						while (guiboard.activeplayer == 1 ) {
							jlbClock1.setText(totaltime+"");
							try {
								sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							number1++;
							if (number1%10==0){
								totaltime--;
							}
							if (totaltime<=0) {
								guiboard.changeplayer();
								guiboard.changecolor();
								guiboard.isWin=true;
								DialogCreator.oneButtonDialog(null, guiboard.color==1?Language.BLACKWIN:Language.WHITEWIN);
							}
							if (gameTime!=GameTime){
								break;
							}	
						}
						if (gameTime!=GameTime){
							break;
						}
					}
					totaltime=time;
					jlbClock1.setText(time+"");
					
					if (gameTime!=GameTime){
						break;
					}
						
					
					while (guiboard.activeplayer ==2) {
						jlbClock2.setText(time+"");
						while (guiboard.activeplayer == 2 ) {
							jlbClock2.setText(totaltime+"");
							try {
								sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							number2++;
							if (number2%10==0){
								totaltime--;
								
							}
							if (number2<=0) {
								guiboard.changeplayer();
								guiboard.changecolor();
								guiboard.isWin=true;
								DialogCreator.oneButtonDialog(null, guiboard.color==1?Language.BLACKWIN:Language.WHITEWIN);
							}
							if (gameTime!=GameTime){
								break;
							}
						}
						if (gameTime!=GameTime){
							break;
						}
						
					}
					jlbClock2.setText(time+"");
					totaltime=time;
				}
			}
		}
		class RemindThread extends Thread {
			public void run() {
				Integer[] temp = null;
				while (!guiboard.isWin&&guiboard.getHistory().size()>0) {
					temp = guiboard.getHistory().get(guiboard.getHistory().size()-1);
					guiboard.SetIcon(temp);
					try {
						sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					guiboard.removeIcon(temp);
					try {
						sleep(500);
					} catch (InterruptedException e) {
						// TODO 锟皆讹拷锟斤拷傻锟�catch 锟斤拷
						e.printStackTrace();
					}
					if (guiboard.flag[temp[0]][temp[1]]==1) {
						guiboard.SetIcon(temp);
					}
				}
				
			}
		}
}
