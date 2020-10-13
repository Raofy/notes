package com.ryan.adaptermode.type;

import com.ryan.adaptermode.common.Line;
import com.ryan.adaptermode.common.Socket;

public class Adapter extends Socket implements Line {


    private String change220To5() {
        String source = super.outElectricity();
        System.out.println(source + "经过充电器转化为5v电压");
        source = "5v电压";
        return source;
    }

    @Override
    public void getElectricity() {
        this.change220To5();
        System.out.println("手机已经充上电了");
    }
}
