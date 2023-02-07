package dev.seodan.fastreconnect.mixin;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.seodan.fastreconnect.FastReconnect;

@Mixin(GuiDisconnected.class)
public abstract class DisconnectedScreenMixin extends GuiScreen {
    @Shadow
    private int field_175353_i;

    @Shadow
    @Final
    private GuiScreen parentScreen;

    @Inject(method = "initGui", at = @At("RETURN"))
    private void initReconnectButton(CallbackInfo info) {
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 2 + this.field_175353_i / 2 + this.fontRendererObj.FONT_HEIGHT + 24, "Reconnect"));
    }

    @Inject(method = "actionPerformed", at = @At("RETURN"))
    private void onClick(GuiButton p_actionPerformed_1_, CallbackInfo info) {
        if (p_actionPerformed_1_.id == 1) {
            ((MultiplayerScreenAccessor)parentScreen).invokeConnect(FastReconnect.cachedInfo);
        }
    }

    @Inject(method = "keyTyped", at = @At("RETURN"))
    private void onKeyPressed(char p_keyTyped_1_, int p_keyTyped_2_, CallbackInfo info) {
        if (p_keyTyped_2_ == 1) {
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }
}
