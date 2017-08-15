package com.thomson.dp.principle.hfdp.intro.impl;

import com.thomson.dp.principle.hfdp.intro.QuackBehavior;

/**
 * 鸭子叫声的实现类
 *
 * @author Thomson Tang
 * @version Created: 06/08/2017.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("real quacking...");
    }
}
