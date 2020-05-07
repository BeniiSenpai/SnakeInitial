
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victoralonso
 */
public class Snake {
    
    private Direction direction;
    private List<Node> body;
    private int remainingNodesToCreate = 0;
    
    
    public Snake(int row, int col, int size) { // Initial position of the head of the snake and number of inital nodes
        body = new ArrayList<Node>();
        for(int i=0; i < size; i++) {
            body.add(new Node((row), (col) - i));
        }
    }
    
    public boolean canMove(int row, int col) {
       if (row < 0 || col < 0 || row >= Board.getRows()|| col >= Board.getCols()) {            
            return false;
        } else { 
           return true;
        }
    }
    
    public void paint(Graphics g, int squareWidth, int squareHeight) {
        boolean firstNode = true; // To print the head, first Node    
        for (Node node: body) {
            if(firstNode) {
                firstNode = false;
                Util.drawSquare(g, squareWidth, squareHeight, node.getCol(),node.getRow() , new Color(30, 96, 94));
            } else {
                Util.drawSquare(g, squareWidth, squareHeight, node.getCol(),node.getRow() , new Color(70, 209, 204));
            }
        }
    }
    
    public void move() {
        int row = body.get(0).getRow();
        int col = body.get(0).getCol();
        switch(direction) {
            case UP:                
                canMove(row - 1, col);
                break;

            case DOWN:
               canMove(row + 1, col);
                break;
           case LEFT:
               canMove(row, col - 1);
                break;
 
           case RIGHT:
               canMove(row, col + 1);
                break;

        }
    }
    
    
    
}
