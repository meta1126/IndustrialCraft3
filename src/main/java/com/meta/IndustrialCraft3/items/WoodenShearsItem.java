package com.meta.IndustrialCraft3.items;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.block.state.BlockState;

public class WoodenShearsItem extends ShearsItem{
    
    public WoodenShearsItem(Properties properties) {
	super(properties);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
	return 2;
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
	return super.isCorrectToolForDrops(stack, state);
    }
 }
