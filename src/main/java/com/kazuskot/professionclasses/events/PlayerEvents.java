package com.kazuskot.professionclasses.events;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import com.kazuskot.professionclasses.ProfessionClassesMod;
import com.kazuskot.professionclasses.profession.ProfessionCapability;

@Mod.EventBusSubscriber(modid = ProfessionClassesMod.MOD_ID)
public class PlayerEvents {

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        
        // Инициализируем профессию игрока при входе
        if (!player.level().isClientSide) {
            ProfessionCapability capability = getProfessionCapability(player);
            if (capability == null) {
                capability = new ProfessionCapability();
                setProfessionCapability(player, capability);
            }
            
            // Открываем экран выбора профессии, если это первый вход
            CompoundTag tag = player.getPersistentData();
            if (!tag.contains("ProfessionSelected")) {
                tag.putBoolean("ProfessionSelected", true);
                // Здесь будет логика открытия UI экрана
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        Player player = event.getEntity();
        // Сохраняем данные профессии при выходе
        saveProfessionData(player);
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        Player original = event.getOriginal();
        Player clone = event.getEntity();
        
        if (!clone.level().isClientSide) {
            ProfessionCapability originalCap = getProfessionCapability(original);
            if (originalCap != null) {
                ProfessionCapability cloneCap = getProfessionCapability(clone);
                if (cloneCap == null) {
                    cloneCap = new ProfessionCapability();
                    setProfessionCapability(clone, cloneCap);
                }
                
                CompoundTag tag = new CompoundTag();
                originalCap.saveData(tag);
                cloneCap.loadData(tag);
            }
        }
    }

    private static ProfessionCapability getProfessionCapability(Player player) {
        // Будет использоваться система Capabilities NeoForge
        return null; // Placeholder
    }

    private static void setProfessionCapability(Player player, ProfessionCapability capability) {
        // Будет использоваться система Capabilities NeoForge
    }

    private static void saveProfessionData(Player player) {
        // Сохранение данных профессии
    }
}
