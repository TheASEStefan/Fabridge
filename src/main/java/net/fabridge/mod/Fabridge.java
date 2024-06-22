package net.fabridge.mod;

import com.mojang.logging.LogUtils;
import net.fabridge.fabricmc.example.ExamplePacket;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.fabridge.fabricmc.network.NetworkHandler;
import org.slf4j.Logger;


@Mod(Fabridge.MODID)
public class Fabridge {
    

    public static final String MODID = "fabridge";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Fabridge() {


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