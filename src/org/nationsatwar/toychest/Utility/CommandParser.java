package org.nationsatwar.toychest.Utility;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.nationsatwar.toychest.ToyChest;

public final class CommandParser implements CommandExecutor {

	protected final ToyChest plugin;
	
	public CommandParser(ToyChest plugin) {
		
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String argsLabel, String[] args) {
		
		// -toychest OR -toychest help
		if (args.length == 0 || args[0].equals("help"))
			helpCommand(sender);
		
		// -toychest reload
		else if (args[0].equals("reload"))
			reloadCommand(sender, args);
		
		// -toychest <non-applicable command>
		else {
			
			sender.sendMessage(ChatColor.DARK_RED + "Invalid command: type '/toychest' for help.");
			return false;
		}
		
		return true;
	}

	/**
	 * Handles the 'Help' command.
	 * <p>
	 * Returns a list of all possible commands to the command sender.
	 * 
	 * @param sender  Person sending the command
	 */
	private void helpCommand(CommandSender sender) {

		sender.sendMessage(ChatColor.DARK_RED + "[Nations at War]" + ChatColor.DARK_AQUA + " -=[TOYCHEST]=-");
		sender.sendMessage(ChatColor.YELLOW + "Allows you to edit item values via config");
		sender.sendMessage(ChatColor.YELLOW + "Command List: Reload");
	}

	/**
	 * Returns help and parses the 'Reload' command for execution.
	 * 
	 * @param sender  Person sending the command
	 * @param args  String of arguments associated with the command
	 */
	private void reloadCommand(CommandSender sender, String[] args) {

		if (args.length > 1 && args[1].equals("help")) {
			
			sender.sendMessage(ChatColor.DARK_RED + "[Nations at War]" + ChatColor.DARK_AQUA + " -=[RELOAD]=-");
			sender.sendMessage(ChatColor.DARK_AQUA + "i.e. '/toychest reload");
			sender.sendMessage(ChatColor.YELLOW + "Reloads the items found in the toy chest.");
			return;
		}
		
		ConfigHandler.reloadToys();
	}
}