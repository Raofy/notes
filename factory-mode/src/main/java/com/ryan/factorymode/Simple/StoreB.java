package com.ryan.factorymode.Simple;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreB implements CarHome{

    @Override
    public void order() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("门店B下单时间：" + simpleDateFormat.format(new Date()));
    }
}
