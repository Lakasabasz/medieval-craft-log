package pl.ench.medievalcraft.log;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ListenerBlockBreak implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		Utils.addLine(e.getPlayer().getName(), e.getBlock().getType().toString(), e.getBlock().getLocation(), Line.BLOCK);
		return;
	}
}
