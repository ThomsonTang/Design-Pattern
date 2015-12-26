package designprinciples.lsp;

/**
 * 里氏替换原则普通枪场景类
 *
 * @author Thomson Tang
 */
public class GunClient {
    public static void main(String[] args) {
        /******************实例1. 给士兵配发枪支杀人*****************/
        //产生三毛这个士兵
        Solider sanMao = new Solider();

        //给三毛配发一支枪，这儿给发了一支步枪
        AbstractGun gun = new Rifle();
        gun.setShape("步枪形状");
        sanMao.setGun(gun);
        //三毛杀敌
        sanMao.killEnemy();
        /***************************************************/

        /***************实例2.新增一个玩具枪****************/
        //给三毛分配玩具枪，士兵拿玩具枪杀敌失败，这已是不正常得业务逻辑处理了
        //这种情况下，应该将ToyGun脱离继承，建立一个独立的父类。
//        sanMao.setGun(new ToyGun());
        //杀敌失败
//        sanMao.killEnemy();
        /***************************************************/

        /******************实例3.小孩玩玩具枪***************/
        Kid xiaoMei = new Kid();
        ToyGun toyGun = new ToyGun();
        AbstractGun gun1 = new MachineGun();
        gun1.setShape("手枪形状");
        toyGun.setGun(gun1);
        xiaoMei.setToy(toyGun);
        xiaoMei.play();
        /*************************************************/

    }
}
