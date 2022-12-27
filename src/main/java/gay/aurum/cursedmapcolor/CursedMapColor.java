package gay.aurum.cursedmapcolor;

import gay.aurum.cursedmapcolor.mixin.MapColorInvoker;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.MapColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CursedMapColor implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("cursedmapcolor");

	public static final MapColor TRUEBLACK = MapColorInvoker.callMapColor(62, 65793);
	public static final MapColor OTHERBLACK = MapColorInvoker.callMapColor(63, 1118481);

	@Override
	public void onInitialize() {

		LOGGER.info("Loaded map colors!");
	}
}
