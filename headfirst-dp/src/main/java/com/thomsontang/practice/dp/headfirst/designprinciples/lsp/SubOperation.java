package designprinciples.lsp;

/**
 * 实现两个数相减，再与100求和
 *
 * @author Thomson Tang
 */
public class SubOperation extends Operation {
    /**
     * 两个数相减
     * @param a
     * @param b
     * @return
     */
    public int m1(int a, int b) {
        return a - b;
    }

    /**
     * 再与100求和
     * @param a
     * @param b
     * @return
     */
    public int m2(int a, int b) {
        return m1(a, b) + 100;
    }
}
