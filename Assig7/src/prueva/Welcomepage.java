import java.awt.*;

import javax.swing.*;
public class Welcomepage extends JFrame {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		//frame.setPreferredSize(new Dimension(500,300));
		JButton start =new JButton("Start game");
		JPanel buttons = new JPanel();
		
		buttons.add(start,BorderLayout.WEST);
		frame.setLayout(new FlowLayout());
		frame.setTitle("Super Bunny Game");
		frame.add(buttons, BorderLayout.WEST);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(800,800);
	}
}
