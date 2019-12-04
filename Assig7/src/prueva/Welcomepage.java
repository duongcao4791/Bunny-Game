import java.awt.*;

import javax.swing.*;
public class Welcomepage {
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		//CarrotFrame m=new CarrotFrame();
		//frame.setPreferredSize(new Dimension(500,300));
		JButton start =new JButton("New game");
		start.addActionListener(event->{CarrotFrame m =new CarrotFrame();});
		JPanel buttons = new JPanel(new GridBagLayout());
		JTextField player1=new JTextField(15);
		JTextField player2=new JTextField(15);
		player1.setText("Enter name of player 1:");
		player1.setHorizontalAlignment(JTextField.CENTER);
		player2.setText("Enter name of player 2:");
		player2.setHorizontalAlignment(JTextField.CENTER);
		GridBagConstraints c = new GridBagConstraints();
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		frame.setSize(800,800);
		frame.setContentPane(new JLabel(new ImageIcon("welcomerabbit.jpg")));
		frame.setLayout(new FlowLayout());
	
		c.gridx=0;
		c.gridy=1;
		
		buttons.add(start,c);
		c.gridx=0;
		c.gridy=2;
		buttons.add(player1,c);
		c.gridx=0;
		c.gridy=3;
		buttons.add(player2,c);
		
		frame.setTitle("Super Bunny Game");
		frame.add(buttons, BorderLayout.WEST);
		frame.pack();
	}
}
