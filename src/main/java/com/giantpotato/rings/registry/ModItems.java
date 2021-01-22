package com.giantpotato.rings.registry;

import com.giantpotato.rings.Rings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems{

    //Items
    public static final Item RING = new Item(new Item.Settings().group(Rings.advanced_group));
    public static final Item AZURITE = new Item(new Item.Settings().group(Rings.advanced_group));
    public static final Item RUBY = new Item(new Item.Settings().group(Rings.advanced_group));

    //Block Items
    public static final BlockItem RUBY_ORE = new BlockItem(ModBlocks.RUBY_ORE, new Item.Settings().group(Rings.advanced_group));
    public static final BlockItem AZURITE_ORE = new BlockItem(ModBlocks.AZURITE_ORE, new Item.Settings().group(Rings.advanced_group));

    public static void registerItems(){
        //Item Registration
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ring"), RING);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "azurite"), AZURITE);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ruby"), RUBY);

        //Block Item Registration
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "azurite_ore"), AZURITE_ORE);
    }
}