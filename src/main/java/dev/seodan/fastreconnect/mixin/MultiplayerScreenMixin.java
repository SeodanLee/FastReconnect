package dev.seodan.fastreconnect.mixin;

import dev.seodan.fastreconnect.FastReconnect;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.network.ServerInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MultiplayerScreen.class)
public abstract class MultiplayerScreenMixin {
    @Inject(method = "connect(Lnet/minecraft/client/network/ServerInfo;)V", at = @At("HEAD"))
    private void cacheServerInfo(ServerInfo entry, CallbackInfo info) {
        FastReconnect.cachedInfo = entry;
    }
}
