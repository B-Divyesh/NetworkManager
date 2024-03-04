package Main;

import javax.swing.JFrame;

public class Source {
	public static void main(String args[]) throws Exception {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Yavasta");
		
		GamePanel game = new GamePanel();
		window.add(game);
		window.pack(); //causes the window to be sized according to gamepanel components
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}