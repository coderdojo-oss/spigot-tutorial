package io.github.coderdojooss;

import org.bukkit.plugin.java.JavaPlugin;

public class BukkitPlugin extends JavaPlugin {

	@Override
	public void onDisable() {
		getLogger().info("onDisable; ik wordt afgesloten");
	}

	@Override
	public void onEnable() {
		getLogger().info("onEnable; ik ben geladen");
	}
}