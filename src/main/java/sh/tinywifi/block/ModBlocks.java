package sh.tinywifi.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import sh.tinywifi.Luminara;
import sh.tinywifi.item.IngredientsItems;

public class ModBlocks {
    public static final Block SALT = registerBlock("salt", AbstractBlock.Settings.create()
            .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Luminara.MOD_ID, "salt")))
            .strength(0.6f)
            .requiresTool()
            .sounds(BlockSoundGroup.ROOTED_DIRT));

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Luminara.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key).useBlockPrefixedTranslationKey());
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerBlocks() {
        ItemGroupEvents.modifyEntriesEvent(IngredientsItems.LUMINARATAB).register(entries -> entries.add(SALT));
    }

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Luminara.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);

    }

}
