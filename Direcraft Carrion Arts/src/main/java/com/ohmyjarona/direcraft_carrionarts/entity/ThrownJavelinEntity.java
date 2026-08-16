package com.ohmyjarona.direcraft_carrionarts.entity;

import com.ohmyjarona.direcraft_carrionarts.item.ModItem;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class ThrownJavelinEntity extends AbstractArrow {
	int HIT_DAMAGE = 4;
	
	public ThrownJavelinEntity(EntityType<? extends ThrownJavelinEntity> entityType, double x, double y, double z,
		Level level, ItemStack pickupItemStack, ItemStack firedFromWeapon) {
		super(entityType, x, y, z, level, pickupItemStack, firedFromWeapon);
	}
	
	public ThrownJavelinEntity(EntityType<? extends ThrownJavelinEntity> entityType, Level level) {
			super(entityType, level);
		}	
	
	public ThrownJavelinEntity(LivingEntity shooter, Level level) {
		
		super(ModEntity.JAVELIN.get(), shooter, level, new ItemStack(ModItem.JAVELIN.get()), null);
	}
	

	@Override
	protected ItemStack getDefaultPickupItem() {
		// TODO Auto-generated method stub
		return new ItemStack(ModItem.JAVELIN.get());
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
		Entity entity = result.getEntity();
		
		entity.hurt(this.damageSources().thrown(this, this.getOwner()),HIT_DAMAGE);
		
		if (!this.level().isClientSide()) {
			this.level().broadcastEntityEvent(this,  (byte)3);
			this.discard();
		}
	}
	
	@Override
	protected void onHitBlock(BlockHitResult result) {
        //this.lastState = this.level().getBlockState(result.getBlockPos());
        super.onHitBlock(result);
        Vec3 vec3 = result.getLocation().subtract(this.getX(), this.getY(), this.getZ());
        this.setDeltaMovement(vec3);
        //ItemStack itemstack = this.getWeaponItem();
        //if (this.level() instanceof ServerLevel serverlevel && itemstack != null) {
         //   this.hitBlockEnchantmentEffects(serverlevel, result, itemstack);
        //}

        Vec3 vec31 = vec3.normalize().scale(0.05F);
        this.setPosRaw(this.getX() - vec31.x, this.getY() - vec31.y, this.getZ() - vec31.z);
        this.playSound(this.getHitGroundSoundEvent(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
        this.inGround = true;
        this.shakeTime = 7;
        //this.setCritArrow(false);
        //this.setPierceLevel((byte)0);
        //this.setSoundEvent(SoundEvents.ARROW_HIT);
        //this.resetPiercedEntities();
	}
	
}
