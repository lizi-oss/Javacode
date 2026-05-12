class Person {
    // 成员变量
    private String name;
    private int age;

    // 构造方法
    public Person() {
        System.out.println("无参构造执行了");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 成员方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void show() {
        System.out.println("姓名：" + name + "，年龄：" + age);
    }
}

// 测试类
public class Main{
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("张三");
        p.setAge(20);
        p.show();

        Person p2 = new Person("李四", 25);
        p2.show();
    }
}