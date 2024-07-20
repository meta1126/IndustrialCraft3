package com.meta.IndustrialCraft3.datagen.server.loot;

import com.meta.IndustrialCraft3.block.ModBlocks;
import com.meta.IndustrialCraft3.items.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class IntroductionBlockLootTables extends BlockLootSubProvider {
    protected IntroductionBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.add(ModBlocks.RATERSITE_ORE.get(),
                block -> this.createOreDrop(block, ModItems.RAWALUMINIUM.get()));

        this.add(ModBlocks.CASSTIERITE_ORE.get(),
                block -> this.createOreDrop(block, ModItems.RAWCASSTIERTE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
