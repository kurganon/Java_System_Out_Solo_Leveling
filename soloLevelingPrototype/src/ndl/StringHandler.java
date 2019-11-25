package ndl;

import dft.ClassicGame;
import map.Maps;
import map.Position;
import tls.player.Player;

public class StringHandler {
	private Player player;
	private ClassicGame game;
	private Maps map;
	
	public StringHandler(Player player, ClassicGame game, Maps map) {
		this.player = player;
		this.game = game;
		this.map = map;
	}
	
	public void checkInput(String input){
		if(isMail(input)) {

			return;
		} else if(isInventory(input)) {

			return;
		} else if(isStats(input)) {

			return;
		} else if(isSkills(input)) {

			return;
		} else if(isShop(input)) {

			return;
		} else if(isAllies(input)) {

			return;
		}
		
		Position p = player.getPosition();
		if(isUp(input)) {
			p = handleUp(p);
		} else {
			p = handleAirborne(p);
		}
		
		if(isLeft(input)) {
			p = handleLeft(p);
		} else if(isRight(input)) {
			p = handleRight(p);
		}
		
		
	}
	
	private boolean isLeft(String input) {
		String[] left = {
				"left",
				"links"
		};
		
		for(int i = 0; i < left.length; i++) {
			if(input.contains(left[i])) {
				return true;
			}
		}
		return false;
	}
	
	private Position handleLeft(Position p) {
		if(!map.solid(player.getPosition(), 3)) {
			p.x--;
			this.game.isChanged();
		}
		
		return p;
	}
	
	private boolean isRight(String input) {
		String[] right = {
				"right",
				"rechts"
		};
		
		for(int i = 0; i < right.length; i++) {
			if(input.contains(right[i])) {
				return true;
			}
		}
		return false;
	}
	
	private Position handleRight(Position p) {
		if(!map.solid(player.getPosition(), 1)) {
			p.x++;
			this.game.isChanged();
		}
		
		return p;
	}
	
	private boolean isUp(String input) {
		String[] up = {
				"up",
				"hoch",
				"rauf",
				"jump",
				"sprung",
				"spring",
				"420"
		};
		
		for(int i = 0; i < up.length; i++) {
			if(input.contains(up[i])) {
				return true;
			}
		}
		return false;
	}
	
	private Position handleUp(Position p) {
		if(map.solid(player.getPosition(), 2) || this.player.isJump()) {
			player.jumped();
			this.game.isChanged();
		} else {
			p.y++;
			this.game.isChanged();
		}
		return p;
	}
	
	private Position handleAirborne(Position p) {
		if(!map.solid(player.getPosition(), 2)) {
			p.y++;
			this.game.isChanged();
		}
		return p;
	}
	
	private boolean isMail(String input) {
		String[] mail = {
				"mail",
				"post",
				"nachricht",
				"message"
		};
		
		for(int i = 0; i < mail.length; i++) {
			if(input.contains(mail[i])) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isInventory(String input) {
		String[] Inventory = {
				"Inventory",
				"Inventar",
				"Items",
				"Gegenst�nde",
				"Besitz"
		};
		
		for(int i = 0; i < Inventory.length; i++) {
			if(input.contains(Inventory[i])) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isStats(String input) {
		String[] stats = {
				"stats",
				"status",
				"eigenschaften",
				"attribute"
		};
		
		for(int i = 0; i < stats.length; i++) {
			if(input.contains(stats[i])) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isSkills(String input) {
		String[] skills = {
				"skills",
				"abilities",
				"f�higkeiten",
				"fertigkeiten"
		};
		
		for(int i = 0; i < skills.length; i++) {
			if(input.contains(skills[i])) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isShop(String input) {
		String[] shop = {
				"shop",
				"store",
				"laden",
				"market",
				"markt",
				"gesch�ft"
		};
		
		for(int i = 0; i < shop.length; i++) {
			if(input.contains(shop[i])) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isAllies(String input) {
		String[] allies = {
				"allies",
				"party",
				"aniki",
				"group",
				"verb�ndete",
				"gruppe",
				"team"
		};
		
		for(int i = 0; i < allies.length; i++) {
			if(input.contains(allies[i])) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
}
