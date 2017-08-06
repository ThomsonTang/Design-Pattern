package com.thomson.practice.srp;

/**
 * "车辆可以载客"的场景类
 *
 * @author Thomson Tang
 * @version Created: 21/02/2017.
 */
public class Client {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.carry("car"); //汽车可以载客
        vehicle.carry("bike"); //自行车可以载客
        vehicle.carry("toy car"); //玩具车不能载客，所以这儿违背SRP原则
    }
}
