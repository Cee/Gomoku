package gomoku.option;

import gomoku.constants.Constants;
import gomoku.language.Language;
import gomoku.theme.Theme;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel jlbTheme;
	protected JLabel jlbTheme1;
	protected JLabel jlbTheme2;
	protected JLabel jlbTheme3;
	
	protected JLabel jlbLanguage;
	protected JLabel jlbLanguage1;
	protected JLabel jlbLanguage2;
	protected JLabel jlbLanguage3;
	
	protected JLabel jlbMusic;
	protected JLabel jlbMusic1;
	protected JLabel jlbMusic2;
	protected JLabel jlbMusic3;
	protected JButton jbtGoBackButton;
	protected JLabel gameBgLabel;
	protected JButton jbtSaveButton;
	public OptionPanel(){
		this.setVisible(true);
		this.setLayout(null);
		ImageIcon gameBg = new ImageIcon(Theme.gamebg);
		gameBgLabel = new JLabel(gameBg); 
		gameBgLabel.setBounds(0,0,gameBg.getIconWidth(),gameBg.getIconHeight());
		
		/*
		 * Theme
		 */
		
		ImageIcon themeIcon = new ImageIcon(Language.CHOOSETHEME);
		jlbTheme = new JLabel(themeIcon);
		jlbTheme.setBounds(20,20,themeIcon.getIconWidth(),themeIcon.getIconHeight());
		
		ImageIcon theme1Icon = new ImageIcon(Theme.themeStarNight);
		jlbTheme1 = new JLabel(theme1Icon);
		jlbTheme1.setBounds(50,100,theme1Icon.getIconWidth(),theme1Icon.getIconHeight());
		
		ImageIcon theme2Icon = new ImageIcon(Theme.themeDonuts);
		jlbTheme2 = new JLabel(theme2Icon);
		jlbTheme2.setBounds(300,100,theme2Icon.getIconWidth(),theme2Icon.getIconHeight());
		
		ImageIcon theme3Icon = new ImageIcon(Theme.themeGundam);
		jlbTheme3 = new JLabel(theme3Icon);
		jlbTheme3.setBounds(550,100,theme3Icon.getIconWidth(),theme3Icon.getIconHeight());
		
		/*
		 * Language
		 */
		ImageIcon languageIcon = new ImageIcon(Language.CHOOSELANGUAGE);
		jlbLanguage = new JLabel(languageIcon);
		jlbLanguage.setBounds(20,180,languageIcon.getIconWidth(),languageIcon.getIconHeight());
		
		ImageIcon language1Icon = new ImageIcon(Theme.languageChinese);
		jlbLanguage1 = new JLabel(language1Icon);
		jlbLanguage1.setBounds(50,260,language1Icon.getIconWidth(),language1Icon.getIconHeight());
		
		ImageIcon language2Icon = new ImageIcon(Theme.languageEnglish);
		jlbLanguage2 = new JLabel(language2Icon);
		jlbLanguage2.setBounds(300,260,language2Icon.getIconWidth(),language2Icon.getIconHeight());
		
		ImageIcon language3Icon = new ImageIcon(Theme.languageJapanese);
		jlbLanguage3 = new JLabel(language3Icon);
		jlbLanguage3.setBounds(550,260,language3Icon.getIconWidth(),language3Icon.getIconHeight());
		
		/*
		 * Music
		 */
		ImageIcon musicIcon = new ImageIcon(Language.CHOOSEMUSIC);
		jlbMusic = new JLabel(musicIcon);
		jlbMusic.setBounds(20,330,musicIcon.getIconWidth(),musicIcon.getIconHeight());
		
		ImageIcon music1Icon = new ImageIcon(Theme.musicFate);
		jlbMusic1 = new JLabel(music1Icon);
		jlbMusic1.setBounds(50,400,music1Icon.getIconWidth(),music1Icon.getIconHeight());
		
		ImageIcon music2Icon = new ImageIcon(Theme.musicSummer);
		jlbMusic2 = new JLabel(music2Icon);
		jlbMusic2.setBounds(300,400,music2Icon.getIconWidth(),music2Icon.getIconHeight());
		
		ImageIcon music3Icon = new ImageIcon(Theme.musicInvoke);
		jlbMusic3 = new JLabel(music3Icon);
		jlbMusic3.setBounds(550,400,music3Icon.getIconWidth(),music3Icon.getIconHeight());
		
		ImageIcon goBackIcon = new ImageIcon(Language.NETRETURN);
		jbtGoBackButton = new JButton(goBackIcon);
		jbtGoBackButton.setBounds(400,480,goBackIcon.getIconWidth(),goBackIcon.getIconHeight());
		jbtGoBackButton.setOpaque(false);
		jbtGoBackButton.setContentAreaFilled(false);
		jbtGoBackButton.setFocusPainted(false);
		jbtGoBackButton.setBorderPainted(false);
		
		ImageIcon saveIcon = new ImageIcon(Language.SAVECHOOSE);
		jbtSaveButton = new JButton (saveIcon);
		jbtSaveButton.setBounds(50,480,saveIcon.getIconWidth(),saveIcon.getIconHeight());
		jbtSaveButton.setOpaque(false);
		jbtSaveButton.setContentAreaFilled(false);
		jbtSaveButton.setFocusPainted(false);
		jbtSaveButton.setBorderPainted(false);
		
		this.add(jlbTheme);
		this.add(jlbTheme1);
		this.add(jlbTheme2);
		this.add(jlbTheme3);
		this.add(jlbLanguage);
		this.add(jlbLanguage1);
		this.add(jlbLanguage2);
		this.add(jlbLanguage3);
		this.add(jlbMusic);
		this.add(jlbMusic1);
		this.add(jlbMusic2);
		this.add(jlbMusic3);
		this.add(jbtGoBackButton);
		this.add(jbtSaveButton);
		this.add(gameBgLabel);
	}

}
