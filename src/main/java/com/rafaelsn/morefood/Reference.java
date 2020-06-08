package com.rafaelsn.morefood;

import com.rafaelsn.morefood.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Reference {
    public static final String MODID = "morefood";
    public static final ItemGroup TAB = new ItemGroup("morefoodlabel") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.RUBY.get());
        }
    };
}
