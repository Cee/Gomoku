package gomoku.information;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gomoku.language.Language;
import gomoku.main.Gomoku;
import gomoku.option.newOptionPanel;
import gomoku.sound.Media;
import gomoku.sound.Sound;
import gomoku.theme.Theme;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OurPanel extends JPanel{
	JLabel ourLabel;
	JButton jbtReturntoMenu;
	public OurPanel(){
		Media.stopBGM(Sound.BGM);
		Media.playBGM(Sound.career);
		this.setLayout(null);
		ImageIcon gameBg = new ImageIcon(Theme.gamebg);
		JLabel gameBgLabel = new JLabel(gameBg); 
		gameBgLabel.setBounds(0,0,gameBg.getIconWidth(),gameBg.getIconHeight());
		
		ImageIcon returnToMenuIcon = new ImageIcon(Language.CAREERRETURN);
		jbtReturntoMenu = new JButton(returnToMenuIcon);
		jbtReturntoMenu.setBounds(0,500,returnToMenuIcon.getIconWidth(),returnToMenuIcon.getIconHeight());
		jbtReturntoMenu.setOpaque(false);
		jbtReturntoMenu.setContentAreaFilled(false);
		jbtReturntoMenu.setBorderPainted(false);
		jbtReturntoMenu.setFocusPainted(false);
		jbtReturntoMenu.addMouseListener(new returnListener());
		this.add(jbtReturntoMenu);
			
		ImageIcon imageIcon = new ImageIcon(Theme.aboutus);
		ourLabel = new JLabel(imageIcon);
		ourLabel.setBounds(0,0,imageIcon.getIconWidth(),imageIcon.getIconHeight());
		JPanel jpOur = new JPanel();
		jpOur.setBounds(0,0,800,600);
		jpOur.setOpaque(false);
		jpOur.add(ourLabel);
		this.add(jpOur);
		jpOur.addMouseListener(new ourMouseListener());

		this.add(gameBgLabel);
		
	}
	public void returntoMenu(){
		this.setVisible(false);
		Gomoku.menuPanel.setVisible(true);
		Media.playBGM(Sound.BGM);
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
	class ourMouseListener implements MouseListener{
	
		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.change);
			if (e.getX()>=400){
				new RightThread().start();
			}else {
				new LeftThread().start();
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
	class LeftThread extends Thread {
		public void run() {
			
			int x1 = ourLabel.getX();
			int y1 = ourLabel.getY();
			if (x1>=0)
				return;
			for (int x = 0; x <=800 ; x=x+10) {
				ourLabel.setLocation(x1+x,y1);
				try {
					sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
 	}
	class RightThread extends Thread {
		public void run(){
			int x1 = ourLabel.getX();
			int y1 = ourLabel.getY();
			for (int x = 0; x <=800 ; x=x+10) {
				ourLabel.setLocation(x1-x,y1);
				try {
					sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
