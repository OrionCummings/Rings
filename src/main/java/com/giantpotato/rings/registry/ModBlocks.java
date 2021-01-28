package com.giantpotato.rings.registry;

import com.giantpotato.rings.Rings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block RUBY_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(3.0f, 15.0f).sounds(BlockSoundGroup.STONE));
    public static final Block AZURITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(3.0f, 15.0f).sounds(BlockSoundGroup.STONE));
    public static final Block PERIDOT_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(3.0f, 15.0f).sounds(BlockSoundGroup.STONE));
    public static final Block ALEXANDRITE_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(3.0f, 15.0f).sounds(BlockSoundGroup.STONE));

    public static final Block RUBY_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(6.0f, 30.0f).sounds(BlockSoundGroup.METAL));
    public static final Block PERIDOT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(6.0f, 30.0f).sounds(BlockSoundGroup.METAL));
    public static final Block AZURITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(6.0f, 30.0f).sounds(BlockSoundGroup.METAL));
    public static final Block ALEXANDRITE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(6.0f, 30.0f).sounds(BlockSoundGroup.METAL));

    public static void RegisterBlocks(){
        registerOres();
        registerGemBlocks();
    }

    private static void registerGemBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Rings.MOD_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Rings.MOD_ID, "peridot_block"), PERIDOT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Rings.MOD_ID, "azurite_block"), AZURITE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Rings.MOD_ID, "alexandrite_block"), ALEXANDRITE_BLOCK);
    }
    public static void registerOres(){
        Registry.register(Registry.BLOCK, new Identifier(Rings.MOD_ID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Rings.MOD_ID, "azurite_ore"), AZURITE_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Rings.MOD_ID, "peridot_ore"), PERIDOT_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Rings.MOD_ID, "alexandrite_ore"), ALEXANDRITE_ORE);
    }

}
