package designprinciples.dip;

/**
 * DIP依赖导致原则场景类
 *
 * @author Thomson Tang
 */
public class Client {
    public static void main(String[] args) {
        IDriver driver = new Driver();
        ICar car = new BMW(); //生成一辆宝马车
        driver.setCar(car);
        driver.drive();
    }
}
