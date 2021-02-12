package alphacore.worldgen.biomes.Features;


import alphacore.AlphaCore;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class Features {
    public static final HugeFungusFeature RADIOACTIVE_HUGE_FUNGUS;
    public static final BlockPileFeatureConfig RADIOACTIVE_ROOTS_CONFIG;
    public static final ConfiguredFeature<?, ?> RADIOACTIVE_FOREST_VEGETATION;
    public static final ConfiguredFeature<?, ?> RADIOACTIVE_FUNGI;

    static {
        RADIOACTIVE_HUGE_FUNGUS = Registry.register(Registry.FEATURE,new Identifier("alphatech", "r_huge_fungus"),new HugeFungusFeature(RadioactiveHugeFungusFeatureConfig.CODEC));
        RADIOACTIVE_ROOTS_CONFIG = new BlockPileFeatureConfig((new WeightedBlockStateProvider()).addState(Blocks.WARPED_ROOTS.getDefaultState(), 1).addState(Blocks.CRIMSON_ROOTS.getDefaultState(), 1).addState(AlphaCore.BLOCKS.rFungus.getDefaultState(), 13).addState(Blocks.WARPED_FUNGUS.getDefaultState(), 1).addState(Blocks.CRIMSON_FUNGUS.getDefaultState(), 1));
        RADIOACTIVE_FOREST_VEGETATION = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, AlphaCore.getIdeniftier("radioactive_forest_vegetation"), Feature.NETHER_FOREST_VEGETATION.configure(RADIOACTIVE_ROOTS_CONFIG).decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(5))));
        RADIOACTIVE_FUNGI = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, AlphaCore.getIdeniftier("radioactive_fungi"), Feature.HUGE_FUNGUS.configure(RadioactiveHugeFungusFeatureConfig.RADIOACTIVE_FUNGUS_NOT_PLANTED_CONFIG).decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(8))));
    }
}
