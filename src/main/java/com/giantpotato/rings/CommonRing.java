package com.giantpotato.rings;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Rarity;

public class CommonRing extends Item {

    //Common rings and their derivatives have these attributes
    public static final int durability = 256;
    public static final Rarity rarity = Rarity.UNCOMMON;
    public static ItemGroup group = Rings.advanced_group;
    public static StatusEffect effect = null;
    public static String name = null;
    public static String MODE = "Default Mode";

    public CommonRing(Settings settings, String mode) {
        super(settings.group(group).rarity(rarity).maxDamage(durability));
        this.MODE = mode;
    }

    public enum Mode {
        ACTIVE(true),
        INACTIVE(false);

        final boolean state;
        Mode(boolean state)
        {
            this.state = state;
        }
        public boolean getBoolean()
        {
            return state;
        }
    }
    public static void checkTag(ItemStack stack){
        if (!stack.isEmpty()) {
            if (!stack.hasTag()) {
                stack.setTag(new CompoundTag());
            }
            CompoundTag nbt = stack.getTag();

            if (!nbt.contains(MODE)) {
                nbt.putBoolean(MODE, false);
            }
        }
    }
    public boolean isActive(ItemStack stack){ return getMode(stack).getBoolean(); }
    public void toggleMode(ItemStack stack) {
        Mode currentMode = getMode(stack);
        if (currentMode.getBoolean()) {
            setMode(stack, Mode.INACTIVE);
            return;
        }
        setMode(stack, Mode.ACTIVE);
    }
    public static Mode getMode(ItemStack stack){
        if(!stack.isEmpty()){
            checkTag(stack);

            return stack.getTag().getBoolean(MODE) ? Mode.ACTIVE : Mode.INACTIVE;
        }
        return Mode.INACTIVE;
    }
    public static void setMode(ItemStack stack, Mode mode){
        checkTag(stack);
        stack.getTag().putBoolean(MODE, mode.getBoolean());
    }
}