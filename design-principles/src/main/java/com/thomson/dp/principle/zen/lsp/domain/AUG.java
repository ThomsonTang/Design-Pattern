package com.thomson.dp.principle.zen.lsp.domain;

/**
 * AUG狙击枪
 *
 * @author Thomson Tang
 */
public class AUG extends Rifle {
    //狙击枪会携带一个精准的望远镜，这就是子类AUG特有的个性方法
    public void zoomOut() {
        System.out.println("用望远镜瞄准敌人......");
    }

    @Override public void shoot() {
        System.out.println("用AUG狙击枪射击......");
    }
}
