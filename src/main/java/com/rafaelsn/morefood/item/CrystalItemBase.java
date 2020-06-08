package com.rafaelsn.morefood.item;

import com.rafaelsn.morefood.Reference;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CrystalItemBase extends Item {

    private Effect effect;
    private int durationInSeconds;
    private int amplifier;
    private int cooldownInSeconds;

    public CrystalItemBase(Effect effect, int durationInSeconds, int amplifier, int cooldownInSeconds) {
        super(new Item.Properties().group(Reference.TAB));
        this.effect = effect;
        this.durationInSeconds = durationInSeconds;
        this.amplifier = amplifier;
        this.cooldownInSeconds = cooldownInSeconds;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.getCooldownTracker().setCooldown(this, 20 * cooldownInSeconds);
        if (!worldIn.isRemote) {
            EffectInstance effectInstance = new EffectInstance(effect, 20 * durationInSeconds, amplifier);
            playerIn.addPotionEffect(effectInstance);
        }
        return ActionResult.resultSuccess(itemstack);
    }
}
