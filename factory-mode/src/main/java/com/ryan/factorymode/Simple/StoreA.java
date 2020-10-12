package com.ryan.factorymode.Simple;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreA implements CarHome{

    @Override
    public void order() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("门店A下单时间：" + simpleDateFormat.format(new Date()));
    }
}
