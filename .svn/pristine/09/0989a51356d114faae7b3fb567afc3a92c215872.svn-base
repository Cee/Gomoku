package gomoku.netgame;

import gomoku.constants.Constants;
import gomoku.gamepanel.DialogCreator;
import gomoku.language.Language;
import gomoku.main.Start;
import gomoku.netgame.NetGamePanel.ExitListener;
import gomoku.netgame.NetGamePanel.RemindThread;
import gomoku.option.newOptionPanel;
import gomoku.sound.Media;
import gomoku.sound.Sound;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author luck
 * @version 2013.4.3 服务器建立
 */
public class GomokuServer extends NetGamePanel {
	private static final long serialVersionUID = 1L;
	boolean isLinked = false;
	JLabel jlbloading;
	ServerSocket serverSocket;
	ServerSocket retractServerSocket;
	ServerSocket giveupServerSocket;
	ServerSocket chatServerSocket;
	public GomokuServer() {
		myplayer = 1;
		otherplayer = 2;
		jbtStart.addMouseListener(new StartListener());
		jbtReturn.addMouseListener(new ReturnListener());
		jbtRetract.addMouseListener(new RetractListener());
		jbtGiveup.addMouseListener(new GiveupListener());
		jbtReview.addMouseListener(new ReviewListener());
		jbtNext.addMouseListener(new NextListener());
		jbtLast.addMouseListener(new LastListener());
		jbtAnimation.addMouseListener(new AnimationListener());
		jbtExit.addMouseListener(new ExitListener());
		firstplayer = 1;
		jbtGiveup.setEnabled(false);
		jbtReview.setEnabled(false);
		chessBoard.initial();
		guiboard.addBG();
		guiboard.renew();
	}

	public void link() {
		new LinkThread().start();
	}

	class LinkThread extends Thread {
		public void run() {
			try {
				serverSocket = new ServerSocket(7676);
				retractServerSocket = new ServerSocket(7677);
				giveupServerSocket = new ServerSocket(7678);
				chatServerSocket = new ServerSocket(7679);
				socket = serverSocket.accept();
				retractSocket = retractServerSocket.accept();
				giveupSocket = giveupServerSocket.accept();
				chatSocket = chatServerSocket.accept();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			isLinked = true;
			new ChatThread().start();
			new WaitingThread().start();
		}
	}



	class StartListener implements MouseListener {
		int x = jbtStart.getX();
		int y = jbtStart.getY();
		
