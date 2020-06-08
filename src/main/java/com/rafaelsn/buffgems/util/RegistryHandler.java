package com.rafaelsn.buffgems.util;

import com.rafaelsn.buffgems.Reference;
import com.rafaelsn.buffgems.blocks.BlockRubyOre;
import com.rafaelsn.buffgems.container.ExampleChestContainer;
import com.rafaelsn.buffgems.item.ItemEmerald;
import com.rafaelsn.buffgems.item.ItemGarnet;
import com.rafaelsn.buffgems.item.ItemRuby;
import com.rafaelsn.buffgems.item.ItemRubyOre;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.BrewingStandContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<Item>(ForgeRegistries.ITEMS, Reference.MODID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<Block>(ForgeRegistries.BLOCKS, Reference.MODID);
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(
            ForgeRegistries.CONTAINERS, Reference.MODID);


    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    // Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemRuby::new);
    public static final RegistryObject<Item> EMERALD = ITEMS.register("emerald", ItemEmerald::new);
    public static final RegistryObject<Item> GARNET = ITEMS.register("garnet", ItemGarnet::new);

    // Blocks
    public static final RegistryObject<Block> RUBY_ORE_BLOCK = BLOCKS.register("ruby_ore_block", BlockRubyOre::new);
    public static final RegistryObject<Item> RUBY_ORE = ITEMS.register("ruby_ore", ItemRubyOre::new);



    // Container

    public static final RegistryObject<ContainerType<ExampleChestContainer>> EXAMPLE_CHEST = CONTAINER_TYPES
            .register("example_chest", () -> IForgeContainerType.create(ExampleChestContainer::new));
}
