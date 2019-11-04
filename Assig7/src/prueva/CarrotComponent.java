package prueva;



/* 1) I add a second bunny which move Up with E Down with X, 
 *  Left with S, and Right with D. The orginal bunny 
 *  moves are controlled by the Up, Down, Left, and 
 *  Right Virtual Keys of the keyboard VK_UP, VK_DOWN,
 *  VK_LEFT and VK_RIGHT. 
 * 2) Using  g.drawString() the program maintain scores for each of the 
 * two bunnies, and each carrot worths 5 points. 
 * Implements the main component for the carrot game.
*/
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.io.*;
import javax.imageio.*;


   public class CarrotComponent extends JComponent 
   { 
	 
	     private ArrayList myPoints; // x,y position of each carrot
		 private int myX; // upper left of image x
		 private int myY; // upper left of image y
		 private int myDy; // change in y for gravity

		 private Image carrotImage;
		 int carrotsPoinsBunny1 = 0;// new score
		 int carrotsPoinsBunny2 = 0;//new score
                 //for bunny 2
		 private Image bunnyImage2, bunnyImage1;  
		 private int my2X = getWidth()-100; // upper left of head x
		 private int my2Y = 50; // upper left of head y
		 int bunnynumber;
		 
		 
         public static final int SIZE = 800; // initial size
		 public static final int PIXELS = 50; // square size per image
		 public static final int MOVE = 20; // keyboard move
		 public static final int GRAVITY = 2; // gravity move
		 public static final int CARROTS = 20; // number of carrots
		 public static final int FIVE = 5;//wing 5 points
		 
		 public static final Font FONT = new Font("Dialog", 0, 24);
		 
		 
		 public CarrotComponent( ) 
		 {
		 
		 setPreferredSize(new Dimension(SIZE, SIZE));
		 
		 // getScaledInstance( ) gives us re-sized version of the image --
		 // speeds up the drawImage( ) if the image is already the right size
		 // See paintComponent( )
		
		 //second bunny
		 bunnyImage2 = readImage("image/bunny2.jpg");
		 bunnyImage2 = bunnyImage2.getScaledInstance(PIXELS, PIXELS,Image.SCALE_SMOOTH);
		 
		 
		 bunnyImage1 = readImage("image/bugs-bunny1.jpg");
		 bunnyImage1 = bunnyImage1.getScaledInstance(PIXELS, PIXELS,Image.SCALE_SMOOTH);
		 
		
		 carrotImage = readImage("image/carrot.gif");
		 carrotImage = carrotImage.getScaledInstance(PIXELS, PIXELS,Image.SCALE_SMOOTH);
		 
		 
		 myPoints = new ArrayList();
		 }
	 
	 
      public  Point randomPoint()
       {
	      int x = (int)(Math.random()*(getWidth() - PIXELS));
	      int y = (int)(Math.random()*(getHeight() - PIXELS));
			
		Point p = new Point(x, y);
		
		return p; 
       }

      // Check the current x,y vs. the carrots
      public void checkCollisions(int X, int Y, int bunny) {
        for (int i = 0 ; i < myPoints.size( ); i++) {
           Point point = (Point) myPoints.get(i);
       
           // if we overlap a carrot, remove it
           if (Math.abs(point.getX( ) - X) <= PIXELS && Math.abs(point.getY( ) - Y) <= PIXELS) 
           {
               //points
        	 if (bunny == 1 ){
        		 carrotsPoinsBunny1 += FIVE;
        	 }
        	 else{//bnny 2
        		 carrotsPoinsBunny2 += FIVE;
        	 }
        	 myPoints.remove(i); // removes carrot from the ArrayList
                 i--;                        // tricky:
                                // back i up, since we removed the ith element
              repaint( );
              }
            }
           if (myPoints.size( ) == 0) {
               reset( ); // new game
               
                // add the message who us the winner
             }
       } 
		
		
    
    public void key(int code) 
    {
    	 if (code == KeyEvent.VK_UP)
    	 {
    	   myY += -MOVE;
    	   bunnynumber = 1;
    	 }
    	 else if (code == KeyEvent.VK_DOWN) 
    	 {
    	   myY += MOVE;
    	   bunnynumber = 1;
    	 }
    	 else if (code == KeyEvent.VK_LEFT) 
    	 {
    	   myX += -MOVE;
    	   bunnynumber = 1;
    	 }
    	 else if (code == KeyEvent.VK_RIGHT) //RIGHT
    	 {
    	   myX += MOVE;
    	   bunnynumber = 1;
    	 }
    	 ////second bunny
    	 if (code == KeyEvent.VK_E)//UP
    	 {
    	   my2Y += -MOVE;
    	   bunnynumber = 2;
    	 }
    	 else if (code == KeyEvent.VK_X) //move down
    	 {
    	   my2Y += MOVE;
    	   bunnynumber = 2;
    	 }
    	 else if (code == KeyEvent.VK_S) //lelf
    	 {
    	   my2X += -MOVE;
    	   bunnynumber = 2;
    	 }
    	 else if (code == KeyEvent.VK_D) //RIGHT
    	 {
    	   my2X += MOVE;
    	   bunnynumber = 2;
    	 }
    	 checkCollisions(my2X,my2Y, bunnynumber );
    	 checkCollisions(myX,myY, bunnynumber );
    	 
    	 repaint( );
     } 
   
	
     // Draws the head and carrots
      public void paintComponent(Graphics g) {
      
    	  
        g.drawImage(bunnyImage2, myX, myY, PIXELS, PIXELS, null);
        g.drawImage(bunnyImage1,my2X, my2Y, PIXELS, PIXELS, null);
        
        
        g.setFont(FONT);
        g.setColor(Color.MAGENTA);
        
        g.drawString("Pink bunny : " + carrotsPoinsBunny1, 10, 50);
        g.drawString("Bug bunny : " + carrotsPoinsBunny2, getWidth()- 200, 50);
        
        // Draw all the carrots
         for (int i=0; i < myPoints.size( ); i++) {
           Point p = (Point) myPoints.get(i);
    
           // point.getX( ) returns a double, so we must cast to int
           g.drawImage(carrotImage,(int) (p.getX( )), (int) (p.getY( )), PIXELS, PIXELS,null);
           }
        }
    
	
	// Utility to read in an Image object
	// If image cannot load, prints error output and returns null.
	private Image readImage(String filename) {
	    Image image = null;
	    
	    try {
	      image = ImageIO.read(new File(filename));
	   }
	     catch (IOException e) {
	     System.out.println("Failed to load image '" + filename + "'");
	     e.printStackTrace( );
	  }
	    
	  return(image);
	 } 
	
	  
	  // Advance things by one tick -- do gravity, check collisions
	 public void tick( ) {
	     myDy = myDy + GRAVITY; // increase dy
	     myY += myDy; // figure new y
	  
	     
	     // check if hit bottom
	     if (myY + PIXELS >= getHeight( )) {
	     // back y up
	     myY -= myDy;
	 
	     // reverse direction of dy (i.e. bounce), but with 98% efficiency
	     myDy = (int) (0.98 * -myDy);
	     }
	     
	    checkCollisions(myX,myDy, 1);
	    repaint( );
	  }
	  
	  public void reset(){
		  
		  myPoints.clear();
		  for (int j = 0; j < CARROTS; j++ ){
			  myPoints.add(randomPoint());
		  }
		      myY =  50;
			  myDy = 50;
			  myX  = getWidth() / 2 - 50 ;
			  my2X = getWidth()-100; 
			  my2Y = 50; 
			  carrotsPoinsBunny1 = 0;
			  carrotsPoinsBunny2 = 0;
		  
	  }
 }