package gomoku.main.guiboard;

import gomoku.ai.AiPlayer;
import gomoku.constants.Constants;
import gomoku.gamepanel.DialogCreator;
import gomoku.language.Language;
import gomoku.player.HumanPlayer;
import gomoku.player.Player;
import gomoku.sound.Media;
import gomoku.sound.Sound;
import gomoku.theme.Theme;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * @author luck
 * @version 2013.4.1.1:00
 * 棋盘按钮
 * 引入玩家
 * 用户与数据的中转站
 */
public class DoubleGuiBoard extends GuiBoard {
	private JPanel longPanel;
	private static final long serialVersionUID = 1L;
	public boolean Single=true;
	public boolean isOK = false;
	public Player player1 = new HumanPlayer("玩家1");
	public Player player2 = new CpuPlayer("电脑");
	public Player player3 = new CpuPlayer("另一台电脑");
	protected MouseHandle mousehandle[][] = new MouseHandle[Constants.SIZE][Constants.SIZE];
	JLabel darkLabel[][] = new JLabel[4][4];
	
	public int SendRow;
	public int SendColumn;
	public int SendColor;
	public boolean isClicked=false;
	public boolean isThinking=false;
	public DoubleGuiBoard() {
		for (int i=0;i<15;i++) {
			for (int j=0;j<15;j++) {
				mousehandle[i][j]= new MouseHandle(i,j);
			}
		}	
	}	
	/**
	 * 给按钮加监听
	 */
	public void AddListener() {
		for (int i=0;i<15;i++) {
			for (int j=0;j<15;j++) {
				buttonList[i][j].addMouseListener(mousehandle[i][j]);
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
	 * 
	 * @author luck
	 * @version 2013.3.30
	 * 内部类 监听
	 */
	class MouseHandle extends MouseAdapter {
		int X;
		int Y;
		public MouseHandle(int a, int b) {
			X=a;
			Y=b;
		}
		/**
		 * 监听1： 鼠标移动到相应位置显示choose图标
		 * 
		 */
		public void mouseEntered(MouseEvent e) {
			if (flag[X][Y] == 0) {
				
				((JButton) e.getSource()).setIcon(new ImageIcon(Theme.choose));
			}
		}
		/**
		 * 监听2：鼠标离开图标消失
		 */
		public void mouseExited(MouseEvent e) { 
			if(flag[X][Y] == 0) {
				((JButton) e.getSource()).setIcon(null);
			}
		}
		/**
		 * 监听3： 下去
		 */
		public void mouseClicked(MouseEvent e){
			if(flag[X][Y] == 0) {
				buttonList[X][Y].setIcon(new ImageIcon( color==Constants.BLACK? Theme.black:Theme.white));
				Media.playSound(Sound.move);
				check(X,Y);
				flag[X][Y]=1;
				Retractable=true;
				step++;
				
//				CheckModel();
				new addChessThread().start();
			}
		}
		class addChessThread extends Thread{
			public void run(){
				if (isOK){
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}		
				}			
				CheckModel();
			}
		}
	}

	/*
	 * 判断游戏模式
	 */
	public void CheckModel(){
		if (Single){
			SinglePlay();
		} else {
			DoublePlay();
		}
	}
	public void removenewListener(){	
	}
	public void SinglePlay() {	
		if (isWin) {
			removeListener();
			removenewListener();
		}else if (isOK) {
			changeplayer();
			player2.play();
			changeplayer();
		}
		
	
		
	}
	public void DoublePlay() {
		if (isWin) {
			removeListener();
			removenewListener();
		} else if (isOK) {
			changeplayer();
			
		}
	}	
	
	
	/**
	 * 
	 * @param a
	 * @param b
	 * 判断胜负
	 * @throws IOException 
	 */
	
	public void check(int a, int b) { 
		chessboard.set(a,b,color,activeplayer);
		isWin=(!(checkWin.checkWin(a, b, chessboard.getChessBoard())==null));
		if (isWin) {
			removeListener();
			isEnd=false;
			//JOptionPane.showMessageDialog(null,color==1?Language.BLACKWIN:Language.WHITEWIN);
			int pass= DialogCreator.oneButtonDialog(null, color==1?Language.BLACKWIN:Language.WHITEWIN);
			
			if (pass==1&&activeplayer==1){
				
				isPass=true;
				isEnd=true;
			} else {
				isEnd = true;
			}
			
		}
		color=color==1?2:1;
	}



	public Integer[] unset() {
		Integer temp[] = chessboard.unset();
		buttonList[temp[0]][temp[1]].setIcon(null);
		flag[temp[0]][temp[1]]=0;
		changecolor();
		changeplayer();
		Retractable=false;
		return temp;
	}
	public Integer[] netunset() {
		Integer temp[] = chessboard.unset();
		buttonList[temp[0]][temp[1]].setIcon(null);
		flag[temp[0]][temp[1]]=0;
		Retractable=false;
		return temp;
	}
	/**
	 * 
	 * @author luck
	 * AI操作
	 */
	class CpuPlayer extends Player{
		public CpuPlayer(String name) {
			super(name);
		}
		/**
		 * @override
		 */
		public String choose() {
			String[] swapChoose = {Language.CHOOSEBLACK,Language.CHOOSEWHITE,Language.DOMORE};
			int rand = (int)(Math.random() * swapChoose.length);
			String selectSwap = swapChoose[rand];
			return selectSwap;
		}
		/**
		 * @override
		 */
		public String chooseagain() {
			String[] swapChoose = {Language.CHOOSEBLACK,Language.CHOOSEWHITE};
			int rand = (int)(Math.random() * swapChoose.length);
			String selectSwap = swapChoose[rand];
			return selectSwap;
		}
		public void specialPlay(int Cpu){
			AiPlayer AI= new AiPlayer();
			removeListener();
			removenewListener();
			Retractable=false;
			int i , j; 
			if (isOK){
				System.out.println(Cpu);
				AI.SetData(chessboard.getChessBoard(), flag, comColor, playerColor,step);
				ArrayList<Integer> list = AI.doAiPlayer(4);
				j = (int)(list.get(0) / Constants.SIZE);
				i = (int)(list.get(0) - Constants.SIZE * j);
				
			}
			else{
				int[] border = new int[4];
				border[0] = Constants.SIZE;
				border[2] = Constants.SIZE;
				border[1] = 0;
				border[3] = 0;
				int[][] nowBoard = chessboard.getChessBoard();
				for(int x = 0; x < Constants.SIZE; x++){
					for (int y =  0; y < Constants.SIZE; y++){
						if (nowBoard[x][y] != 0){
							border[0] = x < border[0]?x:border[0];
							border[2] = y < border[2]?y:border[2];
							border[1] = x > border[1]?x:border[1];
		        			border[3] = y > border[3]?y:border[3];
						}
 			        }
		        }
				
			    int minX = (border[0] == 0 ? border[0]:border[0]-1);
			    int minY = (border[2] == 0 ? border[2]:border[2]-1);
			    int maxX = (border[1] == Constants.SIZE ? border[1]:border[1]+1);
			    int maxY = (border[3] == Constants.SIZE ? border[3]:border[3]+1);
				
				i = (int) (Math.random()*(maxX-minX)) + minX;
				j = (int) (Math.random()*(maxY-minY)) + minY;
				while (flag[i][j]==1) {
					i = (int) (Math.random()*(maxX-minX)) + minX;
					j = (int) (Math.random()*(maxY-minY)) + minY;
				} 
			}			

			buttonList[i][j].setIcon(new ImageIcon(color == Constants.WHITE? Theme.white:Theme.red));

			check(i, j);

			flag[i][j]=1;	
			step++;
			if (!isWin&&activeplayer==3){
				AddListener();
			}
			System.out.println(activeplayer+"动了");
			new checkModelThread().start();
			Retractable=true;
			
		}
		/**
		 * @override
		 * 暂时是随机数模式 坐等AI
		 */
		public void play() {
			AiPlayer AI= new AiPlayer();
			Retractable=false;
			isThinking=true;
			removeListener();
			removenewListener();
			int i , j; 
			if (isOK){
				AI.SetData(chessboard.getChessBoard(), flag, comColor, playerColor,step);
				ArrayList<Integer> list = AI.doAiPlayer(5);
				j = (int)(list.get(0) / Constants.SIZE);
				i = (int)(list.get(0) - Constants.SIZE * j);
			}
			else{	
				int[] border = new int[4];
				border[0] = Constants.SIZE;
				border[2] = Constants.SIZE;
				border[1] = 0;
				border[3] = 0;
				int[][] nowBoard = chessboard.getChessBoard();
				for(int x = 0; x < Constants.SIZE; x++){
					for (int y =  0; y < Constants.SIZE; y++){
						if (nowBoard[x][y] != 0){
							border[0] = x < border[0]?x:border[0];
							border[2] = y < border[2]?y:border[2];
							border[1] = x > border[1]?x:border[1];
		        			border[3] = y > border[3]?y:border[3];
						}
 			        }
		        }
				
			    int minX = (border[0] == 0 ? border[0]:border[0]-1);
			    int minY = (border[2] == 0 ? border[2]:border[2]-1);
			    int maxX = (border[1] == Constants.SIZE ? border[1]:border[1]+1);
			    int maxY = (border[3] == Constants.SIZE ? border[3]:border[3]+1);
				
				i = (int) (Math.random()*(maxX-minX)) + minX;
				j = (int) (Math.random()*(maxY-minY)) + minY;
				while (flag[i][j]==1) {
					i = (int) (Math.random()*(maxX-minX)) + minX;
					j = (int) (Math.random()*(maxY-minY)) + minY;
				} 
			}			
			buttonList[i][j].setIcon(new ImageIcon(color == Constants.BLACK? Theme.black:Theme.white));
			check(i, j);
			flag[i][j]=1;	
			step++;
			if (!isWin){
				AddListener();
			}
			Retractable=true;
			isThinking=false;
	}
	
	}
	class checkModelThread extends Thread {
		public void run(){
			changeplayer();
			if (activeplayer==1){
				return;
			}else if (CpuNumber==2){
				if (activeplayer==2){
					player2.specialPlay(2);
				} else if(activeplayer==3){
					player3.specialPlay(3);
				}
			}
		}
	}
	public void changeplayer() {
		activeplayer=activeplayer==1?2:1;
		nextplayer=nextplayer==1?2:1;
		System.out.println(activeplayer);
	}
	public void changecolor() {
		color= color==1?2:1;
	}
	public void initialNumber() {		
	}
	public void disturb() {
	}
	public void setCpu() {
		player2= new CpuPlayer("CpuPlayer");
	}
	public void addCpu(){
		
	}
	public void addLong(){

		new MoveThread().start();
	}
	public void addLongPanel(){
		this.add(longPanel, new Integer(Integer.MAX_VALUE));
	}
	public void addChange(){
		addDark();		 

		new ChangeThread().start();
	}
	class ChangeThread extends Thread{
		public void run(){
			longPanel = new JPanel();
			longPanel.setVisible(true);
			longPanel.setOpaque(false);
			longPanel.setLayout(null);
			longPanel.setBounds(0,0,450,450);

			addLongPanel();

			ImageIcon longIcon = new ImageIcon("png/long.png");
			JLabel jlbLong  = new JLabel(longIcon);
			jlbLong.setBounds(0, 0, longIcon.getIconWidth(), longIcon.getIconHeight());
			int isDark=0;
			int x=0;
			while (!isWin){
				while (isDark!=49){
					try {
						sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					isDark=(int) (Math.random()*100);
					System.out.println(isDark);
				}
				deleteDark();

				longPanel.add(jlbLong);
				longPanel.setVisible(true);
				while (isDark!=50){
					x=x-5;
					jlbLong.setBounds(x,0,longIcon.getIconWidth(),longIcon.getIconHeight());
					try {
						sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	
					isDark=(int) (Math.random()*100);
					System.out.println("long"+isDark);
				}
				longPanel.setVisible(false);
				addIcon();
				System.out.println("++");

			}	

		}
	}
	class MoveThread extends Thread{
		public void run(){
			longPanel = new JPanel();
			addLongPanel();
			longPanel.setOpaque(false);
			longPanel.setLayout(null);
			longPanel.setBounds(0,0,450,450);
			ImageIcon longIcon = new ImageIcon("png/long.png");
			JLabel jlbLong  = new JLabel(longIcon);
			jlbLong.setBounds(0, 0, longIcon.getIconWidth(), longIcon.getIconHeight());
			longPanel.add(jlbLong);
			while (true){
				int x=0;
				while (!isWin){
					x=x-5;
					jlbLong.setBounds(x,0,longIcon.getIconWidth(),longIcon.getIconHeight());
					try {
						sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}
	public void addDark(){
		for (int i =0 ; i<4 ; i++) {
			for (int j = 0; j< 4 ; j++) {
				darkLabel[i][j] = new JLabel(new ImageIcon(Theme.Dark+j+""+i+".png"));
				darkLabel[i][j].setBounds(116*i+5,116*j+5,116,116);
				this.add(darkLabel[i][j]);				
				darkLabel[i][j].addMouseListener(new DarkListener(i,j));
				
			}
		}
	}
	public void deleteDark(){
		for (int i =0 ; i<4 ; i++) {
			for (int j = 0; j< 4 ; j++) {
				darkLabel[i][j].setEnabled(false);
				darkLabel[i][j].setVisible(false);
			}
			
		}
	}
	public void addIcon(){
		for (int i =0 ; i<4 ; i++) {
			for (int j = 0; j< 4 ; j++) {
				darkLabel[i][j].setEnabled(true);
				darkLabel[i][j].setVisible(true);
				
			}
		}
	}

class DarkListener implements MouseListener{
	int i,j;
	public DarkListener(int i, int j){		
		this.i=i;
		this.j=j;
	}
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		darkLabel[i][j].setVisible(false);
	}
	
	class ReformThread extends Thread {
		public void run(){
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}			
			if(darkLabel[i][j].isEnabled()){
				darkLabel[i][j].setVisible(true);	
			}
						
//			darkLabel[i][j].setIcon(new ImageIcon(Theme.Dark+j+""+i+".png"));
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if (darkLabel[i][j].isEnabled()){
			new ReformThread().start();	
		}
		
		
	}
}
	
}