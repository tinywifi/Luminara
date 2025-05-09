package sh.tinywifi.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import sh.tinywifi.Luminara;

public class IngredientsItems {
    public static final RegistryKey<ItemGroup> LUMINARATAB = RegistryKey.of(
            RegistryKeys.ITEM_GROUP,
            Identifier.of(Luminara.MOD_ID, "luminara")
    );

    public static Item PURIFIED_AMETHYST;
    public static Item SALT_CRYSTAL;

    public static void registerModItems() {
        Registry.register(
                Registries.ITEM_GROUP,
                LUMINARATAB,
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.luminara"))
                        .icon(() -> PURIFIED_AMETHYST.getDefaultStack())
                        .entries((context, entries) -> entries.add(PURIFIED_AMETHYST))
                        .build()
        );

        PURIFIED_AMETHYST = registerItem("purified_amethyst", LUMINARATAB);
        SALT_CRYSTAL = registerItem("salt_crystal", LUMINARATAB);
    }

    @SafeVarargs
    public static Item registerItem(String id, RegistryKey<ItemGroup>... itemGroups) {
        Identifier identifier = Identifier.of(Luminara.MOD_ID, id);
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, identifier);

        Item.Settings settings = new Item.Settings()
                .registryKey(itemKey);
        Item item = Registry.register(Registries.ITEM, itemKey, new Item(settings));
        for (RegistryKey<ItemGroup> group : itemGroups) {
            ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        }

        return item;
    }
}
