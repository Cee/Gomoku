package gomoku.help;

import gomoku.language.Language;
import gomoku.main.Gomoku;
import gomoku.sound.Media;
import gomoku.sound.Sound;
import gomoku.theme.Theme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel gameBgLabel;
	private JButton jbtRuleInformation;
	private JButton jbtSpecialModel;
	private JButton jbtReturn;
	private JButton jbtReturntoMenu;
	 JLabel ruleInformationJLabel;
	 JLabel specialModelJLabel;
	public HelpPanel(){
		this.setVisible(true);
		this.setLayout(null);
		
		ImageIcon ruleIcon = new ImageIcon(Theme.RULEINFORMATION);
		ImageIcon specialIcon = new ImageIcon(Theme.SPECIALMODEL);
		ruleInformationJLabel=new JLabel(ruleIcon);
		specialModelJLabel= new JLabel(specialIcon);
		ruleInformationJLabel.setBounds(100,100,ruleIcon.getIconWidth(),ruleIcon.getIconHeight());
		ruleInformationJLabel.setVisible(false);
		specialModelJLabel.setBounds(100,100,specialIcon.getIconWidth(),specialIcon.getIconHeight());
		specialModelJLabel.setVisible(false);
		this.add(ruleInformationJLabel);
		this.add(specialModelJLabel);
		ImageIcon ruleInformationIcon = new ImageIcon(Language.INFOINTRODUCE);
		jbtRuleInformation= new JButton(ruleInformationIcon);
		jbtRuleInformation.setBounds(100, 100, ruleInformationIcon.getIconWidth()	, ruleInformationIcon.getIconHeight());
	
		jbtRuleInformation.setContentAreaFilled(false);
		jbtRuleInformation.setBorderPainted(false);
		jbtRuleInformation.addMouseListener(new ruleInformationListener());
		ImageIcon specialModelIcon = new ImageIcon(Language.SPECIALINTRODUCE);
		jbtSpecialModel = new JButton(specialModelIcon);
		jbtSpecialModel.setBorderPainted(false);
		jbtSpecialModel.setContentAreaFilled(false);
		jbtSpecialModel.setBounds(100, 200, specialModelIcon.getIconWidth()	, specialModelIcon.getIconHeight());
		jbtSpecialModel.addMouseListener(new specialModelListener());
		
		ImageIcon returnToMenuIcon = new ImageIcon(Language.NETRETURN);
		jbtReturntoMenu = new JButton(returnToMenuIcon);
		jbtReturntoMenu.setBounds(100,300,returnToMenuIcon.getIconWidth(),returnToMenuIcon.getIconHeight());
		jbtReturntoMenu.setContentAreaFilled(false);
		jbtReturntoMenu.setBorderPainted(false);

		jbtReturntoMenu.addMouseListener(new returntoMenuListener());
		
		ImageIcon returnIcon = new ImageIcon(Language.BACKTOHELP);
		jbtReturn = new JButton(returnIcon);
		jbtReturn.setBorderPainted(false);
		jbtReturn.setContentAreaFilled(false);		
		jbtReturn.setBounds(100,500,returnIcon.getIconWidth(),returnIcon.getIconHeight());
		jbtReturn.setVisible(false);
		jbtReturn.addMouseListener(new returnListener());
		
		this.add(jbtRuleInformation);
		this.add(jbtSpecialModel);
		this.add(jbtReturntoMenu);
		this.add(jbtReturn);
		ImageIcon gameBg = new ImageIcon(Theme.gamebg);
		gameBgLabel = new JLabel(gameBg); 
		gameBgLabel.setBounds(0,0,gameBg.getIconWidth(),gameBg.getIconHeight());
		this.add(gameBgLabel);
		
	}
	class ruleInformationListener implements MouseListener {
		int x= jbtRuleInformation.getX();
		int y = jbtRuleInformation.getY();
		

		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.enter);

			ruleInformationJLabel.setVisible(true);
			jbtReturn.setVisible(true);
			jbtReturntoMenu.setVisible(false);
			jbtSpecialModel.setVisible(false);
			jbtRuleInformation.setVisible(false);			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtRuleInformation.setLocation(x+5,y+5);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtRuleInformation.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtRuleInformation.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtRuleInformation.setLocation(x,y);
			
		}
	}
	class returntoMenuListener implements MouseListener {

		int x= jbtReturntoMenu.getX();
		int y = jbtReturntoMenu.getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.goback);

			returntoMenu();
			Gomoku.menuPanel.requestFocus();

			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtReturntoMenu.setLocation(x+5,y+5);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtReturntoMenu.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtReturntoMenu.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtReturntoMenu.setLocation(x,y);
			
		}
		
	}
	class specialModelListener implements MouseListener {
		int x = jbtSpecialModel.getX();
		int y = jbtSpecialModel.getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.enter);

			specialModelJLabel.setVisible(true);
			jbtReturn.setVisible(true);
			jbtReturntoMenu.setVisible(false);
			jbtSpecialModel.setVisible(false);
			jbtRuleInformation.setVisible(false);			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtSpecialModel.setLocation(x+5,y+5);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtSpecialModel.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtSpecialModel.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtSpecialModel.setLocation(x,y);
			
		}
		
	}
	class returnListener implements MouseListener {
		int x = jbtReturn.getX();
		int y = jbtReturn.getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.goback);

			specialModelJLabel.setVisible(false);
			ruleInformationJLabel.setVisible(false);
			jbtReturn.setVisible(false);
			jbtReturntoMenu.setVisible(true);
			jbtSpecialModel.setVisible(true);
			jbtRuleInformation.setVisible(true);			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtReturn.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtReturn.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtReturn.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtReturn.setLocation(x,y);
			
		}	
	}
	public void returntoMenu(){
		this.setVisible(false);
		Gomoku.menuPanel.setVisible(true);		
	}
}
