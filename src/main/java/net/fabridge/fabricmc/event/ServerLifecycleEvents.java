/*

FABRIC

THESE CLASSES ARE PROVIDED BY ASESTEFAN, AND THEY'RE NEEDED IN ORDER TO PORT UTILS FROM FABRIC TO FORGE.
YOU ARE ALLOWED TO MAKE COPIES OF THIS SOFTWARE, BUT ONLY THOSE WHO ARE MARKED AS "FABRIC" UPTOP.
THIS WAS ORIGINALLY DESIGNED FOR OUR GUN MOD, BUT SINCE THEN, IT HAS BEEN VERY USEFUL.


 */

package net.fabridge.fabricmc.event;

import net.minecraft.server.MinecraftServer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author = Fabric API, Better Combat, ASEStefan
 */
public class ServerLifecycleEvents {
    public static List<ServerStarted> onServerStarted = new ArrayList<>();
    public static final Event<ServerStarted> SERVER_STARTED = new ServerEvent();

    public static class ServerEvent extends Event<ServerStarted>{
        public void register(ServerStarted listener){
            onServerStarted.add(listener);
        }
    }

    public interface ServerStarted {
        void onServerStarted(MinecraftServer server);
    }
}
