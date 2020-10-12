package com.ryan.agencymodel.staticproxy;

/**
 * 代理角色
 */
public class Proxy implements Rent {

    private Host host;

    public Proxy() {

    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        this.sell();
        host.rent();
        this.tip();
    }

    public void sell() {
        System.out.println("推销");
    }

    public void tip() {
        System.out.println("收取中介费用");
    }
}

