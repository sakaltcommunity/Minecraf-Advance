package com.sakalti.minecraftadvance.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.damagesource.DamageSource;

public class FireSpiderEntity extends Monster {

    public FireSpiderEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    // 属性設定
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
            .add(Attributes.MAX_HEALTH, 34.0D)        // HP
            .add(Attributes.ATTACK_DAMAGE, 6.0D)      // 攻撃力
            .add(Attributes.MOVEMENT_SPEED, 0.3D);    // 移動速度
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true)); // 攻撃
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D)); // ランダム移動
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F)); // プレイヤーを見る
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this)); // ランダムに見る
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this)); // 反撃
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true)); // プレイヤーを狙う
    }

    @Override
    public boolean doHurtTarget(net.minecraft.world.entity.Entity target) {
        boolean flag = super.doHurtTarget(target);
        if (flag && target.isAlive()) {
            target.setSecondsOnFire(5); // 火をつける（5秒間）
        }
        return flag;
    }

    @Override
    protected int getExperienceReward(Player player) {
        return this.random.nextInt(5) + 4; // 経験値4～8
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {
        super.dropCustomDeathLoot(source, looting, recentlyHit);
        this.spawnAtLocation(net.minecraft.world.item.Items.GUNPOWDER, 1 + looting); // 火薬
        this.spawnAtLocation(net.minecraft.world.item.Items.SPIDER_EYE, this.random.nextInt(2) + looting); // 蜘蛛の目
    }
}
