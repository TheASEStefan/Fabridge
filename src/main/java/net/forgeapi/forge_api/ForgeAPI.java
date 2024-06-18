package net.forgeapi.forge_api;

import com.mojang.logging.LogUtils;
import net.forgeapi.forgemc.example.ExamplePacket;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.forgeapi.forgemc.network.NetworkHandler;
import org.slf4j.Logger;


@Mod(ForgeAPI.MODID)
public class ForgeAPI {
    

    public static final String MODID = "forge_api";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ForgeAPI() {


        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext context = ModLoadingContext.get();
        MinecraftForge.EVENT_BUS.register(this);

        new ExamplePacket().onInitialize(); // Example

        NetworkHandler.registerMessages(); // -> We need to call this so the INSTANCE isn't null when we load into minecraft.

        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(this::commonSetup);




    }



    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();


        }
    }

}