package com.github.nondefraudat;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CaramelIngot extends Item
{

    public CaramelIngot(Settings settings)
    {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        if (hand == Hand.MAIN_HAND)
        {
            System.out.println("plue");
        }

        return super.use(world, user, hand);
    }
}
