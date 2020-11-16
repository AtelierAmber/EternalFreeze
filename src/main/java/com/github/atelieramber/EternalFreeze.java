package com.github.atelieramber;

import com.github.atelieramber.entities.renderers.SnowSwimmerRenderer;
import com.github.atelieramber.registry.EntityRegistry;
import com.github.atelieramber.registry.Registry;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppedEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(EternalFreeze.MODID)
public class EternalFreeze {
    public static final String MODID = "eternalfreeze";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    private static EternalFreeze instance;

    public static EternalFreeze getInstance() {
        return instance;
    }
    public EternalFreeze(){
        instance = this;

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Registry.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);
        modEventBus.addListener(this::clientSetup);


        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        forgeEventBus.addListener(this::removeFog);
        forgeEventBus.addListener(this::onServerStarting);

        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.SNOW_SWIMMER.get(), SnowSwimmerRenderer::new);
    }

    public void onServerStarting(FMLServerStartingEvent event) {

    }

    @SuppressWarnings("deprecation")
    public void removeFog(final EntityViewRenderEvent.FogDensity event) {
        Minecraft mc = Minecraft.getInstance();

        final float farPlane = mc.gameSettings.renderDistanceChunks * 16.0f;
        RenderSystem.fogStart(farPlane * 32.0f);
        RenderSystem.fogEnd(farPlane * 32.0f);
        event.setDensity(0.0f);
        //event.setCanceled(true);
    }
}
