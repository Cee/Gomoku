package gomoku.gamepanel;

import gomoku.constants.Constants;
import gomoku.language.Language;
import gomoku.main.guiboard.DoubleGuiBoard;
import gomoku.option.Set;
import gomoku.option.newOptionPanel;
import gomoku.sound.Media;
import gomoku.sound.Sound;
import gomoku.theme.Theme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * 
 * @author  NorviNS
 *
 */
public class UIPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton jbtReturn;
	protected JButton jbtStart;
	protected JButton jbtRetract;
	protected JButton jbtReview;
	protected JButton jbtGiveup;
	protected JButton jbtExit;
	protected JButton jbtNext;
	protected JButton jbtLast;
	protected JButton jbtAnimation;
	protected JLabel gameBgLabel;
	protected JPanel Reviewpanel;
	protected JPanel MenuPanel;
	
	protected JPanel shellPanel;
	protected JLabel jlbShell1;
	protected JLabel jlbShell2;
	protected JPanel jpClock1;
	protected JLabel jlbClock11;
	protected JLabel jlbClock12;
	protected JLabel jlbClock13;
	protected int time = 180;




	protected JLabel jlbTooEasy;
	protected JLabel jlbTooHard;
	protected JLabel jlbPlayer1;
	protected JLabel jlbPlayer2;
	protected JLabel bgmController;
	protected boolean hasMusic = true;
	public DoubleGuiBoard guiboard = new DoubleGuiBoard();
	public UIPanel() {
		this.setLayout(null);

		jlbTooEasy = new JLabel(new ImageIcon(Theme.tooEasy));
		jlbTooEasy.setBounds(0,45,109,50);
		this.add(jlbTooEasy);
		jlbTooEasy.addMouseListener(new TooEasyListener());
		jlbTooHard = new JLabel(new ImageIcon(Theme.tooHard));
		jlbTooHard.setBounds(0,95,109,50);
		this.add(jlbTooHard);
		jlbTooHard.addMouseListener(new TooHardListener());
		ImageIcon bgmIcon = new ImageIcon(Theme.musicOff); 
		if (!Constants.hasMusic)
			bgmIcon=new ImageIcon(Theme.musicOn);
		bgmController = new JLabel(bgmIcon);
		bgmController.setBounds(0,0,bgmIcon.getIconWidth(),bgmIcon.getIconHeight());
		//bgmController.setOpaque(true);
		this.add(bgmController);
		bgmController.addMouseListener(new bgmControllerListener());
		
		ImageIcon gameBg = new ImageIcon(Theme.gamebg);
		gameBgLabel = new JLabel(gameBg); 
		gameBgLabel.setBounds(0,0,gameBg.getIconWidth(),gameBg.getIconHeight());
		MenuPanel = new JPanel();
		MenuPanel.setLayout(null);
		MenuPanel.setBounds(30,530,800,200);
		
		ImageIcon startIcon = new ImageIcon(Language.START);
		jbtStart = new JButton(startIcon);
		jbtStart.setBounds(0,0,startIcon.getIconWidth(),startIcon.getIconHeight());
		jbtStart.setContentAreaFilled(false);
		jbtStart.setBorderPainted(false);
		MenuPanel.add(jbtStart);
		
		ImageIcon giveUpIcon = new ImageIcon(Language.GIVEUP);
		jbtGiveup = new JButton(giveUpIcon);
		jbtGiveup.setBounds(130,0,giveUpIcon.getIconWidth(),giveUpIcon.getIconHeight());
		jbtGiveup.setContentAreaFilled(false);
		jbtGiveup.setBorderPainted(false);
		MenuPanel.add(jbtGiveup);
		jbtGiveup.setEnabled(false);
		
		ImageIcon retractIcon = new ImageIcon(Language.RETRACT);
		jbtRetract = new JButton(retractIcon);
		jbtRetract.setBounds(260,0,retractIcon.getIconWidth(),retractIcon.getIconHeight());
		jbtRetract.setEnabled(false); 
		jbtRetract.setContentAreaFilled(false);
		jbtRetract.setBorderPainted(false);
		MenuPanel.add(jbtRetract);
		
		ImageIcon reviewIcon = new ImageIcon(Language.REVIEW);
		jbtReview = new JButton(reviewIcon);
		jbtReview.setBounds(390,0,reviewIcon.getIconWidth(),reviewIcon.getIconHeight());
		jbtReview.setEnabled(false);
		jbtReview.setContentAreaFilled(false);
		jbtReview.setBorderPainted(false);
		MenuPanel.add(jbtReview);
		
		ImageIcon returnIcon = new ImageIcon(Language.RETURN);
		jbtReturn = new JButton (returnIcon);
		jbtReturn.setBounds(520,0,returnIcon.getIconWidth(),returnIcon.getIconHeight());
		jbtReturn.setContentAreaFilled(false);
		jbtReturn.setBorderPainted(false);
		MenuPanel.add(jbtReturn);
		
		ImageIcon exitIcon = new ImageIcon(Language.EXIT);
		jbtExit = new JButton(exitIcon);
		jbtExit.setBounds(650,0,exitIcon.getIconWidth(),exitIcon.getIconHeight());
		jbtExit.setContentAreaFilled(false);
		jbtExit.setBorderPainted(false);
		MenuPanel.add(jbtExit);
		
		Reviewpanel = new JPanel();
		Reviewpanel.setLayout(null);
		Reviewpanel.setOpaque(false);
		Reviewpanel.setBounds(690,0,200,600);
		this.add(Reviewpanel);
	
		ImageIcon nextIcon = new ImageIcon(Language.NEXT);
		jbtNext = new JButton(nextIcon);
		jbtNext.setSize(nextIcon.getIconWidth(),nextIcon.getIconHeight());
		jbtNext.setLocation(0,60);
		jbtNext.setContentAreaFilled(false);
		jbtNext.setBorderPainted(false);
		jbtNext.setFocusPainted(false);
		Reviewpanel.add(jbtNext);
		
		ImageIcon lastIcon = new ImageIcon(Language.LAST);
		jbtLast = new JButton(Language.LAST);
		jbtLast = new JButton(lastIcon);
		jbtLast.setSize(lastIcon.getIconWidth(),lastIcon.getIconHeight());
		jbtLast.setLocation(0,0);
		jbtLast.setContentAreaFilled(false);
		jbtLast.setBorderPainted(false);
		jbtLast.setFocusPainted(false);
		Reviewpanel.add(jbtLast);
		Reviewpanel.setVisible(false);
		
		ImageIcon animationIcon = new ImageIcon(Language.ANIMATION);
		jbtAnimation = new JButton (animationIcon);
		jbtAnimation.setSize(lastIcon.getIconWidth(),lastIcon.getIconHeight());
		jbtAnimation.setLocation(0,120);
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
		shellPanel.setBounds(0,0,800,600);
		shellPanel.setVisible(true);
		this.add(shellPanel);
		
		
		/*
		 * PersonImage1
		 */
		ImageIcon whiteShell = new ImageIcon(Theme.whitePlayer);
		jlbShell1 = new JLabel();
		jlbShell1.setIcon(whiteShell);
		jlbShell1.setBounds(0,200,145,415);
		shellPanel.add(jlbShell1);
		
		/*
		 * PersonImage2
		 */
		ImageIcon blackShell = new ImageIcon(Theme.blackPlayer);
		jlbShell2 = new JLabel();
		jlbShell2.setIcon(blackShell);
		jlbShell2.setBounds(650,200,145,415);
		shellPanel.add(jlbShell2);
		
		/*
		 *clock1 
		 */
		ImageIcon time1= new ImageIcon(Theme.timeString+"1.png");
		ImageIcon time2= new ImageIcon(Theme.timeString+"8.png");
		ImageIcon time3= new ImageIcon(Theme.timeString+"0.png");

		jpClock1 = new JPanel();
		jlbClock11 = new JLabel(time1);
		jlbClock11.setBounds(0,0,time1.getIconWidth(),time1.getIconHeight());
		jlbClock12 = new JLabel(time2);
		jlbClock12.setBounds(30,0,time2.getIconWidth(),time2.getIconHeight());
		jlbClock13 = new JLabel(time3);
		jlbClock13.setBounds(60,0,time3.getIconWidth(),time1.getIconHeight());
		jpClock1.add(jlbClock11);
		jpClock1.add(jlbClock12);
		jpClock1.add(jlbClock13);
		jpClock1.setBounds(0,150,120,58);
		jpClock1.setOpaque(false);
		shellPanel.add(jpClock1);
		jpClock1.setVisible(false);
		
		
		MenuPanel.setOpaque(false);
		this.add(MenuPanel);
		/*
		 * represent color
		 */
		
		jlbPlayer1 = new JLabel();
		jlbPlayer1.setBounds(0,200,145,100);
		jlbPlayer1.setFont(new Font(Theme.themeFont,Font.BOLD,Constants.FONTSIZEBIG));
		jlbPlayer1.setForeground(Color.WHITE);
		jlbPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		shellPanel.add(jlbPlayer1);
		
		jlbPlayer2 = new JLabel();
		jlbPlayer2.setBounds(650,200,145,100);
		jlbPlayer2.setFont(new Font(Theme.themeFont,Font.BOLD,Constants.FONTSIZEBIG));
		jlbPlayer2.setForeground(Color.WHITE);
		jlbPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		shellPanel.add(jlbPlayer2);
		
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(200,100));
		panel1.setOpaque(false);
		panel1.setBounds(0,0,100,600);
		this.add(BorderLayout.WEST,panel1);
		setguiboard();
		this.add(gameBgLabel);
		
		this.setOpaque(false);
		

	}
	public void setTime(int totalTime){
		int hundred = totalTime/100;
		int ten = totalTime%100/10;
		int one = totalTime%10;
		ImageIcon time1= new ImageIcon(Theme.timeString+hundred+".png");
		ImageIcon time2= new ImageIcon(Theme.timeString+ten+".png");
		ImageIcon time3= new ImageIcon(Theme.timeString+one+".png");
		jlbClock11.setIcon(time1);
		jlbClock12.setIcon(time2);
		jlbClock13.setIcon(time3);
	}
	public void initialTime(){
		setTime(time);
		
	}
	class TooHardListener implements MouseListener {
		int x = jlbTooHard.getX();
		int y = jlbTooHard.getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			if(Constants.depth>1){
				Media.playSound(Sound.toohard);
				Constants.depth--;
			} else {
				DialogCreator.oneButtonDialog("No", "电脑不能再蠢了");
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jlbTooHard.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jlbTooHard.setLocation(x-3,y-3);

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jlbTooHard.setLocation(x-2,y-2);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jlbTooHard.setLocation(x,y);
		}
		
	}
	class TooEasyListener implements MouseListener{
		int x = jlbTooEasy.getX();
		int y = jlbTooEasy.getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if (Constants.depth<7){
				Media.playSound(Sound.tooeasy);
				Constants.depth++;
			
			} else {
				DialogCreator.oneButtonDialog("No", "这已经是极限了..");
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {

			jlbTooEasy.setLocation(x+3,y+3);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jlbTooEasy.setLocation(x-3,y-3);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jlbTooEasy.setLocation(x-2,y-2);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jlbTooEasy.setLocation(x,y);
		}
		
	}
	class bgmControllerListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if (Constants.hasMusic){
				Constants.hasMusic=false;
				Media.stopBGM(Set.getBGM());
				bgmController.setIcon(new ImageIcon(Theme.musicOn));	
			} else {
				Constants.hasMusic=true;
				Media.playBGM(Set.getBGM());
				bgmController.setIcon(new ImageIcon(Theme.musicOff));
			}
			
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}
		
	}
	public void setguiboard() {
		guiboard=new DoubleGuiBoard();
		guiboard.setOpaque(false);
		guiboard.setBounds(150,50,520,520);
		this.add(guiboard);
	}
}
