package com.thomson.practice.dp.hf.factory.factorymethod;

import com.thomson.practice.dp.hf.factory.entity.Pizza;

/**
 * the abstract PizzaStore.
 *
 * @author Thomson Tang
 */
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
