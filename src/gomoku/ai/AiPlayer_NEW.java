package gomoku.ai;

import gomoku.constants.Constants;

import java.util.ArrayList;

/**
 * 
 * @author Cee
 * @version 2013.4.20
 */

public class AiPlayer_NEW {
	private int[][] chessboard;
	private int[][] flag;
	private int comColor;
	private int playerColor;
	public void SetData(int[][] chessboard, int[][] flag , int comColor, int playerColor) {
		this.chessboard=chessboard;
		this.flag=flag;
		this.comColor=comColor;
		this.playerColor=playerColor;
	}		
	
	public ArrayList<Integer> AIPlayer(){
		int maxAttack = 0;
		int maxDefend = 0;
		boolean out = false;
		 
		int maxTrueFour = 0;
		int maxTrueThree = 0;
		int maxPlayerFour = 0;
		int doubleThree =  0;
		
		ArrayList<Integer> listAttack = new ArrayList<Integer>();
		ArrayList<Integer> listDefend = new ArrayList<Integer>();
		ArrayList<Integer> listFour = new ArrayList<Integer>();
		ArrayList<Integer> listThree = new ArrayList<Integer>();
		ArrayList<Integer> listDoubleThree = new ArrayList<Integer>();
		ArrayList<Integer> listPlayerFour = new ArrayList<Integer>();
		
		for (int i = 0;i < Constants.SIZE; i++){
			if (!out){
				for (int j = 0; j< Constants.SIZE; j++){				
					
					int attack = 0, defend = 0;
					if (flag[i][j] == 0){	
						
						boolean available = true;	
						
						int[] comValue = getValue(i,j,comColor);
						int[] playerValue = getValue(i,j,playerColor);
						
					
						//5 chesses check

						if (comValue[0] > 0){
							out = true;
							listAttack.clear();
							listAttack.add(i + Constants.SIZE * j);
							maxAttack = Constants.MAXINT;
							maxDefend = 0;
							break;
						}
						
						if (playerValue[0] > 0){
							out = true;
							listDefend.clear();
							listDefend.add(i + Constants.SIZE * j);
							maxDefend = Constants.MAXINT;
							break;
						}

						//4 true chesses check
						if (comValue[2] > maxTrueFour){
							maxTrueFour =  comValue[2];
							listFour.clear();
							listFour.add(i + Constants.SIZE * j);
							available = false;
						}
						else if (comValue[2] == maxTrueFour){
							listFour.add(i + Constants.SIZE * j);
							available = false;
						}
						
						if (playerValue[2] > maxPlayerFour){
							maxPlayerFour =  playerValue[2];
							listPlayerFour.clear();
							listPlayerFour.add(i + Constants.SIZE * j);
							available = false;
						}
						else if (playerValue[2] == maxPlayerFour){
							listPlayerFour.add(i + Constants.SIZE * j);
							available = false;
						}


						//double 3 chesses check 
												
						if ((comValue[4] > 1) && available){
							attack =  32768 * comValue[4];
							if (comValue[4] > maxTrueThree){
								maxTrueThree =  comValue[4];
								listThree.clear();
								listThree.add(i + Constants.SIZE * j);
							}
							else if (comValue[4] == maxTrueThree){
								listThree.add(i + Constants.SIZE * j);
							}
							available = false;
						}

						
						if ((playerValue[4] > 1) && available){
							defend =  32768 * playerValue[4];
							if (playerValue[4] > doubleThree){							
								doubleThree =  playerValue[4];
								listDoubleThree.clear();
								listDoubleThree.add(i + Constants.SIZE * j);
							}
							else if (playerValue[4] == doubleThree){
								listDoubleThree.add(i + Constants.SIZE * j);
							}
							available = false;
						}
						
						//others
						

						if (((comValue[3] > 0) || (comValue[2] > 0))&& available){
							attack += 65536 * (comValue[3]+comValue[2]);
							//available = false;
						}
					

						if ((comValue[4] > 0) && available){
							attack += 4096 * (comValue[4]);
							//available = false;
						}
					
			
						if ((comValue[6] > 1) && available){
							attack += 64 * comValue[6];
							//available = false;
						}
					
						if ((comValue[5] > 0) && available){
							attack += 2048 * comValue[5];
							//available = false;
						}
					
						if ((comValue[6] > 0) && available){
							attack += 4 * comValue[6];
							//available = false;
						}
					
						if ((comValue[7] > 0) && available){
							attack +=  comValue[7];
							//available = false;
						}

						if (attack > maxAttack){
							listAttack.clear();
							listAttack.add(i + Constants.SIZE * j);
							maxAttack = attack;
						}
						if (attack == maxAttack){
							listAttack.add(i + Constants.SIZE * j);
						}
					
						
						available = true;
						
						
						if (((playerValue[3] > 0) || (playerValue[2] > 0))&& available){
							defend += 65536 * (playerValue[3]+playerValue[2]);
							//available = false;
						}
								
						if ((playerValue[4] > 0)  && available){
							defend += 32768 * (playerValue[4]);
							//available = false;
						}
					
						if ((playerValue[6] > 1) && available){
							defend += 64 * playerValue[6];
							//available = false;
						}
						
						if ((playerValue[5] > 0) && available){
							defend += 16384 * playerValue[5];
							//available = false;
						}
					
						if ((playerValue[6] > 0) && available){
							defend += 4 * playerValue[6];
							//available = false;
						}
					
						if ((playerValue[7] > 0) && available){
							defend += playerValue[7];
							//available = false;
						}
						if (defend > maxDefend){
							listDefend.clear();
							listDefend.add(i + Constants.SIZE * j);
							maxDefend = defend;
						}
						if (defend == maxDefend){
							listDefend.add(i + Constants.SIZE * j);
						}						
						
											
					}				
				}
			}
				else{
					break;
				}
		}

		if (maxAttack == Constants.MAXINT){
			return listAttack;
		}
		if (maxDefend == Constants.MAXINT){
			return listDefend;
		}
		else {
			
			if (maxTrueFour != 0){
				return listFour;
			}
			if (maxTrueThree > 1){
				return listThree;
			}
			if (maxPlayerFour != 0){
				return listPlayerFour;
			}
			if (doubleThree > 1){
				return listDoubleThree;
			}
			if (maxAttack >= maxDefend) {
				return listAttack;
			}
			else {
				return listDefend;
			}	

		}
		
	}
	
	
	public int[] getValue(int x,int y,int color){
		int[] value = new int[8];
		value[0] = getAnswer(x,y,color,5,true);
		value[1] = getAnswer(x,y,color,5,false);
		value[2] = getAnswer(x,y,color,4,true);
		value[3] = getAnswer(x,y,color,4,false);
		value[4] = getAnswer(x,y,color,3,true);
		value[5] = getAnswer(x,y,color,3,false);
		value[6] = getAnswer(x,y,color,2,true);
		value[7] = getAnswer(x,y,color,2,false);
		return value;
	}
	
