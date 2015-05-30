package org.nationsatwar.toychest.Utility;

import org.nationsatwar.toychest.Toy;
import org.nationsatwar.toychest.ToyChest;

public class ToyChestHook {
	
	public static boolean toyExists(String toyName) {
		
		Toy toy = ToyChest.instance.manager.getToy(toyName);
		
		if (toy != null)
			return true;
		else
			return false;
	}
	
	public static int getDamage(String toyName) {
		
		Toy toy = ToyChest.instance.manager.getToy(toyName);
		
		if (toy != null)
			return toy.getDamage();
		else
			return 0;
	}
	
	public static Object getCustomValue(String toyName, String customValue) {
		
		Toy toy = ToyChest.instance.manager.getToy(toyName);
		
		if (toy != null)
			return toy.getCustomValue(customValue);
		else
			return null;
	}
}