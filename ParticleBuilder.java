package de.utils.delta203.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_12_R1.EnumParticle;
import net.minecraft.server.v1_12_R1.PacketPlayOutWorldParticles;

public class ParticleBuilder {

    EnumParticle particletype;
    boolean longdistance;
    Location location;
    float offsetx;
    float offsety;
    float offsetz;
    float speed;
    int ammount;
   

	/**
	 * @author Delta203
	 * @apiNote Use for creating particles
	 * @param particletype EnumParticle
	 * @param longdisantce boolean
	 * @param location Location
	 * @param offsetx float
	 * @param offsety float
	 * @param offsetz float
	 * @param speed float
	 * @param ammount int
	 */
    public ParticleBuilder(EnumParticle particletype, boolean longdisantce, Location location, float offsetx, float offsety, float offsetz, float speed, int ammount) {
       
        this.particletype = particletype;
        this.location = location;
        this.longdistance = longdisantce;
        this.offsetx = offsetx;
        this.offsety = offsety;
        this.offsetz = offsetz;
        this.speed = speed;
        this.ammount = ammount;
    }
    
	public void sendAll(){
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(this.particletype, this.longdistance, (float)this.location.getX(), (float)this.location.getY(), (float)this.location.getZ(), this.offsetx, this.offsety, this.offsetz, this.speed, this.ammount, 0);
       
        for(Player player : Bukkit.getOnlinePlayers()){
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
        }
    }
   
    public void sendPlayer(Player player){
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(this.particletype, this.longdistance, (float)this.location.getX(), (float)this.location.getY(), (float)this.location.getZ(), this.offsetx, this.offsety, this.offsetz, this.speed, this.ammount, 0);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
    }
}