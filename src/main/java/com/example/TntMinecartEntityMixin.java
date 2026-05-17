package com.tntpower.mixin;

import com.tntpower.TntPowerManager;

import net.minecraft.entity.vehicle.TntMinecartEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(TntMinecartEntity.class)
public class TntMinecartEntityMixin {

    @ModifyArg(
            method = "explode(D)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;createExplosion(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/world/World$ExplosionSourceType;)V"
            ),
            index = 4
    )
    private float modifyMinecartTntExplosionPower(float power) {
        return TntPowerManager.applyMultiplier(power);
    }
}
