package gomoku.netgame;

import gomoku.constants.Constants;
import gomoku.language.Language;
import gomoku.option.Set;
import gomoku.sound.Media;
import gomoku.theme.Theme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.xml.soap.Text;

public class NetUIPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	protected JButton jbtReturn;
	protected JButton jbtStart;
	protected JButton jbtRetract;
	protected JButton jbtReview;
	protected JButton jbtGiveup;
	protected JButton jbtNext;
	protected JButton jbtLast;
	protected JButton jbtExit;
	protected JButton jbtAnimation;
	protected JLabel gameBgLabel;
	protected JPanel Reviewpanel;
	protected JPanel MenuPanel;
	protected JPanel shellPanel;
	protected JLabel jlbShell1;
	protected JLabel jlbShell2;
	protected JLabel jlbClock1;
	protected JLabel jlbClock2;

	protected JLabel jlbPlayer1;
	protected JLabel jlbPlayer2;
	protected JLabel bgmController;
	protected boolean hasMusic = true;
	protected JLabel chatLabel[] = new JLabel[1000];
	protected int chatNumber=0;
	protected JTextArea chatContentArea = new JTextArea();
	
	protected JButton jbtChat = new JButton();
	Socket socket;
	Socket retractSocket;
	Socket giveupSocket;
	Socket chatSocket;
	NetGuiBoard guiboard = new NetGuiBoard(socket, retractSocket);
	
	/**
	 * @author luck
	 * @version 2013.4.2 15:26 特殊版本的UI 有待修改
	 */
	public NetUIPanel() {
		this.setLayout(null);
		chatContentArea.setBounds(300,10,200,20);
		chatContentArea.addKeyListener(new ContentAreaListener());	
		this.add(chatContentArea);		
		ImageIcon chatIcon = new ImageIcon(Theme.chat);
		jbtChat.setIcon(chatIcon);
		jbtChat.setOpaque(false);
		jbtChat.setContentAreaFilled(false);
		jbtChat.setFocusPainted(false);
		jbtChat.setBorderPainted(false);
		jbtChat.setBounds(500,10,chatIcon.getIconWidth(),chatIcon.getIconHeight());
		this.add(jbtChat);
		jbtChat.addActionListener(new ChatListener());
		for (int i = 0; i < 1000 ; i ++) {
			chatLabel[i]= new JLabel();
			chatLabel[i].setFont(new Font(Theme.themeFont,Font.BOLD, 30));
			
			if (Theme.theme.equals("Donuts")){
				int r = (int)(Math.random()*255);
				int g = (int)(Math.random()*255);
				int b = (int)(Math.random()*255);
				chatLabel[i].setForeground(new Color(r,g,b));
			} else {
				chatLabel[i].setForeground(Theme.themeColor);	
			}
			int x= (int) (800-Math.random()*200);
			int y = (int)(Math.random()*600);
			chatLabel[i].setBounds(x,y,1000,200);
			chatLabel[i].setOpaque(false);
			this.add(chatLabel[i]);
		}
		ImageIcon bgmIcon = new ImageIcon(Theme.musicOff);
		if (!Constants.hasMusic){
			bgmIcon= new ImageIcon(Theme.musicOn);
		}
		bgmController = new JLabel(bgmIcon);
		bgmController.setBounds(0, 0, bgmIcon.getIconWidth(), bgmIcon.getIconHeight());
		this.add(bgmController);
		bgmController.addMouseListener(new bgmControllerListener());
		ImageIcon gameBg = new ImageIcon(Theme.gamebg);
		gameBgLabel = new JLabel(gameBg);
		gameBgLabel.setBounds(0, 0, gameBg.getIconWidth(),
				gameBg.getIconHeight());
		MenuPanel = new JPanel();
		MenuPanel.setLayout(null);
		MenuPanel.setBounds(30, 530, 800, 200);

		ImageIcon startIcon = new ImageIcon(Language.START);
		jbtStart = new JButton(startIcon);
		jbtStart.setBounds(0, 0, startIcon.getIconWidth(),
				startIcon.getIconHeight());
		jbtStart.setContentAreaFilled(false);
		jbtStart.setBorderPainted(false);
		MenuPanel.add(jbtStart);

		ImageIcon giveUpIcon = new ImageIcon(Language.GIVEUP);
		jbtGiveup = new JButton(giveUpIcon);
		jbtGiveup.setBounds(130, 0, giveUpIcon.getIconWidth(),
				giveUpIcon.getIconHeight());
		jbtGiveup.setContentAreaFilled(false);
		jbtGiveup.setBorderPainted(false);
		MenuPanel.add(jbtGiveup);
		jbtGiveup.setEnabled(false);

		ImageIcon retractIcon = new ImageIcon(Language.RETRACT);
		jbtRetract = new JButton(retractIcon);
		jbtRetract.setBounds(260, 0, retractIcon.getIconWidth(),
				retractIcon.getIconHeight());
		jbtRetract.setEnabled(false);
		jbtRetract.setContentAreaFilled(false);
		jbtRetract.setBorderPainted(false);
		MenuPanel.add(jbtRetract);

		ImageIcon reviewIcon = new ImageIcon(Language.REVIEW);
		jbtReview = new JButton(reviewIcon);
		jbtReview.setBounds(390, 0, reviewIcon.getIconWidth(),
				reviewIcon.getIconHeight());
		jbtReview.setEnabled(false);
		jbtReview.setContentAreaFilled(false);
		jbtReview.setBorderPainted(false);
		MenuPanel.add(jbtReview);

		ImageIcon returnIcon = new ImageIcon(Language.RETURN);
		jbtReturn = new JButton(returnIcon);
		jbtReturn.setBounds(520, 0, returnIcon.getIconWidth(),
				returnIcon.getIconHeight());
		jbtReturn.setContentAreaFilled(false);
		jbtReturn.setBorderPainted(false);
		MenuPanel.add(jbtReturn);

		ImageIcon exitIcon = new ImageIcon(Language.EXIT);
		jbtExit = new JButton(exitIcon);
		jbtExit.setBounds(650, 0, exitIcon.getIconWidth(),
				exitIcon.getIconHeight());
		jbtExit.setContentAreaFilled(false);
		jbtExit.setBorderPainted(false);
		MenuPanel.add(jbtExit);

		Reviewpanel = new JPanel();
		Reviewpanel.setLayout(null);
		Reviewpanel.setOpaque(false);
		Reviewpanel.setBounds(690, 0, 200, 600);
		this.add(Reviewpanel);

		ImageIcon nextIcon = new ImageIcon(Language.NEXT);
		jbtNext = new JButton(nextIcon);
		jbtNext.setSize(nextIcon.getIconWidth(), nextIcon.getIconHeight());
		jbtNext.setLocation(0, 60);
		jbtNext.setContentAreaFilled(false);
		jbtNext.setBorderPainted(false);
		jbtNext.setFocusPainted(false);
		Reviewpanel.add(jbtNext);

		ImageIcon lastIcon = new ImageIcon(Language.LAST);
		jbtLast = new JButton(Language.LAST);
		jbtLast = new JButton(lastIcon);
		jbtLast.setSize(lastIcon.getIconWidth(), lastIcon.getIconHeight());
		jbtLast.setLocation(0, 0);
		jbtLast.setContentAreaFilled(false);
		jbtLast.setBorderPainted(false);
		jbtLast.setFocusPainted(false);
		Reviewpanel.add(jbtLast);
		Reviewpanel.setVisible(false);

		ImageIcon animationIcon = new ImageIcon(Language.ANIMATION);
		jbtAnimation = new JButton(animationIcon);
		jbtAnimation.setSize(lastIcon.getIconWidth(), lastIcon.getIconHeight());
		jbtAnimation.setLocation(0, 120);
		jbtAnimation.setContentAreaFilled(false);
		jbtAnimation.setBorderPainted(false);
		jbtAnimation.setFocusPainted(false);
		Reviewpanel.add(jbtAnimation);

		/*
		 * shellPanel
		 */
		shellPanel = new JPanel();
		shellPanel.setOpaque(false);
		shellPanel.setLayout(null);
		shellPanel.setBounds(0, 0, 800, 600);
		shellPanel.setVisible(true);
		this.add(shellPanel);

		/*
		 * PersonImage1
		 */
		ImageIcon whiteShell = new ImageIcon(Theme.whitePlayer);
		jlbShell1 = new JLabel();
		jlbShell1.setIcon(whiteShell);
		jlbShell1.setBounds(0, 200, 145, 415);
		shellPanel.add(jlbShell1);

		/*
		 * PersonImage2
		 */
		ImageIcon blackShell = new ImageIcon(Theme.blackPlayer);
		jlbShell2 = new JLabel();
		jlbShell2.setIcon(blackShell);
		jlbShell2.setBounds(650, 200, 145, 415);
		shellPanel.add(jlbShell2);

		/*
		 * clock1
		 */
		jlbClock1 = new JLabel();
		jlbClock1.setBounds(0, 100, 145, 100);
		jlbClock1.setFont(new Font(Theme.themeFont, Font.BOLD,
				Constants.FONTSIZEBIG));
		jlbClock1.setForeground(Color.GRAY);
		jlbClock1.setHorizontalAlignment(SwingConstants.CENTER);
		// jlbClock1.setOpaque(true);
		shellPanel.add(jlbClock1);

		/*
		 * clock2
		 */
		jlbClock2 = new JLabel();
		jlbClock2.setBounds(650, 100, 145, 100);
		jlbClock2.setFont(new Font(Theme.themeFont, Font.BOLD,
				Constants.FONTSIZEBIG));
		jlbClock2.setForeground(Theme.themeColor);
		jlbClock2.setHorizontalAlignment(SwingConstants.CENTER);
		// jlbClock2.setOpaque(true);
		shellPanel.add(jlbClock2);

		MenuPanel.setOpaque(false);
		this.add(MenuPanel);
		/*
		 * represent color
		 */

		jlbPlayer1 = new JLabel();
		jlbPlayer1.setBounds(0, 200, 145, 100);
		jlbPlayer1.setFont(new Font(Theme.themeFont, Font.BOLD,
				Constants.FONTSIZEBIG));
		jlbPlayer1.setForeground(Theme.themeColor);
		jlbPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		// jlbPlayer1.setOpaque(true);
		shellPanel.add(jlbPlayer1);

		jlbPlayer2 = new JLabel();
		jlbPlayer2.setBounds(650, 200, 145, 100);
		jlbPlayer2.setFont(new Font(Theme.themeFont, Font.BOLD,
				Constants.FONTSIZEBIG));
		jlbPlayer2.setForeground(Theme.themeColor);
		jlbPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		// jlbPlayer2.setOpaque(true);
		shellPanel.add(jlbPlayer2);

		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(200, 100));
		panel1.setOpaque(false);
		panel1.setBounds(0, 0, 100, 600);
		this.add(BorderLayout.WEST, panel1);
		guiboard.setOpaque(false);
		guiboard.setBounds(150, 50, 520, 520);
		this.add(guiboard);
		this.add(gameBgLabel);

		this.setOpaque(false);
	}
	class ChatListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (chatContentArea.getText()!=null){
				try {
					PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
					writer.println(chatContentArea.getText());
					writer.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				new BarrageThread(chatContentArea.getText()).start();
				chatContentArea.setText("");
				chatContentArea.requestFocus();
				
			}
			

		}
		
	}
	
	class ContentAreaListener implements KeyListener{
		public void keyTyped(KeyEvent e) {
			
		}

		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				if (chatContentArea.getText()!=null){
					try {
						PrintWriter writer = new PrintWriter(chatSocket.getOutputStream());
						writer.println(chatContentArea.getText());
						writer.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					new BarrageThread(chatContentArea.getText()).start();
					chatContentArea.setText("");
					chatContentArea.requestFocus();
				}
			}
		}

		public void keyReleased(KeyEvent e) {
			
		}
		
	}
	class BarrageThread extends Thread{
		String contentString;
		public BarrageThread(String contentString){
			this.contentString=contentString;
		}
		public void run(){
			chatNumber++;
			int currentNumber=chatNumber;
			chatLabel[currentNumber].setText(contentString);
			int move=0;
			int x = chatLabel[currentNumber].getX();
			int y = chatLabel[currentNumber].getY();
			while (true) {
				try {
					sleep(25);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				chatLabel[currentNumber].setLocation(x-move,y);
				move=move+5;
			}
		}
	}
	class bgmControllerListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (Constants.hasMusic) {
				Constants.hasMusic = false;
				Media.stopBGM(Set.getBGM());
				bgmController.setIcon(new ImageIcon(Theme.musicOn));
			} else {
				Constants.hasMusic = true;
				Media.playBGM(Set.getBGM());
				bgmController.setIcon(new ImageIcon(Theme.musicOff));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	}
}
