/*

FABRIC

THESE CLASSES ARE PROVIDED BY ASESTEFAN, AND THEY'RE NEEDED IN ORDER TO PORT UTILS FROM FABRIC TO FORGE.
YOU ARE ALLOWED TO MAKE COPIES OF THIS SOFTWARE, BUT ONLY THOSE WHO ARE MARKED AS "FABRIC" UPTOP.
THIS WAS ORIGINALLY DESIGNED FOR OUR GUN MOD, BUT SINCE THEN, IT HAS BEEN VERY USEFUL.


 */

package net.fabridge.fabricmc.network;

import net.fabridge.mod.Fabridge;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;


/**
 * @Author = Fabric API, Better Combat, ASEStefan, ChatGPT
 */
public class NetworkHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(Fabridge.MODID, "network"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void registerMessages() {
        int id = 0;
        INSTANCE.registerMessage(id++, PacketWrapper.class, PacketWrapper::encode, PacketWrapper::decode, PacketWrapper::handle);
    }


}
