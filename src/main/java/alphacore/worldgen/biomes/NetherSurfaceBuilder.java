package alphacore.worldgen.biomes;

import alphacore.AlphaCore;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class NetherSurfaceBuilder {
    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> RADIOACTIVE_NYLIUM_BUILDER;

    static {
        RADIOACTIVE_NYLIUM_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(AlphaCore.BLOCKS.rNylium.getDefaultState(), Blocks.NETHERRACK.getDefaultState(),AlphaCore.BLOCKS.rWart.getDefaultState()));
    }
}
