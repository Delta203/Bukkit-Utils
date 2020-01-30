package de.utils.delta203.utils;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	
	/**
	 * @author Delta203
	 * @apiNote Create normal ItemStack
	 * @param item ItemStack
	 * @param name String
	 */
	public static ItemStack normal(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
	
	/**
	 * @author Delta203
	 * @apiNote Create ItemStack with lore
	 * @param item ItemStack
	 * @param name String
	 * @param lore String(Split with %s%)
	 */
	public static ItemStack lore(ItemStack item, String name, String lore) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		ArrayList<String> a = new ArrayList<>();
		String[] larray = lore.split("%s%");
		for(String types : larray) {
			a.add(types);
		}
		meta.setLore(a);
		item.setItemMeta(meta);
		return item;
	}
}
