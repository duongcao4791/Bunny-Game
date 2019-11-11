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
			 setTitle("Super Bunny Game");
			 
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
        // interface
    public void keyTyped(KeyEvent e) { 
    	
    }
    public void keyPressed(KeyEvent e) {
      
        carrotComponent.keyPressed(e.getKeyCode( ));
    }
    
    public void keyReleased(KeyEvent e) {
   
    }
 
 
    public static void main(String[ ] args) {
    /// add the 
       new CarrotFrame();
   }
}
