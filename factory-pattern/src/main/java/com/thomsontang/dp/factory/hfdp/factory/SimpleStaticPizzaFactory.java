package com.thomsontang.dp.factory.hfdp.factory;

import com.thomsontang.dp.factory.hfdp.domain.CheesePizza;
import com.thomsontang.dp.factory.hfdp.domain.GreekPizza;
import com.thomsontang.dp.factory.hfdp.domain.Pizza;

/**
 * the static factory method.
 *
 * @author Thomson Tang
 */
public class SimpleStaticPizzaFactory {

    public static Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        } else if ("greek".equals(type)) {
            pizza = new GreekPizza();
        }
        return pizza;
    }
}
