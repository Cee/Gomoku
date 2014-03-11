package gomoku.chesshandle;


import gomoku.constants.Constants;
import java.util.ArrayList;
/**
 * 
 * @author 小c&Cee酱
 * @version 2013.3.30
 * 储存棋盘信息
 * 
 *
 */
public class ChessBoard {
	private  ArrayList <Integer[]> History = new ArrayList <Integer[]>() ;   //      a=x     a[1]=y   a[2]= color   a[3] = player
	private int[][]  chess= new int[Constants.SIZE+4][Constants.SIZE+4];
	ReviewHandle review = new ReviewHandle();
	public ChessBoard(){
		initial();
	}
	/**
	 * 初始化棋盘
	 */
	public void initial() {
		for(int i =0 ; i < Constants.SIZE;i++){
			for(int j = 0; j <Constants.SIZE; j++){
				chess[i][j]=Constants.BLANK;
			}
		}
		History.clear();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param color
	 * @param player
	 * 
	 * 存入棋子数据
	 */
	public void  set ( int x, int y, int color , int player){
			chess[x][y] = color;
			History.add(new Integer[]  { x , y ,color ,player} );
	}
	/**
	 * 
	 * @return Integer[] 最新下的一颗棋子的有关数据
	 * 
	 */
	public Integer[] unset(){
		Integer temp[] = History.get( History.size()-1 );
		History.remove(History.get( History.size()-1 ));   //出栈
		int x = temp[0];
		int y = temp[1];
		chess[x][y] = Constants.BLANK;               //归零
		return temp;
	}
	
	/**
	 * 
	 * @return ArrayList  history 棋盘信息
	 */
	public  ArrayList <Integer[]> getHistory(){
		return History;
	}
	
	/**
	 * 
	 * @return chess[][][];
	 * 
	 */
	public int[][] getChessBoard(){
		return chess;
	}
	public int getcolor(int x, int y) {
		for (Integer[] temp:History) {
			if (temp[0]==x && temp[1] ==y ){
				return temp[2];
			}
		}
		return 0;
	}
	public void delete(int x, int y) {
		int sequence = -1;
		for (Integer[] temp: History) {
			if (temp[0]==x && temp[1] ==y ){
				sequence = History.indexOf(temp);
				break;
			}
		}
		if (sequence!=-1) {
			History.remove(sequence);
		}
		chess[x][y]=0;
	}
}
