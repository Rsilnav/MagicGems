package com.rafaelsn.buffgems.container;

import com.rafaelsn.buffgems.util.RegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import javax.annotation.Nullable;
import java.util.Objects;

public class ExampleChestContainer extends Container {
    protected ExampleChestContainer(@Nullable ContainerType<?> type, int id) {
        super(type, id);
    }


//    public ExampleChestContainer(final int windowId, final PlayerInventory playerInventory,
//                                 final ExampleChestTileEntity tileEntity) {
//        super(ModContainerTypes.EXAMPLE_CHEST.get(), windowId);
//        this.tileEntity = tileEntity;
//        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());
//
//        // Main Inventory
//        int startX = 8;
//        int startY = 18;
//        int slotSizePlus2 = 18;
//        for (int row = 0; row < 4; ++row) {
//            for (int column = 0; column < 9; ++column) {
//                this.addSlot(new Slot(tileEntity, (row * 9) + column, startX + (column * slotSizePlus2),
//                        startY + (row * slotSizePlus2)));
//            }
//        }
//
//        // Main Player Inventory
//        int startPlayerInvY = startY * 5 + 12;
//        for (int row = 0; row < 3; ++row) {
//            for (int column = 0; column < 9; ++column) {
//                this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * slotSizePlus2),
//                        startPlayerInvY + (row * slotSizePlus2)));
//            }
//        }
//
//        // Hotbar
//        int hotbarY = startPlayerInvY + (startPlayerInvY / 2) + 7;
//        for (int column = 0; column < 9; ++column) {
//            this.addSlot(new Slot(playerInventory, column, startX + (column * slotSizePlus2), hotbarY));
//        }
//    }

    public ExampleChestContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, (ExampleChestTileEntity) null);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < 36) {
                if (!this.mergeItemStack(itemstack1, 36, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, 36, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }
}
