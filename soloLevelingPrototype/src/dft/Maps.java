package dft;

import tls.Tile;

public class Maps {
	public static final int SIZE_Y = 8;
	public static final int RENDER_LIMIT = 15;
	
	private int currentLevel;
	private char[][] room;
	
	/**
	 * 0 - Player
	 * 14 - Spawncover
	 * 1-13 - etc
	 * 
	 * []0 = token;
	 * []1 = posX;
	 * []2 = posY;
	 * []3 = is it to be drawn? 't' XOR 'f';
	 */
	private char[][] actress = new char[RENDER_LIMIT][4];
	
	public Maps() {
		
		this.currentLevel = 0;
		this.room = getRoom();
	}
	
	public Maps(int levelSelect) {
		this.currentLevel = levelSelect;
		this.room = getRoom();
	}
	
	public void draw(Player player, boolean pause) {
		char[][] toDraw = getRoom();
		int drawStart;
		int drawEnd;
		Position p = new Position( actress[0][1], actress[0][2] );
		
		if(pause) {
			char[] pauseString = "PAUSE".toCharArray();
			for(int i = 0; i < pauseString.length; i++) {
				toDraw[(toDraw.length/2-3)+i][SIZE_Y/4] = pauseString[i];
			}
		}
		
		toDraw = addLife(toDraw);
		
		if(p.x - player.getFOV() <= 0) {
			drawStart = 0;
		} else {
			drawStart = p.x - player.getFOV();
		}
		
		if(p.x + player.getFOV() >= toDraw.length) {
			drawEnd = toDraw.length;
		} else {
			drawEnd = p.x + player.getFOV();
		}
		
		for(int i = 0; i < toDraw[0].length; i++) {
			for(int j = drawStart; j < drawEnd; j++) {
				System.out.print(toDraw[j][i]);
			}
			System.out.println();
		}
	}
	
	private char[][] getRoom() {
		switch(this.currentLevel) {
			case 1 : return Room.testRoomParkour();
			case 0:
				
			default: return Room.testRoom();
		}
	}
	
	public char getTile(Position p) {
		return this.room[p.x][p.y];
	}
	
	public int getLevel() {
		return this.currentLevel;
	}
	
	public void setLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	public boolean solid(Position actressP, int direction) {
		Position p;
		switch(direction) {
			case 0: p = new Position(
					actressP.x,
					actressP.y-1);
			
					if(p.y < 0) {
						return true;
					}
					break;
					
			case 1: p = new Position(
					actressP.x+1,
					actressP.y);
			
					if(p.x >= this.room.length) {
						return true;
					}
					break;
					
			case 2: p = new Position(
					actressP.x,
					actressP.y+1);
			
					if(p.y >= SIZE_Y) {
						return true;
					}
					break;
					
			case 3: p = new Position(
					actressP.x-1,
					actressP.y);
			
					if(p.x < 0) {
						return true;
					}
					break;
					
			default: return true;
		}
		char token = this.getTile(p);
		Tile tile = Tile.findTileObject(token);
		return !tile.isPassable(direction);
	}
	
	public void setPlayerPos(Position p, char token) {
		this.actress[0][0] = token;
		this.actress[0][1] = (char)p.x;
		this.actress[0][2] = (char)p.y;
		this.actress[0][3] = 't';
	}
	
	public void setOtherPos(int rank, Position p, char token) {
		this.actress[rank][0] = token;
		this.actress[rank][1] = (char)p.x;
		this.actress[rank][2] = (char)p.y;
		this.actress[rank][3] = 't';
	}
	
	public void deSetOther(int rank) {
		this.actress[rank][3] = 'f';
	}
	
	private char[][] addLife(char[][] toDraw) {
		for(int i = actress.length - 1; i >= 0; i--) {
			if(actress[i][3] == 't') {
				toDraw[actress[i][1]][actress[i][2]] = actress[i][0];
			}
		}
		
		
		return toDraw;
	}
	
	public Position getSpawn() {
		char[][] scanMap = this.room;
		for(int i = 0; i < scanMap.length; i++) {
			for(int j = 0; j < scanMap[i].length; j++) {
				if(scanMap[i][j] == '_') {
					this.actress[RENDER_LIMIT - 1][0] = '.';
					this.actress[RENDER_LIMIT - 1][1] = (char) i;
					this.actress[RENDER_LIMIT - 1][2] = (char) j;
					this.actress[RENDER_LIMIT - 1][3] = 't';
					
					return new Position(i, j);
				}
			}
		}
		return new Position(this.room.length/2, SIZE_Y/2);
	}
}
