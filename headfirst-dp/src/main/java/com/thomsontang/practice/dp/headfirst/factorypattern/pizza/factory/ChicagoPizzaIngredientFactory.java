package com.thomsontang.practice.dp.headfirst.factorypattern.pizza.factory;

import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.Cheese;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.Clam;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.Dough;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.FrozenClams;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.MozzarellaCheese;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.ThickCrustDough;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/14/13
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Clam createClam() {
        return new FrozenClams();
    }
}
