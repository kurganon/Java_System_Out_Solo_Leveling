package tls;

public class GateTile extends Tile{
	private int level;
	
	public GateTile() {
		this.tileToken = '║';
		this.passable = new boolean[4];
		this.passable[0] = true; // north
		this.passable[1] = true; // east
		this.passable[2] = true; // south
		this.passable[3] = true; // west
		this.durability = 0;
		this.level = 0;
	}
	public GateTile(char token, boolean[] passable, int durability, int level) {
		this.tileToken = token;
		this.passable = passable;
		this.durability = 0;
		this.level = level;
	}
}
