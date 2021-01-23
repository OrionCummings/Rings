package com.giantpotato.rings;

import com.giantpotato.rings.registry.ModItems;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import javax.tools.Tool;

public class CommonRing extends Item {

    //Common rings all have these attributes
    public static final int durability = 256;
    public static final Rarity rarity = Rarity.UNCOMMON;
    public static ItemGroup group = Rings.advanced_group;
    public static StatusEffect effect;

    public CommonRing(Settings settings) {
        super(settings.group(group).rarity(rarity).maxDamage(durability));
    }

    ///*
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if(playerEntity.isSprinting() &&
                playerEntity.isHolding(ModItems.AZURITE_RING)){
            StatusEffectInstance speed_effect = new StatusEffectInstance(
                    StatusEffects.SPEED,
                    10,
                    1,
                    false,
                    false);
            playerEntity.applyStatusEffect(speed_effect);
        }
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
     //*/


}