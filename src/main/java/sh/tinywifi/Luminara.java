package sh.tinywifi;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.tinywifi.block.ModBlocks;
import sh.tinywifi.item.IngredientsItems;

public class Luminara implements ModInitializer {
    public static final String MOD_ID = "luminara";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        IngredientsItems.registerModItems();
        ModBlocks.registerBlocks();
    }
}
