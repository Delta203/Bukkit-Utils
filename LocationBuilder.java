package de.utils.delta203.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationBuilder {

	String name;
	Location loc;
	
	/**
	 * @author Delta203
	 * @apiNote Use for saving locations
	 * @param name String
	 * @param loc Location
	 */
	public LocationBuilder(String name, Location loc) {
		this.name = name;
		this.loc = loc;
	}
	
	/**
	 * @author Delta203
	 * @apiNote Use for getting locations
	 * @param name String
	 */
	public LocationBuilder(String name) {
		this.name = name;
	}
	
	/*
	 * Path: Locations.name.<type>
	 */
	public void create() {
		Utils.plugin.getConfig().set("Locations." + name + ".world", loc.getWorld().getName());
		Utils.plugin.getConfig().set("Locations." + name + ".x", loc.getX());
		Utils.plugin.getConfig().set("Locations." + name + ".y", loc.getY());
		Utils.plugin.getConfig().set("Locations." + name + ".z", loc.getZ());
		Utils.plugin.getConfig().set("Locations." + name + ".yaw", loc.getYaw());
		Utils.plugin.getConfig().set("Locations." + name + ".pitch", loc.getPitch());
		Utils.plugin.saveConfig();
	}

	/*
	 * Path: Locations.name.<type>
	 */
	public Location get() {
		Location loc = new Location(Bukkit.getWorld(Utils.plugin.getConfig().getString("Locations." + name + ".world")),
				Utils.plugin.getConfig().getDouble("Locations." + name + ".x"), Utils.plugin.getConfig().getDouble("Locations." + name + ".y"), Utils.plugin.getConfig().getDouble("Locations." + name + ".z"),
				(float) Utils.plugin.getConfig().getDouble("Locations." + name + ".yaw"), (float) Utils.plugin.getConfig().getDouble("Locations." + name + ".pitch"));
		return loc;
	}
}