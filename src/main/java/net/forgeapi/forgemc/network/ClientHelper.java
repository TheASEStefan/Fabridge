/*

FABRIC

THESE CLASSES ARE PROVIDED BY ASESTEFAN, AND THEY'RE NEEDED IN ORDER TO PORT UTILS FROM FABRIC TO FORGE.
YOU ARE ALLOWED TO MAKE COPIES OF THIS SOFTWARE, BUT ONLY THOSE WHO ARE MARKED AS "FABRIC" UPTOP.
THIS WAS ORIGINALLY DESIGNED FOR OUR GUN MOD, BUT SINCE THEN, IT HAS BEEN VERY USEFUL.


 */

package net.forgeapi.forgemc.network;

import net.forgeapi.forgemc.event.Event;
import net.forgeapi.forgemc.event.HudRenderCallback;
import net.forgeapi.forgemc.event.ItemTooltipCallback;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author = Fabric API, Better Combat, ASEStefan
 */
public class ClientHelper {
    public static List<ItemTooltipCallback> onTooltip = new ArrayList<>();
    public static List<HudRenderCallback> onRenderHud = new ArrayList<>();

    public static class TooltipEvent extends Event<ItemTooltipCallback> {
        public void register(ItemTooltipCallback listener) {
            onTooltip.add(listener);
        }
    }

    public static class HudRenderEvent extends Event<HudRenderCallback> {
        public void register(HudRenderCallback listener) {
            onRenderHud.add(listener);
        }
    }
}
