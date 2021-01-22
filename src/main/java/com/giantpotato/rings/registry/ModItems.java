package com.giantpotato.rings.registry;

import com.giantpotato.rings.Rings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems{

    //Gems
    public static final Item AZURITE = new Item(new Item.Settings().group(Rings.advanced_group));
    public static final Item RUBY = new Item(new Item.Settings().group(Rings.advanced_group));
    public static final Item PERIDOT = new Item(new Item.Settings().group(Rings.advanced_group));
    public static final Item ALEXANDRITE = new Item(new Item.Settings().group(Rings.advanced_group));

    //Block Items
    public static final BlockItem RUBY_ORE = new BlockItem(ModBlocks.RUBY_ORE, new Item.Settings().group(Rings.advanced_group));
    public static final BlockItem AZURITE_ORE = new BlockItem(ModBlocks.AZURITE_ORE, new Item.Settings().group(Rings.advanced_group));
    public static final BlockItem PERIDOT_ORE = new BlockItem(ModBlocks.PERIDOT_ORE, new Item.Settings().group(Rings.advanced_group));
    public static final BlockItem ALEXANDRITE_ORE = new BlockItem(ModBlocks.ALEXANDRITE_ORE, new Item.Settings().group(Rings.advanced_group));

    //Rings
    public static final Item RING = new Item(new Item.Settings().group(Rings.advanced_group));

    public static void registerItems(){
        //Gem Registration
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "azurite"), AZURITE);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ruby"), RUBY);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "peridot"), PERIDOT);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "alexandrite"), ALEXANDRITE);

        //Block Item Registration
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "azurite_ore"), AZURITE_ORE);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "peridot_ore"), PERIDOT_ORE);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "alexandrite_ore"), ALEXANDRITE_ORE);

        //Ring Registration
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ring"), RING);
    }
}