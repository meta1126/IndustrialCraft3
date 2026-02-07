package com.meta.IndustrialCraft3.items;

import com.meta.IndustrialCraft3.IndustrialCraft3;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, IndustrialCraft3.MODID);

    public static final RegistryObject<Item> RAWALUMINIUM = ITEMS.register("rawaluminium",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAWCASSTIERTE = ITEMS.register("rawcasstierte",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALUMINIUMINGOT = ITEMS.register("aluminiumingot",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CASSTIERITEINGOT = ITEMS.register("casstieriteinogot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STEELPLATE = ITEMS.register("steelplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TWICECOMPRESSSTEELPLATE = ITEMS.register("twicecompresssteelplate",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STEELINGOT = ITEMS.register("steelingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WOODEN_SHEARS = ITEMS.register("wooden_shears", () -> new WoodenShearsItem(new Item.Properties()
															  .durability(2)));
    
    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }
}
