package designprinciples.dip;

/**
 * 奔驰汽车
 *
 * @author Thomson Tang
 */
public class Benz implements ICar {
    @Override public void run() {
        System.out.println("奔驰汽车开始运行......");
    }
}
