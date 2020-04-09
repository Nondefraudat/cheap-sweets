package com.github.nondefraudat.mixin;

import com.github.nondefraudat.CheapSweetsMain;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin
{
    private static Item item;

    private boolean isEatebalTool()
    {
        return  item.equals(CheapSweetsMain.CARAMEL_AXE) ||
                item.equals(CheapSweetsMain.CARAMEL_HOE) ||
                item.equals(CheapSweetsMain.CARAMEL_PICKAXE) ||
                item.equals(CheapSweetsMain.CARAMEL_SHOVEL) ||
                item.equals(CheapSweetsMain.CARAMEL_SWORD);
    }

    private boolean isEatebalArmor()
    {
        return  item.equals(CheapSweetsMain.CARAMEL_HELMET) ||
                item.equals(CheapSweetsMain.CARAMEL_CHESTPLATE) ||
                item.equals(CheapSweetsMain.CARAMEL_LEGGINGS) ||
                item.equals(CheapSweetsMain.CARAMEL_BOOTS);
    }

    @Inject(method = "eatFood", at = @At("HEAD"), cancellable = true)
    protected void eatFoodPrev(World world, ItemStack stack, CallbackInfoReturnable info)
    {
        item = stack.getItem();
        if ( isEatebalTool() || isEatebalArmor() )
        {
            stack.increment(1);
        }
    }
    @Inject(method = "eatFood", at = @At("TAIL"), cancellable = true)
    protected void eatFoodPost(World world, ItemStack stack, CallbackInfoReturnable info)
    {
        if ( isEatebalTool() || isEatebalArmor() )
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
