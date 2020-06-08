package com.rafaelsn.morefood.util;

import com.rafaelsn.morefood.Reference;
import com.rafaelsn.morefood.item.ItemEmerald;
import com.rafaelsn.morefood.item.ItemGarnet;
import com.rafaelsn.morefood.item.ItemRuby;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<Item>(ForgeRegistries.ITEMS, Reference.MODID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemRuby::new);
    public static final RegistryObject<Item> EMERALD = ITEMS.register("emerald", ItemEmerald::new);
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet", ItemGarnet::new);
}
