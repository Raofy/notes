package com.ryan.factorymode.factory;

import com.ryan.factorymode.common.Coffee;

/**
 * 定义一个coffee抽象工厂
 *
 */
public interface CoffeeFactory {

    Coffee[] createCoffee();
}
