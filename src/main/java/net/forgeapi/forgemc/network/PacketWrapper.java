/*

FABRIC

THESE CLASSES ARE PROVIDED BY ASESTEFAN, AND THEY'RE NEEDED IN ORDER TO PORT UTILS FROM FABRIC TO FORGE.
YOU ARE ALLOWED TO MAKE COPIES OF THIS SOFTWARE, BUT ONLY THOSE WHO ARE MARKED AS "FABRIC" UPTOP.
THIS WAS ORIGINALLY DESIGNED FOR OUR GUN MOD, BUT SINCE THEN, IT HAS BEEN VERY USEFUL.


 */

package net.forgeapi.forgemc.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * @Author = Fabric API, Better Combat, ASEStefan
 */
public class PacketWrapper {
    boolean isClientBound;
    public final ResourceLocation packetType;
    public final ByteBuf data;
    public PacketWrapper(boolean isClientBound, ResourceLocation packetType, ByteBuf data){
        this.isClientBound = isClientBound;
        this.packetType = packetType;
        this.data = data;
    }

    public static void encode(PacketWrapper msg, FriendlyByteBuf packetByteBuf) {
        packetByteBuf.writeBoolean(msg.isClientBound);
        packetByteBuf.writeResourceLocation(msg.packetType);
        packetByteBuf.writeBytes(msg.data);
    }

    public static PacketWrapper decode(FriendlyByteBuf packetByteBuf) {
        return new PacketWrapper(packetByteBuf.readBoolean(), packetByteBuf.readResourceLocation(), packetByteBuf.readBytes(packetByteBuf.readableBytes()));
    }

    public static void handle(PacketWrapper msg, Supplier<NetworkEvent.Context> contextSupplier) {
        if (msg.isClientBound) ClientPlayNetworking.handle(msg);
        else ServerPlayNetworking.handle(msg, contextSupplier.get().getSender());
        contextSupplier.get().setPacketHandled(true);
    }

}
