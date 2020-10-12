package com.ryan.buildermode;

public interface Builder {

    /**
     * 安装主板
     */
    void installBoard(String board);

    /**
     * 安装CPU
     */
    void installCpu(String cpu);

    /**
     * 安装内存
     */
    void installRam(String ram);

    /**
     * 安装硬盘
     */
    void installDisk(String disk);

    /**
     * 安装显卡
     */
    void installGraphicsCard(String card);

    Computer create();

}
