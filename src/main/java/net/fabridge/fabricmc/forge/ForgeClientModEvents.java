/*

FABRIC

THESE CLASSES ARE PROVIDED BY ASESTEFAN, AND THEY'RE NEEDED IN ORDER TO PORT UTILS FROM FABRIC TO FORGE.
YOU ARE ALLOWED TO MAKE COPIES OF THIS SOFTWARE, BUT ONLY THOSE WHO ARE MARKED AS "FABRIC" UPTOP.
THIS WAS ORIGINALLY DESIGNED FOR OUR GUN MOD, BUT SINCE THEN, IT HAS BEEN VERY USEFUL.


*/

package net.fabridge.fabricmc.forge;

import net.fabridge.fabricmc.example.ExampleClientPacket;
import net.fabridge.mod.Fabridge;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.fabridge.fabricmc.event.ClientLifecycleEvents;

/**
 * @Author = Fabric API, Better Combat, ASEStefan
 */
@Mod.EventBusSubscriber(modid = Fabridge.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ForgeClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        new ExampleClientPacket().onInitialize(); // Example

        ClientLifecycleEvents.onClientStarted.forEach((action) -> action.onClientStarted(Minecraft.getInstance()));
    }
}
