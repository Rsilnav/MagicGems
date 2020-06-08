package com.rafaelsn.buffgems;

import com.rafaelsn.buffgems.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Reference {
    public static final String MODID = "buffgems";
    public static final ItemGroup TAB = new ItemGroup("buffgemslabel") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RUBY.get());
        }
    };
}
