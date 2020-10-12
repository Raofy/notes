package com.ryan.buildermode;

public class Computer {

    private String board;

    private String cpu;

    private String ram;

    private String disk;

    private String graphicsCard;

    @Override
    public String toString() {
        return "计算机配置：{" +
                "board='" + this.getBoard() + '\'' +
                ", cpu='" + this.getCpu() + '\'' +
                ", ram='" + this.getRam() + '\'' +
                ", disk='" + this.getDisk() + '\'' +
                ", graphicsCard='" + this.getGraphicsCard() + '\'' +
                '}';
    }

    public Computer() {
    }

    public Computer(String board, String cpu, String ram, String disk, String graphicsCard) {
        this.board = board;
        this.cpu = cpu;
        this.ram = ram;
        this.disk = disk;
        this.graphicsCard = graphicsCard;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }
}
