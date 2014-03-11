package gomoku.main;

import gomoku.animation.AnimationEffect;
import gomoku.career.CareerPanel;
import gomoku.constants.Constants;
import gomoku.gamepanel.DoubleGamePanel;
import gomoku.gamepanel.SingleGamePanel;
import gomoku.gamepanel.special.DisturbPanel;
import gomoku.gamepanel.special.DoubleMovablePanel;
import gomoku.gamepanel.special.SingleMovablePanel;
import gomoku.gamepanel.special.ThreePlayerGamePanel;
import gomoku.help.HelpPanel;
import gomoku.information.OurPanel;
import gomoku.language.Language;
import gomoku.netgame.GomokuServer;
import gomoku.netgame.NetGamePanel;
import gomoku.netgame.WaitingPanel;
import gomoku.option.newOptionPanel;
import gomoku.sound.Media;
import gomoku.sound.Sound;
import gomoku.theme.Theme;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author NorviNS & luck
 * @version 2013/4.1
 */
public class Gomoku extends JFrame {
	private static final long serialVersionUID = 1L;
	public static Menu menuPanel;
	public static Cursor cursor;

	JLabel openingJLabel;
	OpeningThread openingThread = new OpeningThread();
	JLabel bgLabel;
	boolean isadd = false;

	public Gomoku() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image cursorImage = Toolkit.getDefaultToolkit().getImage(Theme.arrow);
		cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage,
				new Point(0, 0), "mycursor");
		this.setCursor(cursor);
		ImageIcon openingIcon = new ImageIcon("png/opening.gif");
		openingJLabel = new JLabel(openingIcon);
		openingJLabel.setBounds(0, 0, openingIcon.getIconWidth(),
				openingIcon.getIconHeight());
		this.add(openingJLabel);
		

		this.setVisible(true);
		this.setSize(Constants.DEFAULT_WIDTH, Constants.DEFAULT_HEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle(Language.TITLE);
		menuPanel = new Menu();
		this.add(menuPanel);
		ImageIcon menuBg1 = new ImageIcon(Theme.menubg1);
		JLabel bgLabel1 = new JLabel(menuBg1);
		bgLabel1.setBounds(0, 0, menuBg1.getIconWidth(),
				menuBg1.getIconHeight());
		ImageIcon menuBg = new ImageIcon(Theme.menubg);
		this.getLayeredPane().add(bgLabel1, new Integer(Integer.MIN_VALUE));
		bgLabel = new JLabel(menuBg);
		bgLabel.setBounds(0, 0, menuBg.getIconWidth(), menuBg.getIconHeight());
		this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));
		JPanel jp = (JPanel) this.getContentPane();
		jp.setOpaque(false);
	
	}
	public void add(){
		openingThread.start();
		this.addKeyListener(new openKeyListener());
	}
	class openKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE
					|| e.getKeyCode() == KeyEvent.VK_ENTER
					|| e.getKeyCode() == KeyEvent.VK_SPACE) {
				openingJLabel.setVisible(false);
				if (!isadd) {
					menuPanel.AddListener();
					isadd = true;
				}

			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自动生成的方法存根

		}

	}

	class OpeningThread extends Thread {
		public void run() {
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			openingJLabel.setVisible(false);
			if (!isadd) {
				menuPanel.AddListener();
				isadd = true;
			}
		}

	}

	public void addHelp() {
		this.add(new HelpPanel());
	}

	public void AddSingle() {
		this.add(new SingleGamePanel(180));
	}

	public void AddDouble() {
		this.add(new DoubleGamePanel(180));
	}

	public void AddThree() {
		this.add(new ThreePlayerGamePanel(0));
	}

	public void addDoubleMovable() {
		this.add(new DoubleMovablePanel());
	}

	public void addSingleMovable() {
		this.add(new SingleMovablePanel());
	}

	public void addDisturb() {
		this.add(new DisturbPanel());
	}

	public void AddServer() {
		this.add(new GomokuServer());
	}

	public void addOptionPanel() {
		this.add(new newOptionPanel());
	}

	public void AddClient() {
	}

	public void AddNet() {
		this.add(new WaitingPanel());
	}

	public void AddCareer() {
		this.add(new CareerPanel());
	}
	public void AddInformation(){
		this.add(new OurPanel());
	}

	/**
	 * 
	 * @author NorviNS & luck
	 * @version 2013.3.31 23:28
	 * 
	 * 
	 */
	public class Menu extends MenuPanel {
		private static final long serialVersionUID = 1L;
		private turnListener turnlistener = new turnListener();
		int addTime = 0;
		int pressed = 0;

		public Menu() {
			jbtSingle.addMouseListener(new SingleActionListener());
			jbtDouble.addMouseListener(new DoubleActionListener());
			jbtInformation.addMouseListener(new InformationActionListener());
			jbtHelp.addMouseListener(new HelpActionListener());
			jbtOption.addMouseListener(new OptionActionListener());
			jbtQuickMode.addMouseListener(new QuickListener());
			jbtCareerMode.addMouseListener(new CareerListener());
			jbtNetGame.addMouseListener(new NetListener());
			// AddListener();
		}

		public void HideMenu() {
			this.setVisible(false);
		}

		public void focusEvt(WindowEvent evt) {
			jbtQuickMode.requestFocus();
		}

		class SingleActionListener implements MouseListener {
			int x = jbtSingle.getX();
			int y = jbtSingle.getY();

			@Override
			public void mouseClicked(MouseEvent e) {
				HideMenu();
				Media.playSound(Sound.enter);

				AddSingle();
				initial();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				jbtSingle.setLocation(x + 5, y + 5);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jbtSingle.setLocation(x - 3, y - 3);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jbtSingle.setLocation(x - 3, y - 3);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbtSingle.setLocation(x, y);

			}
		}

		class DoubleActionListener implements MouseListener {
			int x = jbtDouble.getX();
			int y = jbtDouble.getY();

			@Override
			public void mouseClicked(MouseEvent e) {
				Media.playSound(Sound.enter);

				HideMenu();
				AddDouble();
				initial();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				jbtDouble.setLocation(x + 5, y + 5);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jbtDouble.setLocation(x - 3, y - 3);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jbtDouble.setLocation(x - 3, y - 3);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbtDouble.setLocation(x, y);
			}
		}

		class OptionActionListener implements MouseListener {

			public void mouseClicked(MouseEvent e) {
				Media.playSound(Sound.enter);

				HideMenu();
				addOptionPanel();
				initial();
			}

			public void mousePressed(MouseEvent e) {
				int x = jbtOption.getX();
				int y = jbtOption.getY();
				jbtOption.setLocation(x + 5, y + 5);
			}

			public void mouseReleased(MouseEvent e) {
				int x = jbtOption.getX();
				int y = jbtOption.getY();
				jbtOption.setLocation(x - 5, y - 5);
			}

			public void mouseEntered(MouseEvent e) {
				int x = jbtOption.getX();
				int y = jbtOption.getY();
				jbtOption.setLocation(x - 3, y - 3);
			}

			public void mouseExited(MouseEvent e) {
				int x = jbtOption.getX();
				int y = jbtOption.getY();
				jbtOption.setLocation(x + 3, y + 3);
			}
		}

		class HelpActionListener implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent e) {
				Media.playSound(Sound.enter);

				HideMenu();
				addHelp();
				initial();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int x = jbtHelp.getX();
				int y = jbtHelp.getY();
				jbtHelp.setLocation(x + 5, y + 5);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				int x = jbtHelp.getX();
				int y = jbtHelp.getY();
				jbtHelp.setLocation(x - 5, y - 5);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				int x = jbtHelp.getX();
				int y = jbtHelp.getY();
				jbtHelp.setLocation(x - 3, y - 3);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				int x = jbtHelp.getX();
				int y = jbtHelp.getY();
				jbtHelp.setLocation(x + 3, y + 3);

			}
		}

		class InformationActionListener implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent e) {
				Media.playSound(Sound.enter);
				HideMenu();
				AddInformation();
				initial();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int x = jbtInformation.getX();
				int y = jbtInformation.getY();
				jbtInformation.setLocation(x + 5, y + 5);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				int x = jbtInformation.getX();
				int y = jbtInformation.getY();
				jbtInformation.setLocation(x - 5, y - 5);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				int x = jbtInformation.getX();
				int y = jbtInformation.getY();
				jbtInformation.setLocation(x - 3, y - 3);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				int x = jbtInformation.getX();
				int y = jbtInformation.getY();
				jbtInformation.setLocation(x + 3, y + 3);

			}
		}

		class QuickListener implements MouseListener {

			public void mouseClicked(MouseEvent e) {
				Media.playSound(Sound.choose);
				if (quickPanel.isVisible()) {
					Allinvisible();
					quickPanel.setVisible(false);
				} else {
					Allinvisible();
					quickPanel.setVisible(true);
				}
				initial();
			}

			public void mousePressed(MouseEvent e) {
				int x = jbtQuickMode.getX();
				int y = jbtQuickMode.getY();
				jbtQuickMode.setLocation(x + 5, y + 5);
			}

			public void mouseReleased(MouseEvent e) {
				int x = jbtQuickMode.getX();
				int y = jbtQuickMode.getY();
				jbtQuickMode.setLocation(x - 5, y - 5);
			}

			public void mouseEntered(MouseEvent e) {
				int x = jbtQuickMode.getX();
				int y = jbtQuickMode.getY();
				jbtQuickMode.setLocation(x - 3, y - 3);

			}

			public void mouseExited(MouseEvent e) {
				int x = jbtQuickMode.getX();
				int y = jbtQuickMode.getY();
				jbtQuickMode.setLocation(x + 3, y + 3);
			}
		}

		class CareerListener implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent e) {
				Media.playSound(Sound.enter);

				HideMenu();
				bgLabel.setVisible(false);
				new LoadingThread().start();
				AddCareer();
				bgLabel.setVisible(true);
				isloading = true;
				initial();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				int x = jbtCareerMode.getX();
				int y = jbtCareerMode.getY();

				jbtCareerMode.setLocation(x + 5, y + 5);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				int x = jbtCareerMode.getX();
				int y = jbtCareerMode.getY();

				jbtCareerMode.setLocation(x - 5, y - 5);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				int x = jbtCareerMode.getX();
				int y = jbtCareerMode.getY();

				jbtCareerMode.setLocation(x - 3, y - 3);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				int x = jbtCareerMode.getX();
				int y = jbtCareerMode.getY();

				jbtCareerMode.setLocation(x + 3, y + 3);
			}
		}

		class NetListener implements MouseListener {
			int x = jbtNetGame.getX();
			int y = jbtNetGame.getY();

			@Override
			public void mouseClicked(MouseEvent e) {
				Media.playSound(Sound.enter);

				HideMenu();
				AddNet();
				initial();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				jbtNetGame.setLocation(x + 5, y + 5);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jbtNetGame.setLocation(x - 3, y - 3);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jbtNetGame.setLocation(x - 3, y - 3);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbtNetGame.setLocation(x, y);

			}
		}

		class turnListener extends KeyAdapter {
			int quickNumber = 0;

			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_A
						|| e.getKeyCode() == KeyEvent.VK_LEFT) {
					Allinvisible();
					RemoveListener();
					Media.playSound(Sound.change);
					new LeftThread().start();
					
					AnimationEffect.turnLeft(MenuPanel.quickList);
				} else if (e.getKeyCode() == KeyEvent.VK_D
						|| e.getKeyCode() == KeyEvent.VK_RIGHT) {
					Allinvisible();
					RemoveListener();
					Media.playSound(Sound.change);
					new RightThread().start();
					AnimationEffect.turnRight(MenuPanel.quickList);
				} else if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (Constants.menu==2 && pressed==1){
						Media.playSound(Sound.choose);

						if (quickNumber==1){
							Media.playSound(Sound.enter);

							HideMenu();
							AddNet();
							initial();
							return;
						}
						if (quickNumber==2){
							Media.playSound(Sound.enter);

							HideMenu();
							AddDouble();
							initial();
							return;
						}
						if (quickNumber==3){
							Media.playSound(Sound.enter);

							HideMenu();
							AddSingle();
							initial();
							return;
						}	
					}
					
					if (Constants.menu == 4) {
						Media.playSound(Sound.enter);

						HideMenu();
						Allinvisible();
						addOptionPanel();
						initial();
					} else if (Constants.menu == 2) {
						Media.playSound(Sound.choose);
						if (pressed == 0) {
							Allinvisible();
							quickPanel.setVisible(true);
							pressed = 1;
						} else {
							quickPanel.setVisible(false);
							pressed = 0;
						}

					} else if (Constants.menu == 0) {
						Media.playSound(Sound.enter);
						HideMenu();
						AddInformation();
						Allinvisible();
						initial();

					} else if (Constants.menu == 3) {
						Media.playSound(Sound.enter);

						Allinvisible();
						HideMenu();
						AddCareer();
						initial();

					} else if (Constants.menu == 1) {
						Media.playSound(Sound.enter);

						HideMenu();
						Allinvisible();
						addHelp();
						initial();

					}
				} else if (Constants.menu == 2
						&& (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_UP)) {
					quickNumber++;
					if (quickNumber>3)
						quickNumber=quickNumber-3;
					choose(quickNumber);
					
				} else if (Constants.menu == 2
						&& (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)) {
					quickNumber--;
					if (quickNumber<1)
						quickNumber=quickNumber+3;
					choose(quickNumber);
				}
			}

			private void choose(int quickNumber) {
				initialQuick();
					Media.playSound(Sound.choose);
				
				if (quickNumber==1){
					int x =jbtNetGame.getX();
					int y = jbtNetGame.getY();
					jbtNetGame.setLocation(x-6,y-6);
				}
				if (quickNumber==2){
					int x = jbtDouble.getX();
					int y = jbtDouble.getY();
					jbtDouble.setLocation(x-6,y-6);
					
				}
				if (quickNumber==3){
					int x = jbtSingle.getX();
					int y = jbtSingle.getY();
					jbtSingle.setLocation(x-6,y-6);
				}
			}
		}

		class RightThread extends Thread {
			public void run() {
				/*
				 * FocusEffect
				 * 
				 * MenuPanel.quickList.get(3).setIcon(new
				 * ImageIcon(Language.QUICK));
				 * MenuPanel.quickList.get(3).setSize(120,32);
				 */
				for (int x = 1; x < 21; x = x + 1) {
					AnimationEffect.moveRight(MenuPanel.quickList, x);
					try {
						Thread.sleep(60);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
				/*
				 * FocusEffect
				 * 
				 * MenuPanel.quickList.get(2).setIcon(new
				 * ImageIcon(Language.QUICK_CURRENT));
				 * MenuPanel.quickList.get(2).setSize(350,60);
				 */
				AddListener();
				Constants.menu--;
				if (Constants.menu < 0)
					Constants.menu = Constants.menu + 5;
			}
		}

		class LeftThread extends Thread {
			public void run() {
				for (int x = 1; x < 21; x = x + 1) {
					AnimationEffect.moveLeft(MenuPanel.quickList, x);
					try {
						Thread.sleep(60);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
				AddListener();
				Constants.menu++;
				if (Constants.menu > 4)
					Constants.menu = Constants.menu - 5;
			}
		}

		public void AddListener() {
			addTime++;
			System.out.println(addTime);
			System.out.println("加了");
			Start.gomoku.addKeyListener(turnlistener);
			this.addKeyListener(turnlistener);
			for (JButton eachButton : quickList) {
				eachButton.addKeyListener(turnlistener);
			}
		}

		public void RemoveListener() {
			addTime--;
			System.out.println(addTime);
			System.out.println("减了");

			Start.gomoku.removeKeyListener(turnlistener);
			this.removeKeyListener(turnlistener);
			for (JButton eachButton : quickList) {
				eachButton.removeKeyListener(turnlistener);
			}
		}

		public void Allinvisible() {
			quickPanel.setVisible(false);
			quickNumber=0;
			pressed=0;
			// careerPanel.setVisible(false);
			// infoPanel.setVisible(false);
			// helpPanel.setVisible(false);
		}
		public void initial(){
			Constants.menu=2;
			jbtOption.setLocation(670, 380);
			jbtInformation.setLocation(10, 380);
			jbtCareerMode.setLocation(580, 450);
			jbtQuickMode.setLocation(340, 528);
			jbtHelp.setLocation(100, 450);
			quickNumber=0;
			quickList.set(0, jbtInformation);
			quickList.set(1, jbtHelp);
			quickList.set(2,jbtQuickMode);
			quickList.set(3, jbtCareerMode);
			quickList.set(4, jbtOption);
		}
	
	}

}
