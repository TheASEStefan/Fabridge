/*

FABRIC

THESE CLASSES ARE PROVIDED BY ASESTEFAN, AND THEY'RE NEEDED IN ORDER TO PORT UTILS FROM FABRIC TO FORGE.
YOU ARE ALLOWED TO MAKE COPIES OF THIS SOFTWARE, BUT ONLY THOSE WHO ARE MARKED AS "FABRIC" UPTOP.
THIS WAS ORIGINALLY DESIGNED FOR OUR GUN MOD, BUT SINCE THEN, IT HAS BEEN VERY USEFUL.


 */

package net.forgeapi.forgemc.event;

import net.minecraft.client.gui.GuiGraphics;
import net.forgeapi.forgemc.network.ClientHelper;

/**
 * @Author = Fabric API, Better Combat, ASEStefan
 */
public interface HudRenderCallback {
    Event<HudRenderCallback> EVENT = new ClientHelper.HudRenderEvent();

    void onHudRender(GuiGraphics context, float tickDelta);
}
