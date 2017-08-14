package com.thomsontang.dp.factory.hfdp;

import com.thomson.practice.dp.hf.factory.entity.Pizza;

/**
 * 客户端调用类
 *
 * @author Thomson Tang
 */
public class PizzaStore {

    private SimplePizzaFactory factory;

    public Pizza orderPizza(String type) {
        Pizza pizza;
        //直接调用静态工厂来生成Pizza对象
        //        pizza = SimpleStaticPizzaFactory.createPizza(type);

        //使用工厂来创建披萨
        pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
