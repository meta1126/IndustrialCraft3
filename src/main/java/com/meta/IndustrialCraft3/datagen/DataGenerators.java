package com.meta.IndustrialCraft3.datagen;

import com.meta.IndustrialCraft3.IndustrialCraft3;
import com.meta.IndustrialCraft3.datagen.client.IntroductionBlockStateProvider;
import com.meta.IndustrialCraft3.datagen.server.IntroductionRecieProvider;
import com.meta.IndustrialCraft3.datagen.server.ModWorldGenProvider;
import com.meta.IndustrialCraft3.datagen.server.loot.IntroductionBlockTagsProvider;
import com.meta.IndustrialCraft3.datagen.server.loot.IntroductionLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = IndustrialCraft3.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        generator.addProvider(event.includeServer(), new IntroductionRecieProvider(packOutput));
        generator.addProvider(event.includeServer(), new IntroductionBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeServer(), IntroductionLootTables.create(packOutput));
        generator.addProvider(event.includeServer(), new IntroductionBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
    }

}
