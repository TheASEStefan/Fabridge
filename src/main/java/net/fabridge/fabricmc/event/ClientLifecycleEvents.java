/*

FABRIC

THESE CLASSES ARE PROVIDED BY ASESTEFAN, AND THEY'RE NEEDED IN ORDER TO PORT UTILS FROM FABRIC TO FORGE.
YOU ARE ALLOWED TO MAKE COPIES OF THIS SOFTWARE, BUT ONLY THOSE WHO ARE MARKED AS "FABRIC" UPTOP.
THIS WAS ORIGINALLY DESIGNED FOR OUR GUN MOD, BUT SINCE THEN, IT HAS BEEN VERY USEFUL.


 */

package net.fabridge.fabricmc.event;

import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author = Fabric API, Better Combat, ASEStefan
 */
public class ClientLifecycleEvents {
    public static List<ClientStarted> onClientStarted = new ArrayList<>();
    public static final Event<ClientStarted> CLIENT_STARTED = new ClientEvent();

    public static class ClientEvent extends Event<ClientStarted> {
        public void register(ClientStarted listener){
            onClientStarted.add(listener);
        }
    }

    public interface ClientStarted {
        void onClientStarted(Minecraft client);
    }
}
