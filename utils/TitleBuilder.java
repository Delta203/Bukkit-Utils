package de.utils.delta203.utils;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle.EnumTitleAction;

public class TitleBuilder {
	
	/**
	 * @author Delta203
	 * @apiNote Use for sending custom titles
	 * @param p Player
	 * @param text String
	 * @param cc ChatColor
	 * @param douration int
	 */
	public static void send(Player p, String text, ChatColor cc, int douration) {
		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + text + "\",color:" + cc.name().toLowerCase() + "}");

		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
		PacketPlayOutTitle length = new PacketPlayOutTitle(0, douration, 20);


		((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);
	}
}
