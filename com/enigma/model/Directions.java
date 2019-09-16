package com.enigma.model;

public enum Directions {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Directions getLeft(){
        return Directions.values()[(ordinal()+3)%4];
    }
    public Directions getRight(){
        return Directions.values()[(ordinal()+1)%4];
    }
    public Directions getBackward(){
        return Directions.values()[(ordinal()+2)%4];
    }
    public void cekValid (String dir) {
    }

}
