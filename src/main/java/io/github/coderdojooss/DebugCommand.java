package io.github.coderdojooss;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DebugCommand implements CommandExecutor {
    private final BukkitPlugin plugin;

    public DebugCommand(BukkitPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (Player.class.isInstance(sender)) {
            Player player = (Player) sender;
            boolean result = this.plugin.toggleDebugging(player);
            player.sendMessage("debug is "+(result?"enabled":"disabled"));
            return true;
        }
        return false;
    }
}
