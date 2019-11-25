package tls;

import map.Position;

public class GateTile extends Tile{
	private Position pos;
	private int level;
	private int spawn;
	private boolean active;
	private boolean open;
	
	public GateTile() {
		super();
		this.tileToken = '|';
		this.level = 0;
	}
	
	public GateTile(Position pos, char token, int level, int spawn, boolean active, boolean open) {
		super();
		this.pos = pos;
		this.tileToken = token;
		this.level = level;
		this.spawn = spawn;
		this.active = active;
		this.open = open;
	}
	
	public GateTile(char token, boolean[] passable, int durability, int level) {
		this.tileToken = token;
		this.passable = passable;
		this.durability = 0;
		this.level = level;
	}
	
	public Position getPos() {
		return this.pos;
	}
	
	public char getToken() {
		return this.tileToken;
	}
	
	public int getDestinationLevel() {
		return this.level;
	}
	
	public int getDestinationSpawn() {
		return this.spawn;
	}
	
	public boolean isActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public boolean isOpen() {
		return this.open;
	}
	
	public void setOpen(boolean open) {
		this.open = open;
	}
}
