package alphacore.mixins;

import alphacore.AlphaCore;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TameableEntity.class)
public abstract class TameableEntityMixin extends AnimalEntity {

    protected TameableEntityMixin(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }
    @Shadow
    public abstract LivingEntity getOwner();

    @Inject(method = "onDeath",at = @At("HEAD"))
    public void onDeath(DamageSource source, CallbackInfo ci) {
        if (!this.world.isClient && getOwner() instanceof ServerPlayerEntity) {
            this.dropItem(AlphaCore.ITEMS.PET_STONE);
        }
    }
}
