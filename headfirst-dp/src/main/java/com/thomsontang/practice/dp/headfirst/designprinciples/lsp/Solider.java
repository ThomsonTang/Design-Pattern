package designprinciples.lsp;

/**
 * 士兵的实现类
 *
 * @author Thomson Tang
 */
public class Solider {

    /**
     * 士兵拥有枪支，
     * <p>这把枪是抽象的，是枪就有shoot方法，也就可以杀人，<br>
     * 具体是什么枪，在上战场前通过setGun方法来确定</p>
     */
    private AbstractGun gun;

    /**
     * 士兵可以杀敌
     * <p>杀敌的方式是士兵调用枪支的shoot方法</p>
     */
    public void killEnemy() {
        System.out.println("士兵开始杀敌.....");
        System.out.println("士兵用的枪的形状是：" + gun.getShape());
        gun.shoot();
    }

    /**
     * 给士兵配备一支枪
     *
     * @param gun 枪
     */
    public void setGun(AbstractGun gun) {
        this.gun = gun;
    }
}
