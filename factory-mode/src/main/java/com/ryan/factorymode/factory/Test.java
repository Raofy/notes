package com.ryan.factorymode.factory;

import com.ryan.factorymode.common.Drink;

public class Test {

    static void print(Drink[] c){
        for (Drink coffee : c) {
            System.out.println(coffee.getName());
        }
    }

    public static void main(String[] args) {
        ChinaCoffeeFactory chinaCoffeeFactory = new ChinaCoffeeFactory();
        Drink[] coffee = chinaCoffeeFactory.createCoffee();
        System.out.println("中国咖啡工厂：");
        print(coffee);

        AmericaCoffeeFactory americaCoffeeFactory = new AmericaCoffeeFactory();
        Drink[] coffee1 = americaCoffeeFactory.createCoffee();
        System.out.println("美国咖啡工厂：");
        print(coffee1);
    }
}
