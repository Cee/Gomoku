package gomoku.chesshandle;

import java.util.ArrayList;
/**
 * 
 * @author luck
 *@version 2013.4.2 15:13
 * 处理复盘.
 */
public class ReviewHandle {
	private int sequence = 0;
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	/**
	 * 
	 * @param History
	 * @return 用于复盘时获取下一步棋子的信息
	 */
	public Integer[] next(ArrayList<Integer[]> History) {
		Integer temp[] = null;
		if (sequence <= History.size() - 1) {
			temp = History.get(sequence);
			sequence++;
		}
		return temp;
	}
	/**
	 * 
	 * @param History
	 * @return 用于复盘时获取上一颗棋子的情况
	 */
	public Integer[] last(ArrayList<Integer[]> History) {
		Integer temp[] = null;
		if (sequence > 0) {
			temp = History.get(sequence - 1);
			sequence--;
		}
		return temp;
	}

}
