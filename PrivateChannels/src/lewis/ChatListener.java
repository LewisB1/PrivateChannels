
package lewis;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;

public class ChatListener implements Listener {
	@EventHandler
	public void onPlayrChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		if (Commandstaffchattoggle.inStaffChat.contains(player)) {
			event.setCancelled(true);
			for (Player p : Bukkit.getServer().getOnlinePlayers()) {
				if (p.hasPermission("staffchat.see")) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							Main.getPlugin().getConfig().getString("prefix") + player.getName() + Main.getPlugin().getConfig().getString("chatcolour") + event.getMessage()));
				}
			}

		}

	}

}