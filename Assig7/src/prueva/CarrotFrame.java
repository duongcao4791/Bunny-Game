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
	private JButton newGame; 
	public static final int SIZE = 800; // initial size
	
	
	 public CarrotFrame( ) { 
		 
			 setTitle("Super Bunny Game");
			 
			 Container content = getContentPane( );
			 content.setLayout(new BorderLayout( ));
			 
			 carrotComponent = new CarrotComponent( );
			 
			 content.add(carrotComponent, BorderLayout.CENTER);
			
			 setPreferredSize(new Dimension(SIZE, SIZE));
			 // to move the bunny
			 carrotComponent.addKeyListener(this);
			
			 
			 JPanel panel = new JPanel( );
			 
			 start = new JButton("Start");
			 start.addActionListener(new 
		             ActionListener()
		             { 
		                public void actionPerformed(ActionEvent event)
		                {
		                	carrotComponent.reset( );

		                }
		             });
			 
			 
			 panel.add(start); 
			 start.setFocusable(false);
			
			 finish = new JButton("Finish Game");
			 finish.addActionListener(new 
		             ActionListener()
		             {
		                public void actionPerformed(ActionEvent event)
		                {
		                	 panel.add(start);
		                	 panel.repaint();
		                	
		                }
		             });;
			 panel.add(finish);
			 finish.setFocusable(false);
			 
			 
			 newGame = new JButton("New Game");
			 newGame.addActionListener(this); 
			 panel.add(newGame);
			 newGame.setFocusable(false);
			 
			 
			 content.add(panel, BorderLayout.SOUTH);
			 
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
 
    public static void main(String[ ] args) {
   
       new CarrotFrame();
   }

	
}
