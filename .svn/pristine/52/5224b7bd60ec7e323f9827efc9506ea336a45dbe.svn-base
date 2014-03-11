package gomoku.netgame;

import gomoku.gamepanel.DialogCreator;
import gomoku.language.Language;
import gomoku.main.Gomoku;
import gomoku.main.Start;
import gomoku.sound.Media;
import gomoku.sound.Sound;
import gomoku.theme.Theme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaitingPanel extends JPanel {
	JButton jbtServer;
	JButton jbtClient;
	JButton jbtReturn;
	JLabel jlbloading;
	JLabel jlbNetIcon;
	GomokuServer server = new GomokuServer();
	public WaitingPanel(){
		this.setLayout(null);
		ImageIcon gameBg = new ImageIcon(Theme.gamebg);
		JLabel gameBgLabel = new JLabel(gameBg); 
		gameBgLabel.setBounds(0,0,gameBg.getIconWidth(),gameBg.getIconHeight());
		
		ImageIcon setRoomBg = new ImageIcon(Language.SETROOM);
		jbtServer= new JButton(setRoomBg);
		jbtServer.setBounds(550,100, 200,100);
		jbtServer.setOpaque(false);
		jbtServer.setFocusPainted(false);
		jbtServer.setBorderPainted(false);
		jbtServer.setContentAreaFilled(false);
		
		ImageIcon enterRoomBg = new ImageIcon(Language.ENTERROOM);
		jbtClient= new JButton(enterRoomBg);
		jbtClient.setBounds(550,250,200,100);
		jbtClient.setOpaque(false);
		jbtClient.setFocusPainted(false);
		jbtClient.setBorderPainted(false);
		jbtClient.setContentAreaFilled(false);
		
		ImageIcon netReturnBg = new ImageIcon(Language.NETRETURN);
		jbtReturn = new JButton(netReturnBg);
		jbtReturn.setBounds(550,400,200,100);
		jbtReturn.setOpaque(false);
		jbtReturn.setFocusPainted(false);
		jbtReturn.setBorderPainted(false);
		jbtReturn.setContentAreaFilled(false);
		
		ImageIcon NetIcon = new ImageIcon(Theme.netIcon);
		jlbNetIcon = new JLabel(NetIcon);
		jlbNetIcon.setBounds(0,0,500,600);
		
		this.add(jlbNetIcon);
		this.add(jbtClient);
		this.add(jbtServer);
		this.add(jbtReturn);
		this.add(gameBgLabel);	
		this.setOpaque(false);
		jbtServer.addMouseListener(new ServerListener());
		jbtClient.addMouseListener(new ClientListener());
		jbtReturn.addMouseListener(new ReturnListener());
	}
	class ReturnListener implements MouseListener{
		int x = jbtReturn.getX();
		int y = jbtReturn.getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.goback);
			returntoMenu();
			
			Gomoku.menuPanel.requestFocus();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtReturn.setLocation(x+5,y+5);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtReturn.setLocation(x-3,y-3);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtReturn.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtReturn.setLocation(x,y);
			
		}
	}
	public void returntoMenu(){
		this.setVisible(false);
		Gomoku.menuPanel.setVisible(true);
	}
	class WaitingThread extends Thread {
		public void run(){ 
			ImageIcon loadingIcon = new ImageIcon(Theme.loading);
			jlbloading = new JLabel(loadingIcon);
			jlbloading.setBounds(300,200,loadingIcon.getIconWidth(),loadingIcon.getIconHeight());
			JFrame loadingFrame = new JFrame();
			loadingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			loadingFrame.setSize(400, 200);
			loadingFrame.setVisible(true);
			loadingFrame.add(jlbloading);
			loadingFrame.setResizable(false);
			loadingFrame.setLocationRelativeTo(null);
			while (!server.isLinked){
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
			loadingFrame.setVisible(false);
			server.setVisible(true);
			Start.gomoku.setVisible(true);
			Start.gomoku.repaint();
		}
	}
	public void AddServer(){	
		this.setVisible(false);
		Start.gomoku.setVisible(false);
		Start.gomoku.add(server);
		new WaitingThread().start();
		server.link();
	}
	class ServerListener implements MouseListener {
		int x = jbtServer.getX();
		int y = jbtServer.getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.enter);

			AddServer();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtServer.setLocation(x+5,y+5);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtServer.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtServer.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtServer.setLocation(x,y);
			
		}
		
	}
	public void AddClient(){
		this.setVisible(false);
		Start.gomoku.setVisible(false);
		String ip = DialogCreator.InputDialog("ip", Language.INPUTIP);
		Start.gomoku.add(new GomokuClient(ip));//DialogCreater.InputDialog
		Start.gomoku.setVisible(true);
	}
	class ClientListener implements MouseListener {
		int x = jbtClient.getX();
		int y = jbtClient.getY();
		@Override
		public void mouseClicked(MouseEvent e) {
			Media.playSound(Sound.enter);

			AddClient();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			jbtClient.setLocation(x+5,y+5);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			jbtClient.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jbtClient.setLocation(x-3,y-3);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jbtClient.setLocation(x,y);
			
		}
		
	}
}
