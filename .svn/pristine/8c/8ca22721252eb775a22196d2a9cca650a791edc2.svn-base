package gomoku.main.guiboard;

import gomoku.constants.Constants;


public class SingleMovableGuiboard extends MovableGuiboard{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected MouseHandle mousehandle[][] = new MouseHandle[Constants.SIZE][Constants.SIZE];
	protected newMouseHandle newmousehandle[][] = new newMouseHandle[Constants.SIZE][Constants.SIZE];
	public int state=0;
	public SingleMovableGuiboard(){
		comColor=Constants.WHITE;
		playerColor=Constants.BLACK;
		Single=true;
		isOK=true;
		for (int i=0;i<15;i++) {
			for (int j=0;j<15;j++) {
				mousehandle[i][j]= new MouseHandle(i,j);
				newmousehandle[i][j]= new newMouseHandle(i,j);
			}
		}	
	}
	public void initialNumber() {
		chessNumber[1]=16;
		chessNumber[2]=15*15;
		totalNumber[1]=16;
		totalNumber[2]=15*15;
	}
	/**
	 * 给按钮加监听
	 */
	public void AddListener() {
		removenewListener();
		if (chessNumber[activeplayer]<=0) {
			AddnewListener();
		}else {
			for (int i=0;i<15;i++) {
				for (int j=0;j<15;j++) {
					buttonList[i][j].addMouseListener(mousehandle[i][j]);
				}
			}		
		}
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
}
