class HasStatic{
    private static int x = 100; // 初始值：x = 100

    public static void main(String args[ ]) {
        HasStatic hs1 = new HasStatic();
        hs1.x++; // 操作静态变量，x = 100 + 1 = 101

        HasStatic hs2 = new HasStatic();
        hs2.x++; // 还是操作同一个静态变量，x = 101 + 1 = 102

        hs1 = new HasStatic();
        hs1.x++; // 依然操作同一个静态变量，x = 102 + 1 = 103

        HasStatic.x--; // 直接用类名操作静态变量，x = 103 - 1 = 102

        System.out.println("x=" +x); // 输出：x=102
    }
}