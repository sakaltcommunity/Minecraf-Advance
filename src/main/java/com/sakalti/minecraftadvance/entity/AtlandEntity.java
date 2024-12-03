package com.sakalti.minecraftadvance.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.NearestAttackableTargetGoal;

public class AtlandEntity extends Monster {

    public AtlandEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    // アトリビュートの定義
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
            .add(Attributes.MAX_HEALTH, 14.0D)       // 最大HP
            .add(Attributes.ARMOR, 6.0D)       // 防御力
            .add(Attributes.ARMOR_TOUGHNESS, 5.5D)       // タフネス
            .add(Attributes.ATTACK_DAMAGE, 8.0D)     // 攻撃力
            .add(Attributes.MOVEMENT_SPEED, 0.25D)   // 移動速度
            .add(Attributes.FOLLOW_RANGE, 16.0D);    // 追跡範囲
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true)); // 近接攻撃
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));      // ランダム移動
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F)); // プレイヤーを見る
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));         // 攻撃されたら反撃
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    protected int getExperienceReward(Player player) {
        return this.random.nextInt(3) + 4; // 経験値4～6をドロップ
    }
}
