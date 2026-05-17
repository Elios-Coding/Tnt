package com.tntpower;

public class TntPowerManager {

    private static float multiplier = 1.0F;

    public static float getMultiplier() {
        return multiplier;
    }

    public static void setMultiplier(float value) {
        multiplier = value;
    }

    public static float applyMultiplier(float vanillaPower) {
        return vanillaPower * multiplier;
    }
}
