package com.thomsontang.practice.dp.headfirst.factorypattern.pizza.store;

import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.ChicagoStyleCheesePizza;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.Pizza;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/13/13
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }
}
