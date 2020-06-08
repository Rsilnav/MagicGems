package com.rafaelsn.buffgems.item;

import com.rafaelsn.buffgems.Reference;
import com.rafaelsn.buffgems.util.RegistryHandler;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ItemRubyOre extends BlockItem {
    public ItemRubyOre() {
        super(RegistryHandler.RUBY_ORE_BLOCK.get(), new Item.Properties().group(Reference.TAB));
    }
}
