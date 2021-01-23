package com.giantpotato.rings;

import com.giantpotato.rings.registry.ModBlocks;
import com.giantpotato.rings.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

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
                stacks.add(new ItemStack(ModBlocks.PERIDOT_ORE));
                stacks.add(new ItemStack(ModBlocks.AZURITE_ORE));
                stacks.add(new ItemStack(ModBlocks.ALEXANDRITE_ORE));
                stacks.add(new ItemStack(ModItems.RUBY));
                stacks.add(new ItemStack(ModItems.PERIDOT));
                stacks.add(new ItemStack(ModItems.AZURITE));
                stacks.add(new ItemStack(ModItems.ALEXANDRITE));
            }).build();

    //Ore Generator Values
    public static GemOre commonGemOre = new GemOre(64, 0, 4, 3);
    public static GemOre rareGemOre = new GemOre(20, 0, 3, 1);

    //Common Gems
    private static ConfiguredFeature<?, ?> ORE_RUBY= Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.RUBY_ORE.getDefaultState(), commonGemOre.getVeinSize())).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, commonGemOre.getMinY(), commonGemOre.getMaxY()))).spreadHorizontally().repeat(commonGemOre.getVeinsPerChunk());
    private static ConfiguredFeature<?, ?> ORE_PERIDOT= Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.PERIDOT_ORE.getDefaultState(), commonGemOre.getVeinSize())).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, commonGemOre.getMinY(), commonGemOre.getMaxY()))).spreadHorizontally().repeat(commonGemOre.getVeinsPerChunk());
    private static ConfiguredFeature<?, ?> ORE_AZURITE= Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.AZURITE_ORE.getDefaultState(), commonGemOre.getVeinSize())).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, commonGemOre.getMinY(), commonGemOre.getMaxY()))).spreadHorizontally().repeat(commonGemOre.getVeinsPerChunk());

    //Rare Gems
    private static ConfiguredFeature<?, ?> ORE_ALEXANDRITE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.ALEXANDRITE_ORE.getDefaultState(), rareGemOre.getVeinSize())).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, rareGemOre.getMinY(), rareGemOre.getMaxY()))).spreadHorizontally().repeat(rareGemOre.getVeinsPerChunk());

    public static void generateOres(){
        //Common Gems
        //Ruby Ore
        RegistryKey<ConfiguredFeature<?, ?>> oreRuby = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("rings", "ruby_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreRuby.getValue(), ORE_RUBY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreRuby);

        //Peridot Ore
        RegistryKey<ConfiguredFeature<?, ?>> orePeridot = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("rings", "peridot_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, orePeridot.getValue(), ORE_PERIDOT);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, orePeridot);

        //Azurite Ore
        RegistryKey<ConfiguredFeature<?, ?>> oreAzurite = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("rings", "azurite_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreAzurite.getValue(), ORE_AZURITE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreAzurite);

        //Rare Gems
        //Alexandrite Ore
        RegistryKey<ConfiguredFeature<?, ?>> oreAlexandrite = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("rings", "alexandrite_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreAlexandrite.getValue(), ORE_ALEXANDRITE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreAlexandrite);
    }

    public static final StatusEffect EXP = new ExpStatusEffect();

    public static void registerStatusEffects(){
        Registry.register(Registry.STATUS_EFFECT, new Identifier("rings", "exp"), EXP);
    }

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.RegisterBlocks();
        registerStatusEffects();
        generateOres();
    }
}
