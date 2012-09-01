package me.jophestus.allgamemode;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class AllGamemode extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	PluginDescriptionFile pdfFile;
	public static AllGamemode plugin;

	public void onEnable() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		// TODO Auto-generated method stub

		if (command.getName().equalsIgnoreCase("allgm")) {
			if (sender.hasPermission("allgamemode.all")) {
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("1")
							|| args[0].equalsIgnoreCase("creative")) {
						for (Player plr : Bukkit.getServer().getOnlinePlayers())
							plr.setGameMode(GameMode.CREATIVE);
						sender.sendMessage(ChatColor.GREEN
								+ "All players are now CREATIVE in mode");

					}

					if (args[0].equalsIgnoreCase("0")
							|| args[0].equalsIgnoreCase("survival")) {
						for (Player plr : Bukkit.getServer().getOnlinePlayers())
							plr.setGameMode(GameMode.SURVIVAL);
						sender.sendMessage(ChatColor.GREEN
								+ "All players are now SURVIVAL in mode");
					}
					if (args[0].equalsIgnoreCase("2")
							|| args[0].equalsIgnoreCase("adventure")) {
						for (Player plr : Bukkit.getServer().getOnlinePlayers())
							plr.setGameMode(GameMode.ADVENTURE);
						sender.sendMessage(ChatColor.GREEN
								+ "All players are now ADVENTURE in mode");
					}
				} else {
					sender.sendMessage("Not enough args");
				}
			} else {
				sender.sendMessage("You don't have permission to do this");
			}
		}

		return super.onCommand(sender, command, label, args);

	}

	public void onDisable() {

		pdfFile = this.getDescription();
		this.log.info(pdfFile.getName() + " is now disabled!");
	}
}