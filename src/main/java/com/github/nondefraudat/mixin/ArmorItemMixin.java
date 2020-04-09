package com.github.nondefraudat.mixin;

import com.github.nondefraudat.CheapSweetsMain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArmorItem.class)
public class ArmorItemMixin extends Item
{
    private static Item item;

    private boolean isEatebleArmor()
    {
        return  item.equals(CheapSweetsMain.CARAMEL_HELMET) ||
                item.equals(CheapSweetsMain.CARAMEL_CHESTPLATE) ||
                item.equals(CheapSweetsMain.CARAMEL_LEGGINGS) ||
                item.equals(CheapSweetsMain.CARAMEL_BOOTS);
    }

    public ArmorItemMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    protected void use(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> info)
    {
        item = user.getStackInHand(hand).getItem();
        if ( isEatebleArmor() )
        {
            info.setReturnValue(super.use(world, user, hand));
        }
    }
}
