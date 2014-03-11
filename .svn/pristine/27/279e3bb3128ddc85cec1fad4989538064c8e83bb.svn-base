package gomoku.gamepanel.special;
import gomoku.achievement.PlayTimes;
import gomoku.gamepanel.GamePanel;
import gomoku.language.Language;
import gomoku.main.guiboard.SingleMovableGuiboard;
import gomoku.sound.Media;
import gomoku.sound.Sound;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
public class SingleMovablePanel extends GamePanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  SingleMovablePanel() {
		jbtExit.addMouseListener(new ExitListener());
		jbtStart.addMouseListener(new StartListener());
		jbtRetract.addMouseListener(new RetractListener());
		jbtGiveup.addMouseListener(new GiveupListener());
		jbtReview.addMouseListener(new ReviewListener());
		jbtReturn.addMouseListener(new ReturnListener());
		jbtNext.addMouseListener(new NextListener());
		jbtLast.addMouseListener(new LastListener());
		jbtAnimation.addMouseListener(new AnimationListener());	
		
		
		ImageIcon blackIcon = new ImageIcon(Language.BLACK);
		ImageIcon whiteIcon = new ImageIcon(Language.WHITE);
		jlbPlayer1.setIcon(blackIcon);
		jlbPlayer2.setIcon(whiteIcon);
		guiboard.addBG();
	}
	class StartListener implements MouseListener{
		int x = jbtStart.getX();
		int y = jbtStart.getY();
		@Override
		public void mousePressed(MouseEvent e) {
			jbtStart.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtStart.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtStart.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtStart.setLocation(x,y);
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtStart.isEnabled()){
				Media.playSound(Sound.gamechoose);

				guiboard.isEnd=false;
				guiboard.initialNumber();
				PlayTimes.addPlayTimes();
				jbtRetract.setEnabled(true);
				jbtReview.setEnabled(false);
				jbtGiveup.setEnabled(true);
				guiboard.renew();
				guiboard.AddListener();
				new CheckWinThread().start();
			}
			else {
				Media.playSound(Sound.enable);
			}
		}
	}
	public void setguiboard() {
		guiboard=new SingleMovableGuiboard();
		guiboard.setOpaque(false);
		guiboard.setBounds(150,50,520,520);
		this.add(guiboard);
	}
	
}
