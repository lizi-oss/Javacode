/**
 * 这是一个演示JavaDoc注释用法的工具类
 * <p>该类提供了两个常用的数学运算方法，用于展示JavaDoc注释的基础格式与标签用法</p>
 *
 * @author 豆包
 * @version 1.0
 * @since 2026-05-14
 */
public class Dome1 {

    /**
     * 计算两个整数的和
     *
     * @param a 第一个加数，支持正负整数
     * @param b 第二个加数，支持正负整数
     * @return 两个整数相加的结果，int类型
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * 计算两个整数的差
     *
     * @param a 被减数
     * @param b 减数
     * @return 两个整数相减的结果，int类型
     */
    public static int subtract(int a, int b) {
        return a - b;
    }

    /**
     * 主方法，用于测试MathUtils类的方法
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        int sum = add(5, 3);
        int difference = subtract(10, 4);
        System.out.println("5 + 3 = " + sum);
        System.out.println("10 - 4 = " + difference);
    }
}
