/*

FABRIC

THESE CLASSES ARE PROVIDED BY ASESTEFAN, AND THEY'RE NEEDED IN ORDER TO PORT UTILS FROM FABRIC TO FORGE.
YOU ARE ALLOWED TO MAKE COPIES OF THIS SOFTWARE, BUT ONLY THOSE WHO ARE MARKED AS "FABRIC" UPTOP.
THIS WAS ORIGINALLY DESIGNED FOR OUR GUN MOD, BUT SINCE THEN, IT HAS BEEN VERY USEFUL.


 */

package net.fabridge.fabricmc.network.fabric;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

import java.util.Collection;

/**
 * @Author = Fabric API, Better Combat, ASEStefan
 */
public class PlayerLookup {
    public static Collection<ServerPlayer> tracking(Entity player) {
        return (Collection<ServerPlayer>) player.level().players(); // TODO
    }

    public static Collection<ServerPlayer> around(ServerLevel world, Vec3 origin, double distance) {
        return world.getPlayers((player) -> player.position().distanceTo(origin) <= distance);
    }
}
