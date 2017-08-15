package com.thomson.dp.principle.zen.dip;

/**
 * 宝马汽车
 *
 * @author Thomson Tang
 */
public class BMW implements ICar {
    @Override
    public void run() {
        System.out.println("宝马汽车开始运行......");
    }
}
