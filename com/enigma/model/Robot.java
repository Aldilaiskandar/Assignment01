package com.enigma.model;

public class Robot {
    private Integer postX;
    private Integer postY;
    private Directions DIR;
    private Integer fuel=0;
    private final String FORWARD = "F";
    private final String BACKWARD = "B";
    private final String RIGHT = "R";
    private final String LEFT = "L";
    private char [] commands;

    public Robot(Integer x, Integer y, Directions dir) {
        this.postX = x;
        this.postY = y;
        this.DIR = dir;
    }

    public Integer fillFuel(Integer fuel){
        this.fuel= this.fuel + fuel;
        return fuel;
    }

    void turnRight(){
        this.DIR = this.DIR.getRight();
    }

    void turnLeft(){
        this.DIR = this.DIR.getLeft();
    }

    public void move(String movement) {
        if (movement.equals(RIGHT)) {
            turnRight();
        } else if (movement.equals(LEFT)) {
            turnLeft();
        } else if (movement.equals(FORWARD)) {
            moveForward();
        } else if (movement.equals(BACKWARD)) {
            moveBackward();
        }else {
            System.out.println("huruf " + movement + " ini SALAH PERINTAH!!! ");
            System.out.println(print());
            System.exit(0);
        }
    }

    public void moveForward(){
        if (this.DIR.equals(Directions.NORTH)) {
            this.postY++;
        }
        if (this.DIR.equals(Directions.EAST)) {
            this.postX++;
        }
        if (this.DIR.equals(Directions.SOUTH)) {
            this.postY--;
        }
        if (this.DIR.equals(Directions.WEST)) {
            this.postX--;
        }
    }

    public void moveBackward(){
        if (this.DIR.equals(Directions.NORTH)) {
            this.postY--;
        }
        if (this.DIR.equals(Directions.EAST)) {
            this.postX--;
        }
        if (this.DIR.equals(Directions.SOUTH)) {
            this.postY++;
        }
        if (this.DIR.equals(Directions.WEST)) {
            this.postX++;
        }
    }


    public String setCommands(String commands){
        this.commands = commands.toCharArray();
        return commands;
    }

    public void run(){
        for(int i=0;i<this.commands.length;i++){
            if(this.fuel<=0){
                System.out.println("ROBOT MATI GAN!!! BATTERY HABIS!");
                break;
            }else {
                move(String.valueOf(this.commands[i]));
                System.out.println(this.commands[i] + getPost() + this.DIR);
                if((i+1)%3==0){
                    this.fuel--;
                }
            }
        }
    }

    public String getPost(){
        return "("+this.postX+","+this.postY+")";
    }
    public String print() {
        return "Your Robot Status{" +
                "postX =" + postX +
                ", postY =" + postY +
                ", Battery =" + fuel+
                ", Direction =" + this.DIR+
                '}';
    }
}
