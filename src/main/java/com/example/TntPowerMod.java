package com.tntpower;

import net.fabricmc.api.ModInitializer;

public class TntPowerMod implements ModInitializer {

    public static final String MOD_ID = "tntpower";

    @Override
    public void onInitialize() {
        TntPowerCommand.register();
    }
}
