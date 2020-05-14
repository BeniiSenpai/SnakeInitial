
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Food {

    private Node position;
    private boolean isSpecial;

    public Food(Snake snake) {
        // We pass Snake to the constructor because if the randomnly generated food
        // falls on the Snake you have to create another position for the food
        randomPositionFood(snake);
        isSpecial = false;
    }

    public void paint(Graphics g, int squareWidth, int squareHeight) {
        if (isSpecial) {
            Util.drawSquare(g, position.getRow(), position.getCol(), squareWidth, squareHeight, new Color(255, 51, 51));
        } else {
            Util.drawSquare(g, position.getRow(), position.getCol(), squareWidth, squareHeight, new Color(0, 0, 0));
        }
    }

    // Create all the methods you need here
    public void randomPositionFood(Snake snake) {
        boolean goodPosition = false;
        List<Node> snakePosition = snake.getBody();

        while (!goodPosition) {
            int x = (int) (Math.random() * (Board.numRows));
            int y = (int) (Math.random() * (Board.numCols));
            position = new Node(x, y);
            for (Node checkUp : snakePosition) {
                if (checkUp == position) {
                    break;
                } else {
                    goodPosition = true;
                }
            }
        }
    }

    public Node getPosition() {
        return position;
    }

    public boolean isIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(boolean isSpecial) {
        this.isSpecial = isSpecial;
    }

}
