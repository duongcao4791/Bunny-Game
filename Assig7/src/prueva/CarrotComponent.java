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
	 
	    
		
		 private int carrotsPoinsBunny1 = 0;// new score
		 private int carrotsPoinsBunny2 = 0;//new score
                 //for bunny 2
		 private String bunnyString1 = "Ladies", bunnyString2 = "Gentlemen ";
		 
		 
		 private Image []  bunnyImage2;
		 private Image [] bunnyImage1 ;
		 private Image  carrotImage, grassBack;  
	
		 private int bunnynumber;
		 
		 
         public static final int SIZE = 900; // initial size
		 public static final int PIXELS = 70; // square size per image
		 public static final int MOVE = 20; // keyboard move
		 public static final int GRAVITY = 10; // gravity move
		 public static final int CARROTS = 11; // number of carrots
		 public static final int FIVE = 5;//wing 5 points
		 
		 // position of each carrot
	     private ArrayList<Point> carrotPosition;  
	     
		 
		 
		 private int myX; // upper left x of bunny 
		 private int myY ; // upper left y of bunny 
		 private int my2X; // upper left x of bunny2
		 private int my2Y; // upper left y of bunny2
		 private boolean playing = false;

		 
		 public static final Font FONT = new Font("Dialog", 0, 24);
		 
		 
		 public CarrotComponent( ) 
		 {
		
		 setPreferredSize(new Dimension(SIZE, SIZE));
		 myX = SIZE- 260;
		 myY = 60;
		 my2X = 60; 
		 my2Y = 60; 
		 bunnyImage1 = new Image [7];
		 bunnyImage1[0] = readImage("image/downbunny01.png");//wing
		 bunnyImage1[1] = readImage("image/upbunny01.png");
		 bunnyImage1[2] = readImage("image/Rigthbunny01.png");
		 bunnyImage1[3] = readImage("image/downbunny01.png");
		 bunnyImage1[4] = readImage("image/Leftbunny01.png");
		 bunnyImage1[5] = readImage("image/win01.jpg");
		 bunnyImage1[6] = readImage("image/win01.jpg");
		
		 //second bunny
		 bunnyImage2 = new Image [7];
		 bunnyImage2[0] = readImage("image/dowmBunny02.jpg" );
		 bunnyImage2[1] = readImage("image/upbunny02.png");
		 bunnyImage2[2] = readImage("image/Rigthbunny02.gif");
		 bunnyImage2[3] = readImage("image/dowmBunny02.jpg" );
		 bunnyImage2[4] = readImage("image/leftbunny02.jpg" );
		 bunnyImage2[5] = readImage("image/win02.jpg" );
		 bunnyImage2[6] = readImage("image/stop02.jpg" );
		
				 
				

		 carrotImage = readImage("image/carrot.gif");
		 
		 carrotImage = carrotImage.getScaledInstance(PIXELS, PIXELS,Image.SCALE_SMOOTH);
		 
		 grassBack = readImage("image/growing-green-grass.jpg");
		 grassBack  = grassBack .getScaledInstance(SIZE - 100 , SIZE - 300,Image.SCALE_SMOOTH);
		 
		 //both bunny configurations
		 for (int i = 0; i < 7; i ++) {
			  bunnyImage1[i] = bunnyImage1[i].getScaledInstance(PIXELS, PIXELS,Image.SCALE_SMOOTH);
			  bunnyImage2[i] = bunnyImage2[i].getScaledInstance(PIXELS, PIXELS,Image.SCALE_SMOOTH);
		 }
		 
		 carrotPosition = new ArrayList<Point>();
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
        for (int i = 0 ; i < carrotPosition.size( ); i++) {
           Point point = (Point) carrotPosition.get(i);
       
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
        	 
        	 
        	 carrotPosition.remove(i); // removes carrot from the ArrayList
             i--;                          // tricky:
                                // back i up, since we removed the ith element
              repaint( );
              }
            }
        // when there are no more carrots
           if (carrotPosition.size( ) == 0) {
        	   
        	   
        	   if (carrotsPoinsBunny2 > carrotsPoinsBunny1) {
        		      ImageIcon icon = new ImageIcon(bunnyImage2[5]);
                     JOptionPane.showMessageDialog(null, "The winner is " + bunnyString2 +".", 
                     "WINNER MESSAGE", JOptionPane.INFORMATION_MESSAGE, icon);
        	   }else  if (carrotsPoinsBunny2 < carrotsPoinsBunny1) {
        		       ImageIcon icon = new ImageIcon(bunnyImage1[5]);
        		       JOptionPane.showMessageDialog(null, "The winner is " + bunnyString1 +".", 
        			   "WINNER MESSAGE", JOptionPane.INFORMATION_MESSAGE, icon);
        	   }  
        	   
             }
       } 
		
		
    
    public void keyPressed(int code) 
    {
    	
    	
    	if (playing) {
    		if (code == KeyEvent.VK_UP)
	    	 {
    			if(myY > 0) {
	    		   myY += -MOVE;
		    	   bunnynumber = 1;
		    	   bunnyImage1[0] = bunnyImage1[1];
    			}
	    	 
	    	 }
	    	 else if (code == KeyEvent.VK_DOWN) 
	    	 {
	    		 if(myY <  getHeight()-(PIXELS + 10)) {
		    	   myY += MOVE; 
		    	   bunnynumber = 1;
		    	   bunnyImage1[0] = bunnyImage1[3];
	    	    }
	    	 }
	    	 else if (code == KeyEvent.VK_LEFT) 
	    	 {
	    		
	    		 if(myX > 0) {
		    	   myX += -MOVE;
		    	   bunnynumber = 1;
		    	   bunnyImage1[0] = bunnyImage1[4];
	    		 }
	    	 }
	    	 else if (code == KeyEvent.VK_RIGHT) 
	    	 {
	    		 if(myX < getWidth() - PIXELS) {
		    	   myX += MOVE;
		    	   bunnynumber = 1;
		    	   bunnyImage1[0] = bunnyImage1[2];
	    		 }
	    	 }
	    	 ////second bunny
	    	 if (code == KeyEvent.VK_E)//Up
	    	 {
	    		 if(my2Y > 0) { 
		    	   my2Y += -MOVE;
		    	   bunnynumber = 2;
		    	   bunnyImage2[0] = bunnyImage2[1];
	    		 }
	    	 }
	    	 else if (code == KeyEvent.VK_X) //down
	    	 {
	    		 if(my2Y < getHeight() - (PIXELS + 10) ) {
		    	   my2Y += MOVE;
		    	   bunnynumber = 2;
		    	   bunnyImage2[0] = bunnyImage2[3];
	    		 }
	    	 }
	    	 else if (code == KeyEvent.VK_S) //Left
	    	 {
	    		 if(my2X > 0) {
		    	   my2X += -MOVE;
		    	   bunnynumber = 2;
		    	   bunnyImage2[0] = bunnyImage2[4];
	    		 }else {
	    			 bunnyImage2[0] = bunnyImage2[6];
	    		 }
	    	 }
	    	 else if (code == KeyEvent.VK_D) //Right
	    	 {
	    		 if(my2X < getWidth() - PIXELS) {
		    	   my2X += MOVE;
		    	   bunnynumber = 2;
		    	   bunnyImage2[0] = bunnyImage2[2];
	    		 }else {
	    			 bunnyImage2[0] = bunnyImage2[6];
	    		 }
	    	 }
	    	 
	    	 if(bunnynumber == 1) {
	    		 checkCollisions(myX,myY, bunnynumber );
	    	 }else {
	    		 checkCollisions(my2X,my2Y, bunnynumber );  
	    	 }
 
   	      repaint( );
	    	 
	    } else {
   		 
		       JOptionPane.showMessageDialog(null, "Sorry, you have not started playing. \n Place, click on the start button", 
			   "Message", JOptionPane.INFORMATION_MESSAGE);
 	   }
	    	 
    	
	    	 
     } 
   
	
     // Draws the bunny and carrots
      public void paintComponent(Graphics g) {
      
    	
    	g.drawImage( grassBack, 0, 0,  getWidth() , getHeight()  + 90, null);
        g.drawImage(bunnyImage1[0], myX, myY, PIXELS, PIXELS, null);
        g.drawImage(bunnyImage2[0],my2X, my2Y, PIXELS, PIXELS, null);
        
        g.setColor(Color.MAGENTA);
        g.setFont(FONT);
        g.drawString(bunnyString1 +" : " + carrotsPoinsBunny1, getWidth()- 200, 50);
        g.drawString(bunnyString2 +" : " + carrotsPoinsBunny2, 10, 50);

    	
        // Draw all the carrots
         for (int i = 0; i < carrotPosition.size( ); i++) {
           Point p = (Point) carrotPosition.get(i);
    
           // point.getX( ) returns a double, so we must cast to int
           g.drawImage(carrotImage,(int) (p.getX( )), (int) (p.getY( )), PIXELS, PIXELS,null);
           }
        }
    
	
	
	
	private Image readImage(String upLoadimage) {
	    // If image cannot load, prints error output and returns null.
		Image image = null; 
	    
	    try {
	      image = ImageIO.read(new File(upLoadimage));
	   }
	     catch (IOException e) {
	     System.out.println("We could find image '" + upLoadimage + "'");
	     e.printStackTrace( );
	  }
	    
	  return(image);
	} 
	
/***
 * @param does not need it
 * this method only set the score to 0 and display all the carrots when the player stars a new game 
 * */
	  public void reset(){
		  
		  carrotPosition.clear();
		  playing = true;
		  for (int j = 0; j < CARROTS; j++ ){
			  carrotPosition.add(randomPoint());
		  }
		     
			  carrotsPoinsBunny1 = 0;
			  carrotsPoinsBunny2 = 0;
			  repaint( );
	  }
	  
 }

