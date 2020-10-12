package com.ryan.factorymode.Simple;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        CarHome storeA = CarHomeFactory.createCarHome("storeA");
        storeA.order();
        Thread.sleep(2000);
        CarHome storeB = CarHomeFactory.createCarHome("storeB");
        storeB.order();
    }
}
