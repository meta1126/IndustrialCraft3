package com.meta.IndustrialCraft3.datagen.client;

import com.meta.IndustrialCraft3.IndustrialCraft3;
import com.meta.IndustrialCraft3.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class IntroductionBlockStateProvider extends BlockStateProvider {
    public IntroductionBlockStateProvider(PackOutput output,  ExistingFileHelper exFileHelper) {
        super(output, IndustrialCraft3.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.RATERSITE_ORE);
        simpleBlockWithItem(ModBlocks.CASSTIERITE_ORE);
    }

    private void simpleBlockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(),cubeAll(block.get()));
    }
}
