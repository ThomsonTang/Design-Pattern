package com.thomsontang.practice.dp.headfirst.factorypattern.pizza;

import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.factory.PizzaIngredientFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/14/13
 */
public class CheesePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("------prepare " + name);
        dough = ingredientFactory.createDough();
        cheese = ingredientFactory.createCheese();
    }
}
