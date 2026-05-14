class Dog {
    private String name;
    private int age;

    //含参构造的构造方法
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //实例构造方法1：输出信息
    public void printInfo() {
        System.out.println("Dog's name" + this.name + "Dog's age" + this.age);
    }
    //方法2：调用同一个类里的方法
    public void show(){
        System.out.println("准备调用printInfo的方法");
        this.printInfo();//调用当前对象的方法
    }
}
public class UsingThis {
    public static void main(String[] args){
        Dog d1=new Dog("sbh",20);
        d1.printInfo();
        d1.show();
    }
};
