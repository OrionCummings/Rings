package com.giantpotato.rings;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class RubyRing_Arcane extends Ring{
    public static final int TIER = 5;
    public static String MODE = "Health Boost Mode";
    public static final int DURABILITY = 8192;
    public static final int num_health_bars = 1;

    public static final int saturation_duration_in_seconds = 10;
    public static float cooldown = 0.0f;
    public static float cooldown_percentage = 1.0f;
    public static long time = 0;

    StatusEffectInstance health_boost_effect = new StatusEffectInstance(
            StatusEffects.HEALTH_BOOST,
            300,
            4 * num_health_bars,
            false,
            false);

    StatusEffectInstance instant_health_effect = new StatusEffectInstance(
            StatusEffects.INSTANT_HEALTH,
            1,
            4,//temporary
            false,
            false);

    StatusEffectInstance absorbtion_effect = new StatusEffectInstance(
            StatusEffects.ABSORPTION,
            300 * (saturation_duration_in_seconds / 4),
            0,
            false,
            false);

    public RubyRing_Arcane(Settings settings) {
        super(settings.maxDamage(DURABILITY));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        time = world.getTime();
        if(!world.isClient() && isActive(stack)){
            PlayerEntity player = (PlayerEntity) entity;
            player.applyStatusEffect(absorbtion_effect);
            player.getItemCooldownManager().set(this, 20 * saturation_duration_in_seconds);
            toggleMode(stack);
        }
        cooldown = ((PlayerEntity)entity).getItemCooldownManager().getCooldownProgress(stack.getItem(), 0.0001f);
        cooldown_percentage = Math.round((1 - cooldown) * 100);
        System.out.println("CD: " + cooldown);
        System.out.println("CDP: " + cooldown_percentage);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack stack = playerEntity.getStackInHand(hand);
        if(!world.isClient && playerEntity.isSneaking() && cooldown <= 0){
            toggleMode(stack);
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }

    public boolean hasGlint(ItemStack stack) {
        return isActive(stack);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        boolean status = (cooldown <= 0) ? true : false; //isActive(itemStack);
        String out = (status) ? "Charged " : "Recharging ";
        tooltip.add(new TranslatableText("item.rings.ruby_ring_arcane.tooltip.subtext").formatted(Formatting.BLUE));
        if(status){ tooltip.add(new TranslatableText("item.rings.ruby_ring_arcane.tooltip.status", out, cooldown_percentage).formatted(Formatting.GREEN)); }
        else{ tooltip.add(new TranslatableText("item.rings.ruby_ring_arcane.tooltip.status", out, cooldown_percentage).formatted(Formatting.RED)); }
    }

}
