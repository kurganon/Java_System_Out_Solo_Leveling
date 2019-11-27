package map;

import tls.*;

public class Room {
	private static BlockTile block = new BlockTile();
	private static NothingTile nothing = new NothingTile();
	
	public static char[][] testRoom() {
		int sizeX = 48;
		
		char[][] toR = basicRoom(sizeX);
		
		for(int i = toR.length / 2 - 3; i < toR.length / 2 + 3; i++) {
			toR[i][5] = '#';
		}
		return toR;
	}
	
	public static char[][] testRoomParkour() {
		int size = 48;
		
		char[][] toR = basicRoom(size);
		
		toR[5][5] = block.getTileToken();
		toR[6][5] = block.getTileToken();
		toR[7][5] = block.getTileToken();
		toR[8][4] = block.getTileToken();
		toR[9][4] = block.getTileToken();
		toR[10][4] = block.getTileToken();
		toR[11][3] = block.getTileToken();
		toR[12][3] = block.getTileToken();
		toR[13][3] = block.getTileToken();
		toR[15][3] = block.getTileToken();
		toR[16][3] = block.getTileToken();
		toR[17][3] = block.getTileToken();
		toR[19][3] = block.getTileToken();
		toR[20][3] = block.getTileToken();
		toR[21][3] = block.getTileToken();
		
		return toR;
	}
	
	public static char[][] basicRoom(int size) {
		char[][] toR = new char[size][Maps.SIZE_Y];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < Maps.SIZE_Y; j++) {
				if(j < Maps.SIZE_Y - 2 && !(i == 0 || i == size -1)) {
					toR[i][j] = nothing.getTileToken();
				} else {
					toR[i][j] = block.getTileToken();
				}
			}
		}
		
		return toR;
	}
	
	public static char[][] addCaveCeiling(char[][] room, int offset) {
		float random = 0;
		for(int i = 0; i < room.length; i++) {
			random = (float) (Math.random() * Math.random() * 10);
			if(random < 3) {
				room[i][offset] = '#';
				if(random < 1) {
					room[i][offset+1] = '#';
				}
			}
		}
		
		return room;
	}
	
	public static char[][] addCaveFloor(char[][] room, int offset) {
		float random = 0;
		for(int i = 0; i < room.length; i++) {
			random = (float) (Math.random() * Math.random() * 10);
			if(random < 2) {
				room[i][Maps.SIZE_Y - offset] = '#';
			}
		}
		
		return room;
	}
	
	public static int groundAt(char[] col) {
		int ret = 0;
		for(int i = col.length -1; i >= 0; i++) {
			if(col[i] != block.getTileToken()) {
				ret = i;
				break;
			}
		}
		return ret;
	}
}
