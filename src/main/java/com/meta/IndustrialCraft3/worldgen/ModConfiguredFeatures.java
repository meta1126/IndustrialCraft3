package com.meta.IndustrialCraft3.worldgen;

import com.meta.IndustrialCraft3.IndustrialCraft3;
import com.meta.IndustrialCraft3.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RATERSITE_ORE_KEY = registerKey("ratersite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CASSTIERTE_ORE_KEY = registerKey("casstierte_ore");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneRepaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacebles = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldRatersiteOres = List.of(OreConfiguration.target(stoneRepaceable,
                ModBlocks.RATERSITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldCasstierteOres = List.of(OreConfiguration.target(stoneRepaceable,
                ModBlocks.CASSTIERITE_ORE.get().defaultBlockState()));

        register(context,OVERWORLD_RATERSITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRatersiteOres, 9));
        register(context,OVERWORLD_CASSTIERTE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldCasstierteOres, 15));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialCraft3.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
