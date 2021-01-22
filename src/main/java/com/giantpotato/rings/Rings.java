package com.giantpotato.rings;

import com.giantpotato.rings.registry.ModBlocks;
import com.giantpotato.rings.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

//Rings: Ring, Ring of Swiftness, Ring of Haste, ...
//Gems: Ruby, Peridot, Azurite, Alexandrite
//Ores: Ruby Ore, Azurite Ore, Peridot Ore, Alexandrite Ore
//Blocks: Ruby Block, Azurite Block, Peridot Block, Alexandrite Block

public class Rings implements ModInitializer {

    public static final String MOD_ID = "rings";

    public static final ItemGroup advanced_group = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "advanced_group"))
            .icon(() -> new ItemStack(ModItems.RING))
            .appendItems(stacks -> {
                //Items appear in this order in the creative tab "Rings"
                stacks.add(new ItemStack(ModItems.RING));
                stacks.add(new ItemStack(ModBlocks.RUBY_ORE));
                stacks.add(new ItemStack(ModBlocks.AZURITE_ORE));
                stacks.add(new ItemStack(ModItems.RUBY));
                stacks.add(new ItemStack(ModItems.AZURITE));
            }).build();

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.RegisterBlocks();
    }
}
