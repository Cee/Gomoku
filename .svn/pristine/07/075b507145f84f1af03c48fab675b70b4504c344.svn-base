package gomoku.gamepanel;

import gomoku.chesshandle.ReviewHandle;
import gomoku.language.Language;
import gomoku.main.Gomoku;
import gomoku.sound.Media;
import gomoku.sound.Sound;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * 
 * @author luck
 * @version 2013.3.30
 *  锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
 *  
 */
public class GamePanel extends UIPanel {
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
    protected int whofirst = 0 ;
	protected int firstplayer=1;
	protected String isChanged;
	protected String selectSwap;
	protected int color_of_Player1;
	protected int color_of_Player2;
	protected int GameTime=0;
	ReviewHandle reviewHandle = new ReviewHandle();
	public void exit(){
		this.setVisible(false);
		Gomoku.menuPanel.setVisible(true);
		guiboard.color=1;
	}
	/**
	 * 
	 * @author luck
	 *@version 2013.3.30
	 * 锟斤拷锟斤拷锟斤拷锟�
	 */
	public class GiveupListener implements MouseListener {
		int x = jbtGiveup.getX();
		int y = jbtGiveup.getY();

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtGiveup.isEnabled()){
				Media.playSound(Sound.gamechoose);

				DialogCreator.oneButtonDialog(Language.LaoCao,Language.DontGiveUp);
				//int n = JOptionPane.showConfirmDialog(null, Language.MakeSureToGiveUp, Language.GiveUpTitle, JOptionPane.YES_NO_OPTION);
				int n;
				n = DialogCreator.twoButtonDialog(Language.GiveUpTitle, Language.MakeSureToGiveUp, Language.OK, Language.CANCEL);
				if (n == 2) {
					//JOptionPane.showConfirmDialog(null, Language.PraiseSentence, Language.Praise, JOptionPane.DEFAULT_OPTION);
					DialogCreator.oneButtonDialog(Language.Praise, Language.PraiseSentence);
				} else {
					//JOptionPane.showConfirmDialog(null, Language.Disappointment+Language.PLAYER+guiboard.activeplayer+Language.GiveUpTitle, Language.BadPhenomenon, JOptionPane.DEFAULT_OPTION);
					DialogCreator.oneButtonDialog(Language.BadPhenomenon, Language.Disappointment+Language.PLAYER+guiboard.activeplayer+Language.GiveUpTitle);
					guiboard.changeplayer();
					guiboard.isWin=true;
					guiboard.isEnd=true;
					guiboard.removeListener();
				}				
			}
			else {
				Media.playSound(Sound.enable);
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtGiveup.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtGiveup.setLocation(x-2,y-2);

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtGiveup.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtGiveup.setLocation(x,y);
			
		}
	}
	 public class ExitListener implements MouseListener {
		 int x = jbtExit.getX();
		 int y = jbtExit.getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.goback);

			System.exit(0);
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtExit.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtExit.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtExit.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtExit.setLocation(x,y);
			
		}
	}
	class RemindThread extends Thread {
		public void run() {
			Integer[] temp = null;
			while (!guiboard.isWin&&guiboard.getHistory().size()>0) {
				temp = guiboard.getHistory().get(guiboard.getHistory().size()-1);
				guiboard.SetIcon(temp);
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				guiboard.removeIcon(temp);
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO 锟皆讹拷锟斤拷傻锟�catch 锟斤拷
					e.printStackTrace();
				}
				if (guiboard.flag[temp[0]][temp[1]]==1) {
					guiboard.SetIcon(temp);
				}
			}
			
		}
	}
/**
 * 
 * @author luck
 *@version 2013.3.30
 * 锟斤拷锟教硷拷锟斤拷
 */
	public class ReviewListener implements MouseListener {
		int x =jbtReview.getX();
		int y = jbtReview.getY();

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtReview.isEnabled()){
				Media.playSound(Sound.gamechoose);

				Reviewpanel.setVisible(true);
				guiboard.refresh();
				guiboard.removeListener();		
			}
			else {
				Media.playSound(Sound.enable);
			}		
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtReview.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtReview.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtReview.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtReview.setLocation(x,y);
			
		}
		
	}
/**
 * 
 * @author luck
 * @version 2013.3.30
 * 锟斤拷锟斤拷锟斤拷锟�
 */

	public class RetractListener implements MouseListener {
		int x = jbtRetract.getX();
		int y = jbtRetract.getY();
			
				
			

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtRetract.isEnabled()){

				if (guiboard.Retractable) {
					Media.playSound(Sound.gamechoose);
					
					guiboard.unset();
					if (guiboard.activeplayer==2){
						guiboard.removeListener();
						guiboard.Retractable=true;
					}else {
						guiboard.Retractable=false;
						guiboard.AddListener();
					}			
				}	
			}
			else {
				Media.playSound(Sound.enable);
			}	
		}	

		@Override
		public void mousePressed(MouseEvent e) {
			jbtRetract.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtRetract.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtRetract.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtRetract.setLocation(x,y);
			
		}	
	}
	
