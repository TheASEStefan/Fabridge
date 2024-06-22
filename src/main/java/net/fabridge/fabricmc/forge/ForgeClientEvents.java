/*

FABRIC

THESE CLASSES ARE PROVIDED BY ASESTEFAN, AND THEY'RE NEEDED IN ORDER TO PORT UTILS FROM FABRIC TO FORGE.
YOU ARE ALLOWED TO MAKE COPIES OF THIS SOFTWARE, BUT ONLY THOSE WHO ARE MARKED AS "FABRIC" UPTOP.
THIS WAS ORIGINALLY DESIGNED FOR OUR GUN MOD, BUT SINCE THEN, IT HAS BEEN VERY USEFUL.


*/

package net.fabridge.fabricmc.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.fabridge.mod.Fabridge;
import net.fabridge.fabricmc.network.ClientHelper;

/**
 * @Author = Fabric API, Better Combat, ASEStefan
 */
@Mod.EventBusSubscriber(modid = Fabridge.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeClientEvents {
    @SubscribeEvent
    public static void onToolTip(ItemTooltipEvent event){
        ClientHelper.onTooltip.forEach((action) -> action.getTooltip(event.getItemStack(), event.getFlags(), event.getToolTip()));
    }

    @SubscribeEvent
    public static void onRenderHud(RenderGuiEvent.Post event){
        ClientHelper.onRenderHud.forEach((action) -> action.onHudRender(event.getGuiGraphics(), event.getPartialTick()));
    }
}
