package designprinciples.srp;


/**
 * 单一职责原则 Single Responsibility Principle 场景类
 *
 * @author Thomson Tang
 */
public class Client {
    public static void main(String[] args) {
        Gun gun = new Gun();
        gun.shoot("手枪");
        gun.shoot("步枪");
        gun.shoot("机枪");

        gun.anotherShoot("水枪");
    }
}
