package org.nationsatwar.toychest;

import java.util.HashMap;

public class ToyChestManager {
	
	public HashMap<String, Toy> toychest = new HashMap<String, Toy>();
	
	public Toy getToy(String toyName) {
		
		return toychest.get(toyName);
	}
	
	public void addToy(Toy toy) {
		
		toychest.put(toy.getToyName(), toy);
	}
	
	public void emptyToychest() {
		
		toychest.clear();
	}
}