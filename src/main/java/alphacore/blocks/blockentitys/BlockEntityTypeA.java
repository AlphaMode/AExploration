package alphacore.blocks.blockentitys;

import alphacore.AlphaCore;
import com.mojang.datafixers.types.Type;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

public class BlockEntityTypeA {
    public static final BlockEntityType<GreenLanternBlockEntity> GREEN_LANTERN;
    private static <T extends BlockEntity> BlockEntityType<T> create(String string, BlockEntityType.Builder<T> builder) {
        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, string);
        return (BlockEntityType)Registry.register(Registry.BLOCK_ENTITY_TYPE, (String)string, builder.build(type));
    }
    static {
        GREEN_LANTERN = create("green_lantern", BlockEntityType.Builder.create(GreenLanternBlockEntity::new, AlphaCore.BLOCKS.GREEN_LANTERN));
    }
}
