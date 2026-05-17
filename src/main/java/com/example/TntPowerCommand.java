package com.tntpower;

import com.mojang.brigadier.arguments.FloatArgumentType;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

public class TntPowerCommand {

    public static void register() {

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {

            dispatcher.register(
                    CommandManager.literal("tntpower")
                            .requires(source -> source.hasPermissionLevel(2))
                            .then(CommandManager.argument(
                                            "multiplier",
                                            FloatArgumentType.floatArg(0.0F)
                                    )
                                    .executes(context -> {

                                        float multiplier = FloatArgumentType.getFloat(
                                                context,
                                                "multiplier"
                                        );

                                        TntPowerManager.setMultiplier(multiplier);

                                        context.getSource().sendFeedback(
                                                () -> Text.literal(
                                                        "Global TNT multiplier set to " + multiplier
                                                ),
                                                true
                                        );

                                        return 1;
                                    })
                            )
            );
        });
    }
}
