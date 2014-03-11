package gomoku.ai;

import gomoku.constants.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.sql.rowset.CachedRowSet;

/**
 * 
 * @author Cee
 * @version 2013.05.14
 */

public class AiPlayer extends Thread{
	private int[][] chessboard;
	private int[][] flag;
	private int comColor;
	private int playerColor;
	private int chessNum;

	private final int INFINITY = 2100000000;
	private int depth = Constants.depth;
	private int restrictTime=Constants.time;
	public boolean timeOut = false;
	private int weight = Constants.SIZE + 2;
	private int step=0;
	int[] border = { 0, Constants.SIZE, 0, Constants.SIZE };

	public void SetData(int[][] chessboard, int[][] flag, int comColor,
			int playerColor, int step) {
		this.chessboard = chessboard;
		this.flag = flag;
		this.comColor = comColor;
		this.playerColor = playerColor;
		this.step=step;
		if (step<10){
			depth=1;
		}
	}

	private void resetBorder(int x, int y) {
		if (x - 1 >= 0)
			border[0] = (border[0] < x - 1 ? border[0] : x - 1);
		if (x + 1 <= Constants.SIZE)
			border[1] = (border[1] > x + 1 ? border[1] : x + 1);
		if (y - 1 >= 0)
			border[2] = (border[2] < y - 1 ? border[2] : y - 1);
		if (y + 1 <= Constants.SIZE)
			border[3] = (border[3] > y + 1 ? border[3] : y + 1);
	}

	private Boolean isAvailable(int x, int y, int addX, int addY, int color) {
		int count = 1;
		for (int i = 1; (x + i * addX < Constants.SIZE) && (x + i * addX >= 0)
				&& (y + i * addY < Constants.SIZE) && (y + i * addY >= 0)
				&& (count < chessNum); i++) {
			if ((chessboard[x + i * addX][y + i * addY] == color)
					|| (chessboard[x + i * addX][y + i * addY] == 0))
				count++;
			else
				break;
		}

		for (int i = 1; (x - i * addX >= 0) && (x - i * addX < Constants.SIZE)
				&& (y - i * addY >= 0) && (y - i * addY < Constants.SIZE)
				&& (count < chessNum); i++) {
			if ((chessboard[x - i * addX][y - i * addY] == color)
					|| (chessboard[x - i * addX][y - i * addY] == 0))
				count++;
			else
				break;
		}
		return (count >= chessNum);
	}

	private int Alpha(int alpha, int beta, int depth) {

		int max = alpha;
		if (depth == 0) {
			return calResult();
		}

		int[][] chessboardStatus = Arrangement(comColor);
		for (int i = 0; i < chessboardStatus.length; i++) {
			int x = chessboardStatus[i][0];
			int y = chessboardStatus[i][1];
			if (calType(x, y, comColor) == 1) {
				return 100 * (getResult(1) + depth * 1000);
			}
			chessboard[x][y] = comColor;

			int[] borderNew = { border[0], border[1], border[2], border[3] };
			resetBorder(x, y);
			int t = Beta(max, beta, depth - 1);
			chessboard[x][y] = 0;

			border = borderNew;
			if (t > max) {
				max = t;
			}
			if (max >= beta) {
				return max;
			}
		}
		return max;
	}

	private int Beta(int alpha, int beta, int depth) {
		int min = beta;
		if (depth == 0) {
			return calResult();
		}
		int[][] chessboardStatus = Arrangement(playerColor);
		for (int i = 0; i < chessboardStatus.length; i++) {
			int x = chessboardStatus[i][0];
			int y = chessboardStatus[i][1];
			if (calType(x, y, playerColor) == 1) {
				return -100 * (getResult(1) + depth * 1000);
			}
			int[] borderNew = { border[0], border[1], border[2], border[3] };
			chessboard[x][y] = playerColor;
			resetBorder(x, y);
			int t = Alpha(alpha, min, depth - 1);
			chessboard[x][y] = 0;

			border = borderNew;
			if (t < min) {
				min = t;
			}
			if (min <= alpha) {
				return min;
			}
		}
		return min;
	}	

