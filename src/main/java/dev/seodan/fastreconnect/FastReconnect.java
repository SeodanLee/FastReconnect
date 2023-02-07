package dev.seodan.fastreconnect;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = FastReconnect.MODID, name = FastReconnect.NAME, version = FastReconnect.VERSION)
@SideOnly(Side.CLIENT)
public class FastReconnect {
    public static final String MODID = "fastreconnect";
    public static final String NAME = "FastReconnect";
    public static final String VERSION = "1.0";
    
    public static ServerData cachedInfo;

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }
}
