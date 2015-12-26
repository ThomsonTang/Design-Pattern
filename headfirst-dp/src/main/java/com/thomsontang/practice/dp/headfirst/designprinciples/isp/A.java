package designprinciples.isp;

/**
 * Created by Intellij idea.
 *
 * @author Thomson Tang
 */
public class A {
    public void depend1(I i) {
        i.method1();
    }

    public void depend2(I i) {
        i.method2();
    }

    public void depend3(I i) {
        i.method3();
    }
}
