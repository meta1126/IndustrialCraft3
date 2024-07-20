package com.meta.IndustrialCraft3.datagen.server;

import com.meta.IndustrialCraft3.IndustrialCraft3;
import com.meta.IndustrialCraft3.worldgen.ModBiomeModfiers;
import com.meta.IndustrialCraft3.worldgen.ModConfiguredFeatures;
import com.meta.IndustrialCraft3.worldgen.ModOrePlacement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public  static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModfiers::bootstrap)
            .add(Registries.PLACED_FEATURE, ModOrePlacement::bootstrap);
    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER , Set.of(IndustrialCraft3.MODID));
    }
}
