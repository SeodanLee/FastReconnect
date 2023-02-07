package dev.seodan.fastreconnect.mixin;

import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.multiplayer.ServerData;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GuiMultiplayer.class)
public interface MultiplayerScreenAccessor {
    @Invoker("connectToServer")
    public void invokeConnect(ServerData p_connectToServer_1_);
}
