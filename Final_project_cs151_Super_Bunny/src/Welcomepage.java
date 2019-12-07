import java.awt.*;

import javax.swing.*;
public class Welcomepage {
	
	  static String name1;
	  static String name2;
	  static boolean saveName1 = false, saveName2 = false;
	  public static final int SIZE = 830; // initial size
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		

		Font style = new Font("Verdana",Font.BOLD,15);
		
		
		JButton start =new JButton("Start  a  new  game");
		//JButton saveP1 =new JButton("Save Name");
		//JButton saveP2 =new JButton("Save Name");
		
		JLabel jlabel = new JLabel("Enter name of player 1:");
	    jlabel.setFont(style);
	    JLabel jlabel2 = new JLabel("Enter name of player 2:");
	    jlabel2.setFont(style); 
	
		JPanel buttons = new JPanel(new GridBagLayout());
		buttons. setBackground(Color.cyan);
		JTextField player1 = new JTextField(20);
		player1.setFont(style);
		JTextField player2 = new JTextField(20);
		player2.setFont(style);
	
		player1.setHorizontalAlignment(JTextField.CENTER);
		player2.setHorizontalAlignment(JTextField.CENTER); 
		
		
		
		start.addActionListener(event->{
			name1 = player1.getText();
			name2 = player2.getText();
			if (name1 == "" || name2 == "") {
				saveName1 = saveName2 = false;
			}
			else {
				saveName1 = saveName2 = true;
			}
					
					
			if(saveName1  && saveName2 ) {
				int [] score1 = {0 ,0, 0, 0};
				int [] score2 = {0 ,0, 0, 0};
				Bunny_score bunny1 = new Bunny_score (name1.toUpperCase(), score1);
				Bunny_score bunny2 = new Bunny_score (name2.toUpperCase(), score2);
				
				new CarrotFrame( bunny1,  bunny2); 
				
				//done playing reset the JtextFiles for new user
				player1.setText("");
				player2.setText("");
				saveName1 = saveName2 = false;
			}
			else {
		   		 
			       JOptionPane.showMessageDialog(null, "Sorry, you haven't save the name. \n Please, click on the save button", 
				   "Message", JOptionPane.INFORMATION_MESSAGE);
	 	   }
		
		});
//		saveP1.addActionListener(event->{
//			name1 =  player1.getText(); 
//			saveName1 = true;
//		});
//		saveP2.addActionListener(event->{
//			name2 =  player2.getText(); 
//			saveName2 = true;
//		});
		
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(SIZE, SIZE));
		
	
		
		frame.setContentPane(new JLabel(new ImageIcon("image/welcomerabbit.jpg")));
		frame.setLayout(new FlowLayout());
		
	    GridBagConstraints c = new GridBagConstraints();
		c.gridx =0;
		c.gridy =0;
		
		buttons.add(jlabel,c);
	
		c.gridx = 0;
		c.gridy = 1;
		c.fill = GridBagConstraints.VERTICAL;
		buttons.add(player1,c);
		
//		c.gridx =1;
//		c.gridy =1;
//		buttons.add(saveP1,c);
		
		c.gridx = 0;
		c.gridy = 2;
		buttons.add(jlabel2,c);
		
		c.gridx =0;
		c.gridy =3;
		c.fill = GridBagConstraints.VERTICAL;
		buttons.add(player2,c);
		
	
		
//		c.gridx = 1;
//		c.gridy = 3;
//		buttons.add(saveP2,c);
		
		c.gridx =0;
		c.gridy =4;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		buttons.add(start,c);
		
		frame.setTitle("Super Bunny Game");
		frame.add(buttons, BorderLayout.WEST);
		frame.pack();
	}
}