package com.ryan.factorymode.AbstractFactory;

import com.ryan.factorymode.common.*;

public class ChinaDrinksFactory implements AbstractDrinksFactory{


    @Override
    public Coffee createCoffee() {
        return new Latte();
    }

    @Override
    public Tea createTea() {
        // TODO Auto-generated method stub
        return new MilkTea();
    }

    @Override
    public Sodas createSodas() {
        // TODO Auto-generated method stub
        return new XueBi();
    }
}
