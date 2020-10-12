package com.ryan.factorymode.factory;

import com.ryan.factorymode.common.Cappuccino;
import com.ryan.factorymode.common.Coffee;
import com.ryan.factorymode.common.Latte;

public class ChinaCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee[] createCoffee() {
        return new Coffee[] {new Cappuccino(), new Latte()};
    }
}
