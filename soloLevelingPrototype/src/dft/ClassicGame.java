package dft;

import java.util.Scanner;

public class ClassicGame {
	private Scanner sc = new Scanner(System.in);
	private Maps maps;
	private Player player;
	private StringHandler handle;
	
	private boolean game;
	private boolean pause;
	private boolean change;
	
	public ClassicGame() {
		this.levelSelect();
		this.player = new Player(maps);
		this.handle = new StringHandler(player, this, maps);
		this.spawn();
		
		game = true;
		pause = false;
		change = false;
		
		engine();
	}
	
	private void engine() {
		while(game) {
			if(!pause) {
				System.out.print("Input: ");
				handle.checkInput(sc.nextLine());
			}
			if(change) {
				maps.setPlayerPos(this.player.getPosition(), Player.TOKEN);
				maps.draw(player, pause);
				change = !change;
			}
		}
	}
	
	private void levelSelect() {
		System.out.print("Choose a level: ");
		this.maps = new Maps(sc.nextInt());
	}
	
	private void spawn() {
		this.player.spawn(maps.getSpawn());
		this.maps.setPlayerPos(this.player.getPosition(), Player.TOKEN);
		maps.draw(player, pause);
	}
	
	public void isChanged() {
		this.change = true;
	}
}
