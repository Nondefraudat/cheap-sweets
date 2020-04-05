package com.github.nondefraudat.mixin;

import com.github.nondefraudat.CheapSweetsMain;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DefaultedList;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.security.auth.callback.Callback;

@Mixin (LivingEntity.class)
public abstract class LivingEntityMixin extends Entity
{
    @Shadow @Final private DefaultedList<ItemStack> equippedArmor;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject (at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info)
    {
        if (isOnFire())
        {
            ItemStack helmetStack = equippedArmor.get(3);
            ItemStack chestplateStack = equippedArmor.get(2);
            ItemStack legginsStack = equippedArmor.get(1);
            ItemStack bootsStack = equippedArmor.get(0);

            int explosionCount = 0;

            if (helmetStack.getItem().equals(CheapSweetsMain.PAPER_HELMET))
            {
                TntEntity tntEntity = EntityType.TNT.create(world);
                tntEntity.setFuse(0);
                tntEntity.updatePosition(this.prevX, this.prevY, this.prevZ);

                world.spawnEntity(tntEntity);
            }
        }
    }
}
