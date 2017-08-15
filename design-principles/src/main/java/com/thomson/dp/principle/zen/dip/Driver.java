package com.thomson.dp.principle.zen.dip;

/**
 * 司机实现类
 *
 * @author Thomson Tang
 */
public class Driver implements IDriver {
    private ICar car = null;

    @Override
    public void drive() {
        this.car.run();
    }

    @Override
    public void setCar(ICar car) {
        this.car = car;
    }
}
