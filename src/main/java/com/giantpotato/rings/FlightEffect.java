package com.giantpotato.rings;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.server.network.ServerPlayerEntity;

public class FlightEffect extends StatusEffect {

    public FlightEffect() {
            super(StatusEffectType.BENEFICIAL,0x34DBEB);
        }
/*
        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true;
        }

        @Override
        public void applyUpdateEffect(LivingEntity entity, int amplifier) {
            if (entity instanceof ServerPlayerEntity) {
                ServerPlayerEntity player = (ServerPlayerEntity) entity;
                giveFlyingPowers(player);
            }
        }

        @Override
        public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
            if (entity instanceof ServerPlayerEntity) {
                ServerPlayerEntity player = (ServerPlayerEntity) entity;
                removeFlyingPowers(player);
            }
        }

        public static void giveFlyingPowers(ServerPlayerEntity player) {
            PlayerAbilities currentAbilities = player.getAbilities();
            currentAbilities.allowFlying = true;
            player.sendAbilitiesUpdate();
        }

        public static void removeFlyingPowers(ServerPlayerEntity player) {
            PlayerAbilities currentAbilities = player.getAbilities();
            currentAbilities.allowFlying = false;
            currentAbilities.flying = false;
            player.sendAbilitiesUpdate();
        }
    }
    */
}