	private int[][] Arrangement(int color) {

		int diffcolor = (color == comColor) ? playerColor : comColor;

		int minX = (border[0] == 0 ? border[0] : border[0] - 1);
		int minY = (border[2] == 0 ? border[2] : border[2] - 1);
		int maxX = (border[1] == Constants.SIZE ? border[1] : border[1] + 1);
		int maxY = (border[3] == Constants.SIZE ? border[3] : border[3] + 1);

		int count = 0;
		int[] getValue = new int[2];
		int[][] chessboardStatus = new int[(maxX - minX) * (maxY - minY)][3];
		for (int i = minX; i < maxX; i++)
			for (int j = minY; j < maxY; j++)
				if (chessboard[i][j] == 0) {
					getValue[0] = calType(i, j, color);
					getValue[1] = calType(i, j, diffcolor);
					chessboardStatus[count][0] = i;
					chessboardStatus[count][1] = j;
					chessboardStatus[count][2] = getResult(getValue[0])
							+ getResult(getValue[1]);
					count++;
				}

		Arrays.sort(chessboardStatus, new ArrComparator());
		int size = (weight > count) ? count : weight;
		int[][] arrange = new int[size][3];
		System.arraycopy(chessboardStatus, 0, arrange, 0, size);
		return arrange;
	}

