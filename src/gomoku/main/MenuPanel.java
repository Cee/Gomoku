package gomoku.main;

import gomoku.constants.Constants;
import gomoku.language.Language;
import gomoku.theme.Theme;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * @author NorviNS & luck
 * @version 2013.4.1 
 * Menu UI
 */
public class MenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton jbtSingle;
	protected JButton jbtDouble;
	protected JButton jbtFinalPhase;
	protected JButton jbtReview;
	protected JButton jbtTheme;
	protected JButton jbtQuit;
	protected static JButton jbtHelp;
	protected static JButton jbtInformation;
	protected JButton jbtSound;
	protected JButton jbtChessboard;
	protected static JButton jbtOption;
	protected JButton jbtLanguage;
	protected static JButton jbtQuickMode;
	protected static JButton jbtCareerMode;
	protected JButton jbtNetGame;
	protected static JPanel quickPanel;
	protected JPanel careerPanel;
	protected JPanel infoPanel;
	protected JPanel helpPanel;
	protected JLabel chooseLabel;
	protected JLabel isLoading;
	protected boolean isloading=false;
	ImageIcon chooseBg;
	protected int quickNumber = 0;

	String chooseLabelName="png/"+Theme.theme+"/chooseBg.gif";
	int bgNum = 0;
	
	public static ArrayList<JButton> quickList = new ArrayList<JButton>();

	public MenuPanel() {
		this.setLayout(null);
		jbtSingle = new JButton(new ImageIcon(Language.SINGLE));
		jbtSingle.setBounds(22, 18, 400, 100);
		jbtSingle.setContentAreaFilled(false);
		jbtSingle.setBorderPainted(false);
		jbtSingle.setFocusPainted(false);

		jbtDouble = new JButton(new ImageIcon(Language.DOUBLE));
		jbtDouble.setBounds(22, 124, 400, 101);
		jbtDouble.setContentAreaFilled(false);
		jbtDouble.setBorderPainted(false);
		jbtDouble.setFocusPainted(false);

		jbtNetGame = new JButton(new ImageIcon(Language.NET));
		jbtNetGame.setBounds(20, 231, 400, 100);
		jbtNetGame.setContentAreaFilled(false);
		jbtNetGame.setBorderPainted(false);
		jbtNetGame.setFocusPainted(false);
		
		jbtFinalPhase = new JButton(Language.FINALPHASE);

		jbtReview = new JButton(Language.REVIEW);

		jbtQuit = new JButton(Language.QUIT);

		ImageIcon quickIcon = new ImageIcon(Language.QUICK);
		jbtQuickMode = new JButton(quickIcon);
		jbtQuickMode.setSize(quickIcon.getIconWidth(),quickIcon.getIconHeight());
		jbtQuickMode.setLocation(340, 528);
		jbtQuickMode.setContentAreaFilled(false);
		jbtQuickMode.setBorderPainted(false);
		jbtQuickMode.setFocusPainted(false);
		jbtQuickMode.setFocusable(true);

		ImageIcon careerIcon = new ImageIcon(Language.CAREER);
		jbtCareerMode = new JButton(careerIcon);
		jbtCareerMode.setSize(careerIcon.getIconWidth(),careerIcon.getIconHeight());
		jbtCareerMode.setLocation(580, 450);
		jbtCareerMode.setContentAreaFilled(false);
		jbtCareerMode.setBorderPainted(false);
		jbtCareerMode.setFocusPainted(false);

		ImageIcon helpIcon = new ImageIcon(Language.HELP);
		jbtHelp = new JButton(helpIcon);
		jbtHelp.setSize(helpIcon.getIconWidth(),helpIcon.getIconHeight());
		jbtHelp.setLocation(100, 450);
		jbtHelp.setContentAreaFilled(false);
		jbtHelp.setBorderPainted(false);
		jbtHelp.setFocusPainted(false);

		ImageIcon infoIcon = new ImageIcon(Language.INFORMATION);
		jbtInformation = new JButton(infoIcon);
		jbtInformation.setSize(infoIcon.getIconWidth(),infoIcon.getIconHeight());
		jbtInformation.setLocation(10, 380);
		jbtInformation.setContentAreaFilled(false);
		jbtInformation.setBorderPainted(false);
		jbtInformation.setFocusPainted(false);

		ImageIcon optionIcon = new ImageIcon(Language.OPTION);
		jbtOption = new JButton(optionIcon);
		jbtOption.setSize(optionIcon.getIconWidth(),optionIcon.getIconHeight());
		jbtOption.setLocation(670, 380);
		jbtOption.setContentAreaFilled(false);
		jbtOption.setBorderPainted(false);
		jbtOption.setFocusPainted(false);
		
		
		chooseBg = new ImageIcon(chooseLabelName);
		chooseLabel = new JLabel(chooseBg);
		chooseLabel.setBounds(180, 290, chooseBg.getIconWidth(),
				chooseBg.getIconHeight());

		quickPanel = new JPanel();
		quickPanel.setSize(400, 500);
		quickPanel.setLocation(200, 85);
		quickPanel.setLayout(null);
		quickPanel.setOpaque(false);

		quickPanel.add(jbtSingle);
		quickPanel.add(jbtDouble);
		quickPanel.add(jbtNetGame);
		quickPanel.add(chooseLabel);
		quickPanel.setVisible(false);

		this.add(jbtOption);
		this.add(jbtHelp);
		this.add(jbtInformation);
		this.add(jbtQuickMode);
		this.add(jbtCareerMode);
		this.add(quickPanel);
		this.setOpaque(false);
		
		
		quickList.add(jbtInformation);//0
		quickList.add(jbtHelp);//1
		quickList.add(jbtQuickMode);//2
		quickList.add(jbtCareerMode);//3
		quickList.add(jbtOption);//4
	}

	public void initialQuick(){
		jbtSingle.setLocation(22,18);
		jbtDouble.setLocation(22,124);
		jbtNetGame.setLocation(22, 231);
	}
	class LoadingThread extends Thread{
		public void run(){
			try {
				sleep(1000);
			} catch (InterruptedException e1) {
			}
			if (!isloading){
				ImageIcon loadingiIcon = new ImageIcon(Theme.loading1);
				System.out.println(Theme.loading1);
				isLoading = new JLabel(loadingiIcon);
				isLoading.setBounds(200, 300,loadingiIcon.getIconWidth(),loadingiIcon.getIconHeight());
				Start.gomoku.add(isLoading);
				while (!isloading){
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}	
			}
			
			isLoading.setVisible(false);
		}
	}
}
