package tls.player;

import map.Maps;
import map.Position;

public class Player {
	public static final char TOKEN = 'S';
	public static final int MAX_FOV = 14;
	private Maps map;
	private Position pos;
	
	private int[] neededExp;
	
	private int lvl;
	private int exp;
	private int maxHealth;
	private int health;
	private int maxMana;
	private int mana;
	private int stamina;
	private int power;
	private int agility;
	private int perception;
	private int intelligence;
	
	private boolean jumping;
	private int jumpLimit;
	private int jumpCounter;
	private int fov;
	
	public Player(Maps map) {
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
	
	public void spawn(Position pos) {
		this.pos = pos;
	}
	
	public void setPosition(Position pos) {
		this.pos = pos;
	}
	
	public Position getPosition() {
		return this.pos;
	}
	
	public void addExp(int amount) {
		int lvlCounter = 0;
		while(amount > 0) {
			if(this.neededExp[this.lvl + lvlCounter] - this.exp < amount) {
				lvlCounter++;
				amount -= (this.neededExp[this.lvl + lvlCounter] - this.exp);
				this.exp = 0;
			} else {
				this.exp += amount;
				amount = 0;
			}
		}
		
		this.levelUp(lvlCounter);
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
		this.recalcFOV();
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
	
	private void recalcFOV() {
		if(this.perception >= 13) {
			this.fov = MAX_FOV;
		} else {
			this.fov = 9 + this.perception;
		}
	}
	
	private void staminaUp(int amount) {
		for(int i = 0; i < amount; i++) {
			this.stamina++;
		}
		this.recalcHealth();
	}
	
	private void intelligenceUp(int amount) {
		for(int i = 0; i < amount; i++) {
			this.intelligence++;
		}
		this.recalcMana();
	}
	
	private void powerUp(int amount) {
		for(int i = 0; i < amount; i++) {
			this.power++;
		}
		this.recalcJumpLimit();
	}
	
	private void perceptionUp(int amount) {
		for(int i = 0; i < amount; i++) {
			this.perception++;
		}
		this.recalcFOV();
	}
	
	private void agilityUp(int amount) {
		for(int i = 0; i < amount; i++) {
			this.agility++;
		}
	}
	
	private void statInit() {
		this.lvl = 1;
		this.exp = 0;
		this.stamina = 1;
		this.power = 1;
		this.agility = 1;
		this.perception = 1;
		this.intelligence = 1;

		this.recalcHealth();
		this.recalcMana();
		this.recalcJumpLimit();
		this.recalcFOV();
		this.restoreAll();
		
		this.neededExp = chargeExpTable();
	}
	
	private int[] chargeExpTable() {
		int[] toR = new int[200];
		for(int i = 0; i < toR.length; i++) {
			if(i >= 0 && i <= 21) {
				toR[i] = 40 * i;
			} else if(i > 21 && i <= 51) {
				toR[i] = 160 * i;
			} else if(i > 51 && i <= 101) {
				toR[i] = 640 * i;
			} else if(i > 101 && i <= 151) {
				toR[i] = 2560 * i;
			} else if(i > 151) {
				toR[i] = 5120 * i;
			}
		}
		return toR;
	}
}
