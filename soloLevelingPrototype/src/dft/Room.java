package dft;

import tls.*;

public class Room {
	private static BlockTile block = new BlockTile();
	private static NothingTile nothing = new NothingTile();
	private static PlayerSpawnTile playerSpawn = new PlayerSpawnTile();
	
	public static char[][] testRoom() {
		int sizeX = 48;
		
		char[][] toR = new char[sizeX][Maps.SIZE_Y];
		for(int i = 0; i < sizeX; i++) {
			for(int j = 0; j < Maps.SIZE_Y; j++) {
				if(j < Maps.SIZE_Y - 2 && !(i == 0 || i == sizeX -1)) {
					toR[i][j] = nothing.getTileToken();
				} else {
					toR[i][j] = block.getTileToken();
				}
			}
		}
		
		toR[3][5] = '_';
		
		for(int i = toR.length / 2 - 3; i < toR.length / 2 + 3; i++) {
			toR[i][5] = '#';
		}
		return toR;
	}
	
	public static char[][] testRoomParkour() {
		int size = 48;
		
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
		
		toR[3][5] = playerSpawn.getTileToken();
		
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
		toR[21][2] = new GateTile().getTileToken();
		
		return toR;
	}

}
