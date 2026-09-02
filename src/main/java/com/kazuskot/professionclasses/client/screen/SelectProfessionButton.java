package com.kazuskot.professionclasses.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import com.kazuskot.professionclasses.profession.Profession;
import com.kazuskot.professionclasses.network.SelectProfessionPacket;
import com.kazuskot.professionclasses.ProfessionClassesMod;

public class SelectProfessionButton extends Button {
    private final Profession profession;

    public SelectProfessionButton(int x, int y, int width, int height, Component message, Profession profession) {
        super(x, y, width, height, message, button -> {
            // Отправляем пакет на сервер
            ProfessionClassesMod.CHANNEL.sendToServer(new SelectProfessionPacket(profession));
        }, DEFAULT_NARRATION);
        this.profession = profession;
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        int color = this.isHovered ? 0xFF00AA00 : 0xFF00FF00;
        guiGraphics.fill(this.getX(), this.getY(), this.getX() + this.width, this.getY() + this.height, color);
        
        guiGraphics.drawCenteredString(
            this.getFont(),
            this.getMessage(),
            this.getX() + this.width / 2,
            this.getY() + (this.height - 8) / 2,
            0x000000
        );
    }
}
