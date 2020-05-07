
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victoralonso
 */
public class Food {
    private Node position;
    private boolean isSpecial;
    
    public Food(Snake snake) { 
        // We pass Snake to the constructor because if the randomnly generated food
        // falls on the Snake you have to create another position for the food
        position = randomPosition(snake);
        
        
    }
    
    public void paint(Graphics g, int squareWidth, int squareHeight) {
        // Finish this method. Call Util.drawSquare()
    }
    
    // Create all the methods you need here

    private Node randomPosition(Snake snake) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
