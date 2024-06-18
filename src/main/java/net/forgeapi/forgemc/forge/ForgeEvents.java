/*

FABRIC

THESE CLASSES ARE PROVIDED BY ASESTEFAN, AND THEY'RE NEEDED IN ORDER TO PORT UTILS FROM FABRIC TO FORGE.
YOU ARE ALLOWED TO MAKE COPIES OF THIS SOFTWARE, BUT ONLY THOSE WHO ARE MARKED AS "FABRIC" UPTOP.
THIS WAS ORIGINALLY DESIGNED FOR OUR GUN MOD, BUT SINCE THEN, IT HAS BEEN VERY USEFUL.


*/

package net.forgeapi.forgemc.forge;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.forgeapi.forge_api.ForgeAPI;
import net.forgeapi.forgemc.event.ServerLifecycleEvents;
import net.forgeapi.forgemc.network.ServerPlayNetworking;
import net.forgeapi.forgemc.network.fabric.ServerPlayConnectionEvents;

/**
 * @Author = Fabric API, Better Combat, ASEStefan
 */
@Mod.EventBusSubscriber(modid = ForgeAPI.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.getEntity().level().isClientSide)
            ServerPlayConnectionEvents.onPlayerJoined.forEach((action) -> action.onPlayReady(
                    ((ServerPlayer)event.getEntity()).connection,
                    (id, data) -> ServerPlayNetworking.send((ServerPlayer) event.getEntity(), id, data),
                    event.getEntity().getServer()
            ));
    }

    @SubscribeEvent
    public static void onServerStart(ServerStartedEvent event) {
        ServerLifecycleEvents.onServerStarted.forEach((action) -> action.onServerStarted(event.getServer()));
    }
}
