package com.giantpotato.rings;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class RubyRing_Uncommon extends Ring{
    public static final int TIER = 3;
    public static String MODE = "Conduit Mode";
    public static final int DURABILITY = 1024;

    StatusEffectInstance conduit_effect = new StatusEffectInstance(
            StatusEffects.CONDUIT_POWER,
            0,
            0,//temporary
            false,
            false);

    public RubyRing_Uncommon(Settings settings) {
        super(settings.maxDamage(DURABILITY));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient() && isActive(stack)){
            PlayerEntity player = (PlayerEntity) entity;
            player.applyStatusEffect(conduit_effect);
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack stack = playerEntity.getStackInHand(hand);
        if(!world.isClient && playerEntity.isSneaking()){
            toggleMode(stack);
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }

    public boolean hasGlint(ItemStack stack) {
        return isActive(stack);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        boolean status = isActive(itemStack);
        String out = (status) ? "On" : "Off";
        tooltip.add(new TranslatableText("item.rings.ruby_ring_uncommon.tooltip.subtext").formatted(Formatting.BLUE));
        if(status){ tooltip.add(new TranslatableText("item.rings.ruby_ring_uncommon.tooltip.status", out).formatted(Formatting.GREEN)); }
        else{ tooltip.add(new TranslatableText("item.rings.ruby_ring_uncommon.tooltip.status", out).formatted(Formatting.RED)); }
    }

}
