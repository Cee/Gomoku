package gomoku.career;


import gomoku.constants.Constants;
import gomoku.gamepanel.DialogCreator;
import gomoku.gamepanel.GamePanel;
import gomoku.gamepanel.SingleGamePanel;
import gomoku.gamepanel.special.DisturbPanel;
import gomoku.gamepanel.special.SingleMovablePanel;
import gomoku.gamepanel.special.ThreePlayerGamePanel;
import gomoku.main.Gomoku;
import gomoku.sound.Media;
import gomoku.sound.Sound;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 生涯模式
 * 
 * @author Xc
 * @version 2012.5.8
 * preview:
 * 800 * ( 400 + 220 )
 * 
 * 
 */

/*
 * new LifePanel();
 * 
 */

public class LifePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int pointer;
	int chapter;
	JPanel textField;
	JLabel bgLabel;
	JButton jbtSkip;
	String name;
	int lengthOfLine = 24;
	String textString;
	GamePanel gamePanel;
	int isCompleted;
	public LifePanel(){
		this.setLayout(null);
		//读取记录
		
		this.addMouseListener(new GoNextMouseListener());
//		this.addKeyListener(new keyBoardListener());
//		this.requestFocus();
		load();	
		Paint();
	}
	

	
	public LifePanel(int i) {
		this.setLayout(null);
		this.addMouseListener(new GoNextMouseListener());
		load();
		chapter=0;
		pointer=1;
		Paint();
	}



	void save(){
		File file = null;
		BufferedWriter writer = null;

	
		file = new File("LifeRecord.dat");
		try {
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			
			try {
				e.printStackTrace();
				file.createNewFile();
				writer = new BufferedWriter(new FileWriter(file));
				new File("test").createNewFile();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			} 
		}
		try {
			writer.write(chapter+ " " +pointer +" " + isCompleted);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	void load(){
	
		File file = new File("LifeRecord.dat");
		BufferedReader Reader = null;
		try {
			Reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e2) {	
			//声明未找到
			pointer = 1;
			chapter = 0;
			return;
		}
		try {
			String in = Reader.readLine();
//			System.out.println(in);
			String[] cmd = in.split(" ");
			chapter = Integer.parseInt( cmd[0] );
			if( (chapter <0) ||(chapter>7)){
				chapter = 0;
			}
			pointer = Integer.parseInt( cmd[1] );
			isCompleted = Integer.parseInt(cmd[2]);
//			System.out.println(chapter +" "+pointer);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			Reader.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}



	void clear(){
		this.remove(bgLabel);
		this.remove(textField);
		this.remove(jbtSkip);
	}

	
	void rePaint(){
		clear();
		Paint();
		this.repaint();
	}
	
	
	void Paint(){

		
		
		//取背景
		//背景
		ImageIcon bgPicture = new ImageIcon("lifePictures\\chapter" + chapter + "\\"+fpng() + ".png");
		bgLabel = new JLabel(bgPicture);
		bgLabel.setBounds(0, 0, bgPicture.getIconWidth() , bgPicture.getIconHeight());
						
		
		
			
		
		//取文字
		
		String inString = Read();
		String[]  cmd = inString.split("%");
		inString = inString.replaceAll("\t", "");
		name = cmd[0];
		
		String[] textArray = new String[3];
		if( cmd[1].length() >= lengthOfLine ){
			textArray[0] = cmd[1].substring(0,lengthOfLine-1);
			if(cmd[1].length() >= ( lengthOfLine * 2 )){
				textArray[1] = cmd[1].substring(lengthOfLine - 1, 2 * lengthOfLine - 2);
				textArray[2] = cmd[1].substring(lengthOfLine * 2 - 2 );
			}
			else{
				textArray[1] = cmd[1].substring(lengthOfLine - 1);
				textArray[2] = "";
			}
		}
		else{
			textArray[0] = cmd[1];
			textArray[1] = "";
			textArray[2] = "";
		}
		
		textString = "<html>" + textArray[0] + "<br>" + 
								textArray[1] + "\t<br>" + 
								textArray[2] + "\t</html>";
		
//		System.out.println(textArray[0]);
//		System.out.println(textArray[1]);
//		System.out.println(textArray[2]);
		
		
		
		
		
		//文字框
		textField = new JPanel();
		textField.setBounds(8, 400, 770, 175);
		//文字部分  名字 
		
		JLabel nameSpace = new JLabel();


		if(name.substring(0,2).equals("独白")){
			nameSpace.setText("");
		}
		else{
			nameSpace.setText(name+":");
		}
		nameSpace.setFont(new Font("宋体" , 1 , 28));
		nameSpace.setBounds(30, 4, 700, 28);
		nameSpace.setForeground(new Color(150,155,175));
	
		//对话
		JLabel text = new JLabel();
		text.setText(textString);
		text.setFont(new Font("宋体" , 1 , 28));
		text.setBounds(30,10, 780,135);
		text.setForeground(new Color(150,155,175));
		
		//边框
		JLabel boarder = new JLabel(new ImageIcon("png/boarder.png"));
		boarder.setBounds(0,0,750,150);
		
		textField.setLayout(null);
		textField.add(nameSpace);
//		textField.setBackground();
		textField.setOpaque(false);
		textField.add(text);
		textField.add(boarder);
		
		
		//跳过
		jbtSkip = new JButton(new ImageIcon("png/skip.png"));
		jbtSkip.addActionListener(new skipActionListener());
		jbtSkip.setBounds(700, 500, 80,30 );
		jbtSkip.setOpaque(true);
		jbtSkip.setContentAreaFilled(false);
		jbtSkip.setBorderPainted(false);
		jbtSkip.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				jbtSkip.setIcon(new ImageIcon("png/skipPressed.png"));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				jbtSkip.setIcon(new ImageIcon("png/skipPressed.png"));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				jbtSkip.setIcon(new ImageIcon("png/skip.png"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jbtSkip.setIcon(new ImageIcon("png/skipEntered.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jbtSkip.setIcon(new ImageIcon("png/skip.png"));
			}
			
		});
		
		
		
		
		
		this.setLayout(null);
		//先来着居上
		this.add(jbtSkip);
		this.add(textField);
		this.add(bgLabel);
		
	}
	
	void next(){
		pointer++;
		//判断继续剧情还是进入游戏
		if(pointer > lengthOfChapter(chapter)){
			new NextChapterThread().start();
		}
		else{
			rePaint();
		}
		
	}
	class NextChapterThread extends Thread{
		public void run(){
			pointer = 1;
			save();
			if(chapter==0){
				chapter++;
				save();
				rePaint();
			}
			else if (chapter == 8){
				chapter = 0 ; 
				save();
				PassAll();
			}
			else{
				enterGame();
				while (true){
					try {
						sleep(100);
					} catch (InterruptedException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					while (!gamePanel.guiboard.isWin){
						try {
							sleep(500);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}					
					}
					while (!gamePanel.guiboard.isEnd){
						try {
							sleep(500);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
					if (gamePanel.guiboard.isPass){
						gamePanel.guiboard.isPass=false;
						DialogCreator.oneButtonDialog("Win", "挑战成功！进入下一关");
						gamePanel.setVisible(false);
						chapter++;
						if (chapter==8){
							PassAll();
							isCompleted=1;
						}
						save();
						rePaint();
						return;
					} else {
						Media.playSound(Sound.lose);
						int choose = DialogCreator.twoButtonDialog("Lose", "挑战失败", "再次挑战", "回到主界面", 1);
						if (choose==2) {
							
							Media.stopBGM(Sound.career);
							Media.playBGM(Sound.BGM);
							Constants.hasMusic=true;
							returntoMenu();
							
							break;
						} 
						gamePanel.guiboard.isWin=false;
					}

				}
				
			}	
		}
	}
	void returntoMenu(){
		this.setVisible(false);
		Gomoku.menuPanel.setVisible(true);
	}
	public void enterGame(){
		switch (chapter) {
		case 1: 
				gamePanel = new SingleGamePanel("Dark",180);
				break;
		case 2: 
				gamePanel = new SingleGamePanel("Disturb", 180);
				break;
		case 3: 
				gamePanel = new SingleMovablePanel();
				break;
		case 4:	gamePanel = new SingleGamePanel("Change", 180);
				break;
		case 5: gamePanel = new DisturbPanel(0);
			break;
		case 6: gamePanel = new ThreePlayerGamePanel(2);
			break;
		case 7: gamePanel = new SingleGamePanel(5);
		default:
			break;
			
		}
		clear();
		gamePanel.setBounds(0,0,800,620);
		this.add(gamePanel);
		gamePanel.enableReturn();
		repaint();
		
	}
	
	void lose(){
		
	}
	
	void PassAll(){
		DialogCreator.oneButtonDialog("Win", "Win");
		returntoMenu();
	}
	
	
	int fpng(){
		return pointer;
	}
	
	
	/*
	 * 将下一行文本读入inString
	 */
	String Read(){
		File file = new File("lifeText\\chapter" + chapter + "" + ".dat");
		BufferedReader Reader = null;
		String inString = null;
		try {
			Reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		try {
			for(int i = 0 ; i< pointer ; i ++){
				inString = Reader.readLine();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			Reader.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return inString;
	}
	
	int lengthOfChapter(int chapter){
		File file = new File("lifeText\\chapter" + chapter + "" + ".dat");
		BufferedReader Reader = null;
		int flag = 0;
		try {
			Reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e2) {
			
			e2.printStackTrace();
		}
		try {
			while(Reader.readLine() !=null){
				flag++;
			}
		}
		catch (IOException e){
			
		}
		
		try {
			Reader.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return flag;
		
	}

	class GotoNextActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			next();
		}
	}


	class GoNextMouseListener implements MouseListener{
	
	
		public void mouseClicked(MouseEvent e) {
			next();
		}
	
	
		public void mousePressed(MouseEvent e) {
		
			
		}
	
	
		public void mouseReleased(MouseEvent e) {
			
		}
	
	
		public void mouseEntered(MouseEvent e) {
	
			
		}
	
	
		public void mouseExited(MouseEvent e) {
	
			
		}
		
	}


	class skipActionListener implements ActionListener{
	
	
		public void actionPerformed(ActionEvent e) {
			new NextChapterThread().start();
		}
	}
	public int getChapter() {
		return chapter;
	}
}
