package com.giantpotato.rings.registry;

import com.giantpotato.rings.AzuriteRing;
import com.giantpotato.rings.Rings;
import com.giantpotato.rings.RubyRing;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems{

    //Common Gems
    public static final Item AZURITE = new Item(new Item.Settings().group(Rings.advanced_group).rarity(Rarity.COMMON));
    public static final Item RUBY = new Item(new Item.Settings().group(Rings.advanced_group).rarity(Rarity.COMMON));
    public static final Item PERIDOT = new Item(new Item.Settings().group(Rings.advanced_group).rarity(Rarity.COMMON));

    //Rare Gems
    public static final Item ALEXANDRITE = new Item(new Item.Settings().group(Rings.advanced_group).rarity(Rarity.RARE));

    //Block Items
    public static final BlockItem RUBY_ORE = new BlockItem(ModBlocks.RUBY_ORE, new Item.Settings().group(Rings.advanced_group));
    public static final BlockItem AZURITE_ORE = new BlockItem(ModBlocks.AZURITE_ORE, new Item.Settings().group(Rings.advanced_group));
    public static final BlockItem PERIDOT_ORE = new BlockItem(ModBlocks.PERIDOT_ORE, new Item.Settings().group(Rings.advanced_group));
    public static final BlockItem ALEXANDRITE_ORE = new BlockItem(ModBlocks.ALEXANDRITE_ORE, new Item.Settings().group(Rings.advanced_group));

    //Common Rings
    public static final Item RING = new Item(new Item.Settings().group(Rings.advanced_group));


    //public static final Item RUBY_RING = new Item(new Item.Settings().group(Rings.advanced_group).rarity(Rarity.UNCOMMON).maxDamage(256));
    public static final Item RUBY_RING = new RubyRing(new Item.Settings());

    public static final Item PERIDOT_RING = new Item(new Item.Settings().group(Rings.advanced_group).rarity(Rarity.UNCOMMON).maxDamage(256));
    //public static final Item AZURITE_RING = new Item(new Item.Settings().group(Rings.advanced_group).rarity(Rarity.UNCOMMON).maxDamage(256));
    public static final Item AZURITE_RING = new AzuriteRing(new Item.Settings());

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

        //Common Ring Registration
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ring"), RING);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ruby_ring"), RUBY_RING);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "peridot_ring"), PERIDOT_RING);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "azurite_ring"), AZURITE_RING);
    }
}