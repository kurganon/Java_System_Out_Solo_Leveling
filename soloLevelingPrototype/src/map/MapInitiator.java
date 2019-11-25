package map;

public class MapInitiator {
	
	private Maps map;
	
	public MapInitiator(Maps map) {
		this.map = map;
	}

	public char[][] getRoom(int spawn) {
		switch(map.getLevel()) {
			case 1 : return this.testRoom1(spawn);
			case 0 :
			default: return this.testRoom0(spawn);
		}
	}
	
	private char[][] testRoom0 (int spawn) {
		char[][] newRoom = Room.testRoom();
		newRoom = Room.addCaveCeiling(newRoom, 0);
		
		map.flush();
		map.addGate(new Position(4, 5), 0, 1);
		map.addGate(new Position(newRoom.length-5, 5), 0, 0);
		
		switch(spawn) {
			case 1:
				map.setSpawn(new Position(newRoom.length-3, 5));
				break;
			case 0:
			default:
				map.setSpawn(new Position(2, 5));
		}
		
		return newRoom;
	}
	
	private char[][] testRoom1 (int spawn) {
		char[][] newRoom = Room.testRoomParkour();
		
		map.flush();
		map.addGate(new Position(21, 2), 0, 0);
		map.addGate(new Position(newRoom.length-5, 5), 1, 0);
		
		switch(spawn) {
			case 1:
			case 0:
			default:
				map.setSpawn(new Position(2, 5));
		}
		
		return newRoom;
	}
	
	
	
	public static char[][] hardCopy(char[][] room) {
		char[][] retRoom = new char[room.length][room[0].length];
		
		for(int i = 0; i < retRoom.length; i++) {
			for(int j = 0; j < retRoom[i].length; j++) {
				retRoom[i][j] = room[i][j];
			}
		}
		
		return retRoom;
	}
}
