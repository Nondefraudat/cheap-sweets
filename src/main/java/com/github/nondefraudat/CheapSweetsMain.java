package com.github.nondefraudat;

import com.github.nondefraudat.materials.SweetArmorMaterials;
import com.github.nondefraudat.materials.SweetToolMaterials;
import com.github.nondefraudat.tools.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CheapSweetsMain implements ModInitializer
{
	public static final ItemGroup CHEAP_SWEETS = FabricItemGroupBuilder.build(new Identifier("sweets", "cheap_sweets"), () -> new ItemStack(CheapSweetsMain.CARAMEL_INGOT));

	public static final Block CARAMEL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).build());
	public static final Block CARAMEL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0F, 6.0F).sounds(BlockSoundGroup.STONE).build());

	public static final Item CARAMEL_BLOCK_ITEM = new BlockItem(CARAMEL_BLOCK, new Item.Settings().food((new FoodComponent.Builder().hunger(6).saturationModifier(0.5F)).build()).group(CHEAP_SWEETS));
	public static final Item CARAMEL_ORE_ITEM = new BlockItem(CARAMEL_ORE, new Item.Settings().group(CHEAP_SWEETS));

	public static final Item CARAMEL_INGOT = new Item(new Item.Settings().food((new FoodComponent.Builder().hunger(2).saturationModifier(0.3F)).build()).group(CHEAP_SWEETS));

	public static final Item CARAMEL_AXE = new CaramelAxe(SweetToolMaterials.CARAMEL, 5.0F, -3.0F, (new Item.Settings()).food((new FoodComponent.Builder().hunger(2).saturationModifier(0.3F)).build()).group(CHEAP_SWEETS));
	public static final Item CARAMEL_HOE = new CaramelHoe(SweetToolMaterials.CARAMEL, -3.0F, (new Item.Settings().food((new FoodComponent.Builder().hunger(2).saturationModifier(0.3F)).build()).group(CHEAP_SWEETS)));
	public static final Item CARAMEL_PICKAXE = new CaramelPickaxe(SweetToolMaterials.CARAMEL, 1, -2.8F, (new Item.Settings()).food((new FoodComponent.Builder().hunger(2).saturationModifier(0.3F)).build()).group(CHEAP_SWEETS));
	public static final Item CARAMEL_SHOVEL = new CaramelShovel(SweetToolMaterials.CARAMEL, 1.5F, -3.0F, (new Item.Settings()).food((new FoodComponent.Builder().hunger(2).saturationModifier(0.3F)).build()).group(ItemGroup.TOOLS));
	public static final Item CARAMEL_SWORD = new CaramelSword(SweetToolMaterials.CARAMEL, 3, -2.4F, (new Item.Settings()).food((new FoodComponent.Builder().hunger(2).saturationModifier(0.3F)).build()).group(CHEAP_SWEETS));

	public static final Item CARAMEL_HELMET = new ArmorItem(SweetArmorMaterials.CARAMEL, EquipmentSlot.HEAD, (new Item.Settings()).food((new FoodComponent.Builder().hunger(2).saturationModifier(0.3F)).build()).group(CHEAP_SWEETS));
	public static final Item CARAMEL_CHESTPLATE = new ArmorItem(SweetArmorMaterials.CARAMEL, EquipmentSlot.CHEST, (new Item.Settings()).food((new FoodComponent.Builder().hunger(2).saturationModifier(0.3F)).build()).group(CHEAP_SWEETS));
	public static final Item CARAMEL_LEGGINGS = new ArmorItem(SweetArmorMaterials.CARAMEL, EquipmentSlot.LEGS, (new Item.Settings()).food((new FoodComponent.Builder().hunger(2).saturationModifier(0.3F)).build()).group(CHEAP_SWEETS));
	public static final Item CARAMEL_BOOTS = new ArmorItem(SweetArmorMaterials.CARAMEL, EquipmentSlot.FEET, (new Item.Settings()).food((new FoodComponent.Builder().hunger(2).saturationModifier(0.3F)).build()).group(CHEAP_SWEETS));

	@Override
	public void onInitialize()
	{
		Registry.register(Registry.BLOCK, new Identifier("sweets", "caramel_block"), CARAMEL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier("sweets", "caramel_ore"), CARAMEL_ORE);

		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_block"), CARAMEL_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_ore"), CARAMEL_ORE_ITEM);

		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_ingot"), CARAMEL_INGOT);

		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_axe"), CARAMEL_AXE);
		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_hoe"), CARAMEL_HOE);
		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_pickaxe"), CARAMEL_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_shovel"), CARAMEL_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_sword"), CARAMEL_SWORD);

		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_helmet"), CARAMEL_HELMET);
		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_chestplate"), CARAMEL_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_leggins"), CARAMEL_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier("sweets", "caramel_boots"), CARAMEL_BOOTS);
	}
}
