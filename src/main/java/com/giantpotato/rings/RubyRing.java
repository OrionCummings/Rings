package com.giantpotato.rings;
//REFACTOR THIS
//I DIDN'T WRITE THIS
//DONT STEAL PEOPLES WORK
//https://gist.github.com/kwpugh/c3a6ded5240918e5e182dbd5b730e9d0

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RubyRing extends CommonRing{

    public RubyRing(Settings settings)
    {
        super(settings, "Attraction Mode");
    }
/*
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(!world.isClient && isActive(stack))
        {
            ServerPlayerEntity player = (ServerPlayerEntity) entity;
            MinecraftServer server = player.getServer();

            BlockPos playerPos = new BlockPos(player.getPos());

            // Check for a particular block that stops the attraction
            for (BlockPos targetPos : BlockPos.iterateOutwards(playerPos, 16, 5, 16))
            {
                BlockState blockstate = world.getBlockState(targetPos);
                Block block = blockstate.getBlock();

                if ((blockstate.getBlock() == Blocks.COAL_BLOCK))
                {
                    return;
                }

            }

            List<ItemEntity> entityItems = player.getServerWorld().getEntitiesByClass(ItemEntity.class, player.getBoundingBox().expand(16.0D), EntityPredicates.VALID_ENTITY);
            for (ItemEntity entityItemNearby : entityItems)
            {
                entityItemNearby.onPlayerCollision(player);
            }

            List<Entity> entityXP = player.getServerWorld().getEntitiesByClass(ExperienceOrbEntity.class, player.getBoundingBox().expand(16.0D), EntityPredicates.VALID_ENTITY);
            for (Entity entityXPNearby : entityXP)
            {
                entityXPNearby.onPlayerCollision(player);
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
    {
        ItemStack magnet = player.getStackInHand(hand);

        if (!world.isClient && !player.isSneaking())
        {
            toggleMode(magnet);

            return new TypedActionResult<>(ActionResult.SUCCESS, magnet);
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, magnet);
    }

    public boolean isActive(ItemStack magnet){ return getMagnetMode(magnet).getBoolean(); }

    public void setMagnetMode(ItemStack magnet, MagnetMode mode)
    {
        checkTag(magnet);
        magnet.getTag().putBoolean(this.mode, mode.getBoolean());
    }

    public MagnetMode getMagnetMode(ItemStack magnet)
    {
        if (!magnet.isEmpty())
        {
            checkTag(magnet);

            return magnet.getTag().getBoolean(this.mode) ? MagnetMode.ACTIVE : MagnetMode.INACTIVE;
        }
        return MagnetMode.INACTIVE;
    }

    public void toggleMode(ItemStack magnet)
    {
        MagnetMode currentMode = getMagnetMode(magnet);

        if (currentMode.getBoolean())
        {
            setMagnetMode(magnet, MagnetMode.INACTIVE);

            return;
        }

        setMagnetMode(magnet, MagnetMode.ACTIVE);
    }

    public void checkTag(ItemStack magnet)
    {
        if (!magnet.isEmpty())
        {
            if (!magnet.hasTag())
            {
                magnet.setTag(new CompoundTag());
            }
            CompoundTag nbt = magnet.getTag();

            if (!nbt.contains(this.mode))
            {
                nbt.putBoolean(this.mode, false);
            }
        }
    }

    public enum MagnetMode
    {
        ACTIVE(true), INACTIVE(false);

        final boolean state;

        MagnetMode(boolean state)
        {
            this.state = state;
        }

        public boolean getBoolean()
        {
            return state;
        }
    }

    public boolean hasGlint(ItemStack magnet)
    {
        return isActive(magnet);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        boolean status = isActive(itemStack);
        tooltip.add(new TranslatableText("item.ruby_ring.line1").formatted(Formatting.GREEN));
        tooltip.add(new TranslatableText("item.ruby_ring.line2").formatted(Formatting.YELLOW));
        tooltip.add(new TranslatableText("item.ruby_ring.line3", status).formatted(Formatting.LIGHT_PURPLE));
    }
 //*/
}
