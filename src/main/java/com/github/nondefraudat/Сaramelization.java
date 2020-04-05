package com.github.nondefraudat;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.world.World;

public class Сaramelization extends Enchantment
{

    protected Сaramelization(Weight weight, EnchantmentTarget type, EquipmentSlot[] slotTypes)
    {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMinimumPower(int level)
    {
        return 15;
    }
    @Override
    public int getMaximumLevel()
    {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level)
    {
        if (target instanceof LivingEntity)
        {
            World world = user.world;

            TntEntity tntEntity = EntityType.TNT.create(world);
            tntEntity.setFuse(0);
            tntEntity.updatePosition(target.prevX, target.prevY, target.prevZ);

            world.spawnEntity(tntEntity);
        }
    }
}
