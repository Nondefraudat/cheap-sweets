package com.github.nondefraudat.mixin;

import com.github.nondefraudat.CheapSweetsMain;
import com.github.nondefraudat.tools.CaramelAxe;
import net.minecraft.advancement.criterion.Criterions;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.UnbreakingEnchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(LivingEntity.class)
public class LivingEntityMixin
{
    @Inject(method = "eatFood", at = @At("HEAD"), cancellable = true)
    protected void eatFoodPrev(World world, ItemStack stack, CallbackInfoReturnable info)
    {
        if (
                stack.getItem().equals(CheapSweetsMain.CARAMEL_AXE) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_HOE) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_PICKAXE) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_SHOVEL) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_SWORD) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_HELMET) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_CHESTPLATE) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_LEGGINGS) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_BOOTS)
        );
        {
            stack.increment(1);
        }
    }
    @Inject(method = "eatFood", at = @At("TAIL"), cancellable = true)
    protected void eatFoodPost(World world, ItemStack stack, CallbackInfoReturnable info)
    {
        if (
                stack.getItem().equals(CheapSweetsMain.CARAMEL_AXE) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_HOE) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_PICKAXE) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_SHOVEL) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_SWORD) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_HELMET) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_CHESTPLATE) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_LEGGINGS) ||
                stack.getItem().equals(CheapSweetsMain.CARAMEL_BOOTS)
        );
        {
            if (stack.getCount() > 1)
            {
                stack.decrement(1);
            }

            int maxDamage = stack.getMaxDamage();
            int currentDamage = stack.getDamage();
            int damageCounter = maxDamage / 10;
            if (damageCounter + currentDamage > maxDamage)
            {
                stack.decrement(1);
            }
            else
            {
                stack.setDamage(damageCounter + currentDamage);
            }
        }

    }
}
