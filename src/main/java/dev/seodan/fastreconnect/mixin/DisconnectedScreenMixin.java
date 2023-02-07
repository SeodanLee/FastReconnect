package dev.seodan.fastreconnect.mixin;

import com.google.common.collect.Lists;
import dev.seodan.fastreconnect.FastReconnect;
import net.minecraft.client.gui.screen.DisconnectedScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(DisconnectedScreen.class)
public abstract class DisconnectedScreenMixin extends Screen {
    @Shadow
    private int reasonHeight;

    @Shadow
    @Final
    private Screen parent;

    @Inject(method = "init", at = @At("RETURN"))
    private void initReconnectButton(CallbackInfo info) {
        this.buttons.add(new ButtonWidget(1, this.width / 2 - 100, this.height / 2 + this.reasonHeight / 2 + this.textRenderer.fontHeight + 24, "Reconnect"));
    }

    @Inject(method = "buttonClicked", at = @At("RETURN"))
    private void onClick(ButtonWidget button, CallbackInfo info) {
        if (button.id == 1) {
            ((MultiplayerScreenAccessor) parent).invokeConnect(FastReconnect.cachedInfo);
        }
    }

    @Inject(method = "keyPressed", at = @At("RETURN"))
    private void onKeyPressed(char id, int code, CallbackInfo info) {
        if (code == 1) {
            this.client.setScreen(this.parent);
        }
    }
}
