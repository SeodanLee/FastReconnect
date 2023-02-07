package dev.seodan.fastreconnect.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.seodan.fastreconnect.FastReconnect;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.multiplayer.ServerData;

@Mixin(GuiMultiplayer.class)
public abstract class MultiplayerScreenMixin {
    @Inject(method = "connectToServer", at = @At("HEAD"))
    private void cacheServerInfo(ServerData p_connectToServer_1_, CallbackInfo info) {
        FastReconnect.cachedInfo = p_connectToServer_1_;
    }
}
