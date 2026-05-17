class Demo {
    // 静态变量，所有实例共享
    private static int count = 0;

    // 静态方法修改静态变量
    public static void staticAdd() {
        count++; // 直接修改静态变量
    }

    // 实例方法修改静态变量
    public void instanceAdd() {
        count++; // 也能修改静态变量
    }

    public static void main(String[] args) {
        Demo.staticAdd();       // 静态方法修改：count=1
        Demo d1 = new Demo();
        d1.instanceAdd();       // 实例方法修改：count=2
        Demo d2 = new Demo();
        d2.instanceAdd();       // 另一个对象修改：count=3

        System.out.println(count); // 输出 3
    }
}