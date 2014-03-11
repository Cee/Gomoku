package gomoku.career;

import gomoku.gamepanel.DialogCreator;
import gomoku.gamepanel.DoubleGamePanel;
import gomoku.gamepanel.SingleGamePanel;
import gomoku.gamepanel.special.DisturbPanel;
import gomoku.gamepanel.special.DoubleMovablePanel;
import gomoku.gamepanel.special.SingleMovablePanel;
import gomoku.gamepanel.special.ThreePlayerGamePanel;
import gomoku.language.Language;
import gomoku.main.Gomoku;
import gomoku.main.Start;
import gomoku.sound.Media;
import gomoku.sound.Sound;
import gomoku.theme.Theme;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpecialPanel extends JPanel{
	int chapter;
	JButton modelListButton[]= new JButton[8];
	JLabel introduceLabel;
	
	public SpecialPanel (int chapter, int isCompleted){
		this.setLayout(null);
		ImageIcon gameBg = new ImageIcon(Theme.gamebg);
		JLabel gameBgLabel = new JLabel(gameBg); 
		gameBgLabel.setBounds(0,0,gameBg.getIconWidth(),gameBg.getIconHeight());
		
		ImageIcon specialBgLabelIcon = new ImageIcon(Theme.specialBg);
		JLabel specialBgLabel = new JLabel(specialBgLabelIcon);
		specialBgLabel.setBounds(175,75,450,450);
		specialBgLabel.setOpaque(false);
		introduceLabel = new JLabel(new ImageIcon(Theme.special)); 
		introduceLabel.setBounds(280,180,250,250);
		introduceLabel.setOpaque(false);
		this.add(introduceLabel);
		this.chapter=chapter;
		ImageIcon modelIcon0 = new ImageIcon(Language.NOLIGHT);
		modelListButton[0] = new JButton(modelIcon0);
		modelListButton[0].setBounds(115,410,modelIcon0.getIconWidth(),modelIcon0.getIconHeight());
		modelListButton[0].setOpaque(false);
		modelListButton[0].setBorderPainted(false);
		modelListButton[0].setContentAreaFilled(false);
		modelListButton[0].setFocusPainted(false);
		
		ImageIcon modelIcon1 =new ImageIcon(Language.FOG);
		modelListButton[1] = new JButton(modelIcon1);
		modelListButton[1].setBounds(60,260,modelIcon1.getIconWidth(),modelIcon1.getIconHeight());
		modelListButton[1].setOpaque(false);
		modelListButton[1].setBorderPainted(false);
		modelListButton[1].setContentAreaFilled(false);
		modelListButton[1].setFocusPainted(false);
		
		ImageIcon modelIcon2 = new ImageIcon(Language.NONEW);
		modelListButton[2] = new JButton(modelIcon2);
		modelListButton[2].setBounds(110,110,modelIcon2.getIconWidth(),modelIcon2.getIconHeight());
		modelListButton[2].setOpaque(false);
		modelListButton[2].setBorderPainted(false);
		modelListButton[2].setContentAreaFilled(false);
		modelListButton[2].setFocusPainted(false);
		
		ImageIcon modelIcon3 = new ImageIcon(Language.STARMOVE);
		modelListButton[3] = new JButton(modelIcon3);
		modelListButton[3].setBounds(340,20,modelIcon3.getIconWidth(),modelIcon3.getIconHeight());
		modelListButton[3].setOpaque(false);
		modelListButton[3].setBorderPainted(false);
		modelListButton[3].setContentAreaFilled(false);
		modelListButton[3].setFocusPainted(false);
		
		ImageIcon modelIcon4 = new ImageIcon(Language.DRYOUT);
		modelListButton[4] = new JButton(modelIcon4);
		modelListButton[4].setBounds(580,110,modelIcon4.getIconWidth(),modelIcon4.getIconHeight());
		modelListButton[4].setOpaque(false);
		modelListButton[4].setBorderPainted(false);
		modelListButton[4].setContentAreaFilled(false);
		modelListButton[4].setFocusPainted(false);
		
		ImageIcon modelIcon5 = new ImageIcon(Language.NOHEAD);
		modelListButton[5] = new JButton(modelIcon5);
		modelListButton[5].setBounds(625,260,modelIcon5.getIconWidth(),modelIcon5.getIconHeight());
		modelListButton[5].setOpaque(false);
		modelListButton[5].setBorderPainted(false);
		modelListButton[5].setContentAreaFilled(false);
		modelListButton[5].setFocusPainted(false);
		
		ImageIcon modelIcon6 = new ImageIcon(Language.FINALFIGHT);
		modelListButton[6] = new JButton(modelIcon6);
		modelListButton[6].setBounds(580,410,modelIcon6.getIconWidth(),modelIcon6.getIconHeight());
		modelListButton[6].setOpaque(false);
		modelListButton[6].setBorderPainted(false);
		modelListButton[6].setContentAreaFilled(false);
		modelListButton[6].setFocusPainted(false);
		
		ImageIcon modelIcon7 = new ImageIcon(Language.SPECIALRETURN);
		modelListButton[7] = new JButton(modelIcon7);
		modelListButton[7].setBounds(340,520,modelIcon7.getIconWidth(),modelIcon7.getIconHeight());
		modelListButton[7].setOpaque(false);
		modelListButton[7].setBorderPainted(false);
		modelListButton[7].setContentAreaFilled(false);
		modelListButton[7].setFocusPainted(false);
		
		modelListButton[0].addMouseListener(new darkListener());
		modelListButton[1].addMouseListener(new fogListener());
		modelListButton[3].addMouseListener(new startMoveListener());
		modelListButton[7].addMouseListener(new returntoMenuListener());
		modelListButton[2].addMouseListener(new moveableGameListener());
		modelListButton[4].addMouseListener(new disturbGameListener());
		modelListButton[6].addMouseListener(new finalGameListener());
		modelListButton[5].addMouseListener(new threePlayerListener());
		for (int i = 0; i<=7 ; i++){
			add(modelListButton[i]);
			modelListButton[i].setEnabled(false);
		}
		if (isCompleted==1){
			chapter=8;
		}
		
		for (int i = 0; i < chapter-1;i++ ) {
			modelListButton[i].setEnabled(true);
		}
		modelListButton[7].setEnabled(true);
		this.add(specialBgLabel);
		this.add(gameBgLabel);
		
	}
	public void addSinglefog(){
		
		this.setVisible(false);
		Start.gomoku.add(new SingleGamePanel("Disturb", 180));
	}
	public void addDoublefog(){
		this.setVisible(false);
		Start.gomoku.add(new DoubleGamePanel("Disturb", 180));
	}
	public void addSingleDark(){
		this.setVisible(false);
		Start.gomoku.add(new SingleGamePanel("Dark", 180));
	}
	public void addDoubleDark(){
		this.setVisible(false);
		Start.gomoku.add(new DoubleGamePanel("Dark", 180));
	}
	public void returntoMenu(){
		this.setVisible(false);
		Gomoku.menuPanel.setVisible(true);
	}
	public void addSingleChange(){
		this.setVisible(false);
		Start.gomoku.add(new SingleGamePanel("Change", 180));		
	}
	public void addDoubleChange(){
		this.setVisible(false);
		Start.gomoku.add(new DoubleGamePanel("Change", 180));		
	}
	class startMoveListener implements MouseListener {
		int x = modelListButton[3].getX();
		int y = modelListButton[3].getY();

		@Override
		public void mouseClicked(MouseEvent e) {
			if (modelListButton[3].isEnabled()){
				Media.playSound(Sound.enter);

				int model = DialogCreator.twoButtonDialog(Language.CHOOSEMODEL,Language.CHOOSEMODEL, Language.SINGLEPLAYER, Language.DOUBLEPLAYER,1);
				if (model == 1 ) {
					addSingleChange();
				} else if(model==2){
					addDoubleChange();
				}			
			}
			else {
				Media.playSound(Sound.enable);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			modelListButton[3].setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			modelListButton[3].setLocation(x,y);
			
		}

		public void mouseEntered(MouseEvent e) {
			introduceLabel.setIcon(new ImageIcon(Theme.special+"3.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			introduceLabel.setIcon(null);
		}
		
	}
	class fogListener implements MouseListener {
		int x = modelListButton[1].getX();
		int y = modelListButton[1].getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			if (modelListButton[1].isEnabled()){
				Media.playSound(Sound.enter);

				int model = DialogCreator.twoButtonDialog(Language.CHOOSEMODEL,Language.CHOOSEMODEL, Language.SINGLEPLAYER, Language.DOUBLEPLAYER,1);
				if (model == 1 ) {
					addSinglefog();
				} else if(model==2){
					addDoublefog();
				}					
				
			}
			else {
				Media.playSound(Sound.enable);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			modelListButton[1].setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			modelListButton[1].setLocation(x,y);
		}

		public void mouseEntered(MouseEvent e) {
			introduceLabel.setIcon(new ImageIcon(Theme.special+"1.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			introduceLabel.setIcon(null);
		}
		
	}
	class darkListener implements MouseListener {
		int x = modelListButton[0].getX();
		int y = modelListButton[0].getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			if (modelListButton[0].isEnabled()){
				Media.playSound(Sound.enter);

				int model = DialogCreator.twoButtonDialog(Language.CHOOSEMODEL,Language.CHOOSEMODEL, Language.SINGLEPLAYER, Language.DOUBLEPLAYER,1);
				if (model == 1 ) {
					addSingleDark();
				} else if(model==2){
					addDoubleDark();
				}				
			}
			else {
				Media.playSound(Sound.enable);
			}
					
		}

		@Override
		public void mousePressed(MouseEvent e) {
			modelListButton[0].setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			modelListButton[0].setLocation(x,y);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			introduceLabel.setIcon(new ImageIcon(Theme.special+"0.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			introduceLabel.setIcon(null);
		}
		
	}
	class threePlayerListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (modelListButton[5].isEnabled()){
				Media.playSound(Sound.enter);

				int model = DialogCreator.twoButtonDialog(Language.CHOOSEMODEL,Language.CHOOSEMODEL, Language.SINGLEPLAYER, Language.THREEPLAYER,1);
				if (model == 1 ) {
					addDoulbeCpuThreePlayer();

				} else if(model==2){
					addSinglethreePlayer();

				}		
			}
			else {
				Media.playSound(Sound.enable);
			}			
		}
		int x = modelListButton[5].getX();
		int y = modelListButton[5].getY();
		@Override
		public void mousePressed(MouseEvent e) {
			modelListButton[5].setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			modelListButton[5].setLocation(x,y);
		}

		public void mouseEntered(MouseEvent e) {
			introduceLabel.setIcon(new ImageIcon(Theme.special+"5.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			introduceLabel.setIcon(null);
		}
		
	}
	class returntoMenuListener implements MouseListener {
		int x = modelListButton[7].getX();
		int y = modelListButton[7].getY();
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.goback);

			returntoMenu();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			modelListButton[7].setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			modelListButton[7].setLocation(x-2,y-2);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			modelListButton[7].setLocation(x-2,y-2);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			modelListButton[7].setLocation(x,y);
		}		
	}
	public void addSingleFinal(){
		this.setVisible(false);
		Start.gomoku.add(new SingleGamePanel(5));
	}
	public void addDoubleFinal(){
		this.setVisible(false);
		Start.gomoku.add(new DoubleGamePanel(5));
	}
	public void addSingleMoveable(){
		this.setVisible(false);
		Start.gomoku.add(new SingleMovablePanel());
		
	}
	public void addDoubleMoveable(){
		this.setVisible(false);
		Start.gomoku.add(new DoubleMovablePanel());
	}
	public void addDoubleDisturb(){
		this.setVisible(false);
		Start.gomoku.add(new DisturbPanel());
	}
	public void addSingleDisturb(){
		this.setVisible(false);
		Start.gomoku.add(new DisturbPanel(1));
	}
	public void addSinglethreePlayer(){
		this.setVisible(false);
		Start.gomoku.add(new ThreePlayerGamePanel(0));
	}
	public void addDoulbeCpuThreePlayer(){
		this.setVisible(false);
		Start.gomoku.add(new ThreePlayerGamePanel(2));
	}
	class finalGameListener implements MouseListener {
		int x = modelListButton[6].getX();
		int y = modelListButton[6].getY();
		public void mouseClicked(MouseEvent e) {
			if (modelListButton[6].isEnabled()){
				Media.playSound(Sound.enter);

				int model = DialogCreator.twoButtonDialog(Language.CHOOSEMODEL,Language.CHOOSEMODEL, Language.SINGLEPLAYER, Language.DOUBLEPLAYER,1);
				if (model == 1 ) {
					addSingleFinal();
					
				} else if(model ==2 ){
					addDoubleFinal();
				}	
			}
			else {
				Media.playSound(Sound.enable);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			modelListButton[6].setLocation(x+3,y+3);
					
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			modelListButton[6].setLocation(x,y);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			introduceLabel.setIcon(new ImageIcon(Theme.special+"6.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			introduceLabel.setIcon(null);
		}
		
	}
	class disturbGameListener implements MouseListener {
		int x = modelListButton[4].getX();
		int y = modelListButton[4].getY();

		@Override
		public void mouseClicked(MouseEvent e) {
			if (modelListButton[4].isEnabled()){
				Media.playSound(Sound.enter);

				int model = DialogCreator.twoButtonDialog(Language.CHOOSEMODEL,Language.CHOOSEMODEL, Language.SINGLEPLAYER, Language.DOUBLEPLAYER,1);
				if (model == 1 ) {
					addSingleDisturb();
				} else if(model==2){
					addDoubleDisturb();
				}			
			}
			else {
				Media.playSound(Sound.enable);
			}				
		}

		@Override
		public void mousePressed(MouseEvent e) {
			modelListButton[4].setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			modelListButton[4].setLocation(x,y);
		}

		public void mouseEntered(MouseEvent e) {
			introduceLabel.setIcon(new ImageIcon(Theme.special+"4.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			introduceLabel.setIcon(null);
		}
	}
	class moveableGameListener implements MouseListener {
		int x = modelListButton[2].getX();
		int y = modelListButton[2].getY();

		@Override
		public void mouseClicked(MouseEvent e) {
			if (modelListButton[2].isEnabled()){
				Media.playSound(Sound.enter);

				int model = DialogCreator.twoButtonDialog(Language.CHOOSEMODEL,Language.CHOOSEMODEL, Language.SINGLEPLAYER, Language.DOUBLEPLAYER,1);
				if (model == 1 ) {
					addSingleMoveable();
					
				} else if(model==2){
					addDoubleMoveable();
				}			
			}
			else {
				Media.playSound(Sound.enable);
			}
			
		
		}

		@Override
		public void mousePressed(MouseEvent e) {
			modelListButton[2].setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			modelListButton[2].setLocation(x,y);
		}
		public void mouseEntered(MouseEvent e) {
			introduceLabel.setIcon(new ImageIcon(Theme.special+"2.png"));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			introduceLabel.setIcon(null);
		}
		
	}
}
