package lewis;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static Plugin getPlugin() {

		return Bukkit.getServer().getPluginManager().getPlugin("staffchat");
	}

	public void onEnable() {
		getConfig().options().copyDefaults(true);
		getConfig().options().copyHeader(true);
		saveDefaultConfig();

		registerStuff();
		System.out.println("StaffChat enabled!");

	}

	public void onDisable() {
		System.out.println("StaffChat Disabled!");

	}

	public void registerStuff() {
		getCommand("tsc").setExecutor(new Commandstaffchattoggle());
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new ChatListener(), this);
		Permission staffSee = new Permission("staffchat.see");
		Permission staffToggle = new Permission("staffchat.toggle");
		pm.addPermission(staffSee);
		pm.addPermission(staffToggle);

	}
}