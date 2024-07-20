package com.meta.IndustrialCraft3.worldgen;

import com.meta.IndustrialCraft3.IndustrialCraft3;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static net.minecraft.data.worldgen.placement.PlacementUtils.createKey;

public class ModOrePlacement {

    private static ResourceKey<PlacedFeature> createKey(String name) {

        return ResourceKey.create(Registries.PLACED_FEATURE,
                new ResourceLocation(IndustrialCraft3.MODID, name));
    }

    public static final ResourceKey<PlacedFeature> ORE_RATERSITE = createKey("ore_ratersite");
    public static final ResourceKey<PlacedFeature> ORE_CASSTIERTE = createKey("ore_casstierte");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures =
                context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(context, ORE_RATERSITE,
               configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RATERSITE_ORE_KEY),
               commonOrePlacement(50,HeightRangePlacement.uniform(VerticalAnchor.absolute(-70),
                       VerticalAnchor.absolute(100))));

        PlacementUtils.register(context, ORE_CASSTIERTE,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_CASSTIERTE_ORE_KEY),
        commonOrePlacement(120,HeightRangePlacement.uniform(VerticalAnchor.absolute(-50),
                VerticalAnchor.absolute(140))));
    }

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    public static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }
}
