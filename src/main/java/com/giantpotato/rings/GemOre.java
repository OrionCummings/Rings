package com.giantpotato.rings;

public class GemOre{
    public int maxY;
    public int minY;
    public int veinSize;
    public int veinsPerChunk;

    public GemOre(int maxY, int minY, int veinSize, int veinsPerChunk){
        this.maxY = maxY;
        this.minY = minY;
        this.veinSize = veinSize;
        this.veinsPerChunk = veinsPerChunk;
    }

    public int getMaxY(){return maxY;}
    public int getMinY(){return minY;}
    public int getVeinSize(){return veinSize;}
    public int getVeinsPerChunk(){return veinsPerChunk;}

}
