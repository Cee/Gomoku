package gomoku.option;

import gomoku.gamepanel.DialogCreator;
import gomoku.language.Language;
import gomoku.main.Gomoku;
import gomoku.main.Gomoku.Menu;
import gomoku.main.MenuPanel;
import gomoku.main.Start;
import gomoku.sound.Media;
import gomoku.sound.Sound;
import gomoku.theme.Theme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class newOptionPanel extends OptionPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String theme=Set.getTheme();
	private String language=Set.getLanguage();
	private String Music=Set.getBGM();	
	public newOptionPanel(){
		initial();
		jbtGoBackButton.addMouseListener(new goBackListener());
		jbtSaveButton.addMouseListener(new SaveListener());
		jlbLanguage1.addMouseListener(new LanguageListener());
		jlbLanguage2.addMouseListener(new LanguageListener());
		jlbLanguage3.addMouseListener(new LanguageListener());
		jlbTheme1.addMouseListener(new ThemeListener());
		jlbTheme2.addMouseListener(new ThemeListener());
		jlbTheme3.addMouseListener(new ThemeListener());
		jlbMusic1.addMouseListener(new MusicListener());
		jlbMusic2.addMouseListener(new MusicListener());
		jlbMusic3.addMouseListener(new MusicListener());
	}
	public void initial(){
		switch (theme) {
		case "StarNight":
			int x = jlbTheme1.getX();
			int y = jlbTheme1.getY();
			jlbTheme1.setLocation(x+10,y+10);
			break;
		case "Donuts":
			x = jlbTheme2.getX();
			y = jlbTheme2.getY();
			jlbTheme2.setLocation(x+10,y+10);
			break;
		case "Gundam":
			x = jlbTheme3.getX();
			y = jlbTheme3.getY();
			jlbTheme3.setLocation(x+10,y+10);
		default:
			break;
		}
		switch (Music) {
		case "bgm1":
			int x = jlbMusic1.getX();
			int y = jlbMusic1.getY();
			jlbMusic1.setLocation(x+10,y+10);
			break;
		case "bgm2":
			x = jlbMusic2.getX();
			y = jlbMusic2.getY();
			jlbMusic2.setLocation(x+10,y+10);
			break;
		case "bgm3":
			x = jlbMusic3.getX();
			y = jlbMusic3.getY();
			jlbMusic3.setLocation(x+10,y+10);
		default:
			break;
		}
		switch (language) {
		case "Chinese":
			int x = jlbLanguage1.getX();
			int y = jlbLanguage1.getY();
			jlbLanguage1.setLocation(x+10,y+10);
			break;
		case "English":
			x = jlbLanguage2.getX();
			y = jlbLanguage2.getY();
			jlbLanguage2.setLocation(x+10,y+10);
			break;
		case "Japanese":
			x = jlbLanguage3.getX();
			y = jlbLanguage3.getY();
			jlbLanguage3.setLocation(x+10,y+10);
		default:
			break;
		}
		
		
	}
	public void goBack(){
		this.setVisible(false);
		Gomoku.menuPanel.setVisible(true);
		Gomoku.menuPanel.requestFocus();

	}
	public void initialTheme(){
		jlbTheme1.setLocation(50,100);
		jlbTheme2.setLocation(300,100);
		jlbTheme3.setLocation(550,100);
	}
	public void initialLanguage(){
		jlbLanguage1.setLocation(50,260);
		jlbLanguage2.setLocation(300,260);
		jlbLanguage3.setLocation(550,260);
	}
	public void initialMusic(){
		jlbMusic1.setLocation(50,400);
		jlbMusic2.setLocation(300,400);
		jlbMusic3.setLocation(550,400);
	}
	class MusicListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.option);

			if (e.getSource().equals(jlbMusic1)){
				Music = "bgm1";
			} else if (e.getSource().equals(jlbMusic2)) {
				Music = "bgm2";
			} else {
				Music = "bgm3";
			}
			initialMusic();
			if (e.getSource().equals(jlbMusic1)){
				int x = jlbMusic1.getX();
				int y = jlbMusic1.getY();
				jlbMusic1.setLocation(x+10,y+10);
			} else if(e.getSource().equals(jlbMusic2)){
				int x = jlbMusic2.getX();
				int y = jlbMusic2.getY();
				jlbMusic2.setLocation(x+10,y+10);
			} else {
				int x = jlbMusic3.getX();
				int y = jlbMusic3.getY();
				jlbMusic3.setLocation(x+10,y+10);
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
			if (e.getSource().equals(jlbMusic1)){
				int x = jlbMusic1.getX();
				int y = jlbMusic1.getY();
				jlbMusic1.setLocation(x-5,y-5);
			} else if(e.getSource().equals(jlbMusic2)){
				int x = jlbMusic2.getX();
				int y = jlbMusic2.getY();
				jlbMusic2.setLocation(x-5,y-5);
			} else {
				int x = jlbMusic3.getX();
				int y = jlbMusic3.getY();
				jlbMusic3.setLocation(x-5,y-5);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(jlbMusic1)){
				int x = jlbMusic1.getX();
				int y = jlbMusic1.getY();
				jlbMusic1.setLocation(x+5,y+5);
			} else if(e.getSource().equals(jlbMusic2)){
				int x = jlbMusic2.getX();
				int y = jlbMusic2.getY();
				jlbMusic2.setLocation(x+5,y+5);
			} else {
				int x = jlbMusic3.getX();
				int y = jlbMusic3.getY();
				jlbMusic3.setLocation(x+5,y+5);
			}
		}
		
	}
	class ThemeListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.option);

			if (e.getSource().equals(jlbTheme1)){
				theme= "StarNight";
			} else if (e.getSource().equals(jlbTheme2)){
				theme= "Donuts";
			} else {
				theme="Gundam";
			}
			initialTheme();
			if (e.getSource().equals(jlbTheme1)){
				int x = jlbTheme1.getX();
				int y = jlbTheme1.getY();
				jlbTheme1.setLocation(x+10,y+10);
			} else if(e.getSource().equals(jlbTheme2)){
				int x = jlbTheme2.getX();
				int y = jlbTheme2.getY();
				jlbTheme2.setLocation(x+10,y+10);
			} else {
				int x = jlbTheme3.getX();
				int y = jlbTheme3.getY();
				jlbTheme3.setLocation(x+10,y+10);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource().equals(jlbTheme1)){
				int x = jlbTheme1.getX();
				int y = jlbTheme1.getY();
				jlbTheme1.setLocation(x-5,y-5);
			} else if(e.getSource().equals(jlbTheme2)){
				int x = jlbTheme2.getX();
				int y = jlbTheme2.getY();
				jlbTheme2.setLocation(x-5,y-5);
			} else {
				int x = jlbTheme3.getX();
				int y = jlbTheme3.getY();
				jlbTheme3.setLocation(x-5,y-5);
			}			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(jlbTheme1)){
				int x = jlbTheme1.getX();
				int y = jlbTheme1.getY();
				jlbTheme1.setLocation(x+5,y+5);
			} else if(e.getSource().equals(jlbTheme2)){
				int x = jlbTheme2.getX();
				int y = jlbTheme2.getY();
				jlbTheme2.setLocation(x+5,y+5);
			} else {
				int x = jlbTheme3.getX();
				int y = jlbTheme3.getY();
				jlbTheme3.setLocation(x+5,y+5);
			}			
		}
		
	}
	class LanguageListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.option);
			if (e.getSource().equals(jlbLanguage1)){
				language="Chinese";
			} else if(e.getSource().equals(jlbLanguage2)){
				language = "English";
			} else {
				language = "Japanese";
			}
			initialLanguage();
			if (e.getSource().equals(jlbLanguage1)){
				int x = jlbLanguage1.getX();
				int y = jlbLanguage1.getY();
				jlbLanguage1.setLocation(x+10,y+10);
			} else if(e.getSource().equals(jlbLanguage2)){
				int x = jlbLanguage2.getX();
				int y = jlbLanguage2.getY();
				jlbLanguage2.setLocation(x+10,y+10);
			} else {
				int x = jlbLanguage3.getX();
				int y = jlbLanguage3.getY();
				jlbLanguage3.setLocation(x+10,y+10);
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
			if (e.getSource().equals(jlbLanguage1)){
				int x = jlbLanguage1.getX();
				int y = jlbLanguage1.getY();
				jlbLanguage1.setLocation(x-5,y-5);
			} else if(e.getSource().equals(jlbLanguage2)){
				int x = jlbLanguage2.getX();
				int y = jlbLanguage2.getY();
				jlbLanguage2.setLocation(x-5,y-5);
			} else {
				int x = jlbLanguage3.getX();
				int y = jlbLanguage3.getY();
				jlbLanguage3.setLocation(x-5,y-5);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(jlbLanguage1)){
				int x = jlbLanguage1.getX();
				int y = jlbLanguage1.getY();
				jlbLanguage1.setLocation(x+5,y+5);
			} else if(e.getSource().equals(jlbLanguage2)){
				int x = jlbLanguage2.getX();
				int y = jlbLanguage2.getY();
				jlbLanguage2.setLocation(x+5,y+5);
			} else {
				int x = jlbLanguage3.getX();
				int y = jlbLanguage3.getY();
				jlbLanguage3.setLocation(x+5,y+5);
			}
		}
		
	}
	class goBackListener implements MouseListener{

		int x = jbtGoBackButton.getX();
		int y = jbtGoBackButton.getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.goback);

			goBack();
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			jbtGoBackButton.setLocation(x+5,y+5);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtGoBackButton.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtGoBackButton.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtGoBackButton.setLocation(x,y);
			
		}
		
		
	}
	class SaveListener implements MouseListener {
		int x = jbtSaveButton.getX();
		int y = jbtSaveButton.getY();

		@Override
		public void mouseClicked(MouseEvent e) {
			Set.setLanguage(language);
			Set.setTheme(theme);
			Set.setBGM(Music);
			try {
				Save.save();
				Load.read();
				
			} catch (IOException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			Theme.load(Set.getTheme());
			Language.load(Set.getLanguage());
			Sound.load(Set.getBGM());
			Media.playSound(Sound.save);
			Media.playBGM(Sound.BGM);
			DialogCreator.oneButtonDialog("OK", "修改成功");			
			Start.gomoku.dispose();
			Start.gomoku = new Gomoku();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtSaveButton.setLocation(x+5,y+5);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtSaveButton.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtSaveButton.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtSaveButton.setLocation(x,y);
			
		}
		
		
	}

}
