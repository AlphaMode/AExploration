package alphacore.worldgen.biomes.Features;

import alphacore.AlphaCore;
import com.mojang.datafixers.util.Function5;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;

public class RadioactiveHugeFungusFeatureConfig extends HugeFungusFeatureConfig implements FeatureConfig {

    public static final RadioactiveHugeFungusFeatureConfig RADIOACTIVE_FUNGUS_CONFIG;
    public static final RadioactiveHugeFungusFeatureConfig RADIOACTIVE_FUNGUS_NOT_PLANTED_CONFIG;
    public RadioactiveHugeFungusFeatureConfig(BlockState validBaseBlock, BlockState stemState, BlockState hatState, BlockState decorationState, boolean planted) {
        super(validBaseBlock, stemState, hatState, decorationState, planted);
    }
    static {
        RADIOACTIVE_FUNGUS_CONFIG = new RadioactiveHugeFungusFeatureConfig(AlphaCore.BLOCKS.rNylium.getDefaultState(), AlphaCore.BLOCKS.rStem.getDefaultState(), AlphaCore.BLOCKS.rWart.getDefaultState(),Blocks.SHROOMLIGHT.getDefaultState(), true);
        RADIOACTIVE_FUNGUS_NOT_PLANTED_CONFIG = new RadioactiveHugeFungusFeatureConfig(RADIOACTIVE_FUNGUS_CONFIG.validBaseBlock, RADIOACTIVE_FUNGUS_CONFIG.stemState, RADIOACTIVE_FUNGUS_CONFIG.hatState, RADIOACTIVE_FUNGUS_CONFIG.decorationState, false);
    }
}
