package alphacore.mixins;

import alphacore.AlphaCore;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NetherrackBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Iterator;
import java.util.Random;

@Mixin(NetherrackBlock.class)
public class NetherrackBlockMixin {
    /**
     * @author Mojang/AlphaMode
     * @reason No provided way
     */
    @Overwrite
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        Iterator var7 = BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1)).iterator();

        while (var7.hasNext()) {
            BlockPos blockPos = (BlockPos) var7.next();
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isOf(AlphaCore.BLOCKS.rNylium)) {
                bl3 = true;
            }

            if (blockState.isOf(Blocks.WARPED_NYLIUM)) {
                bl2 = true;
            }

            if (blockState.isOf(Blocks.CRIMSON_NYLIUM)) {
                bl = true;
            }

            if (bl2 && bl && bl3) {
                break;
            }
        }

        if (bl2 && bl) {
            world.setBlockState(pos, random.nextBoolean() ? Blocks.WARPED_NYLIUM.getDefaultState() : Blocks.CRIMSON_NYLIUM.getDefaultState(), 3);
        } else if (bl2 && bl3) {
            world.setBlockState(pos, random.nextBoolean() ? Blocks.WARPED_NYLIUM.getDefaultState() : AlphaCore.BLOCKS.rNylium.getDefaultState(), 3);
        } else if (bl && bl3) {
            world.setBlockState(pos, random.nextBoolean() ? AlphaCore.BLOCKS.rNylium.getDefaultState() : Blocks.CRIMSON_NYLIUM.getDefaultState(), 3);
        } else if (bl2 && bl && bl3) {
            if (random.nextBoolean()) {
                world.setBlockState(pos, random.nextBoolean() ? Blocks.WARPED_NYLIUM.getDefaultState() : Blocks.CRIMSON_NYLIUM.getDefaultState(), 3);
            } else {
                world.setBlockState(pos, AlphaCore.BLOCKS.rNylium.getDefaultState(), 3);
            }
        } else if (bl3) {
            world.setBlockState(pos, AlphaCore.BLOCKS.rNylium.getDefaultState(), 3);
        } else if (bl2) {
            world.setBlockState(pos, Blocks.WARPED_NYLIUM.getDefaultState(), 3);
        } else if (bl) {
            world.setBlockState(pos, Blocks.CRIMSON_NYLIUM.getDefaultState(), 3);
        }
    }

    /*@Unique private boolean bl3 = false;

    @Inject(method = "grow",at = @At(value = "INVOKE",target = "Lnet/minecraft/block/Block;getDefaultState()Lnet/minecraft/block/BlockState;"),locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state, CallbackInfo ci,BlockState arg3) {
        if (arg3.isOf(AlphaCore.rNylium)) {
            bl3 = true;
        }
    }

    @Inject(method = "grow",at = @At("HEAD"))
    public void growone(ServerWorld world, Random random, BlockPos pos, BlockState state, CallbackInfo ci) {
        bl3 = false;
    }
    @Inject(method = "grow",at = @At(value = "RETURN"))
    public void growtwo(ServerWorld world, Random random, BlockPos pos, BlockState state, CallbackInfo ci) {
        if(bl3) {
            world.setBlockState(pos, AlphaCore.rNylium.getDefaultState(), 3);
        }
    }*/

}
