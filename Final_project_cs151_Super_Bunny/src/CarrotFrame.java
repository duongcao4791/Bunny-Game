
// CarrotFrame.java 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Implements the Frame for the carrot game.
 * Manages the buttons and keyboard events.
 */ 
 class CarrotFrame extends JFrame implements KeyListener, ActionListener
{
    private CarrotComponent carrotComponent;
	private JButton start;
	private JButton finish;
	public static final int SIZE = 830; // initial size
	
	
	 public CarrotFrame(Bunny_score bunny1, Bunny_score bunny2   ) { 
		 
			 setTitle("Super Bunny Game");
			 
			 Container content = getContentPane( );
			 content.setLayout(new BorderLayout( ));
			  
			 carrotComponent = new CarrotComponent(bunny1, bunny2 );
			 
			 content.add(carrotComponent, BorderLayout.CENTER);
			
			 setPreferredSize(new Dimension(SIZE, SIZE));
			 // to move the bunny
			 carrotComponent.addKeyListener(this);
			
			 
			 JPanel panel = new JPanel( );
			 
			 start = new JButton("Start Game " + (bunny1.getGame_number() + 1));
			 start.addActionListener(new 
		             ActionListener()
		             { 
		                public void actionPerformed(ActionEvent event)
		                {
		                	if(bunny1.getGame_number() < 2) {
			                	
			                	
			                	bunny1.setGame_number(bunny1.getGame_number() + 1);
			                	bunny2.setGame_number(bunny2.getGame_number() + 1);
			                	
			                	start.setText("Start Game " + (bunny1.getGame_number() + 1));
			                	panel.add(start);
			                	panel.add(finish);
			                	content.add(panel, BorderLayout.SOUTH);
			                	
			                	carrotComponent.reset();
		                	}else if (bunny1.getGame_number() <3 ){
		                		start.setText("Go back for another round");
			                	panel.add(start);
			                	panel.add(finish);
			                	content.add(panel, BorderLayout.SOUTH);
			                
			                	carrotComponent.reset();
			                	
			                	bunny1.setGame_number(bunny1.getGame_number() + 1);
			                	bunny2.setGame_number(bunny2.getGame_number() + 1);
		                	}else {
			                	dispose();
		                	}

		                }
		             });
			 
			 
			 panel.add(start); 
			 start.setFocusable(false);
			
			 finish = new JButton("Finish Game");
			 finish.addActionListener(e -> {
				 
				 dispose();
				 
	             });
		           
		            
			 panel.add(finish);
			 
			 finish.setFocusable(false);
			 
			 
			 content.add(panel, BorderLayout.SOUTH);
			 
			// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 pack( ); 
			 carrotComponent.requestFocusInWindow( );
			 setVisible(true);
		 } 

        // we must implement the next three methods to implement the KeyListener
    public void keyTyped(KeyEvent e) { 
    	
    }
    public void keyPressed(KeyEvent e) {
      
        carrotComponent.keyPressed(e.getKeyCode( ));
    }
    
    public void keyReleased(KeyEvent e) {
   
    }
    public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}