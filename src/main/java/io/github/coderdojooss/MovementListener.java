package io.github.coderdojooss;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListener implements Listener {
	private final BukkitPlugin plugin;

    public MovementListener(BukkitPlugin instance) {
        plugin = instance;
    }
    
    @EventHandler
    public void onRedstone(BlockRedstoneEvent event) {
    	this.plugin.getLogger().info(String.format("redstone event: %s",event));
    	this.plugin.getLogger().info(String.format("redstone block: %s",event.getBlock()));
    	DyeColor color = findDyeColor(event.getBlock());
    	this.plugin.getLogger().info(String.format("color: %s",color));
    	if(color!=null) {
    		this.plugin.getServer().broadcastMessage("dyeColor: "+color);
    	}
    }
    
    private DyeColor findDyeColor(Block block) {
    	for(BlockFace blockFace:BlockFace.values()) {
    		Block relativeBlock = block.getRelative(blockFace);
    		
    		this.plugin.getLogger().info(String.format("relative on %s: %s",blockFace,relativeBlock));
    		if(Material.CARPET.equals(relativeBlock.getType())) {
    			return DyeColor.getByData(relativeBlock.getData());
    		}
    	}
    	return null;
    }
	
	@EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (this.plugin.isDebugging(event.getPlayer())) {
        	DyeColor color = findDyeColor(event.getTo().getBlock());
        	if(color!=null) {
        		event.getPlayer().sendMessage("you are moving onto "+color+" dyed carpet");
        	}
        }
    }
}