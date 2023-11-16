package net.astralturtle.astralsenchants.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;



public class LightningStrikerEnchantment extends Enchantment {
    public LightningStrikerEnchantment(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot... equipmentSlots) {
        super(rarity, enchantmentCategory, equipmentSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide()) {
            ServerLevel world = (ServerLevel) pAttacker.level();
            BlockPos pos = pTarget.blockPosition();

            for (int i = 0; i < pLevel; i++) {
                EntityType.LIGHTNING_BOLT.spawn(world, (ItemStack) null, null, pos, MobSpawnType.TRIGGERED, true, true);
            }


        }


        super.doPostAttack(pAttacker, pTarget, pLevel);
    }


    public int getMaxLevel() {
        return 3;
    }
}