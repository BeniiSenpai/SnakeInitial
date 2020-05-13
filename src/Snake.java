
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.*;

public class Snake {

    private Direction direction;
    private List<Node> body;
    private int remainingNodesToCreate = 0;

    public Snake(int row, int col, int size) { // Initial position of the head of the snake and number of inital nodes
        body = new ArrayList<Node>();
        for (int i = 0; i < size; i++) {
            body.add(new Node((row), (col) - i));
        }

        direction = Direction.RIGHT;
    }

    public void paint(Graphics g, int squareWidth, int squareHeight) {
        boolean firstNode = true; // To print the head, first Node    
        for (Node node : body) {
            if (firstNode) {
                firstNode = false;
                Util.drawSquare(g, node.getRow(), node.getCol(), squareWidth, squareHeight, new Color(30, 96, 94));
            } else {
                Util.drawSquare(g, node.getRow(), node.getCol(), squareWidth, squareHeight, new Color(70, 209, 204));
            }
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean canMove(int row, int col) {
        if (row < 0 || col < 0 || row >= Board.getRows() || col >= Board.getCols()) {
            return false;
        } else {
            /*
            if (colidesWithItSelf()) {
                return false;
            }
            */
            move();
            return true;
        }
    }
    
    public void remainingNodesToMove(int row, int col){
        body.add(0, new Node(row, col));
        if (remainingNodesToCreate == 0) {
            body.remove(body.size() - 1);
        } else {
            remainingNodesToCreate --;
        }
        
    }
    
    /*
    private boolean colidesWithItSelf() {
        Node node;
        Node firstNode = body.get(0);
        for (int i = 1; i < body.size(); i++) {
            node = body.get(i);
            if (node.getCol() == firstNode.getCol() && node.getRow() == firstNode.getRow()) {
                return true;
            }
        }
        return false;
    }
    */

    public void move() {
        int row = body.get(0).getRow();
        int col = body.get(0).getCol();
        switch (direction) {
            case UP:
                remainingNodesToMove(row - 1, col);
                break;
            case DOWN:
                remainingNodesToMove(row + 1, col);
                break;
            case LEFT:
                remainingNodesToMove(row, col - 1);
                break;
            case RIGHT:
                remainingNodesToMove(row, col + 1);
                break;
        }
        
        Toolkit.getDefaultToolkit().sync();
    }

}
