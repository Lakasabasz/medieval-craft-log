package pl.ench.medievalcraft.log;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ListenerChestOpen implements Listener {

	@EventHandler
	public void onChestOpen(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getClickedBlock().getType().equals(Material.CHEST) || e.getClickedBlock().getType().equals(Material.TRAPPED_CHEST) || e.getClickedBlock().getType().equals(Material.ENDER_CHEST)){
				Utils.addLine(e.getPlayer().getName(), e.getClickedBlock().getLocation(), Line.CHEST);
			}
		}
	}
}
