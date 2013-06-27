package org.nationsatwar.toychest;

public class Toy {
	
	private String toyName;
	
	private int damage;
	
	public Toy(String toyName) {
		
		this.toyName = toyName;
	}
	
	public String getToyName() {
		
		return toyName;
	}
	
	public int getDamage() {
		
		return damage;
	}
	
	public void setDamage(int damage) {
		
		this.damage = damage;
	}
}