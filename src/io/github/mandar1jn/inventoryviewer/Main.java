package io.github.mandar1jn.inventoryviewer;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.mandar1jn.inventroryviewer.commands.SeeEnderChestCommand;
import io.github.mandar1jn.inventroryviewer.commands.SeeInventoryCommand;

public class Main extends JavaPlugin
{

    public void onEnable() {
        this.registerCommands();
    }
    
    public void onDisable() {
    }
    
    public void registerCommands() {
    	this.getCommand("seeinventory").setExecutor((CommandExecutor)new SeeInventoryCommand());
    	this.getCommand("seeenderchest").setExecutor((CommandExecutor)new SeeEnderChestCommand());
    }
}