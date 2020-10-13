package com.ryan.buildermode;

public class Client {

    public static void main(String[] args) {
        /**
         * 客户要求组装一台办公配置的计算机
         *
         */
        OfficeBuilder officeBuilder = new OfficeBuilder();
        Director director = new Director(officeBuilder);
        Computer computer = director.create("技嘉主板", "锐龙CPU", "七彩虹内存条", "希捷硬盘", "集成显卡");
        System.out.println(computer.toString());

        /**
         * 客户要求组装一台游戏配置的计算机
         *
         */
        GameBuilder gameBuilder = new GameBuilder();
        Director director1 = new Director(gameBuilder);
        Computer computer1 = director1.create("技嘉主板", "因特尔CPU", "三星内存条", "希捷硬盘", "1050ti显卡");
        System.out.println(computer1.toString());


        /**
         * 没有抽象建造者和指挥者的建造者模式
         */
        ComputerB computerB = new ComputerB.ComputerBuilder("主板", "cpu", "hd", "希捷", "显卡")
                .setMouse("鼠标").setMousePad("垫子").build();

        System.out.println(computerB.toString());
    }

}
