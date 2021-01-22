package com.giantpotato.rings;

import com.giantpotato.rings.registry.ModBlocks;
import net.minecraft.block.Block;

import java.util.ArrayList;
//TODO
public class GemOre {
    //Ore Generation Values
    public int maxY;
    public int minY;
    public int veinSize; //don't go less than 3
    public int veinsPerChunk; //20 is more common than diamond

    public void Gem(int maxY, int minY, int veinSize, int veinsPerChunk){
        this.maxY = maxY;
        this.minY = minY;
        this.veinSize = veinSize;
        this.veinsPerChunk = veinsPerChunk;
    }
}
