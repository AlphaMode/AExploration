package alphacore.blocks.nether;

import alphacore.AlphaCore;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.*;

import java.util.Random;

public class RadioactiveNylium extends NyliumBlock implements Fertilizable {
    public RadioactiveNylium(Settings settings) {
        super(settings);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockState blockState = world.getBlockState(pos);
        BlockPos blockPos = pos.up();
        if (blockState.isOf(AlphaCore.BLOCKS.rNylium)) {
            NetherForestVegetationFeature.generate(world, random, blockPos, ConfiguredFeatures.Configs.WARPED_ROOTS_CONFIG, 3, 1);
            NetherForestVegetationFeature.generate(world, random, blockPos, ConfiguredFeatures.Configs.NETHER_SPROUTS_CONFIG, 3, 1);
            if (random.nextInt(8) == 0) {
                TwistingVinesFeature.method_26265(world, random, blockPos, 3, 1, 2);
            }
        }
    }
}
