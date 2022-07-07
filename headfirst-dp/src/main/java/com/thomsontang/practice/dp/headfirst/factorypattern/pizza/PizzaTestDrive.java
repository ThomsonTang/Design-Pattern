package com.thomsontang.practice.dp.headfirst.factorypattern.pizza;

import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.store.ChicagoPizzaStore;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.store.NYPizzaStore;
import com.thomsontang.practice.dp.headfirst.factorypattern.pizza.store.PizzaStore;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 8/13/13
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("I ordered a " + pizza.getName());

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("You ordered a " + pizza.getName());
    }
}
