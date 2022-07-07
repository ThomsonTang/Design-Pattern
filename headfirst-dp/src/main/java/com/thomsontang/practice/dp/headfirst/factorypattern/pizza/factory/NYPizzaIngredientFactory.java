package com.thomsontang.practice.dp.headfirst.factorypattern.pizza.factory;

import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.Cheese;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.Clam;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.Dough;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.FreshClams;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.ReggianoCheese;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.ThinCrustDough;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/14/13
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Clam createClam() {
        return new FreshClams();
    }
}
