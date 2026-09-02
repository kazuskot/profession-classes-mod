package com.kazuskot.professionclasses.profession;

import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;

public class ProfessionCapability {
    private PlayerProfession playerProfession;

    public ProfessionCapability() {
        this.playerProfession = new PlayerProfession();
    }

    public PlayerProfession getProfession() {
        return playerProfession;
    }

    public void setProfession(Profession profession) {
        this.playerProfession.setProfession(profession);
    }

    public void saveData(CompoundTag tag) {
        CompoundTag profTag = new CompoundTag();
        playerProfession.saveToTag(profTag);
        tag.put("ProfessionData", profTag);
    }

    public void loadData(CompoundTag tag) {
        if (tag.contains("ProfessionData")) {
            playerProfession.loadFromTag(tag.getCompound("ProfessionData"));
        }
    }

    public void sync() {
        // Будет использоваться для синхронизации с клиентом
    }
}
