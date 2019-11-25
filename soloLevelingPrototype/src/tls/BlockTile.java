package tls;

public class BlockTile extends Tile {
	public BlockTile() {
		this.tileToken = '#';
		this.passable = new boolean[4];
		this.passable[0] = false; // north
		this.passable[1] = false; // east
		this.passable[2] = false; // south
		this.passable[3] = false; // west
		this.durability = 100;
	}

}
