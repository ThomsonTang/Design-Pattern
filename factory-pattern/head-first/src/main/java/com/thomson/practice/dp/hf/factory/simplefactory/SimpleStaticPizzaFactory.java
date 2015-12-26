package com.thomson.practice.dp.hf.factory.simplefactory;

import com.thomson.practice.dp.hf.factory.entity.CheesePizza;
import com.thomson.practice.dp.hf.factory.entity.GreekPizza;
import com.thomson.practice.dp.hf.factory.entity.Pizza;

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
