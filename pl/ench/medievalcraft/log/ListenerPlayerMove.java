package pl.ench.medievalcraft.log;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ListenerPlayerMove implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		Utils.addLine(e.getPlayer().getName(), e.getFrom(), e.getTo(), Line.PLAYERS);
		return;
	}
}
