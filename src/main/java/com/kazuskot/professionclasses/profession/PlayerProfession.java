package com.kazuskot.professionclasses.profession;

import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;

public class PlayerProfession {
    private Profession profession;
    private int level;
    private int experience;
    private int experienceNeeded;
    private String subclass;

    public PlayerProfession() {
        this.profession = Profession.BLACKSMITH;
        this.level = 1;
        this.experience = 0;
        this.experienceNeeded = 100;
        this.subclass = "";
    }

    public PlayerProfession(Profession profession) {
        this.profession = profession;
        this.level = 1;
        this.experience = 0;
        this.experienceNeeded = 100;
        this.subclass = "";
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
        this.level = 1;
        this.experience = 0;
        this.experienceNeeded = 100;
        this.subclass = "";
    }

    public Profession getProfession() {
        return profession;
    }

    public int getLevel() {
        return level;
    }

    public void addExperience(int exp) {
        this.experience += exp;
        if (this.experience >= this.experienceNeeded && this.level < 7) {
            levelUp();
        }
    }

    private void levelUp() {
        this.level++;
        this.experience = 0;
        this.experienceNeeded = (int) (this.experienceNeeded * 1.5);
    }

    public int getExperience() {
        return experience;
    }

    public int getExperienceNeeded() {
        return experienceNeeded;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getSubclass() {
        return subclass;
    }

    public void saveToTag(CompoundTag tag) {
        tag.putString("Profession", profession.getId());
        tag.putInt("Level", level);
        tag.putInt("Experience", experience);
        tag.putInt("ExperienceNeeded", experienceNeeded);
        tag.putString("Subclass", subclass);
    }

    public void loadFromTag(CompoundTag tag) {
        if (tag.contains("Profession")) {
            this.profession = Profession.fromId(tag.getString("Profession"));
        }
        if (tag.contains("Level")) {
            this.level = tag.getInt("Level");
        }
        if (tag.contains("Experience")) {
            this.experience = tag.getInt("Experience");
        }
        if (tag.contains("ExperienceNeeded")) {
            this.experienceNeeded = tag.getInt("ExperienceNeeded");
        }
        if (tag.contains("Subclass")) {
            this.subclass = tag.getString("Subclass");
        }
    }
}
