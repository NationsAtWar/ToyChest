package org.nationsatwar.toychest;

import java.util.HashMap;

public class Toy {
	
	private String toyName;
	
	private int damage;
	
	private HashMap<String, Object> customValues = new HashMap<String, Object>();
	
	// Constructor
	public Toy(String toyName) {
		
		this.toyName = toyName;
	}
	
	// Getters
	public String getToyName() {
		
		return toyName;
	}
	
	public int getDamage() {
		
		return damage;
	}
	
	public Object getCustomValue(String key) {
		
		return customValues.get(key);
	}
	
	// Setters/Adders
	public void setDamage(int damage) {
		
		this.damage = damage;
	}
	
	public void addCustomValue(String key, Object value) {
		
		customValues.put(key, value);
	}
}