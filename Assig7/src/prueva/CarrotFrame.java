package prueva;


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
	private JButton slow;
	

	
	
	 public CarrotFrame( ) {
			 setTitle("Carrot");
			 
			 Container content = getContentPane( );
			 content.setLayout(new BorderLayout( ));
			 
			 carrotComponent = new CarrotComponent( );
			 content.add(carrotComponent, BorderLayout.CENTER);
			 
			 carrotComponent.addKeyListener(this);
			 carrotComponent.setFocusable(true);
			 
			 JPanel panel = new JPanel( );
			 
			 start = new JButton("Start");
			 start.addActionListener(this);
			 panel.add(start);
			 start.setFocusable(false);
			
			 finish = new JButton("Finish Game");
			 finish.addActionListener(this);
			 panel.add(finish);
			 finish.setFocusable(false);
			 
			 
			 slow = new JButton("Slower");
			 slow.addActionListener(this);
			 panel.add(slow);
			 slow.setFocusable(false);
			 
			 
			 content.add(panel, BorderLayout.SOUTH);
			 
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 pack( );
			 carrotComponent.requestFocusInWindow( );
			 setVisible(true);
		 } 
	
	 // Handle timer and button events
     public void actionPerformed(ActionEvent e) {
    
        if (e.getSource( ).equals(finish)) {
            
         }
       else if (e.getSource( ).equals(slow)) {
              
        }

        else if (e.getSource( ).equals(start)) {
              carrotComponent.reset( );
               
        }
     }
        // Must implement the next three methods to implement the KeyListener
        // interface -- aka "notifications" sent by the system on various events
	
        // Key typed notification -- down and up
    public void keyTyped(KeyEvent e) { 
    	//not relevant
    }
    public void keyPressed(KeyEvent e) {
       // use e.getCharCode( ) to get its character
       // use e.getKeyCode( ) for things like up/down arrow
        carrotComponent.key(e.getKeyCode( ));
    }
       // Key released -- the up stroke

    public void keyReleased(KeyEvent e) {
    /* not relevant to this application */ 
    	}
 
 
    public static void main(String[ ] args) {
      CarrotFrame frame = new CarrotFrame( );
      
      
   }
}