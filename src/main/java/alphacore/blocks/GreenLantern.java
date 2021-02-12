package alphacore.blocks;

import alphacore.blocks.blockentitys.GreenLanternBlockEntity;
import net.minecraft.block.*;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;


public class GreenLantern extends LanternBlock implements BlockEntityProvider {

    public GreenLantern(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(HANGING, false)).with(field_26441, false));
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new GreenLanternBlockEntity();
    }
}