/**
 * 
 * @author luck
 *@version 2013.3.30
 * 锟斤拷一锟斤拷
 */
	public class NextListener implements MouseListener {
		int x = jbtNext.getX();
		int y = jbtNext.getY();
		

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtNext.isEnabled()){
				Media.playSound(Sound.gamechoose);

				Integer temp[] = reviewHandle.next(guiboard.getHistory());
				if (temp != null) {
					guiboard.SetIcon(temp);
				}			
			}
			else {
				Media.playSound(Sound.enable);
			}
				
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtNext.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtNext.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtNext.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtNext.setLocation(x,y);
			
		}	
	
	}
	/**
	 * 
	 * @author luck
	 *@version 2013.3.30
	 * 锟斤拷一锟斤拷
	 */
	public class LastListener implements MouseListener {
		int x = jbtLast.getX();
		int y = jbtLast.getY();
		public void actionPerformed(ActionEvent event ){
	
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtLast.isEnabled()){
				Media.playSound(Sound.gamechoose);

				Integer temp[] = reviewHandle.last(guiboard.getHistory());
				if (temp != null) {
					guiboard.removeIcon(temp);
				}				
			}
			else {
				Media.playSound(Sound.enable);
			}
			
		}


		@Override
		public void mousePressed(MouseEvent e) {
			jbtLast.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtLast.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtLast.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtLast.setLocation(x,y);
			
		}	
	}
	/**
	 * 
	 * @author luck
	 *@version 2013.3.30
	 * 锟斤拷锟斤拷
	 */
	public class AnimationListener implements MouseListener {
		int x = jbtAnimation.getX();
		int y = jbtAnimation.getY();
		class ReviewThread extends Thread {
			public void run() {
				
				int size = guiboard.getHistory().size();
				for (int i = 0; i < size; i++) {
					try {
						Integer temp[] = reviewHandle.next(guiboard.getHistory());
						if (temp != null) {
							guiboard.SetIcon(temp);
						}

						Thread.sleep(500);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				jbtAnimation.setEnabled(true);
				jbtNext.setEnabled(true);
				jbtLast.setEnabled(true);
			}
		}
		@Override
		
		public void mouseClicked(MouseEvent e) {
			if(jbtAnimation.isEnabled()){
				Media.playSound(Sound.gamechoose);

				guiboard.refresh();
				reviewHandle.setSequence(0);
				jbtNext.setEnabled(false);
				jbtLast.setEnabled(false);
				jbtAnimation.setEnabled(false);
				new ReviewThread().start();	
			}
			else {
				Media.playSound(Sound.enable);
			}
						
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtAnimation.setLocation(x+3,y+3);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtAnimation.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtAnimation.setLocation(x-2,y-2);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtAnimation.setLocation(x,y);
			
		}	
	}			
	public class ReturnListener implements MouseListener {
		int x = jbtReturn.getX();
		int y = jbtReturn.getY();

		@Override
		public void mouseClicked(MouseEvent e) {
			if (jbtReturn.isEnabled()){
				GameTime++;
				Media.playSound(Sound.goback);

				exit();	
				Gomoku.menuPanel.requestFocus();

			}
			else {
				Media.playSound(Sound.enable);
			}
			
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
	/**
	 * 
	 * @author luck
	 * @version 2013.4.2 15:28
	 * 检测胜负的线程
	 */
	public class CheckWinThread extends Thread {
		public void run() {
			while (!guiboard.isWin) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (guiboard.isThinking){
					jbtRetract.setEnabled(false);
				}else {
					jbtRetract.setEnabled(true);
				}
			}
			jbtRetract.setEnabled(false);
			jbtGiveup.setEnabled(false);
			jbtReview.setEnabled(true);
		}
	}
	/**
	 * 
	 * @author luck
	 * 用于计时的线程
	 */
	class TimeThread extends Thread {
		public void run() {
			int gameTime = GameTime;
			int totaltime = time;
			int number1=0;
			int number2=0;	
			while (!guiboard.isWin) {
				while (guiboard.activeplayer == 1) {
					jpClock1.setLocation(0,150);
					initialTime();
					while (guiboard.activeplayer == 1 ) {
						setTime(totaltime);
						try {
							sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						number1++;
						if (number1%10==0){
							totaltime--;
						}
						if (totaltime<=0) {
							guiboard.changeplayer();
							guiboard.changecolor();
							guiboard.isWin=true;
							DialogCreator.oneButtonDialog(null, guiboard.color==1?Language.BLACKWIN:Language.WHITEWIN);
						}
						if (gameTime!=GameTime){
							break;
						}	
					}
					if (gameTime!=GameTime){
						break;
					}
				}
				totaltime=time;
				initialTime();
				if (gameTime!=GameTime){
					break;
				}
				if (guiboard.isWin){
					break;
				}
				
				while (guiboard.activeplayer ==2) {
					jpClock1.setLocation(650,150);
					while (guiboard.activeplayer == 2 ) {
						setTime(totaltime);
						try {
							sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						number2++;
						if (number2%10==0){
							totaltime--;
							
						}
						if (number2<=0) {
							guiboard.changeplayer();
							guiboard.changecolor();
							guiboard.isWin=true;
							DialogCreator.oneButtonDialog(null, guiboard.color==1?Language.BLACKWIN:Language.WHITEWIN);
						}
						
						if (gameTime!=GameTime){
							break;
						}
					}
					if (gameTime!=GameTime){
						break;
					}
					
				}
				initialTime();
				totaltime=time;
			}
		}
	}
	public void enableReturn(){
		jbtReturn.setEnabled(false);
	}

}