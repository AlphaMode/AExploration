package alphacore.blocks.nether;

import alphacore.AlphaCore;
import alphacore.worldgen.biomes.Features.RadioactiveHugeFungusFeatureConfig;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;
import java.util.function.Supplier;

class RafdioactiveFungus extends PlantBlock implements Fertilizable {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D);
    private final Supplier<ConfiguredFeature<RadioactiveHugeFungusFeatureConfig, ?>> FungusFeature;

    protected RafdioactiveFungus(Settings settings, Supplier<ConfiguredFeature<RadioactiveHugeFungusFeatureConfig, ?>> fungusFeature) {
        super(settings);
        FungusFeature = fungusFeature;
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getBlockState(pos.down()).getBlock() == AlphaCore.BLOCKS.rNylium;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        ((ConfiguredFeature)this.FungusFeature.get()).generate(world, world.getChunkManager().getChunkGenerator(), random, pos);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.NYLIUM) || floor.isOf(Blocks.MYCELIUM) || floor.isOf(Blocks.SOUL_SOIL) || super.canPlantOnTop(floor, world, pos);
    }
    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return (double)random.nextFloat() < 0.4D;
    }
    /*
    Biome rForest = Registry.register(BuiltinRegistries.BIOME,rForest_Key.getValue(), new Biome.Builder().generationSettings(new GenerationSettings.Builder().surfaceBuilder(NetherSurfaceBuilder.RADIOACTIVE_NYLIUM_BUILDER)
                .structureFeature(ConfiguredStructureFeatures.FORTRESS)
                .structureFeature(ConfiguredStructureFeatures.BASTION_REMNANT)
                .structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_NETHER)
                .structureFeature(ConfiguredStructureFeatures.NETHER_FOSSIL)
                .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.WARPED_FOREST_VEGETATION)
                .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.SPRING_LAVA)
                .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.WARPED_FUNGI)
                .feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ConfiguredFeatures.WARPED_FUNGI_PLANTED)
                .build())
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.NETHER)
                .depth(.125F)
                .scale(.55F)
                .temperature(2.0F)
                .downfall(0.4F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3f76e4)
                        .waterFogColor(0x050533)
                        .fogColor(0xc0d8ff)
                        .skyColor(0x77adff)
                        .build())
                .spawnSettings(new SpawnSettings.Builder().build())
                .build());
     */
}
