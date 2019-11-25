package tls;

public class Tile {
	protected char tileToken;
	protected boolean[] passable;
	protected int durability;
	
	public Tile() {
		this.tileToken = '.';
		this.passable = new boolean[4];
		this.passable[0] = true; // north
		this.passable[1] = true; // east
		this.passable[2] = true; // south
		this.passable[3] = true; // west
		this.durability = 0;
	}
	
	public char getTileToken() {
		return this.tileToken;
	}
	
	public boolean isPassable(int direction) {
		return this.passable[direction];
	}
	
	public int getDurability() {
		return this.durability;
	}
	
	public static Tile findTileObject(char token) {
		switch(token) {
			case '.': return new NothingTile();
			case '#': return new BlockTile();
			case '_': return new PlayerSpawnTile();
			case '║': return new GateTile();
			default: return new BlockTile();
		}
	}
}
