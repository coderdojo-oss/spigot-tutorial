package io.github.coderdojooss;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitPlugin extends JavaPlugin {

	private final MovementListener playerListener = new MovementListener(this);
	private final BlockListener blockListener = new BlockListener();
    private final Map<Player, Boolean> debugees = new HashMap<>();

	@Override
	public void onDisable() {
		getLogger().info("onDisable; ik wordt afgesloten");
	}

	@Override
	public void onEnable() {
		// Register our events
        getServer().getPluginManager().registerEvents(playerListener, this);
        getServer().getPluginManager().registerEvents(blockListener, this);

        // Register our commands
        getCommand("pos").setExecutor(new PosCommand());
        getCommand("debug").setExecutor(new DebugCommand(this));
        
        getLogger().info( getDescription().getName() + " v" + getDescription().getVersion() + " is geladen!" );
	}
	
	public boolean isDebugging(final Player player) {
		return Boolean.TRUE.equals(this.debugees.get(player));
    }
	
	public boolean toggleDebugging(final Player player) {
        this.debugees.put(player, !isDebugging(player));
        return isDebugging(player);
    }
}