	private int[] count(int x, int y, int addX, int addY, int color) {

		if (!isAvailable(x, y, addX, addY, color))
			return new int[] { 0, 1 };
		int i;
		int countPlus = 1;
		int countMinus = 1;
		int countAll = 1;
		int plusAvailable = 0;
		int minusAvailable = 0;
		int allAvailable = 0;
		boolean horizonBlank = false;
		boolean verticalBlank = false;
		int horizonPlace = 1;
		int verticalPlace = 1;

		if (chessboard[x][y] != 0) {
			throw new IllegalArgumentException("position x,y must be empty!..");
		}

		for (i = 1; x + i * addX < Constants.SIZE && x + i * addX >= 0
				&& y + i * addY < Constants.SIZE && y + i * addY >= 0; i++) {
			if (chessboard[x + i * addX][y + i * addY] == color) {
				countPlus++;
			} else if (chessboard[x + i * addX][y + i * addY] == 0) {
				if (!horizonBlank) {
					horizonBlank = true;
					horizonPlace = i;
				} else
					break;
			} else
				break;
		}

		if (x + i * addX < Constants.SIZE && x + i * addX >= 0
				&& y + i * addY < Constants.SIZE && y + i * addY >= 0) {
			if (chessboard[x + i * addX][y + i * addY] == 0) {
				plusAvailable++;
				if (countPlus == horizonPlace)
					horizonBlank = false;
				if (horizonBlank && countPlus > chessNum - 2
						&& horizonPlace < chessNum - 1)
					plusAvailable--;
			} else if (chessboard[x + i * addX][y + i * addY] != color
					&& i >= 2)
				if (chessboard[x + (i - 1) * addX][y + (i - 1) * addY] == 0) {
					plusAvailable++;
					horizonBlank = false;
				}
		} else if (i >= 2
				&& chessboard[x + (i - 1) * addX][y + (i - 1) * addY] == 0) {
			plusAvailable++;
			horizonBlank = false;
		}

		for (i = 1; x - i * addX >= 0 && x - i * addX < Constants.SIZE
				&& y - i * addY >= 0 && y - i * addY < Constants.SIZE; i++) {
			if (chessboard[x - i * addX][y - i * addY] == color)
				countMinus++;
			else if (chessboard[x - i * addX][y - i * addY] == 0) {
				if (!verticalBlank) {
					verticalBlank = true;
					verticalPlace = i;
				} else
					break;
			} else
				break;
		}

		if (x - i * addX < Constants.SIZE && x - i * addX >= 0
				&& y - i * addY < Constants.SIZE && y - i * addY >= 0) {
			if (chessboard[x - i * addX][y - i * addY] == 0) {
				minusAvailable++;
				if (countMinus == verticalPlace)
					verticalBlank = false;
				if (verticalBlank && countMinus > chessNum - 2
						&& verticalPlace < chessNum - 1)
					minusAvailable--;
			} else if (chessboard[x - i * addX][y - i * addY] != color
					&& i >= 2) {
				if (chessboard[x - (i - 1) * addX][y - (i - 1) * addY] == 0) {
					minusAvailable++;
					verticalBlank = false;
				}
			} else if (i >= 2
					&& chessboard[x - (i - 1) * addX][y - (i - 1) * addY] == 0) {
				minusAvailable++;
				verticalBlank = false;
			}
		}

		if (!horizonBlank && !verticalBlank) {
			countAll = countPlus + countMinus - 1;
			allAvailable = plusAvailable + minusAvailable;
			return new int[] { countAll, allAvailable };
		} else if (horizonBlank && verticalBlank) {
			int temp = horizonPlace + verticalPlace - 1;
			if (temp >= chessNum)
				return new int[] { temp, 2 };
			if (temp == chessNum - 1)
				return new int[] { temp, 2 };
			if (countPlus + verticalPlace - 1 >= chessNum - 1
					|| countMinus + horizonPlace - 1 >= chessNum - 1)
				return new int[] { 4, 1 };
			if (countPlus + verticalPlace - 1 == chessNum - 2
					&& plusAvailable > 0
					|| countMinus + horizonPlace - 1 == chessNum - 2
					&& minusAvailable > 0)
				return new int[] { 3, 2 };
			return new int[] { 3, 1 };
		} else {
			if (countPlus + countMinus - 1 < chessNum)
				return new int[] { countPlus + countMinus - 1,
						plusAvailable + minusAvailable };
			else {
				if (horizonBlank && countMinus + horizonPlace - 1 >= chessNum)
					return new int[] { countMinus + horizonPlace - 1,
							minusAvailable + 1 };
				if (verticalBlank && countPlus + verticalPlace - 1 >= chessNum)
					return new int[] { countPlus + verticalPlace - 1,
							plusAvailable + 1 };
				if (horizonBlank
						&& (countMinus + horizonPlace - 1 == chessNum - 1
								&& minusAvailable == 1 || horizonPlace == chessNum - 1))
					return new int[] { 4, 2 };
				if (verticalBlank
						&& (countPlus + verticalPlace - 1 == chessNum - 1
								&& plusAvailable == 1 || verticalPlace == chessNum - 1))
					return new int[] { 4, 2 };
				return new int[] { 4, 1 };
			}
		}
	}

	private int getResult(int k) {
		switch (k) {
		case 1:
			return 100000;
		case 2:
			return 30000;
		case 3:
			return 5000;
		case 4:
			return 1000;
		case 5:
			return 500;
		case 6:
			return 200;
		case 7:
			return 100;
		case 8:
			return 50;
		case 9:
			return 10;
		case 10:
			return 5;
		case 11:
			return 3;
		case 12:
			return 2;
		default:
			return 0;
		}
	}

