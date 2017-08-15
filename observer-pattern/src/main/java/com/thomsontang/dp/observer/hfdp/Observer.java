package com.thomsontang.dp.observer.hfdp;

/**
 * The Observer interface is implemented by all observers.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @date 7/26/13
 */
public interface Observer {
    /**
     * update the state values from the subject when a weather measurement changed.
     *
     * @param temp     温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    void update(float temp, float humidity, float pressure);
}
