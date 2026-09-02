package com.kazuskot.professionclasses;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kazuskot.professionclasses.network.SelectProfessionPacket;

@Mod(ProfessionClassesMod.MOD_ID)
public class ProfessionClassesMod {
    public static final String MOD_ID = "profession_classes";
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfessionClassesMod.class);
    
    public static net.neoforged.neoforge.network.simple.SimpleChannel CHANNEL;

    public ProfessionClassesMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::registerPayloads);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Profession Classes mod loaded!");
    }

    @OnlyIn(Dist.CLIENT)
    private void clientSetup(FMLClientSetupEvent event) {
        LOGGER.info("Client setup for Profession Classes");
    }

    private void registerPayloads(RegisterPayloadHandlerEvent event) {
        CHANNEL = net.neoforged.neoforge.network.simple.SimpleChannel.forVersion("1.0");
        final IPayloadRegistration register = event.registrar(MOD_ID);
        
        register.play(
            SelectProfessionPacket.ID,
            SelectProfessionPacket::new,
            handler -> handler
                .client((packet, context) -> packet.handle(context))
                .server((packet, context) -> packet.handle(context))
        );
    }
}
