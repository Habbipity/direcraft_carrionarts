package com.ohmyjarona.direcraft_carrionarts.item.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.ohmyjarona.direcraft_carrionarts.entity.ThrownJavelinEntity;
import com.ohmyjarona.direcraft_carrionarts.item.ModItem;

import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

public class JavelinItem extends ProjectileWeaponItem{

    public static final int MAX_DRAW_DURATION = 72000;
    public static final int DEFAULT_RANGE = 15;
	
	
	public JavelinItem(Properties properties) {
		super(properties);
	}


	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		// TODO Auto-generated method stub
		return ammo -> ammo.is(ModItem.JAVELIN.get());
	}


	@Override
	public int getDefaultProjectileRange() {
		// TODO Auto-generated method stub
		return DEFAULT_RANGE;
	}


	@Override
	protected void shootProjectile(LivingEntity shooter, Projectile projectile, int index, float velocity,
			float inaccuracy, float angle, LivingEntity target) {
		// TODO Auto-generated method stub
		
	}
	
    public static float getPowerForTime(int charge) {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }
	
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player) {
            ItemStack itemstack = player.getProjectile(stack);
            if (!itemstack.isEmpty()) {
                int i = this.getUseDuration(stack, entityLiving) - timeLeft;
                i = net.neoforged.neoforge.event.EventHooks.onArrowLoose(stack, level, player, i, !itemstack.isEmpty());
                if (i < 0) return;
                float f = getPowerForTime(i);
                if (!((double)f < 0.1)) {
                    List<ItemStack> list = draw(stack, itemstack, player);
                    if (level instanceof ServerLevel serverlevel && !list.isEmpty()) {
            			ThrownJavelinEntity projectile = new ThrownJavelinEntity(player, level);
            			projectile.shootFromRotation(player,  player.getXRot(), player.getYRot(), 0.0f, 1.5f, 0.0f);
            			level.addFreshEntity(projectile);
                    }

                    level.playSound(
                        null,
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        SoundEvents.ARROW_SHOOT,
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F
                    );
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }
	
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        boolean flag = !player.getProjectile(itemstack).isEmpty();

        InteractionResultHolder<ItemStack> ret = net.neoforged.neoforge.event.EventHooks.onArrowNock(itemstack, level, player, hand, flag);
        if (ret != null) return ret;

        if (!player.hasInfiniteMaterials() && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }
    }
    
    @Override
    public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(ModItem.JAVELIN.get());
    }
    
    
    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return MAX_DRAW_DURATION;
    }
    
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.SPEAR;
    }
    
	/*
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand){
		ItemStack itemStack = player.getItemInHand(usedHand);
		
		level.playSound(null,  player.getX(), player.getY(), player.getZ(),
			SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5f, 
			0.4f/(level.getRandom().nextFloat() * 0.5f + 0.8f)
				);
		
		if (!level.isClientSide()) {
			Snowball projectile = new Snowball(level, player);
			projectile.shootFromRotation(player,  player.getXRot(), player.getYRot(), 0.0f, 1.5f, 0.0f);
			level.addFreshEntity(projectile);
		}
		
		player.awardStat(Stats.ITEM_USED.get(this));
		if (!player.getAbilities().instabuild) {
			itemStack.shrink(1);
			
		}
		return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
	}*/
	

    /**
     * Gets the velocity of the arrow entity from the bow's charge
     */
 
    
    
    
}
