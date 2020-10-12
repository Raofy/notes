package com.ryan.buildermode;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Computer create(String board, String cpu, String ram, String disk, String graphicsCard) {
        this.builder.installBoard(board);
        this.builder.installCpu(cpu);
        this.builder.installRam(ram);
        this.builder.installDisk(disk);
        this.builder.installGraphicsCard(graphicsCard);
        return this.builder.create();
    }
}
