package gomoku.netgame;

import gomoku.gamepanel.DialogCreator;
import gomoku.language.Language;
import gomoku.main.guiboard.DoubleGuiBoard;

import java.net.Socket;

import javax.swing.JOptionPane;

public class NetGuiBoard extends DoubleGuiBoard{
	private static final long serialVersionUID = 1L;
	Socket socket;
	Socket retractSocket;
	public NetGuiBoard(Socket socket, Socket retractSocket) {
		
		this.socket=socket;
		this.retractSocket=retractSocket;
	}	
	public void check(int row, int column)  {
		SendRow=row;
		SendColumn=column;
		isClicked=true;
		chessboard.set(row,column,color,activeplayer);
		isWin=(!(checkWin.checkWin(row, column, chessboard.getChessBoard())==null));
		if (isWin) {
			removeListener();
			DialogCreator.oneButtonDialog("Winner", color==1?Language.BLACKWIN:Language.WHITEWIN);
		}
		changecolor();
	}
}
