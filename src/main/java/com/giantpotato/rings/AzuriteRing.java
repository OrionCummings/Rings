package com.giantpotato.rings;


import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class AzuriteRing extends CommonRing {
    public AzuriteRing(Settings settings) {
        super(settings);
        effect = new RingsSpeedEffect();
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.rings.azurite_ring.tooltip"));
    }

    public String toString(){return "Azurite Ring";}
}
