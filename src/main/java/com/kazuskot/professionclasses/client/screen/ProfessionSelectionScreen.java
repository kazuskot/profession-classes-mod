package com.kazuskot.professionclasses.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.resources.ResourceLocation;
import com.kazuskot.professionclasses.ProfessionClassesMod;
import com.kazuskot.professionclasses.profession.Profession;

public class ProfessionSelectionScreen extends Screen {
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 40;
    private static final ResourceLocation TEXTURE = new ResourceLocation(ProfessionClassesMod.MOD_ID, "textures/gui/profession_select.png");

    private Profession selectedProfession = Profession.BLACKSMITH;

    public ProfessionSelectionScreen() {
        super(Component.literal("Выбор Профессии"));
    }

    @Override
    protected void init() {
        super.init();
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // Кнопки для выбора профессий
        int x = centerX - 200;
        int y = centerY - 100;

        for (Profession profession : Profession.values()) {
            this.addRenderableWidget(new ProfessionButton(
                x, y,
                BUTTON_WIDTH, BUTTON_HEIGHT,
                Component.literal(profession.getDisplayName()),
                (button) -> this.selectedProfession = profession
            ));
            x += BUTTON_WIDTH + 20;
            if (x > centerX + 200) {
                x = centerX - 200;
                y += BUTTON_HEIGHT + 20;
            }
        }

        // Кнопка подтверждения
        this.addRenderableWidget(new SelectProfessionButton(
            centerX - BUTTON_WIDTH / 2, centerY + 150,
            BUTTON_WIDTH, BUTTON_HEIGHT,
            Component.literal("Выбрать"),
            selectedProfession
        ));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(guiGraphics, pMouseX, pMouseY, pPartialTick);
        
        guiGraphics.drawCenteredString(
            this.font,
            Component.literal("Выберите профессию"),
            this.width / 2,
            20,
            0xFFFFFF
        );

        guiGraphics.drawCenteredString(
            this.font,
            Component.literal("Выбрана: " + selectedProfession.getDisplayName()),
            this.width / 2,
            this.height - 30,
            0x00FF00
        );

        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }
}