	private int calType(int x, int y, int color) {

		if (chessboard[x][y] != 0)
			return -1;

		int[][] types = new int[4][2];
		types[0] = count(x, y, 0, 1, color);
		types[1] = count(x, y, 1, 0, color);
		types[2] = count(x, y, -1, 1, color);
		types[3] = count(x, y, 1, 1, color);

		int five = 0;
		int deadFour = 0, liveFour = 0;
		int deadThree = 0, liveThree = 0;
		int deadTwo = 0, liveTwo = 0;

		for (int k = 0; k < 4; k++) {
			if (types[k][0] > 5 && chessNum == 5) {
				five++;
			} else if (types[k][0] == 5 && chessNum == 5)
				five++;
			else if (types[k][0] == 4 && types[k][1] == 2)
				liveFour++;
			else if (types[k][0] == 4 && types[k][1] != 2)
				deadFour++;
			else if (types[k][0] == 3 && types[k][1] == 2)
				liveThree++;
			else if (types[k][0] == 3 && types[k][1] != 2)
				deadThree++;
			else if (types[k][0] == 2 && types[k][1] == 2)
				liveTwo++;
			else if (types[k][0] == 2 && types[k][1] != 2)
				deadTwo++;
		}
		if (five != 0)
			return 1;
		if (liveFour != 0 || deadFour >= 2 || deadFour != 0 && liveThree != 0)
			return 2;
		if (liveThree >= 2)
			return 3;
		if (deadThree != 0 && liveThree != 0)
			return 4;
		if (deadFour != 0)
			return 5;
		if (liveThree != 0)
			return 6;
		if (liveTwo >= 2)
			return 7;
		if (deadThree != 0)
			return 8;
		if (liveTwo != 0 && deadTwo != 0)
			return 9;
		if (liveTwo != 0)
			return 10;
		if (deadTwo != 0)
			return 11;
		return 12;
	}

	protected int calResult() {
		int result = 0, computerValue = 2, playerValue = 1;
		int i_min = (border[0] == 0 ? border[0] : border[0] - 1);
		int j_min = (border[2] == 0 ? border[2] : border[2] - 1);
		int i_max = (border[1] == Constants.SIZE ? border[1] : border[1] + 1);
		int j_max = (border[3] == Constants.SIZE ? border[3] : border[3] + 1);
		for (int i = i_min; i < i_max; i++)
			for (int j = j_min; j < j_max; j++)
				if (chessboard[i][j] == 0) {
					int type = calType(i, j, comColor);
					if (type == 1 && chessNum == 5)
						result += 30 * computerValue * getResult(type);
					else if (type == 2)
						result += 10 * computerValue * getResult(type);
					else if (type == 3)
						result += 3 * computerValue * getResult(type);
					else
						result += computerValue * getResult(type);

					type = calType(i, j, playerColor);
					if (type == 1 && chessNum == 5)
						result -= 30 * playerValue * getResult(type);
					else if (type == 2)
						result -= 10 * playerValue * getResult(type);
					else if (type == 3)
						result -= 3 * playerValue * getResult(type);
					else
						result -= playerValue * getResult(type);
				}
		return result;
	}

