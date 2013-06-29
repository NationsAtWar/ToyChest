package org.nationsatwar.toychest.Utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

import org.nationsatwar.toychest.ToyChest;

public final class CommandParser implements ICommand {
	
	private final List aliases;
	
	private final ToyChest plugin;
	
	public CommandParser(ToyChest plugin) {
		
		this.plugin = plugin;

	    this.aliases = new ArrayList();
	    this.aliases.add("toychest");
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] arguments) {
		
		// -toychest OR -toychest help
		if (arguments.length == 0 || arguments[0].equals("help"))
			helpCommand(sender);
		
		// -toychest reload
		else if (arguments[0].equals("reload"))
			reloadCommand(sender, arguments);
		
		// -toychest <non-applicable command>
		else {
			
			sender.sendChatToPlayer("§4" + "Invalid command: type '/toychest' for help.");
			return;
		}
		
		return;
	}

	/**
	 * Handles the 'Help' command.
	 * <p>
	 * Returns a list of all possible commands to the command sender.
	 * 
	 * @param sender  Person sending the command
	 */
	private void helpCommand(ICommandSender sender) {

		sender.sendChatToPlayer("§4" + "[Nations at War]" + "§3" + "-=[TOYCHEST]=-");
		sender.sendChatToPlayer("§e" + "Allows you to edit item values via config");
		sender.sendChatToPlayer("§e" + "Command List: Reload");
	}

	/**
	 * Returns help and parses the 'Reload' command for execution.
	 * 
	 * @param sender  Person sending the command
	 * @param args  String of arguments associated with the command
	 */
	private void reloadCommand(ICommandSender sender, String[] args) {

		if (args.length > 1 && args[1].equals("help")) {
			
			sender.sendChatToPlayer("§4" + "[Nations at War]" + "§3" + " -=[RELOAD]=-");
			sender.sendChatToPlayer("§3" + "i.e. '/toychest reload");
			sender.sendChatToPlayer("§e" + "Reloads the items found in the toy chest.");
			return;
		}
		
		plugin.log("Hi");
		ConfigHandler.reloadToys(plugin);
	}

	@Override
	public int compareTo(Object arg0) {
		
		return 0;
	}

	@Override
	public String getCommandName() {
		
		return aliases.get(0).toString();
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		
		return aliases.get(0).toString() + "<text>";
	}

	@Override
	public List getCommandAliases() {
		
		return aliases;
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender,
			String[] astring) {
		
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i) {
		
		return false;
	}
}