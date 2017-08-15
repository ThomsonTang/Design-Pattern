package com.thomson.dp.principle.zen.lsp.domain;

/**
 * 玩具枪实现类
 *
 * @author Thomson Tang
 */
public class ToyGun extends AbstractToy {
    //玩具枪组合真枪，通过委托来获得真枪的属性，比如形状、声音等
    private AbstractGun gun;

    @Override public void bePlayed() {
        System.out.println("玩具的形状是：" + gun.getShape());
    }

    //给玩具枪设置一个真枪当做模型
    public void setGun(AbstractGun gun) {
        this.gun = gun;
    }
    //    /**
    //     * 玩具枪不能用来射击杀人，所以shoot方法实现为空就行了
    //     */
    //    @Override public void shoot() {
    //
    //    }
}
