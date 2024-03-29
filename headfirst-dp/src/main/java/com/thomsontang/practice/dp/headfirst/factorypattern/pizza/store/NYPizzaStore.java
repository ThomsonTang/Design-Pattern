package com.thomsontang.practice.dp.headfirst.factorypattern.pizza.store;

import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.CheesePizza;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.ClamPizza;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.Pizza;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.factory.NYPizzaIngredientFactory;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.factory.PizzaIngredientFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/13/13
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        }

        return pizza;
    }
}
