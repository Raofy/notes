package com.ryan.factorymode.AbstractFactory;

import com.ryan.factorymode.common.Coffee;
import com.ryan.factorymode.common.Sodas;
import com.ryan.factorymode.common.Tea;

public interface AbstractDrinksFactory {

    /**
     * 制造咖啡
     * @return
     */
    Coffee createCoffee();

    /**
     * 制造茶
     * @return
     */
    Tea createTea();

    /**
     * 制造碳酸饮料
     * @return
     */
    Sodas createSodas();
}
