package com.kazuskot.professionclasses.network;

import net.minecraft.network.FriendlyByteBuf;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import com.kazuskot.professionclasses.profession.Profession;

public class SelectProfessionPacket {
    public static final String ID = "select_profession";
    private final Profession profession;

    public SelectProfessionPacket(Profession profession) {
        this.profession = profession;
    }

    public SelectProfessionPacket(FriendlyByteBuf buf) {
        this.profession = Profession.fromId(buf.readUtf());
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUtf(profession.getId());
    }

    public void handle(PlayPayloadContext context) {
        context.workHandler().submitAsync(() -> {
            var player = context.player();
            if (player != null) {
                // Обработка на сервере
            }
        });
    }

    public Profession getProfession() {
        return profession;
    }
}
