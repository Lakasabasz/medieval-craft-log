package pl.ench.medievalcraft.log;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private static Main inst;
	
	public void onEnable(){
		inst = this;
		
		Bukkit.getPluginManager().registerEvents(new ListenerBlockBreak(), this);
		Bukkit.getPluginManager().registerEvents(new ListenerBlockPlace(), this);
		
		//Bukkit.getPluginManager().registerEvents(new ListenerPlayerMove(), this);
		
		Bukkit.getPluginManager().registerEvents(new ListenerChestOpen(), this);
		
		Utils.chceckFiles();
	}
	
	public void onDisable(){
		Utils.flush(Flush.ALL);
	}
	
	public static Main getInst(){
		return inst;
	}
}
