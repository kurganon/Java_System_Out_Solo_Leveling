package tls;

import map.Maps;
import map.Position;

public abstract class ActressTile extends Tile {
	public static final int MAX_FOV = 14;
	protected Maps map;
	protected Position pos;
	
	protected int lvl;
	protected int maxHealth;
	protected int health;
	protected int maxMana;
	protected int mana;
	protected int stamina;
	protected int power;
	protected int agility;
	protected int perception;
	protected int intelligence;
	
	protected boolean jumping;
	protected int jumpLimit;
	protected int jumpCounter;
	protected int fov;
	
	protected ActressTile(Maps map) {
		this.map = map;
		this.jumping = false;
		this.jumpCounter = 0;
		
		
		this.statInit();
	}
	
	public boolean isJump() {
		return this.jumping;
	}
	
	public void jumped() {
		if(this.jumpLimit > this.jumpCounter) {
			this.jumpCounter++;
			if(!this.map.solid(this.pos, 0)) {
				this.pos.y--;
			}
			if(this.jumpCounter == this.jumpLimit) {
				this.jumpCounter = 0;
				this.jumping = false;
			} else {
				this.jumping = true;
			}
		}
	}
	
	public void setPosition(Position pos) {
		this.pos = pos;
	}
	
	public Position getPosition() {
		return this.pos;
	}
	
	public void restoreAll() {
		this.health = this.maxHealth;
		this.mana = this.maxMana;
	}
	
	public void restoreHealth(int amount) {
		if(this.maxHealth - this.health < amount) {
			this.health = this.maxHealth;
		} else {
			this.health += amount;
		}
	}
	
	public void restoreMana(int amount) {
		if(this.maxMana - this.mana < amount) {
			this.mana = this.maxMana;
		} else {
			this.mana += amount;
		}
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getMana() {
		return this.mana;
	}
	
	public int getStamina() {
		return this.stamina;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public int getAgility() {
		return this.agility;
	}
	
	public int getPerception() {
		return this.perception;
	}
	
	public int getIntelligence() {
		return this.intelligence;
	}
	
	public int getFOV() {
		return this.fov;
	}
	
	private void levelUp(int amount) {
		for(int i = 0; i < amount; i++) {
			this.lvl++;
			this.stamina++;
			this.power++;
			this.agility++;
			this.perception++;
			this.intelligence++;
		}

		this.recalcHealth();
		this.recalcMana();
		this.recalcJumpLimit();
		this.restoreAll();
	}
	
	private void recalcHealth() {
		this.maxHealth = this.stamina * 10; 
	}
	
	private void recalcMana() {
		this.maxMana = this.intelligence * (this.lvl/10 +1); 
	}
	
	private void recalcJumpLimit() {
		this.jumpLimit = this.power/50 +1; 
	}
	
	private void statInit() {
		this.lvl = 1;
		this.stamina = 1;
		this.power = 1;
		this.agility = 1;
		this.perception = 1;
		this.intelligence = 1;

		this.recalcHealth();
		this.recalcMana();
		this.recalcJumpLimit();
		this.restoreAll();
	}
}