		@Override
		public void mouseClicked(MouseEvent e) {

			if (jbtStart.isEnabled()) {
				Media.playSound(Sound.gamechoose);

				if (hasClient == 1) {
					hasClient = 0;
					GameTime++;
					chessBoard.initial();
					guiboard.renew();
					firstplayer = 1;
					jbtStart.setEnabled(false);
					jbtGiveup.setEnabled(true);
					new CheckThread().start();
					new RuleThread().start();
					new RetractThread().start();
					new GiveupThread().start();
				} else {
					DialogCreator.oneButtonDialog("等待", "另外一名玩家还未准备");

				}

			}
			else {
				Media.playSound(Sound.enable);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtStart.setLocation(x + 3, y + 3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtStart.setLocation(x - 2, y - 2);

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtStart.setLocation(x - 2, y - 2);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtStart.setLocation(x, y);

		}

	}

	class RuleThread extends Thread {
		int Model;

		public void run() {
			String[] Players = { player1.getName(), player2.getName() };
			String select = player1.choosefirst(Players);
			if (select.equals(player2.getName())) {
				firstplayer = 2;
			}
			try {
				socket.getOutputStream().write(firstplayer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (firstplayer == 1) {
				System.out.println("Add");
				guiboard.AddListener();
				while (guiboard.step <= 3) {
					try {
						sleep(100);
						if (guiboard.isClicked) {
							socket.getOutputStream().write(guiboard.SendRow);
							socket.getOutputStream().write(guiboard.SendColumn);
							guiboard.isClicked = false;
							System.out.println(guiboard.step);
						}
					} catch (InterruptedException | IOException e) {
						e.printStackTrace();
					}
				}
				guiboard.removeListener();
				try {
					Model = socket.getInputStream().read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (Model == 0) {
					while (guiboard.step <= 5) {
						try {
							sleep(100);
							int row, column;
							row = socket.getInputStream().read();
							column = socket.getInputStream().read();
							guiboard.SetIcon(new Integer[] { row, column,
									guiboard.color });
							guiboard.check(row, column);
							guiboard.step++;
							System.out.println(row + " " + column);

						} catch (InterruptedException | IOException e) {
							e.printStackTrace();
						}
					}
					String Select = player1.chooseagain();
					if (Select.equals(Language.CHOOSEBLACK)) {
						myColor = Constants.BLACK;
						otherColor = Constants.WHITE;
						try {
							socket.getOutputStream().write(myColor);
							socket.getOutputStream().write(otherColor);
							guiboard.activeplayer = 2;
							socket.getOutputStream().write(
									guiboard.activeplayer);
						} catch (IOException e) {
							e.printStackTrace();
						}
						startThread();
					} else if (Select.equals(Language.CHOOSEWHITE)) {
						myColor = Constants.WHITE;
						otherColor = Constants.BLACK;
						try {
							socket.getOutputStream().write(myColor);
							socket.getOutputStream().write(otherColor);
							guiboard.activeplayer = 1;
							socket.getOutputStream().write(
									guiboard.activeplayer);
						} catch (IOException e) {
							e.printStackTrace();
						}

						startThread();
					}
				} else if (Model == 1) {
					try {
						otherColor = socket.getInputStream().read();
						myColor = socket.getInputStream().read();
						guiboard.activeplayer = socket.getInputStream().read();
					} catch (IOException e) {
						e.printStackTrace();
					}
					startThread();
				}

			} else if (firstplayer == 2) {
				while (guiboard.step <= 3) {
					try {
						sleep(100);
						int row, column;
						row = socket.getInputStream().read();
						column = socket.getInputStream().read();

						guiboard.SetIcon(new Integer[] { row, column,
								guiboard.color });
						guiboard.check(row, column);
						guiboard.step++;
					} catch (InterruptedException | IOException e) {
						e.printStackTrace();
					}
				}
				String Select = player1.choose();
				if (Select.equals(Language.DOMORE)) {
					guiboard.isClicked = false;
					try {
						socket.getOutputStream().write(0);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					guiboard.AddListener();
					while (guiboard.step <= 5) {
						try {
							sleep(100);
							if (guiboard.isClicked) {
								socket.getOutputStream()
										.write(guiboard.SendRow);
								socket.getOutputStream().write(
										guiboard.SendColor);
								guiboard.isClicked = false;
							}

						} catch (InterruptedException | IOException e) {
							e.printStackTrace();
						}
					}
					try {
						otherColor = socket.getInputStream().read();
						myColor = socket.getInputStream().read();
						guiboard.activeplayer = socket.getInputStream().read();
						startThread();
					} catch (IOException e) {
						e.printStackTrace();
					}

				} else if (Select.equals(Language.CHOOSEBLACK)) {
					try {
						socket.getOutputStream().write(1);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					myColor = Constants.BLACK;
					otherColor = Constants.WHITE;
					try {
						socket.getOutputStream().write(myColor);
						socket.getOutputStream().write(otherColor);
						guiboard.activeplayer = 2;
						socket.getOutputStream().write(guiboard.activeplayer);
					} catch (IOException e) {
						e.printStackTrace();
					}
					startThread();
				} else if (Select.equals(Language.CHOOSEWHITE)) {
					try {
						socket.getOutputStream().write(1);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					myColor = Constants.WHITE;
					otherColor = Constants.BLACK;
					try {
						socket.getOutputStream().write(myColor);
						socket.getOutputStream().write(otherColor);
						guiboard.activeplayer = 1;
						socket.getOutputStream().write(guiboard.activeplayer);
					} catch (IOException e) {
						e.printStackTrace();
					}
					startThread();
				}
			}
			new TimeThread().start();
			ImageIcon player1 = new ImageIcon(
					myColor == Constants.BLACK ? Language.BLACK
							: Language.WHITE);
			ImageIcon player2 = new ImageIcon(
					myColor == Constants.WHITE ? Language.BLACK
							: Language.WHITE);
			jlbPlayer1.setIcon(player1);
			jlbPlayer2.setIcon(player2);
		}
	}

	public void startThread() {
		new NetThread(this).start();
		new RemindThread().start();

	}
}
