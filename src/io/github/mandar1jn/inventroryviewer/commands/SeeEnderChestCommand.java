package io.github.mandar1jn.inventroryviewer.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import net.md_5.bungee.api.ChatColor;

public class SeeEnderChestCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player != true) {
			sender.sendMessage(ChatColor.RED + "You have to be a player to use that command!");
			return false;
		}
		final Player player = (Player)sender;
		if(!player.hasPermission("inventoryviewer.enderchest.see")) {
			sender.sendMessage(ChatColor.RED + "You don't have the permission to do that!");
			return false;
		}
		if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Please specifie a player!");
            return false;
        }
        final Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            player.sendMessage(ChatColor.RED + "That player doesn't exist or isn't online!");
            return false;
        }
        player.openInventory((Inventory)target.getEnderChest());
		return true;
	}
}