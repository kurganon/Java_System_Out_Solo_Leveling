package map;

public class MapInitiator {
	
	private Maps map;

	public char[][] getRoom() {
		switch(map.getLevel()) {
			case 1 : return Room.testRoomParkour();
			case 0:
				
			default: return Room.testRoom();
		}
	}
	
	
	
	
}
