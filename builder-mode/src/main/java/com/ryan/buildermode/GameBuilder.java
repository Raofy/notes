package com.ryan.buildermode;

public class GameBuilder implements Builder {

    private Computer computer = new Computer();

    @Override
    public void installBoard(String board) {
        computer.setBoard(board);
    }

    @Override
    public void installCpu(String cpu) {
        computer.setCpu(cpu);
    }

    @Override
    public void installRam(String ram) {
        computer.setRam(ram);
    }

    @Override
    public void installDisk(String disk) {
        computer.setDisk(disk);
    }

    @Override
    public void installGraphicsCard(String graphiceCard) {
        computer.setGraphicsCard(graphiceCard);
    }

    @Override
    public Computer create() {
        return this.computer;
    }
}
