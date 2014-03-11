package gomoku.chesshandle;

import java.util.ArrayList;

/**
 * 
 * @author Cee
 * @version 2013.4.2 15:11 用于判断胜负
 */
public class CheckWin {

	/**
	 * 
	 * @return 胜负 5子连珠
	 */
	public ArrayList<int[]> checkWin(int x, int y, int[][] chess) {
		ArrayList<int[]> arrayList = new ArrayList<int[]>();
		for (int p = 0; p <= 4; p++) {
			int rx = x - p;
			int ry = y - p;
			if ((rx >= 0) && (rx + 4 <= 14)) {
				if ((chess[rx][y] == chess[rx + 1][y])
						&& (chess[rx][y] == chess[rx + 2][y])
						&& (chess[rx][y] == chess[rx + 3][y])
						&& (chess[rx][y] == chess[rx + 4][y])) {
					for (int i = 0; i <= 4; i++) {
						int temp[] = new int[2];
						temp[0] = rx + i;
						temp[1] = y;
						arrayList.add(temp);
					}
					return arrayList;

				}
			}

			if ((ry >= 0) && (ry + 4 <= 14)) {
				if ((chess[x][ry] == chess[x][ry + 1])
						&& (chess[x][ry] == chess[x][ry + 2])
						&& (chess[x][ry] == chess[x][ry + 3])
						&& (chess[x][ry] == chess[x][ry + 4])) {
					for (int i = 0; i <= 4; i++) {
						int temp[] = new int[2];

						temp[0] = x;
						temp[1] = ry + i;
						arrayList.add(temp);
					}
					return arrayList;

				}
				

			}

			if ((rx >= 0) && (rx + 4 <= 14) && (ry >= 0) && (ry + 4 <= 14)) {
				if ((chess[rx][ry] == chess[rx + 1][ry + 1])
						&& (chess[rx][ry] == chess[rx + 2][ry + 2])
						&& (chess[rx][ry] == chess[rx + 3][ry + 3])
						&& (chess[rx][ry] == chess[rx + 4][ry + 4])) {
					for (int i = 0; i <= 4; i++) {
						int temp[] = new int[2];
						temp[0] = rx + i;
						temp[1] = ry + i;
						arrayList.add(temp);
					}
					return arrayList;

				}

			}
			rx = x + p;
			if ((rx - 4 >= 0) && (rx <= 14) && (ry >= 0) && (ry + 4 <= 14)) {
				if ((chess[rx][ry] == chess[rx - 1][ry + 1])
						&& (chess[rx][ry] == chess[rx - 2][ry + 2])
						&& (chess[rx][ry] == chess[rx - 3][ry + 3])
						&& (chess[rx][ry] == chess[rx - 4][ry + 4])) {
					for (int i = 0; i <= 4; i++) {
						int temp[] = new int[2];
						temp[0] = rx - i;
						temp[1] = ry + i;
						arrayList.add(temp);
					}
					return arrayList;

				}

			}

		}
		return null;
	}

	/**
	 * 
	 * @return 胜负 四子连珠
	 */
	public boolean checkWinFour(int x, int y, int[][] chess) {
		for (int p = 0; p <= 3; p++) {
			int rx = x - p;
			int ry = y - p;
			if ((rx >= 0) && (rx + 3 <= 14)) {
				if ((chess[rx][y] == chess[rx + 1][y])
						&& (chess[rx][y] == chess[rx + 2][y])
						&& (chess[rx][y] == chess[rx + 3][y])) {
					return true;
				}
			}

			if ((ry >= 0) && (ry + 3 <= 14)) {
				if ((chess[x][ry] == chess[x][ry + 1])
						&& (chess[x][ry] == chess[x][ry + 2])
						&& (chess[x][ry] == chess[x][ry + 3])) {
					return true;
				}
			}

			if ((rx >= 0) && (rx + 3 <= 14) && (ry >= 0) && (ry + 3 <= 14)) {
				if ((chess[rx][ry] == chess[rx + 1][ry + 1])
						&& (chess[rx][ry] == chess[rx + 2][ry + 2])
						&& (chess[rx][ry] == chess[rx + 3][ry + 3])) {
					return true;
				}
			}
			rx = x + p;
			if ((rx - 3 >= 0) && (rx <= 14) && (ry >= 0) && (ry + 3 <= 14)) {
				if ((chess[rx][ry] == chess[rx - 1][ry + 1])
						&& (chess[rx][ry] == chess[rx - 2][ry + 2])
						&& (chess[rx][ry] == chess[rx - 3][ry + 3])) {
					return true;
				}
			}

		}
		return false;
	}
}
