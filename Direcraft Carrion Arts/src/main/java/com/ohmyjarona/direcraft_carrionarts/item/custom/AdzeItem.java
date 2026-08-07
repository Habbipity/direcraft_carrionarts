package com.ohmyjarona.direcraft_carrionarts.item.custom;


import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.HoeItem;

import java.util.function.Consumer;
import java.util.function.Predicate;

import com.mojang.datafixers.util.Pair;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class AdzeItem extends ShovelItem {

	public AdzeItem(Tier tier, Properties properties) {
		super(tier, properties
				.component(DataComponents.TOOL, tier.createToolProperties(BlockTags.MINEABLE_WITH_SHOVEL))
				.component(DataComponents.TOOL, tier.createToolProperties(BlockTags.MINEABLE_WITH_HOE))
			)
		;
	}
	
    public static Consumer<UseOnContext> changeIntoState(BlockState state) {
        return p_316061_ -> {
            p_316061_.getLevel().setBlock(p_316061_.getClickedPos(), state, 11);
            p_316061_.getLevel().gameEvent(GameEvent.BLOCK_CHANGE, p_316061_.getClickedPos(), GameEvent.Context.of(p_316061_.getPlayer(), state));
        };
    }
	
    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_HOE_ACTIONS.contains(itemAbility) || ItemAbilities.DEFAULT_SHOVEL_ACTIONS.contains(itemAbility);
    }
    
    @Override
    public InteractionResult useOn(UseOnContext context) {
    	if (context.getPlayer().isShiftKeyDown()) {
            Level level = context.getLevel();
            BlockPos blockpos = context.getClickedPos();
            BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(context, net.neoforged.neoforge.common.ItemAbilities.HOE_TILL, false);
            Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, changeIntoState(toolModifiedState));
            if (pair == null) {
                return InteractionResult.PASS;
            } else {
                Predicate<UseOnContext> predicate = pair.getFirst();
                Consumer<UseOnContext> consumer = pair.getSecond();
                if (predicate.test(context)) {
                    Player player = context.getPlayer();
                    level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (!level.isClientSide) {
                        consumer.accept(context);
                        if (player != null) {
                            context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                        }
                    }

                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else {
                    return InteractionResult.PASS;
                }
            }
    	}
    	return super.useOn(context);
    }
}
