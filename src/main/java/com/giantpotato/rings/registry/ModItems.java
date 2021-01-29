package com.giantpotato.rings.registry;

import com.giantpotato.rings.*;
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

    //Gem Block Items
    public static final BlockItem RUBY_BLOCK = new BlockItem(ModBlocks.RUBY_BLOCK, new Item.Settings().group(Rings.advanced_group));
    public static final BlockItem PERIDOT_BLOCK = new BlockItem(ModBlocks.PERIDOT_BLOCK, new Item.Settings().group(Rings.advanced_group));
    public static final BlockItem AZURITE_BLOCK = new BlockItem(ModBlocks.AZURITE_BLOCK, new Item.Settings().group(Rings.advanced_group));
    public static final BlockItem ALEXANDRITE_BLOCK = new BlockItem(ModBlocks.ALEXANDRITE_BLOCK, new Item.Settings().group(Rings.advanced_group));

    //Rings
    public static final Item RING = new Item(new Item.Settings().group(Rings.advanced_group));

    //Ruby Rings
    public static final Item RUBY_RING = new RubyRing(new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item RUBY_RING_IMPROVED = new RubyRing_Improved(new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item RUBY_RING_UNCOMMON = new RubyRing_Uncommon(new Item.Settings().rarity(Rarity.RARE));
    public static final Item RUBY_RING_MYTHICAL = new RubyRing_Mythical(new Item.Settings().rarity(Rarity.RARE));
    public static final Item RUBY_RING_ARCANE = new RubyRing_Arcane(new Item.Settings().rarity(Rarity.EPIC).fireproof());

    //Peridot Rings
    public static final Item PERIDOT_RING = new PeridotRing(new Item.Settings().rarity(Rarity.UNCOMMON));

    //Azurite Rings
    public static final Item AZURITE_RING = new AzuriteRing(new Item.Settings().rarity(Rarity.UNCOMMON));

    public static void registerItems(){
        registerGems();
        registerOres();
		registerGemBlocks();
        registerRings();
    }

    private static void registerGemBlocks() {
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "peridot_block"), PERIDOT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "azurite_block"), AZURITE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "alexandrite_block"), ALEXANDRITE_BLOCK);
    }
    private static void registerOres() {
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "azurite_ore"), AZURITE_ORE);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "peridot_ore"), PERIDOT_ORE);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "alexandrite_ore"), ALEXANDRITE_ORE);
    }
    public static void registerGems() {
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "azurite"), AZURITE);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ruby"), RUBY);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "peridot"), PERIDOT);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "alexandrite"), ALEXANDRITE);
    }

    public static void registerRings(){
        registerBaseRings();
        registerRubyRings();
        registerPeridotRings();
        registerAzuriteRings();
    }

    private static void registerBaseRings() {
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ring"), RING);
    }

    public static void registerRubyRings(){
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ruby_ring"), RUBY_RING);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ruby_ring_improved"), RUBY_RING_IMPROVED);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ruby_ring_uncommon"), RUBY_RING_UNCOMMON);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ruby_ring_mythical"), RUBY_RING_MYTHICAL);
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "ruby_ring_arcane"), RUBY_RING_ARCANE);
	}

    public static void registerPeridotRings(){
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "peridot_ring"), PERIDOT_RING);

    }

    public static void registerAzuriteRings(){
        Registry.register(Registry.ITEM, new Identifier(Rings.MOD_ID, "azurite_ring"), AZURITE_RING);

    }
}