	public ArrayList<Integer> doAiPlayer(int chessNum) {
		new TimingThread().start();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int max = -INFINITY;
		int returnX = -1;
		int returnY = -1;
		this.chessNum = chessNum;
		for (int i = 0; i<Constants.SIZE;i++) {
			for (int j = 0; j<Constants.SIZE;j++){
				if (chessboard[i][j] == 0){
					if (calType(i, j, comColor) == 1){
						list.add(i + j * Constants.SIZE);		
						return list;
					}
				}
			}
		}
		
		for (int i = 0; i<Constants.SIZE;i++) {
			for (int j = 0; j<Constants.SIZE;j++){
				if (chessboard[i][j] == 0){
					if (calType(i, j, playerColor) == 1){
						list.add(i + j * Constants.SIZE);		
						return list;
					}
				}
			}
		}

		int[][] chessboardStatus = Arrangement(comColor);
		Calculate[] calculate = new Calculate[4];
		for (int i = 0; i <4 ; i++) {
			calculate[i]= new Calculate();
			calculate[i].getStatic(i, chessboardStatus, chessboard);
		}
		for (int i = 0; i <4 ; i++) {
			calculate[i].start();
			System.out.println("线程"+i+"开始");
		}	
		int count=0;
		int bestThread=-1;
		while (true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count=0;
			for (int i =0; i <4 ; i++ ) {
				if (!calculate[i].isOK){
					break;
				}else {
					count++;

				}
			}
			if (count==4) {
				for (int i = 0 ; i <4 ; i ++) {
					if (max<calculate[i].max){
						max=calculate[i].max;
						bestThread=i;
					}
				}
				System.out.println(bestThread);
				returnX=calculate[bestThread].returnX;
				returnY=calculate[bestThread].returnY;
				System.out.println(max);
				break;
			}
		}
		
		resetBorder(returnX, returnY);
		list.add(returnX + returnY * Constants.SIZE);
		return list;
	}
	class Calculate extends Thread {
		int[][] chessboardStatus;
		int[][] chessboard = new int[Constants.SIZE+4][Constants.SIZE+4];
		int[] border = { 0, Constants.SIZE, 0, Constants.SIZE };
		int returnX;
		int returnY;
		int max=-INFINITY;
		int sequence;
		boolean isOK=false;
		public void getStatic(int sequence, int[][] chessboardStatus, int[][] chessboard) {
			this.chessboardStatus=chessboardStatus;
			for (int i = 0; i<Constants.SIZE+4; i++) {
				for (int j = 0 ; j <Constants.SIZE+4; j++) {
					this.chessboard[i][j]=chessboard[i][j];
				}
			}
			this.sequence=sequence;
		}
		public void run(){
			for (int k = sequence; k < chessboardStatus.length; k=k+4) {
				int i = chessboardStatus[k][0];
				int j = chessboardStatus[k][1];
				if (chessNum == 4) {
					int count = 0;
					for (int x = 0; x < Constants.SIZE; x++) {
						for (int y = 0; y < Constants.SIZE; y++) {
							if (chessboard[x][y] == 1) {
								count++;
								if (count > 1) {
									border[0] = (x - 1) > 0 ? (x - 1) : 0;
									border[2] = (y - 1) > 0 ? (y - 1) : 0;
									border[1] = (x + 1) < Constants.SIZE ? (x + 1)
											: Constants.SIZE;
									border[3] = (y + 1) < Constants.SIZE ? (y + 1)
											: Constants.SIZE;
									break;
								}
							}
						}
					}
				}

				int[] borderNew = { border[0], border[1], border[2], border[3] };

				chessboard[i][j] = comColor;
				resetBorder(i, j);

				int t = Beta(-INFINITY, INFINITY, depth);

				chessboard[i][j] = 0;
				border = borderNew;

				Random rm = new Random();
				boolean replace = rm.nextInt() % 3 == 0;

				if (t - max > 1000 || Math.abs(t - max) < 1000 && replace) {
					returnX = i;
					returnY = j;
					max = t;
				}
				
			if (timeOut){
				System.out.println("强制跳出");
				timeOut=false;
				break;
			}
		}
			isOK=true;
			System.out.println("线程"+sequence+"结束,返回值"+max);
		}
		private void resetBorder(int x, int y) {
			if (x - 1 >= 0)
				border[0] = (border[0] < x - 1 ? border[0] : x - 1);
			if (x + 1 <= Constants.SIZE)
				border[1] = (border[1] > x + 1 ? border[1] : x + 1);
			if (y - 1 >= 0)
				border[2] = (border[2] < y - 1 ? border[2] : y - 1);
			if (y + 1 <= Constants.SIZE)
				border[3] = (border[3] > y + 1 ? border[3] : y + 1);
		}

		private Boolean isAvailable(int x, int y, int addX, int addY, int color) {
			int count = 1;
			for (int i = 1; (x + i * addX < Constants.SIZE) && (x + i * addX >= 0)
					&& (y + i * addY < Constants.SIZE) && (y + i * addY >= 0)
					&& (count < chessNum); i++) {
				if ((chessboard[x + i * addX][y + i * addY] == color)
						|| (chessboard[x + i * addX][y + i * addY] == 0))
					count++;
				else
					break;
			}

			for (int i = 1; (x - i * addX >= 0) && (x - i * addX < Constants.SIZE)
					&& (y - i * addY >= 0) && (y - i * addY < Constants.SIZE)
					&& (count < chessNum); i++) {
				if ((chessboard[x - i * addX][y - i * addY] == color)
						|| (chessboard[x - i * addX][y - i * addY] == 0))
					count++;
				else
					break;
			}
			return (count >= chessNum);
		}

