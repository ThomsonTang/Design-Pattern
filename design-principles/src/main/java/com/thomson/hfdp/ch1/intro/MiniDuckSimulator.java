package com.thomson.hfdp.ch1.intro;

import com.thomson.hfdp.ch1.intro.impl.FlyRocketPowered;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 07/08/2017.
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
