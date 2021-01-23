package com.giantpotato.rings;

import com.giantpotato.rings.registry.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class RingsSpeedEffect extends StatusEffect {
    public RingsSpeedEffect(){
        super(StatusEffectType.BENEFICIAL, 0x33EE55);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    // This method is called when it applies the status effect. We implement custom functionality here.
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            if(((PlayerEntity) entity).isSprinting() &&
                    ((PlayerEntity) entity).isHolding(ModItems.AZURITE_RING)){
                StatusEffectInstance speed_effect = new StatusEffectInstance(StatusEffects.SPEED, 0, 1 << amplifier, false, false);
                ((PlayerEntity) entity).applyStatusEffect(speed_effect);
            }
        }
    }
}
