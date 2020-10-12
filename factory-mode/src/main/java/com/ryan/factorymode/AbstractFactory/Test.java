package com.ryan.factorymode.AbstractFactory;

import com.ryan.factorymode.common.Coffee;
import com.ryan.factorymode.common.Drink;
import com.ryan.factorymode.common.Sodas;
import com.ryan.factorymode.common.Tea;

public class Test {
    static void print(Drink drink){
        if(drink == null){
            System.out.println("产品：--" );
        }else{
            System.out.println("产品：" + drink.getName());
        }
    }

    public static void main(String[] args) {
        AbstractDrinksFactory chinaDrinksFactory = new ChinaDrinksFactory();
        Coffee coffee = chinaDrinksFactory.createCoffee();
        Tea tea = chinaDrinksFactory.createTea();
        Sodas sodas = chinaDrinksFactory.createSodas();
        System.out.println("中国饮品工厂有如下产品：");
        print(coffee);
        print(tea);
        print(sodas);

        AbstractDrinksFactory americaDrinksFactory = new AmericaDrinksFactory();
        coffee = americaDrinksFactory.createCoffee();
        tea = americaDrinksFactory.createTea();
        sodas = americaDrinksFactory.createSodas();
        System.out.println("美国饮品工厂有如下产品：");
        print(coffee);
        print(tea);
        print(sodas);
    }

}
