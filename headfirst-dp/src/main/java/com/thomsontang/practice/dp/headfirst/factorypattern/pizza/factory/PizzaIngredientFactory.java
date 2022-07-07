package com.thomsontang.practice.dp.headfirst.factorypattern.pizza.factory;

import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.Cheese;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.Clam;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.Dough;

/**
 * An interface for the factory that is going to create all our ingredients.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/14/13
 */
public interface PizzaIngredientFactory {
    Dough createDough();

    Cheese createCheese();

    Clam createClam();
}
