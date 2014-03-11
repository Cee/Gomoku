package gomoku.career;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gomoku.constants.Constants;
import gomoku.language.Language;
import gomoku.main.Gomoku;
import gomoku.main.Start;
import gomoku.sound.Media;
import gomoku.sound.Sound;
import gomoku.theme.Theme;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CareerPanel extends JPanel{
	JButton jbtNewGame;
	JButton jbtContinue;
	JButton jbtReturntoMenu;
	JButton jbtSpecialModel;
	JLabel jlbCareerIconJLabel;
	LifePanel lifePanel = new LifePanel();
	public CareerPanel(){
		this.setLayout(null);
		ImageIcon gameBg = new ImageIcon(Theme.gamebg);
		JLabel gameBgLabel = new JLabel(gameBg); 
		gameBgLabel.setBounds(0,0,gameBg.getIconWidth(),gameBg.getIconHeight());	

		ImageIcon newGameIcon = new ImageIcon(Language.NEWJOURNEY);
		jbtNewGame = new JButton(newGameIcon);
		jbtNewGame.setBounds(100,50,newGameIcon.getIconWidth(),newGameIcon.getIconHeight());
		jbtNewGame.setOpaque(false);
		jbtNewGame.setContentAreaFilled(false);
		jbtNewGame.setBorderPainted(false);
		jbtNewGame.setFocusPainted(false);
		
		ImageIcon continueIcon = new ImageIcon(Language.OLDMEMORY);
		jbtContinue = new JButton (continueIcon);
		jbtContinue.setBounds(100,200,continueIcon.getIconWidth(),continueIcon.getIconHeight());
		jbtContinue.setOpaque(false);
		jbtContinue.setContentAreaFilled(false);
		jbtContinue.setBorderPainted(false);
		jbtContinue.setFocusPainted(false);
		
		ImageIcon specialModeIcon = new ImageIcon(Language.SPECIALMODE);
		jbtSpecialModel = new JButton(specialModeIcon);
		jbtSpecialModel.setBounds(100,350,specialModeIcon.getIconWidth(),specialModeIcon.getIconHeight());
		jbtSpecialModel.setOpaque(false);
		jbtSpecialModel.setContentAreaFilled(false);
		jbtSpecialModel.setBorderPainted(false);
		jbtSpecialModel.setFocusPainted(false);
		
		ImageIcon returnToMenuIcon = new ImageIcon(Language.CAREERRETURN);
		jbtReturntoMenu = new JButton(returnToMenuIcon);
		jbtReturntoMenu.setBounds(100,500,returnToMenuIcon.getIconWidth(),returnToMenuIcon.getIconHeight());
		jbtReturntoMenu.setOpaque(false);
		jbtReturntoMenu.setContentAreaFilled(false);
		jbtReturntoMenu.setBorderPainted(false);
		jbtReturntoMenu.setFocusPainted(false);
		
		ImageIcon careerIcon =new ImageIcon(Theme.careerIconString);
		jlbCareerIconJLabel = new JLabel(careerIcon);
		jlbCareerIconJLabel.setBounds(150,50,careerIcon.getIconWidth(),careerIcon.getIconHeight());
		jlbCareerIconJLabel.setOpaque(false);
		
		this.add(jbtNewGame);
		this.add(jbtContinue);
		this.add(jbtSpecialModel);
		this.add(jbtReturntoMenu);
		this.add(jlbCareerIconJLabel);
		this.add(gameBgLabel);		
		jbtReturntoMenu.addMouseListener(new returnListener());
		jbtSpecialModel.addMouseListener(new specialModelListener());
		jbtNewGame.addMouseListener(new newGameListener());
		jbtContinue.addMouseListener(new continueListener());
	}
	public void returntoMenu(){
		this.setVisible(false);
		Gomoku.menuPanel.setVisible(true);
	}
	public void addnew(){
		this.setVisible(false);
		lifePanel = new LifePanel(0);
		Start.gomoku.add(lifePanel);
	}
	public void addcontinue(){
		this.setVisible(false);		
		Start.gomoku.add(lifePanel);
	}
	public void addSpecialPanel(){
		this.setVisible(false);
		Start.gomoku.add(new SpecialPanel(lifePanel.getChapter(),lifePanel.isCompleted));
	}
	class returnListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.goback);

			returntoMenu();
			Gomoku.menuPanel.requestFocus();
		}
		public void mousePressed(MouseEvent e) {
			jbtReturntoMenu.setLocation(jbtReturntoMenu.getX()+3, jbtReturntoMenu.getY()+3);
		}
		public void mouseReleased(MouseEvent e) {
			jbtReturntoMenu.setLocation(jbtReturntoMenu.getX()-3, jbtReturntoMenu.getY()-3);
		}
		public void mouseEntered(MouseEvent e) {
			jbtReturntoMenu.setLocation(jbtReturntoMenu.getX()-2, jbtReturntoMenu.getY()-2);
		}
		public void mouseExited(MouseEvent e) {
			jbtReturntoMenu.setLocation(jbtReturntoMenu.getX()+2, jbtReturntoMenu.getY()+2);
		}
		
	}
	class newGameListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.enter);
			Media.stopBGM(Sound.BGM);
			Constants.hasMusic=false;
			Media.playBGM(Sound.career);
			addnew();
		}
		public void mousePressed(MouseEvent e) {
			jbtNewGame.setLocation(jbtNewGame.getX()+3, jbtNewGame.getY()+3);
		}
		public void mouseReleased(MouseEvent e) {
			jbtNewGame.setLocation(jbtNewGame.getX()-3, jbtNewGame.getY()-3);
		}
		public void mouseEntered(MouseEvent e) {
			jbtNewGame.setLocation(jbtNewGame.getX()-2, jbtNewGame.getY()-2);
		}
		public void mouseExited(MouseEvent e) {
			jbtNewGame.setLocation(jbtNewGame.getX()+2, jbtNewGame.getY()+2);
		}
		
	}
	class continueListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.enter);
			Media.stopBGM(Sound.BGM);
			Constants.hasMusic=false;
			Media.playBGM(Sound.career);
			addcontinue();
		}
		public void mousePressed(MouseEvent e) {
			jbtContinue.setLocation(jbtContinue.getX()+3, jbtContinue.getY()+3);
		}
		public void mouseReleased(MouseEvent e) {
			jbtContinue.setLocation(jbtContinue.getX()-3, jbtContinue.getY()-3);
		}
		public void mouseEntered(MouseEvent e) {
			jbtContinue.setLocation(jbtContinue.getX()-2, jbtContinue.getY()-2);
		}
		public void mouseExited(MouseEvent e) {
			jbtContinue.setLocation(jbtContinue.getX()+2, jbtContinue.getY()+2);
		}
		
	}
	class specialModelListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.enter);

			addSpecialPanel();
		}
		public void mousePressed(MouseEvent e) {
			jbtSpecialModel.setLocation(jbtSpecialModel.getX()+3, jbtSpecialModel.getY()+3);
		}
		public void mouseReleased(MouseEvent e) {
			jbtSpecialModel.setLocation(jbtSpecialModel.getX()-3, jbtSpecialModel.getY()-3);
		}
		public void mouseEntered(MouseEvent e) {
			jbtSpecialModel.setLocation(jbtSpecialModel.getX()-2, jbtSpecialModel.getY()-2);
		}
		public void mouseExited(MouseEvent e) {
			jbtSpecialModel.setLocation(jbtSpecialModel.getX()+2, jbtSpecialModel.getY()+2);
		}
	}
	
}
