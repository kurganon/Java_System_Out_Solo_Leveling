package tls;

public class PlayerSpawnTile extends Tile {
	public PlayerSpawnTile() {
		this.tileToken = '_';
		this.passable = new boolean[4];
		this.passable[0] = true; // north
		this.passable[1] = true; // east
		this.passable[2] = true; // south
		this.passable[3] = true; // west
		this.durability = 0;
	}
}
