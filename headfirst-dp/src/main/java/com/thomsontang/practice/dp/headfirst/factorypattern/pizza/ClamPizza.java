package com.thomsontang.practice.dp.headfirst.factorypattern.pizza;

import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.factory.PizzaIngredientFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/14/13
 */
public class ClamPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClam();
    }
}
