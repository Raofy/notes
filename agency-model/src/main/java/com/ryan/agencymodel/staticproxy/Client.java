package com.ryan.agencymodel.staticproxy;

public class Client {

    public static void main(String[] args) {

        //出租资源
        Host host = new Host();

        //中介接盘
        Proxy proxy = new Proxy(host);

        //客户租赁
        proxy.rent();
    }
}
