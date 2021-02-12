package alphacore;

import alphacore.blocks.GreenLantern;
import alphacore.blocks.PetAltarBlock;
import alphacore.blocks.nether.RadioactiveFungus;
import alphacore.blocks.nether.RadioactiveNylium;
import alphacore.worldgen.biomes.BiomeCreator;
import alphacore.worldgen.biomes.Features.RadioactiveHugeFungusFeatureConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.impl.biome.InternalBiomeData;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;


public class AlphaCore implements ModInitializer {
    public static Identifier getIdeniftier(String id) {
        return new Identifier("alphatech",id);
    }


    public static final ConfiguredFeature<HugeFungusFeatureConfig, ?> rFungusFeature = Feature.HUGE_FUNGUS.configure(RadioactiveHugeFungusFeatureConfig.RADIOACTIVE_FUNGUS_CONFIG);
    public static final RegistryKey<Biome> rForest_Key = RegistryKey.of(Registry.BIOME_KEY, new Identifier("alphatech","radioactive_forest"));



    public static class BLOCKS {
        public static final LanternBlock PURPLE_LANTERN = new LanternBlock(AbstractBlock.Settings.of(Material.METAL).requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance((state) -> 20).nonOpaque());
        public static final LanternBlock WHITE_LANTERN = new LanternBlock(AbstractBlock.Settings.of(Material.METAL).requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance((state) -> 10).nonOpaque());
        public static final LanternBlock YELLOW_LANTERN = new LanternBlock(AbstractBlock.Settings.of(Material.METAL).requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance((state) -> 30).nonOpaque());
        public static final LanternBlock CRIMSON_LANTERN = new LanternBlock(AbstractBlock.Settings.of(Material.METAL).requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance((state) -> 10).nonOpaque());
        public static final GreenLantern GREEN_LANTERN = new GreenLantern(AbstractBlock.Settings.of(Material.METAL).requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance((state) -> 10).nonOpaque());
        public static final RadioactiveFungus rFungus = new RadioactiveFungus(AbstractBlock.Settings.of(Material.PLANT, MaterialColor.CYAN).breakInstantly().noCollision().sounds(BlockSoundGroup.FUNGUS), () -> Feature.HUGE_FUNGUS.configure(RadioactiveHugeFungusFeatureConfig.RADIOACTIVE_FUNGUS_CONFIG));
        public static final Block rHyphae = new PillarBlock(AbstractBlock.Settings.of(Material.NETHER_WOOD, MaterialColor.field_25704).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM));
        public static final Block rNylium = new RadioactiveNylium(AbstractBlock.Settings.of(Material.STONE, MaterialColor.field_25705).requiresTool().strength(0.4F).sounds(BlockSoundGroup.NYLIUM).ticksRandomly());
        public static final Block rWart = new Block(FabricBlockSettings.copyOf(AbstractBlock.Settings.of(Material.SOLID_ORGANIC, MaterialColor.field_25708).strength(1.0F).sounds(BlockSoundGroup.WART_BLOCK)));
        public static final Block rStem = new PillarBlock(AbstractBlock.Settings.of(Material.NETHER_WOOD, (blockState) -> {
            return MaterialColor.field_25706;
        }).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM));
        public static final PetAltarBlock PET_ALTAR_BLOCK = new PetAltarBlock(FabricBlockSettings.of(Material.STONE));
    }
    public static class ITEMS {
        public static final Item PET_STONE = new Item(new FabricItemSettings());
        public static final Item PET_ALTAR = new BlockItem(BLOCKS.PET_ALTAR_BLOCK, new FabricItemSettings());
    }
    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, getIdeniftier("radioactive_nylium"), BLOCKS.rNylium);
        Registry.register(Registry.BLOCK,getIdeniftier("radioactive_wart_block"), BLOCKS.rWart);
        Registry.register(Registry.ITEM, getIdeniftier("radioactive_wart_block"), new BlockItem(BLOCKS.rWart, new FabricItemSettings()));
        Registry.register(Registry.ITEM, getIdeniftier("radioactive_nylium"), new BlockItem(BLOCKS.rNylium, new Item.Settings()));

        Registry.register(Registry.BLOCK, getIdeniftier("radioactive_hyphae"), BLOCKS.rHyphae);
        Registry.register(Registry.ITEM, getIdeniftier("radioactive_hyphae"), new BlockItem(BLOCKS.rHyphae, new FabricItemSettings()));

        Registry.register(Registry.BLOCK,getIdeniftier("purple_lantern"), BLOCKS.PURPLE_LANTERN);
        Registry.register(Registry.BLOCK,getIdeniftier("crimson_lantern"), BLOCKS.CRIMSON_LANTERN);
        Registry.register(Registry.BLOCK, getIdeniftier("white_lantern"), BLOCKS.WHITE_LANTERN);
        Registry.register(Registry.BLOCK, getIdeniftier("yellow_lantern"), BLOCKS.YELLOW_LANTERN);
        Registry.register(Registry.BLOCK, getIdeniftier("green_lantern"), BLOCKS.GREEN_LANTERN);

        Registry.register(Registry.ITEM, getIdeniftier("purple_lantern"), new BlockItem(BLOCKS.PURPLE_LANTERN, new FabricItemSettings()));
        Registry.register(Registry.ITEM, getIdeniftier("crimson_lantern"), new BlockItem(BLOCKS.CRIMSON_LANTERN, new FabricItemSettings()));
        Registry.register(Registry.ITEM, getIdeniftier("white_lantern"), new BlockItem(BLOCKS.WHITE_LANTERN, new FabricItemSettings()));
        Registry.register(Registry.ITEM, getIdeniftier("yellow_lantern"), new BlockItem(BLOCKS.YELLOW_LANTERN, new FabricItemSettings()));
        Registry.register(Registry.ITEM, getIdeniftier("green_lantern"), new BlockItem(BLOCKS.GREEN_LANTERN, new FabricItemSettings()));

        Registry.register(Registry.BLOCK, getIdeniftier("radioactive_stem"), BLOCKS.rStem);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,getIdeniftier("radioactive_fungus_config"), rFungusFeature);
        Registry.register(Registry.ITEM,new Identifier("alphatech","radioactive_stem"), new BlockItem(BLOCKS.rStem,new Item.Settings()));
        Registry.register(Registry.BLOCK,getIdeniftier("radioactive_fungus"), BLOCKS.rFungus);
        Registry.register(Registry.ITEM,getIdeniftier("radioactive_fungus"),new BlockItem(BLOCKS.rFungus,new FabricItemSettings()));

        Registry.register(Registry.ITEM,getIdeniftier("pet_stone"), ITEMS.PET_STONE);
        Registry.register(Registry.ITEM, getIdeniftier("pet_altar"), ITEMS.PET_ALTAR);
        Registry.register(Registry.BLOCK, getIdeniftier("pet_altar"), BLOCKS.PET_ALTAR_BLOCK);
        Registry.register(BuiltinRegistries.BIOME, rForest_Key.getValue(), BiomeCreator.createRadioactiveForest());

        InternalBiomeData.addNetherBiome(rForest_Key, new Biome.MixedNoisePoint(0.35F, 0.35F, 0, 0, 0.2F));
    }
}
