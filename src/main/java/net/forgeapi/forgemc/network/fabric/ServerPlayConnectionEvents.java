/*

FABRIC

THESE CLASSES ARE PROVIDED BY ASESTEFAN, AND THEY'RE NEEDED IN ORDER TO PORT UTILS FROM FABRIC TO FORGE.
YOU ARE ALLOWED TO MAKE COPIES OF THIS SOFTWARE, BUT ONLY THOSE WHO ARE MARKED AS "FABRIC" UPTOP.
THIS WAS ORIGINALLY DESIGNED FOR OUR GUN MOD, BUT SINCE THEN, IT HAS BEEN VERY USEFUL.


 */

package net.forgeapi.forgemc.network.fabric;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.forgeapi.forgemc.event.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author = Fabric API, Better Combat, ASEStefan
 */
public class ServerPlayConnectionEvents {
    public static List<Join> onPlayerJoined = new ArrayList<>();
    public static final Event<Join> JOIN = new PlayerJoinEvent();

    public static class PlayerJoinEvent extends Event<Join> {
        public void register(Join listener){
            onPlayerJoined.add(listener);
        }
    }

    public interface Join {
        void onPlayReady(ServerGamePacketListenerImpl handler, PacketSender sender, MinecraftServer server);
    }

}