		private int Alpha(int alpha, int beta, int depth) {

			int max = alpha;
			if (depth == 0) {
				return calResult();
			}

			int[][] chessboardStatus = Arrangement(comColor);
			for (int i = 0; i < chessboardStatus.length; i++) {
				int x = chessboardStatus[i][0];
				int y = chessboardStatus[i][1];
				if (calType(x, y, comColor) == 1) {
					return 100 * (getResult(1) + depth * 1000);
				}
				chessboard[x][y] = comColor;

				int[] borderNew = { border[0], border[1], border[2], border[3] };
				resetBorder(x, y);
				int t = Beta(max, beta, depth - 1);
				chessboard[x][y] = 0;

				border = borderNew;
				if (t > max) {
					max = t;
				}
				if (max >= beta) {
					return max;
				}
			}
			return max;
		}

		private int Beta(int alpha, int beta, int depth) {
			int min = beta;
			if (depth == 0) {
				return calResult();
			}
			int[][] chessboardStatus = Arrangement(playerColor);
			for (int i = 0; i < chessboardStatus.length; i++) {
				int x = chessboardStatus[i][0];
				int y = chessboardStatus[i][1];
				if (calType(x, y, playerColor) == 1) {
					return -100 * (getResult(1) + depth * 1000);
				}
				int[] borderNew = { border[0], border[1], border[2], border[3] };
				chessboard[x][y] = playerColor;
				resetBorder(x, y);
				int t = Alpha(alpha, min, depth - 1);
				chessboard[x][y] = 0;

				border = borderNew;
				if (t < min) {
					min = t;
				}
				if (min <= alpha) {
					return min;
				}
			}
			return min;
		}

		private int[][] Arrangement(int color) {

			int diffcolor = (color == comColor) ? playerColor : comColor;

			int minX = (border[0] == 0 ? border[0] : border[0] - 1);
			int minY = (border[2] == 0 ? border[2] : border[2] - 1);
			int maxX = (border[1] == Constants.SIZE ? border[1] : border[1] + 1);
			int maxY = (border[3] == Constants.SIZE ? border[3] : border[3] + 1);

			int count = 0;
			int[] getValue = new int[2];
			int[][] chessboardStatus = new int[(maxX - minX) * (maxY - minY)][3];
			for (int i = minX; i < maxX; i++)
				for (int j = minY; j < maxY; j++)
					if (chessboard[i][j] == 0) {
						getValue[0] = calType(i, j, color);
						getValue[1] = calType(i, j, diffcolor);
						chessboardStatus[count][0] = i;
						chessboardStatus[count][1] = j;
						chessboardStatus[count][2] = getResult(getValue[0])
								+ getResult(getValue[1]);
						count++;
					}

			Arrays.sort(chessboardStatus, new ArrComparator());
			int size = (weight > count) ? count : weight;
			int[][] arrange = new int[size][3];
			System.arraycopy(chessboardStatus, 0, arrange, 0, size);
			return arrange;
		}

