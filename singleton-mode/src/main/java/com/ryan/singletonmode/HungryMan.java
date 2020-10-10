package com.ryan.singletonmode;

/**
 * 饿汉式单例模式
 */
public class HungryMan {

    private static HungryMan hmInstance = new HungryMan();

    private HungryMan() {

    }

    public static HungryMan getInstance() {
        return hmInstance;
    }

}
