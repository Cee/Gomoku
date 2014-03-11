package gomoku.main.guiboard;

import javax.swing.ImageIcon;

import gomoku.constants.Constants;
import gomoku.theme.Theme;

public class DisturbGuiboard extends DoubleGuiBoard{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void disturb() {
		int disturbChessnumber = (int) (Math.random()*3);
		while (disturbChessnumber>=0) {
			int i = (int) (Math.random()*Constants.SIZE);
			int j =(int) (Math.random()*Constants.SIZE);
			while (flag[i][j]==1) {
				i = (int) (Math.random()*Constants.SIZE);
				j =(int) (Math.random()*Constants.SIZE);
			} 
			buttonList[i][j].setIcon(new ImageIcon(Theme.red));
			flag[i][j]=1;
			disturbChessnumber--;
		}
	}
}
