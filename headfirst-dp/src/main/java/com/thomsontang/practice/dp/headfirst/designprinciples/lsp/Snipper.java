package designprinciples.lsp;

/**
 * AUG狙击手类
 *
 * @author Thomson Tang
 */
public class Snipper extends Solider {
    public void killEnemy(AUG aug) {
        //首先观察敌人，精确瞄准目标
        aug.zoomOut();

        //开始射击
        aug.shoot();
    }
}
