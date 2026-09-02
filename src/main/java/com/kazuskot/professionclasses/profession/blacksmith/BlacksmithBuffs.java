package com.kazuskot.professionclasses.profession.blacksmith;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class BlacksmithBuffs {

    public static void applyBuffsForLevel(Player player, int level) {
        switch (level) {
            case 1:
                // Без баффов
                break;
            case 2:
                // Маленький бонус к силе при использовании инструментов
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0, true, false));
                break;
            case 3:
                // Ускорение майнинга
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0, true, false));
                break;
            case 4:
                // Ускорение + устойчивость к урону при работе с инструментами
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 1, true, false));
                player.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 20, 0, true, false));
                break;
            case 5:
                // Значительный бонус к силе
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 2, true, false));
                player.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 20, 0, true, false));
                break;
            case 6:
                // Мастерство
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 3, true, false));
                player.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 20, 1, true, false));
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 0, true, false));
                break;
            case 7:
                // Полное мастерство
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 4, true, false));
                player.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 20, 1, true, false));
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 1, true, false));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 0, true, false));
                break;
        }
    }

    public static void applyEnchantmentBonus(ItemStack stack, int level) {
        // Логика для добавления дополнительных эффектов к крафченым вещам
        // Будет расширено при интеграции с overgeraded модом
        
        if (level >= 5) {
            // На уровне 5+ добавляем небольшой шанс на добавление эффекта
            // stack.enchant(...); // Будет использоваться при полной интеграции
        }
    }
}
