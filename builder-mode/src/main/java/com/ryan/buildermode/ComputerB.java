package com.ryan.buildermode;

/**
 * 替代多参构造的建造者模式
 */
public class ComputerB {

    private String board;

    private String cpu;

    private String ram;

    private String disk;

    private String graphicsCard;

    // 其它一些可选配置
    private String mouse ; // 鼠标
    private String computerCase ; //机箱
    private String mousePad ;   //鼠标垫
    private String other ;  //其它配件


    public ComputerB() {
    }

    @Override
    public String toString() {
        return "ComputerB{" +
                "board='" + board + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", disk='" + disk + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", mouse='" + mouse + '\'' +
                ", computerCase='" + computerCase + '\'' +
                ", mousePad='" + mousePad + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public ComputerB (ComputerBuilder computerBuilder) {
        this.board = computerBuilder.getBoard();
        this.cpu = computerBuilder.getCpu();
        this.ram = computerBuilder.getRam();
        this.disk = computerBuilder.getDisk();
        this.graphicsCard = computerBuilder.getGraphicsCard();
        this.mouse = computerBuilder.mouse ;
        this.computerCase = computerBuilder.computerCase ;
        this.mousePad = computerBuilder.mousePad ;
        this.other = computerBuilder.other ;

    }

    public static class ComputerBuilder {
        // 一个电脑的必须配置
        private String board ;     // 主板
        private String cpu ;           // cpu
        private String ram;
        private String disk;
        private String graphicsCard;

        // 其它一些可选配置
        private String mouse ; // 鼠标
        private String computerCase ; //机箱
        private String mousePad ;   //鼠标垫
        private String other ;  //其它配件

        public ComputerB build() {
            return new ComputerB(this);
        }

        public ComputerBuilder(String board, String cpu, String ram, String disk, String graphicsCard) {
            this.board = board;
            this.cpu = cpu;
            this.ram = ram;
            this.disk = disk;
            this.graphicsCard = graphicsCard;
        }

        public String getBoard() {
            return board;

        }

        public ComputerBuilder setBoard(String board) {
            this.board = board;
            return this;
        }

        public String getCpu() {
            return cpu;
        }

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public String getRam() {
            return ram;
        }

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public String getDisk() {
            return disk;
        }

        public ComputerBuilder setDisk(String disk) {
            this.disk = disk;
            return this;
        }

        public String getGraphicsCard() {
            return graphicsCard;
        }

        public ComputerBuilder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public String getMouse() {
            return mouse;
        }

        public ComputerBuilder setMouse(String mouse) {
            this.mouse = mouse;
            return this;
        }

        public String getComputerCase() {
            return computerCase;
        }

        public ComputerBuilder setComputerCase(String computerCase) {
            this.computerCase = computerCase;
            return this;
        }

        public String getMousePad() {
            return mousePad;
        }

        public ComputerBuilder setMousePad(String mousePad) {
            this.mousePad = mousePad;
            return this;
        }

        public String getOther() {
            return other;
        }

        public ComputerBuilder setOther(String other) {
            this.other = other;
            return this;
        }
    }
}
