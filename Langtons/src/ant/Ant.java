package ant;

import application.Main;

import board.Tile;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ant extends Thread {

    private int id;
    private int direction;
    private int xPos;
    private int yPos;
    private int boardX;
    private int boardY;
    private Rectangle rec;

    public Ant(int id, int direction, int xPos, int yPos) {
        this.id = id;
        this.direction = direction;
        this.xPos = xPos;
        this.yPos = yPos;
        System.out.println(direction);
        System.out.println("Ants position: " + xPos + ":" + yPos);
    }

    public void stepForward(Ant ant) {
        // 0 = up | 1 = right | 2 = down | 3 = left
//    	System.out.println(ant.id + " : "+ant.xPos + " | "+ant.yPos);
        switch (direction) {
            case 0:
                if (ant.getyPos() - 1 < 0) {
                    ant.setyPos(boardY - 1);
                }
                ant.setyPos(yPos - 1);
                ant.turn(ant);
                nextColor(ant);
                //ant.changeTilecolor(ant);
                break;
            case 1:
                if (ant.getxPos() + 1 > boardX - 1) {
                    ant.setxPos(0);
                }
                ant.setxPos(xPos + 1);
                ant.turn(ant);
                nextColor(ant);
                //ant.changeTilecolor(ant);
                break;
            case 2:
                if (ant.getyPos() + 1 > boardY - 1) {
                    ant.setyPos(0);
                }
                ant.setyPos(yPos + 1);
                ant.turn(ant);
                nextColor(ant);
                //ant.changeTilecolor(ant);
                break;
            case 3:
                if (ant.getxPos() - 1 < 0) {
                    ant.setxPos(boardX - 1);
                }
                ant.setxPos(xPos - 1);
                ant.turn(ant);
                nextColor(ant);
                //ant.changeTilecolor(ant);
                break;
        }

    }
    
    public void nextColor(Ant ant){
       if (Main.boardy[ant.getxPos()][ant.getyPos()].isBlack() == true) {
    	   Main.boardy[ant.getxPos()][ant.getyPos()].setBlack(false);
       } else {
    	   Main.boardy[ant.getxPos()][ant.getyPos()].setBlack(true);
       }
    }

    public void turn(Ant ant) {
        // if black turn to the right
        // 0 = up | 1 = right | 2 = down | 3 = left
        if (checkIfBlack(ant)) {
            if (direction == 0) {
                direction = 3;
            } else {
                direction -= 1;
            }
        } else if (direction == 3) {
            direction = 0;
        } else {
            direction += 1;
        }
    }

    //This method is from an older version of the programm
    public void changeTilecolor(Ant ant) {
        if (Main.boardy[ant.getxPos()][ant.getyPos()].isBlack() == true) {
        	Main.boardy[ant.getxPos()][ant.getyPos()].setBlack(false);

            rec = new Rectangle();
            rec.setWidth(5);
            rec.setHeight(5);
            rec.setFill(Color.rgb(200, 80, 50));
            rec.setStrokeWidth(0.0);
            application.Main.root.getChildren().remove(new Rectangle());
            application.Main.root.add(rec, ant.getxPos(), ant.getyPos());
        } else {
        	Main.boardy[ant.getxPos()][ant.getyPos()].setBlack(true);

            rec = new Rectangle();
            rec.setWidth(5);
            rec.setHeight(5);
            rec.setFill(Color.rgb(50, 80, 200));
            rec.setStrokeWidth(0.0);
            application.Main.root.getChildren().remove(new Rectangle());
            application.Main.root.add(rec, ant.getxPos(), ant.getyPos());
        }
    }

    public void setupBoard(int a, int i) {
        boardX = a;
        boardY = i;
        for (int y = 0; y < i; y++) {
            for (int x = 0; x < a; x++) {
            	Main.boardy[x][y] = new Tile(x, y, false);
                rec = new Rectangle();
                rec.setWidth(5);
                rec.setHeight(5);
                rec.setFill(Color.rgb(255, 255, 255));
                rec.setStroke(Color.BLACK);
                rec.setStrokeWidth(0.0);
                //application.Main.root.add(rec, x, y);
            }
        }
        System.out.println(boardX + " : " + boardY);
    }

    public boolean checkIfBlack(Ant ant) {    	
        return Main.boardy[ant.getxPos()][ant.getyPos()].isBlack();
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
