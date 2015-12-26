package designprinciples.lsp;

/**
 * 小孩实现类
 *
 * @author Thomson Tang
 */
public class Kid {

    /**
     * 小孩拥有自己的玩具
     */
    private AbstractToy toy;

    /**
     * 小孩玩玩具枪
     */
    public void play() {
        System.out.println("小孩开始玩玩具.......");
        toy.bePlayed();
    }

    /**
     * 给小孩一个玩具
     *
     * @param toy 玩具
     */
    public void setToy(AbstractToy toy) {
        this.toy = toy;
    }
}
