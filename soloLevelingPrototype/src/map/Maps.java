package map;

import ndl.ActressHandler;
import tls.Tile;
import tls.player.Player;

public class Maps {
	public static final int SIZE_Y = 8;
	public static final int RENDER_LIMIT = 16;
	
	private MapInitiator mapIni;
	private int currentLevel;
	private char[][] room;
	
	/**
	 * 0 ~ Player
	 * 1-last ~ etc
	 */
	private ActressHandler[] actress = new ActressHandler[RENDER_LIMIT];
	
	/**
	 * 0-(last-1) ~ etc
	 * last ~ Spawncover
	 */
	private ActressHandler[] extra = new ActressHandler[RENDER_LIMIT];
	
	public Maps() {
		
		this.currentLevel = 0;
		this.room = mapIni.getRoom();
	}
	
	public Maps(int levelSelect) {
		this.currentLevel = levelSelect;
		this.room = mapIni.getRoom();
	}
	
	public void draw(Player player, boolean pause) {
		char[][] toDraw = mapIni.getRoom();
		int drawStart;
		int drawEnd;
		Position p = actress[0].getPos();
		
		if(pause) {
			char[] pauseString = "PAUSE".toCharArray();
			for(int i = 0; i < pauseString.length; i++) {
				toDraw[(toDraw.length/2-3)+i][SIZE_Y/4] = pauseString[i];
			}
		}

		toDraw = addExtra(toDraw);
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
		this.actress[0] = new ActressHandler(token, p);
	}
	
	public void setOtherPos(int rank, Position p, char token) {
		this.actress[rank] = new ActressHandler(token, p);
	}
	
	public void deSetOther(int rank) {
		this.actress[rank].flush();
	}
	
	private char[][] addExtra(char[][] toDraw) {
		for(int i = extra.length - 1; i >= 0; i--) {
			if(extra[i].isToDraw()) {
				toDraw[extra[i].getPos().x][extra[i].getPos().y] = extra[i].getToken();
			}
		}
		
		return toDraw;
	}
	
	private char[][] addLife(char[][] toDraw) {
		for(int i = actress.length - 1; i >= 0; i--) {
			if(actress[i].isToDraw()) {
				toDraw[actress[i].getPos().x][actress[i].getPos().y] = actress[i].getToken();
			}
		}
		
		return toDraw;
	}
	
	public Position getSpawn() {
		return this.extra[Maps.RENDER_LIMIT].getPos();
	}
}
