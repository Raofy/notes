package com.ryan.adaptermode.object;


import com.ryan.adaptermode.common.Socket;

/**
 * 对象适配器
 */
public class Test {


    public static void main(String[] args) {
        /**
         * 给iPhone手机充电
         *
         */
        Iphone iphone = new Iphone();

        //拿一个电源适配器
        ObjectAdapter objectAdapter = new ObjectAdapter(new Socket());

        iphone.getAdapter(objectAdapter);

    }

}
