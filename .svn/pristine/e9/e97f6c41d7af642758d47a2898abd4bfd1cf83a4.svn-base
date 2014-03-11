package gomoku.gamepanel.special;

import gomoku.achievement.PlayTimes;
import gomoku.gamepanel.GamePanel;
import gomoku.gamepanel.GamePanel.AnimationListener;
import gomoku.gamepanel.GamePanel.ExitListener;
import gomoku.gamepanel.GamePanel.GiveupListener;
import gomoku.gamepanel.GamePanel.LastListener;
import gomoku.gamepanel.GamePanel.NextListener;
import gomoku.gamepanel.GamePanel.ReturnListener;
import gomoku.gamepanel.GamePanel.ReviewListener;
import gomoku.main.guiboard.Threeguiboard;
import gomoku.sound.Media;
import gomoku.sound.Sound;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * 
 * @author luck
 *三人游戏面板
 */
public class ThreePlayerGamePanel extends GamePanel{
	private static final long serialVersionUID = 1L;
	public ThreePlayerGamePanel(int cpuNumber) {
		jbtExit.addMouseListener(new ExitListener());
		jbtStart.addMouseListener(new StartListener());
		jbtRetract.addMouseListener(new RetractListener());
		jbtGiveup.addMouseListener(new GiveupListener());
		jbtReview.addMouseListener(new ReviewListener());
		jbtReturn.addMouseListener(new ReturnListener());
		jbtNext.addMouseListener(new NextListener());
		jbtLast.addMouseListener(new LastListener());
		jbtAnimation.addMouseListener(new AnimationListener());	
		
		guiboard.CpuNumber=cpuNumber;
		if (cpuNumber>0){
			guiboard.addCpu();
		}		
	}
	public void setguiboard() {
		guiboard=new Threeguiboard();
		guiboard.setOpaque(false);
		guiboard.setBounds(150,50,520,520);
		this.add(guiboard);
	}
	/**
	 * 
	 * @author luck
	 * @version 2013.4.3 15:27
	 * 开始监听
	 */
	class StartListener implements MouseListener {
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
				PlayTimes.addPlayTimes();
				whofirst=0;
				firstplayer=1;
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
		
}
