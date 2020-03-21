package lewis;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandstaffchattoggle implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender Sender, Command cmd, String label, String[] args) {

		if (!(Sender instanceof Player)) {

			Sender.sendMessage("No do this command ONLINE!");
			return false;

		}
		Player player = (Player) Sender;

		if (player.hasPermission("staffchat.toggle")) {
			if (inStaffChat.contains(player)) {
				inStaffChat.remove(player);
				player.sendMessage("Staffchat Disabled!");

			} else {
				player.sendMessage("Staffchat Enabled!");
				inStaffChat.add(player);
			}
		}

		else {
			player.sendMessage("You dont have access to use this command!");
		}
		return false;
	}
}
