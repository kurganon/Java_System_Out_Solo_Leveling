package ndl;

import java.util.ArrayList;

import map.Position;
import tls.GateTile;
import tls.player.Player;

public class GateHandler {
	private ArrayList<GateTile> gates = new ArrayList<GateTile>();
	
	private int gateAtPlayer = -1;
	
	public boolean playerAtGate() {
		Position p = Player.getPlayer().getPosition();
		for(int i = 0; i < gates.size(); i++) {
			if(this.gates.get(i).getPos().isEqual(p)) {
				this.gateAtPlayer = i;
				return true;
			}
		}
		this.gateAtPlayer = -1;
		return false;
	}
	
	public GateTile getGate(int i) {
		return gates.get(i);
	}
	
	public GateTile getGateAtPlayer() {
		if(gateAtPlayer < 0) {
			return null;
		} else {
			return gates.get(gateAtPlayer);
		}
	}
	
	public void addGate(GateTile gate) {
		gates.add(gate);
	}
	
	public void clearList() {
		gates.clear();
		this.gateAtPlayer = -1;
	}
}
