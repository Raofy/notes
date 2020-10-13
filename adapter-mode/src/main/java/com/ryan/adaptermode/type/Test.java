package com.ryan.adaptermode.type;

/**
 * 类适配器
 */
public class Test {


    public static void main(String[] args) {
        /**
         * 给iPhone手机充电
         *
         */
        Iphone iphone = new Iphone();

        //拿一个电源适配器
        Adapter adapter = new Adapter();

        iphone.getAdapter(adapter);

    }

}
