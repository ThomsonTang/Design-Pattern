package designprinciples.lsp;

/**
 * 步枪类
 *
 * @author Thomson Tang
 */
public class Rifle extends AbstractGun {
    @Override public void shoot() {
        System.out.println("步枪冲锋......");
    }

//    @Override public void setShape(String color) {
//        super.setShape("步枪的形状");
//    }
}