	public int getAnswer(int x,int y,int color,int num,boolean require){
		int result = 0;
		if (flag[x][y] == 0){
			chessboard[x][y] = color;
			flag[x][y] = 1;  
			result = calResult(num,require,x,y,color);
			flag[x][y] = 0;
			chessboard[x][y] = 0;
		}
		return result;
	}
	public int calResult(int up, boolean require,int x,int y,int color){
		chessboard[x][y] = color;
		flag[x][y] = 1; 
		int result = 0;
		int max = up - 1;
		int diffColor;
		diffColor = color==1?2:1;
		for (int p = 0; p <= max; p++){
			int rx = x - p;
			int ry = y - p;
			if ((rx >= 0) && (rx + max <= Constants.SIZE)){
				boolean isTrue = true;
				for (int q = 0; q <= max; q++){
					if (!(isTrue = (isTrue && (chessboard[rx+q][y] == color)))){
						break;
					}
				}
				if (isTrue){
					if (checkout(rx-1,y,rx+up,y,up,require,diffColor)){
						result++;
					}		
				}
			}
			if ((ry >= 0) && (ry + max <= Constants.SIZE)){
				boolean isTrue = true;
				for (int q = 0; q <= max; q++){
					if (!(isTrue = (isTrue && (chessboard[x][ry+q] == color)))){
						break;
					}
				}
				if (isTrue){
					if (checkout(x,ry,x,ry+up,up,require,diffColor)){
						result++;
					}		
				}
			}
			if ((rx >= 0) && (rx + max <= Constants.SIZE) && (ry >= 0) && (ry + max <= Constants.SIZE)){
				boolean isTrue = true;
				for (int q = 0; q <= max; q++){
					if (!(isTrue = (isTrue && (chessboard[rx+q][ry+q] == color)))){
						break;
					}
				}
				if (isTrue){
					if (checkout(rx-1,ry-1,rx+up,ry+up,up,require,diffColor)){
						result++;
					}		
				}
			}
			rx = x + p;
			if ((rx - max >= 0) && (rx <= Constants.SIZE) && (ry >= 0) && (ry + max <=Constants.SIZE)){
				boolean isTrue = true;
				for (int q = 0; q <= max; q++){
					if (!(isTrue = (isTrue && (chessboard[rx-q][ry+q] == color)))){
						break;
					}
				}
				if (isTrue){
					if (checkout(rx-up,ry+up,rx+1,ry-1,up,require,diffColor)){
						result++;
					}		
				}
			}
		}
		flag[x][y] = 0;
		chessboard[x][y] = 0;
		return result;
		
	}
	public boolean checkout(int a,int b,int c,int d,int up,boolean require,int diffColor){
		if (up == 5){
			return true;
		}
		else {
			boolean bool;
			if (require){
				bool = (a >= 0) && (a <= Constants.SIZE) && (b >= 0) && (b <= Constants.SIZE) && (chessboard[a][b] != diffColor);
				bool = bool || ((c >= 0) && (c <= Constants.SIZE) && (d >= 0) && (d <= Constants.SIZE) && (chessboard[c][d] != diffColor));
			}
			else{
				bool = (a >= 0) && (a <= Constants.SIZE) && (b >= 0) && (b <= Constants.SIZE) && (chessboard[a][b] == diffColor);
				bool = bool || ((c >= 0) && (c <= Constants.SIZE) && (d >= 0) && (d <= Constants.SIZE) && (chessboard[c][d] == diffColor));
			}
			if (bool){
				return true;
			}
		}
		return false;
	}	
}