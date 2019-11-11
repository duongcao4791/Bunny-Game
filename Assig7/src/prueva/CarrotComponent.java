package prueva;



/* 
 * if the player choose to play with another person
 * 
 * 1) 
 * The first bunny is
 *  controlled by the Up, Down, Left, and 
 *  Right Virtual Keys of the keyboard VK_UP, VK_DOWN,
 *  VK_LEFT and VK_RIGHT. 
 *  the second player will move the bunny Up with E, Down with X, 
 *  Left with S, and Right with D. 
 *  
 * 2) We are using  g.drawString() to maintain scores for each of the 
 * two bunnies, and each carrot worths 5 points. 
*/
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.io.*;
import javax.imageio.*;


   public class CarrotComponent extends JComponent 
   { 
	 
	     // position of each carrot
	     private ArrayList<Point> myPoints; 
		 private int myX; // upper left of image x
		 private int myY; // upper left of image y
		 private int myDy; // change in y for gravity

		 private Image carrotImage;
		 int carrotsPoinsBunny1 = 0;// new score
		 int carrotsPoinsBunny2 = 0;//new score
                 //for bunny 2
		 String mainPlayer = "main Player";
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
		 bunnyImage1 = readImage("image/bugs-bunny1.jpg");
		 bunnyImage1 = bunnyImage1.getScaledInstance(PIXELS, PIXELS,Image.SCALE_SMOOTH);

		 //second bunny
		 setPreferredSize(new Dimension(SIZE, SIZE));
		 bunnyImage2 = readImage("image/bunny2.jpg");
		 bunnyImage2 = bunnyImage2.getScaledInstance(PIXELS, PIXELS,Image.SCALE_SMOOTH);
		 
		
		 
		
		 carrotImage = readImage("image/carrot.gif");
		 carrotImage = carrotImage.getScaledInstance(PIXELS, PIXELS,Image.SCALE_SMOOTH);
		 
		 myPoints = new ArrayList<Point>();
		 }
	 
	 
      public  Point randomPoint()
       {
	      int x = (int)(Math.random()*(getWidth() - PIXELS));
	      int y = (int)(Math.random()*(getHeight() - PIXELS));
			
		 Point p = new Point(x, y);
		
		 return p; 
       }

      // Check the current x,y of the bunny and the carrots to collect the points
      public void checkCollisions(int X, int Y, int bunny) {
        for (int i = 0 ; i < myPoints.size( ); i++) {
           Point point = (Point) myPoints.get(i);
       
           // if the player pass over a carrot, we remove carrot and add 5 ponts to the player 
           //who got the carrot.
           if (Math.abs(point.getX( ) - X) <= PIXELS && Math.abs(point.getY( ) - Y) <= PIXELS) 
           {
               //points
        	 if (bunny == 1 ){
        		 carrotsPoinsBunny1 += FIVE;
        	 }
        	 else{//bunny 2
        		 carrotsPoinsBunny2 += FIVE;
        	 } 
        	 
        	 
        	 myPoints.remove(i); // removes carrot from the ArrayList
             i--;                          // tricky:
                                // back i up, since we removed the ith element
              repaint( );
              }
            }
        // when there are no more carrots
           if (myPoints.size( ) == 0) {
        	   ImageIcon icon = new ImageIcon(bunnyImage1);
               JOptionPane.showMessageDialog(null, "The winner is " + mainPlayer +".", 
                 "WINNER MESSAGE", JOptionPane.INFORMATION_MESSAGE, icon);
             }
       } 
		
		
    
    public void keyPressed(int code) 
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
    	 if(bunnynumber == 1) {
    		 checkCollisions(myX,myY, bunnynumber );
    	 }else {
    		 checkCollisions(my2X,my2Y, bunnynumber );
    	 }
    	 
    	 repaint( );
     } 
   
	
     // Draws the bunny and carrots
      public void paintComponent(Graphics g) {
      
    	  
        g.drawImage(bunnyImage2, myX, myY, PIXELS, PIXELS, null);
        g.drawImage(bunnyImage1,my2X, my2Y, PIXELS, PIXELS, null);
        
        g.setColor(Color.MAGENTA);
        g.setFont(FONT);
        g.drawString(mainPlayer +" : " + carrotsPoinsBunny1, 10, 50);
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
	
/***
 * @param does not need it
 * this method only set the score to 0 and display all the carrots when the player stars a new game 
 * */
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
			  repaint( );
	  }
	  
 }
