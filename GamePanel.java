package Main;

import java.awt.Color;

import java.awt.Dimension;
import java.io.Serializable;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Serializable, Runnable {
	private static final long serialVersionUID = 1L;
	final int originalTileSize =16;
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	final int infoLocationRow = 100;
	final int infoLocationCol= 100;
	final int boxWidth = 20;
	final int boxHeight = 20;
	JButton search = new JButton("check Ip");
	JLabel netBox = new JLabel();
	
	
	Thread gameThread;
	
	//Constructor
	public GamePanel() throws Exception {	
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.white);
		this.add(search);
		search.setBounds(100, 100, 100, 100);
		this.setDoubleBuffered(true);
		this.add(netBox);
		netBox.setBounds(infoLocationRow, infoLocationCol, boxWidth, boxHeight);
		Network network = new Network();
		String netInterfaceName= network.getInterfaceName();
		String netIp = network.getExternalIp();
		String netHost = network.hostDetails();
		netBox.setText("<html>" + netInterfaceName + "<br>" + netIp + "<br>" + netHost + "</html>");
		
	}

	public void gameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(gameThread != null) {
						
		}
	}
}
