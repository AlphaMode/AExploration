package alphacore.blocks.blockentitys;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.ElderGuardianEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.apache.logging.log4j.LogManager;

import java.util.List;

public class GreenLanternBlockEntity extends BlockEntity implements Tickable {
    public GreenLanternBlockEntity() {
        super(BlockEntityTypeA.GREEN_LANTERN);
    }

    public float distanceTo(Entity entity) {
        float f = (float)(this.pos.getX() - entity.getX());
        float g = (float)(this.pos.getY() - entity.getY());
        float h = (float)(this.pos.getZ() - entity.getZ());
        return MathHelper.sqrt(f * f + g * g + h * h);
    }

    public double squaredDistanceTo(double x, double y, double z) {
        double d = this.pos.getX() - x;
        double e = this.pos.getY() - y;
        double f = this.pos.getZ() - z;
        return d * d + e * e + f * f;
    }

    public double squaredDistanceTo(Entity entity) {
        return this.squaredDistanceTo(entity.getPos());
    }

    public double squaredDistanceTo(Vec3d vector) {

        double d = this.pos.getX() - vector.x;
        double e = this.pos.getY() - vector.y;
        double f = this.pos.getZ() - vector.z;
        return d * d + e * e + f * f;
    }

    @Override
    public void tick() {
        if(this.world.isClient())
            return;

        List<ServerPlayerEntity> list = ((ServerWorld)this.world).getPlayers((serverPlayerEntityx) -> {
            return this.squaredDistanceTo(serverPlayerEntityx) < 150.0D;
        });

        for (ServerPlayerEntity p:list) {
            p.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5,0));
        }
    }
}
