package com.thomsontang.dp.factory.hfdp.factory;

import com.thomson.practice.dp.hf.factory.entity.CheesePizza;
import com.thomson.practice.dp.hf.factory.entity.GreekPizza;
import com.thomson.practice.dp.hf.factory.entity.Pizza;

/**
 * the simple pizza factory.
 *
 * @author Thomson Tang
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        } else if ("greek".equals(type)) {
            pizza = new GreekPizza();
        }
        return pizza;
    }
}
