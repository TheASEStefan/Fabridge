/*

FABRIC

THESE CLASSES ARE PROVIDED BY ASESTEFAN, AND THEY'RE NEEDED IN ORDER TO PORT UTILS FROM FABRIC TO FORGE.
YOU ARE ALLOWED TO MAKE COPIES OF THIS SOFTWARE, BUT ONLY THOSE WHO ARE MARKED AS "FABRIC" UPTOP.
THIS WAS ORIGINALLY DESIGNED FOR OUR GUN MOD, BUT SINCE THEN, IT HAS BEEN VERY USEFUL.


 */

package net.fabridge.fabricmc.event;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.fabridge.fabricmc.network.ClientHelper;

import java.util.List;

/**
 * @Author = Fabric API, Better Combat, ASEStefan
 */
public interface ItemTooltipCallback {
    Event<ItemTooltipCallback> EVENT = new ClientHelper.TooltipEvent();

    void getTooltip(ItemStack stack, TooltipFlag context, List<Component> lines);

}
