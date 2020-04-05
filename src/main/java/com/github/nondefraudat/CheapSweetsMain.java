package com.github.nondefraudat;

import com.github.nondefraudat.armor.CaramelArmorMaterials;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CheapSweetsMain implements ModInitializer
{
	private static final ItemGroup CHEAP_SWEETS = FabricItemGroupBuilder.build(new Identifier("sweets", "cheap_sweets"), () -> new ItemStack(CheapSweetsMain.CARAMEL_INGOT));

	private static final Item CARAMEL_INGOT = new CaramelIngot(new Item.Settings().group(CHEAP_SWEETS).maxCount(64));

	// private static final ToolMaterial CARAMEL_PICKAXE = new CaramelPickaxe();

	public static final Item PAPER_HELMET = new ArmorItem(CaramelArmorMaterials.PAPER, EquipmentSlot.HEAD, new Item.Settings().group(CHEAP_SWEETS));
	public static final Item PAPER_CHESTPLATE = new ArmorItem(CaramelArmorMaterials.PAPER, EquipmentSlot.CHEST, new Item.Settings().group(CHEAP_SWEETS));
	public static final Item PAPER_LEGGINS = new ArmorItem(CaramelArmorMaterials.PAPER, EquipmentSlot.LEGS, new Item.Settings().group(CHEAP_SWEETS));
	public static final Item PAPER_BOOTS = new ArmorItem(CaramelArmorMaterials.PAPER, EquipmentSlot.FEET, new Item.Settings().group(CHEAP_SWEETS));

	private static final Block CARAMEL_BLOCK = new CaramelBlock(FabricBlockSettings.of(Material.GLASS).build());

	private static final Enchantment CARAMELIZATION = new Сaramelization(Enchantment.Weight.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});

	@Override
	public void onInitialize()
	{
		Registry.register(Registry.BLOCK, new Identifier("sweets", "caramel_block"), CARAMEL_BLOCK);

		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_ingot"), CARAMEL_INGOT);
		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_block"), new BlockItem(CARAMEL_BLOCK, new Item.Settings().group(CHEAP_SWEETS)));
		// Paper armor
		Registry.register(Registry.ITEM, new Identifier("sweets", "paper_helmet"), PAPER_HELMET);
		Registry.register(Registry.ITEM, new Identifier("sweets", "paper_chestplate"), PAPER_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier("sweets", "paper_leggins"), PAPER_LEGGINS);
		Registry.register(Registry.ITEM, new Identifier("sweets", "paper_boots"), PAPER_BOOTS);

		Registry.register(Registry.ENCHANTMENT, new Identifier("sweets", "caramelization"), CARAMELIZATION);
	}
}
