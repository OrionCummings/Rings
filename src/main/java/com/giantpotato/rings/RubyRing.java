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

public class RubyRing extends CommonRing{

    StatusEffectInstance haste_effect = new StatusEffectInstance(
            StatusEffects.HASTE,
            0,
            2,//temporary
            false,
            false);

    public RubyRing(Settings settings) {
        super(settings, "Haste Mode");
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient() && isActive(stack)){
            PlayerEntity player = (PlayerEntity) entity;
            player.applyStatusEffect(haste_effect);
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
        tooltip.add(new TranslatableText("item.rings.ruby_ring.tooltip.subtext").formatted(Formatting.BLUE));
        tooltip.add(new TranslatableText("item.rings.ruby_ring.tooltip.status", status).formatted(Formatting.GREEN));
    }

}