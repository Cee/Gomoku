package gomoku.main.guiboard;

import gomoku.constants.Constants;
import gomoku.gamepanel.DialogCreator;
import gomoku.language.Language;
import gomoku.theme.Theme;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DoubleMoveableGuiboard extends MovableGuiboard{
	private static final long serialVersionUID = 1L;
	protected MouseHandle mousehandle[][] = new MouseHandle[Constants.SIZE][Constants.SIZE];
	protected newMouseHandle newmousehandle[][] = new newMouseHandle[Constants.SIZE][Constants.SIZE];
	protected Deletemousehandle deletemousehandle[][] = new Deletemousehandle[Constants.SIZE][Constants.SIZE];

	public DoubleMoveableGuiboard(){
		Single=false;
		isOK=true;
		for (int i=0;i<15;i++) {
			for (int j=0;j<15;j++) {
				mousehandle[i][j]= new MouseHandle(i,j);
				newmousehandle[i][j]= new newMouseHandle(i,j);
				deletemousehandle[i][j] = new Deletemousehandle(i, j);
			}
		}	
	}
	/**
	 * 给按钮加监听
	 */
	public void AddListener() {
		removenewListener();
		removeDeleteListener();
		if (chessNumber[activeplayer]<=0) {
			System.out.println("棋子用光了");
			AddnewListener();
		}else {
			for (int i=0;i<15;i++) {
				for (int j=0;j<15;j++) {
					buttonList[i][j].addMouseListener(mousehandle[i][j]);
				}
			}		
		}
	
	}
	public boolean isnearby(int X, int Y) {
		if ( Math.abs(templocation[0]-X)+Math.abs(templocation[1]-Y)==1 )
			return true;
		else 
			return false;
	}
	/**
	 *  去除监听
	 */
	public void removeListener() {
		for (int i=0;i<15;i++) {
			for (int j=0;j<15;j++) {
				buttonList[i][j].removeMouseListener(mousehandle[i][j]);
			}
		}
	}
	/**
	 * 给按钮加监听
	 */
	public void AddnewListener() {
		removeDeleteListener();
		removenewListener();
		for (int i=0;i<15;i++) {
			for (int j=0;j<15;j++) {
				buttonList[i][j].addMouseListener(newmousehandle[i][j]);
			}
		}
	}	
	/**
	 *  去除监听
	 */
	public void removenewListener() {
		for (int i=0;i<15;i++) {
			for (int j=0;j<15;j++) {
				buttonList[i][j].removeMouseListener(newmousehandle[i][j]);
			}
		}
	}
	public void addDeleteListener() {
		removenewListener();
		removeListener();
		for (int i=0;i<15;i++) {
			for (int j=0;j<15;j++) {
				buttonList[i][j].addMouseListener(deletemousehandle[i][j]);
			}
		}
	}
	public void removeDeleteListener() {
		for (int i=0;i<15;i++) {
			for (int j=0;j<15;j++) {
				buttonList[i][j].removeMouseListener(deletemousehandle[i][j]);
			}
		}
	}
	class Deletemousehandle extends MouseAdapter {
		int X;
		int Y;
		public Deletemousehandle (int a, int b) {
			X=a;
			Y=b;
		}
		public void mouseClicked(MouseEvent e) {
			if (flag[X][Y]==1 && color==chessboard.getcolor(X, Y)){
				buttonList[X][Y].setIcon(null);
				chessboard.delete(X,Y);
				totalNumber[activeplayer]--;
				color=color==1?2:1;
				buttonList[X][Y].setIcon(new ImageIcon(color==Constants.BLACK? Theme.black:Theme.white));
				check(X, Y);
				CheckModel();
				AddListener();
				
			}
		}
	}

	public void check(int a, int b)  { 
		chessboard.set(a,b,color,activeplayer);
		ArrayList<int[]> arrayList = checkWin.checkWin(a, b, chessboard.getChessBoard());
		isWin=(!(arrayList==null));
		if (isWin) {
			for (int[] temp:arrayList){
				buttonList[temp[0]][temp[1]].setIcon(null);
				chessboard.delete(temp[0], temp[1]);
				flag[temp[0]][temp[1]]=0;
				chessNumber[activeplayer]++;	
			}
			chessNumber[activeplayer]--;
			DialogCreator.oneButtonDialog("Congratulations", color==1?"黑方先到5子，请选择要吃的子":"白方先到5子，请选择要吃的子");
			addDeleteListener();
			changecolor();
			if (totalNumber[color]<=6) 
				DialogCreator.oneButtonDialog("Congratulations", color==1?Language.BLACKWIN:Language.WHITEWIN);
		}
		else if (!isWin){
			changecolor();
		}
	}

	
}
