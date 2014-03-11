package gomoku.gamepanel.special;

import gomoku.achievement.PlayTimes;
import gomoku.constants.Constants;
import gomoku.gamepanel.GamePanel;
import gomoku.main.guiboard.DisturbGuiboard;
import gomoku.player.HumanPlayer;
import gomoku.sound.Media;
import gomoku.sound.Sound;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DisturbPanel extends GamePanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DisturbPanel(int model){
		jbtExit.addMouseListener(new ExitListener());
		jbtStart.addMouseListener(new StartListener());
		jbtRetract.addMouseListener(new RetractListener());
		jbtGiveup.addMouseListener(new GiveupListener());
		jbtReview.addMouseListener(new ReviewListener());
		jbtReturn.addMouseListener(new ReturnListener());
		jbtNext.addMouseListener(new NextListener());
		jbtLast.addMouseListener(new LastListener());
		jbtAnimation.addMouseListener(new AnimationListener());
		guiboard.player1 = new HumanPlayer("Íæ¼Ò1");
		guiboard.setCpu();
		guiboard.Single=true;
		guiboard.isOK=true;
		guiboard.comColor=Constants.WHITE;
		guiboard.playerColor=Constants.BLACK;
		guiboard.addBG();
	}
	public DisturbPanel() {
		jbtExit.addMouseListener(new ExitListener());
		jbtStart.addMouseListener(new StartListener());
		jbtRetract.addMouseListener(new RetractListener());
		jbtGiveup.addMouseListener(new GiveupListener());
		jbtReview.addMouseListener(new ReviewListener());
		jbtReturn.addMouseListener(new ReturnListener());
		jbtNext.addMouseListener(new NextListener());
		jbtLast.addMouseListener(new LastListener());
		jbtAnimation.addMouseListener(new AnimationListener());
		guiboard.player1 = new HumanPlayer("Íæ¼Ò1");
		guiboard.player2 = new HumanPlayer("Íæ¼Ò2");
		guiboard.Single=false;
		guiboard.isOK=true;
		guiboard.addBG();
	}
	class StartListener implements MouseListener{
			

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtStart.isEnabled()){
				Media.playSound(Sound.gamechoose);

				guiboard.isEnd=false;
				PlayTimes.addPlayTimes();
				jbtRetract.setEnabled(true);
				jbtReview.setEnabled(false);
				jbtGiveup.setEnabled(true);
				guiboard.renew();
				guiboard.AddListener();
				new CheckWinThread().start();
				new DisturbThread().start();	
			}
			else {
				Media.playSound(Sound.enable);
			}
		}

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
	}
	class DisturbThread extends Thread {
		public void run() {
			while (!guiboard.isWin) {
				int sleeptime = (int) (Math.random()*6000);
				try {
					sleep(sleeptime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				guiboard.disturb();		
			}
		
		}
	}
	public void setguiboard() {
		
		guiboard=new DisturbGuiboard();
		guiboard.setOpaque(false);
		guiboard.setBounds(150,50,520,520);
		this.add(guiboard);
	}
}