		private int[] count(int x, int y, int addX, int addY, int color) {

			if (!isAvailable(x, y, addX, addY, color))
				return new int[] { 0, 1 };
			int i;
			int countPlus = 1;
			int countMinus = 1;
			int countAll = 1;
			int plusAvailable = 0;
			int minusAvailable = 0;
			int allAvailable = 0;
			boolean horizonBlank = false;
			boolean verticalBlank = false;
			int horizonPlace = 1;
			int verticalPlace = 1;

			if (chessboard[x][y] != 0) {
				throw new IllegalArgumentException("position x,y must be empty!..");
			}

			for (i = 1; x + i * addX < Constants.SIZE && x + i * addX >= 0
					&& y + i * addY < Constants.SIZE && y + i * addY >= 0; i++) {
				if (chessboard[x + i * addX][y + i * addY] == color) {
					countPlus++;
				} else if (chessboard[x + i * addX][y + i * addY] == 0) {
					if (!horizonBlank) {
						horizonBlank = true;
						horizonPlace = i;
					} else
						break;
				} else
					break;
			}

			if (x + i * addX < Constants.SIZE && x + i * addX >= 0
					&& y + i * addY < Constants.SIZE && y + i * addY >= 0) {
				if (chessboard[x + i * addX][y + i * addY] == 0) {
					plusAvailable++;
					if (countPlus == horizonPlace)
						horizonBlank = false;
					if (horizonBlank && countPlus > chessNum - 2
							&& horizonPlace < chessNum - 1)
						plusAvailable--;
				} else if (chessboard[x + i * addX][y + i * addY] != color
						&& i >= 2)
					if (chessboard[x + (i - 1) * addX][y + (i - 1) * addY] == 0) {
						plusAvailable++;
						horizonBlank = false;
					}
			} else if (i >= 2
					&& chessboard[x + (i - 1) * addX][y + (i - 1) * addY] == 0) {
				plusAvailable++;
				horizonBlank = false;
			}

			for (i = 1; x - i * addX >= 0 && x - i * addX < Constants.SIZE
					&& y - i * addY >= 0 && y - i * addY < Constants.SIZE; i++) {
				if (chessboard[x - i * addX][y - i * addY] == color)
					countMinus++;
				else if (chessboard[x - i * addX][y - i * addY] == 0) {
					if (!verticalBlank) {
						verticalBlank = true;
						verticalPlace = i;
					} else
						break;
				} else
					break;
			}

			if (x - i * addX < Constants.SIZE && x - i * addX >= 0
					&& y - i * addY < Constants.SIZE && y - i * addY >= 0) {
				if (chessboard[x - i * addX][y - i * addY] == 0) {
					minusAvailable++;
					if (countMinus == verticalPlace)
						verticalBlank = false;
					if (verticalBlank && countMinus > chessNum - 2
							&& verticalPlace < chessNum - 1)
						minusAvailable--;
				} else if (chessboard[x - i * addX][y - i * addY] != color
						&& i >= 2) {
					if (chessboard[x - (i - 1) * addX][y - (i - 1) * addY] == 0) {
						minusAvailable++;
						verticalBlank = false;
					}
				} else if (i >= 2
						&& chessboard[x - (i - 1) * addX][y - (i - 1) * addY] == 0) {
					minusAvailable++;
					verticalBlank = false;
				}
			}

			if (!horizonBlank && !verticalBlank) {
				countAll = countPlus + countMinus - 1;
				allAvailable = plusAvailable + minusAvailable;
				return new int[] { countAll, allAvailable };
			} else if (horizonBlank && verticalBlank) {
				int temp = horizonPlace + verticalPlace - 1;
				if (temp >= chessNum)
					return new int[] { temp, 2 };
				if (temp == chessNum - 1)
					return new int[] { temp, 2 };
				if (countPlus + verticalPlace - 1 >= chessNum - 1
						|| countMinus + horizonPlace - 1 >= chessNum - 1)
					return new int[] { 4, 1 };
				if (countPlus + verticalPlace - 1 == chessNum - 2
						&& plusAvailable > 0
						|| countMinus + horizonPlace - 1 == chessNum - 2
						&& minusAvailable > 0)
					return new int[] { 3, 2 };
				return new int[] { 3, 1 };
			} else {
				if (countPlus + countMinus - 1 < chessNum)
					return new int[] { countPlus + countMinus - 1,
							plusAvailable + minusAvailable };
				else {
					if (horizonBlank && countMinus + horizonPlace - 1 >= chessNum)
						return new int[] { countMinus + horizonPlace - 1,
								minusAvailable + 1 };
					if (verticalBlank && countPlus + verticalPlace - 1 >= chessNum)
						return new int[] { countPlus + verticalPlace - 1,
								plusAvailable + 1 };
					if (horizonBlank
							&& (countMinus + horizonPlace - 1 == chessNum - 1
									&& minusAvailable == 1 || horizonPlace == chessNum - 1))
						return new int[] { 4, 2 };
					if (verticalBlank
							&& (countPlus + verticalPlace - 1 == chessNum - 1
									&& plusAvailable == 1 || verticalPlace == chessNum - 1))
						return new int[] { 4, 2 };
					return new int[] { 4, 1 };
				}
			}
		}

