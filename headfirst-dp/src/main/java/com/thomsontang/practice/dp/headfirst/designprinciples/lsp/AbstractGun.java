package designprinciples.lsp;

public abstract class AbstractGun {
    /**
     * 枪都会有形状
     */
    private String shape;

    //枪是用来杀敌的
    public abstract void shoot();

    //设置枪的形状
    public void setShape(String shape) {
        this.shape = shape;
    }

    /**
     * 获取枪的形状
     *
     * @return 枪得形状
     */
    public String getShape() {
        return shape;
    }
}

