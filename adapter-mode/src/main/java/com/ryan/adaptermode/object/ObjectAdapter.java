package com.ryan.adaptermode.object;

import com.ryan.adaptermode.common.Line;
import com.ryan.adaptermode.common.Socket;

public class ObjectAdapter implements Line {

    private Socket socket;

    public ObjectAdapter(Socket socket) {
        this.socket = socket;
    }

    private String change220To5() {
        String source = socket.outElectricity();
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
