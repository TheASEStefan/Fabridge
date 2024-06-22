/*

FABRIC

THESE CLASSES ARE PROVIDED BY ASESTEFAN, AND THEY'RE NEEDED IN ORDER TO PORT UTILS FROM FABRIC TO FORGE.
YOU ARE ALLOWED TO MAKE COPIES OF THIS SOFTWARE, BUT ONLY THOSE WHO ARE MARKED AS "FABRIC" UPTOP.
THIS WAS ORIGINALLY DESIGNED FOR OUR GUN MOD, BUT SINCE THEN, IT HAS BEEN VERY USEFUL.


 */

package net.fabridge.fabricmc.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.fabridge.fabricmc.network.fabric.PacketSender;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author = Fabric API, Better Combat, ASEStefan
 */
public class ClientPlayNetworking {
    public static Map<ResourceLocation, PlayChannelHandler> HANDLERS = new HashMap<>();

    public static boolean registerGlobalReceiver(ResourceLocation id, PlayChannelHandler handler){
        HANDLERS.put(id, handler);
        return true;
    }

    public static void send(ResourceLocation id, FriendlyByteBuf forwardBuffer) {
        NetworkHandler.INSTANCE.sendToServer(new PacketWrapper(false, id, forwardBuffer));
    }

    public static void handle(PacketWrapper msg) {
        HANDLERS.get(msg.packetType).receive(Minecraft.getInstance(), Minecraft.getInstance().getConnection(), new FriendlyByteBuf(msg.data), null);
    }

    public interface PlayChannelHandler {
        void receive(Minecraft client, ClientPacketListener handler, FriendlyByteBuf buf, PacketSender responseSender);
    }
}
