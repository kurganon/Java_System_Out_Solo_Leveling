package ndl;

import map.Position;

public class ActressHandler {
	protected char token;
	protected Position position;
	protected boolean toDraw;
	protected boolean active;
	
	public ActressHandler (char token, Position p) {
		this.token = token;
		this.position = p;
		this.toDraw = true;
		this.active = true;
	}
	
	public void setToken(char token) {
		this.token = token;
	}
	
	public char getToken() {
		return this.token;
	}
	
	public void setPos(Position p) {
		this.position = p;
	}
	
	public void setPos(int x, int y) {
		this.position = new Position(x, y);
	}
	
	public Position getPos() {
		return this.position;
	}
	
	public void setToDraw(boolean toDraw) {
		this.toDraw = toDraw;
	}
	
	public boolean isToDraw() {
		if(this.active) {
			return this.toDraw;
		} else {
			return false;
		}
	}
	
	public void flush() {
		this.active = false;
	}
}
