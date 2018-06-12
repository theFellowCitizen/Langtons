package board;

public class Tile {
	
	private int x;
	private int y;
	private boolean black; //true = black false = white	
	
	public Tile(int x, int y, boolean black) {
		super();
		this.x = x;
		this.y = y;
		this.black = black;
	}	
	public int getX() {
		return x;
	}	
	public void setX(int x) {
		this.x = x;
	}	
	public int getY() {
		return y;
	}	
	public void setY(int y) {
		this.y = y;
	}
	public boolean isBlack() {
		return black;
	}
	public void setBlack(boolean black) {
		this.black = black;
	}
}