		private int getResult(int k) {
			switch (k) {
			case 1:
				return 100000;
			case 2:
				return 30000;
			case 3:
				return 5000;
			case 4:
				return 1000;
			case 5:
				return 500;
			case 6:
				return 200;
			case 7:
				return 100;
			case 8:
				return 50;
			case 9:
				return 10;
			case 10:
				return 5;
			case 11:
				return 3;
			case 12:
				return 2;
			default:
				return 0;
			}
		}

		private int calType(int x, int y, int color) {

			if (chessboard[x][y] != 0)
				return -1;

			int[][] types = new int[4][2];
			types[0] = count(x, y, 0, 1, color);
			types[1] = count(x, y, 1, 0, color);
			types[2] = count(x, y, -1, 1, color);
			types[3] = count(x, y, 1, 1, color);

			int five = 0;
			int deadFour = 0, liveFour = 0;
			int deadThree = 0, liveThree = 0;
			int deadTwo = 0, liveTwo = 0;

			for (int k = 0; k < 4; k++) {
				if (types[k][0] > 5 && chessNum == 5) {
					five++;
				} else if (types[k][0] == 5 && chessNum == 5)
					five++;
				else if (types[k][0] == 4 && types[k][1] == 2)
					liveFour++;
				else if (types[k][0] == 4 && types[k][1] != 2)
					deadFour++;
				else if (types[k][0] == 3 && types[k][1] == 2)
					liveThree++;
				else if (types[k][0] == 3 && types[k][1] != 2)
					deadThree++;
				else if (types[k][0] == 2 && types[k][1] == 2)
					liveTwo++;
				else if (types[k][0] == 2 && types[k][1] != 2)
					deadTwo++;
			}
			if (five != 0)
				return 1;
			if (liveFour != 0 || deadFour >= 2 || deadFour != 0 && liveThree != 0)
				return 2;
			if (liveThree >= 2)
				return 3;
			if (deadThree != 0 && liveThree != 0)
				return 4;
			if (deadFour != 0)
				return 5;
			if (liveThree != 0)
				return 6;
			if (liveTwo >= 2)
				return 7;
			if (deadThree != 0)
				return 8;
			if (liveTwo != 0 && deadTwo != 0)
				return 9;
			if (liveTwo != 0)
				return 10;
			if (deadTwo != 0)
				return 11;
			return 12;
		}

		protected int calResult() {
			int result = 0, computerValue = 2, playerValue = 1;
			int i_min = (border[0] == 0 ? border[0] : border[0] - 1);
			int j_min = (border[2] == 0 ? border[2] : border[2] - 1);
			int i_max = (border[1] == Constants.SIZE ? border[1] : border[1] + 1);
			int j_max = (border[3] == Constants.SIZE ? border[3] : border[3] + 1);
			for (int i = i_min; i < i_max; i++)
				for (int j = j_min; j < j_max; j++)
					if (chessboard[i][j] == 0) {
						int type = calType(i, j, comColor);
						if (type == 1 && chessNum == 5)
							result += 30 * computerValue * getResult(type);
						else if (type == 2)
							result += 10 * computerValue * getResult(type);
						else if (type == 3)
							result += 3 * computerValue * getResult(type);
						else
							result += computerValue * getResult(type);

						type = calType(i, j, playerColor);
						if (type == 1 && chessNum == 5)
							result -= 30 * playerValue * getResult(type);
						else if (type == 2)
							result -= 10 * playerValue * getResult(type);
						else if (type == 3)
							result -= 3 * playerValue * getResult(type);
						else
							result -= playerValue * getResult(type);
					}
			return result;
		}
	}
	class TimingThread extends Thread {
		public void run() {
			try {
				sleep(restrictTime);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			timeOut = true;

		}

	}

}