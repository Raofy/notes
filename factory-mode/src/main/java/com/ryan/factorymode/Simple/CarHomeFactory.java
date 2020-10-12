package com.ryan.factorymode.Simple;

public class CarHomeFactory {

    public static CarHome createCarHome(String store) {
        switch (store) {
            case "storeA":
                return new StoreA();
            case "storeB":
                return new StoreB();
            default:
                throw new RuntimeException("门店不存在");
        }
    }
}
