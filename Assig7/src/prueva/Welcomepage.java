import java.awt.*;

import javax.swing.*;
public class Welcomepage extends JFrame {
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		//frame.setPreferredSize(new Dimension(500,300));
		JButton start =new JButton("Start game");
		JPanel buttons = new JPanel();

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		frame.setSize(800,800);
		frame.setContentPane(new JLabel(new ImageIcon("welcomerabbit.jpg")));
		frame.setLayout(new FlowLayout());
		buttons.add(start,BorderLayout.CENTER);

		frame.setTitle("Super Bunny Game");
		frame.add(buttons, BorderLayout.CENTER);
		frame.pack();
	}
}
