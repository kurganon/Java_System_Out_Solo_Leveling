package tls;

import map.Position;

public class GateTile extends Tile{
	private int level;
	private Position pos;
	
	public GateTile() {
		super();
		this.tileToken = '|';
		this.level = 0;
	}
	public GateTile(char token, boolean[] passable, int durability, int level) {
		this.tileToken = token;
		this.passable = passable;
		this.durability = 0;
		this.level = level;
	}
}
