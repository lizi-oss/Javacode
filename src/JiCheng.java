/*继承的作用是优化代码的编写，减少冗余代码的编写。方便修改代码，减少代码量。
子类只能继承一个父类，利用super去访问父类的成员。
super（）；super（name）；这是访问父类的构造方法
super.name;访问父类的属性
super.print();访问父类的方法*/
/*
super的注意事项：
在子类的构造方法中调用，且必须是第一句。
*/
//抽象父类：定义通用模板
 abstract class Pet1{
    String name;
    int age;

    public Pet1(String nsme,int age){
        this.name=name;
        this.age=age;
    }
    //抽象方法：没有实现必须让子类重写
    public abstract void print();
}
 class Dog2 extends Pet1{
     public Dog2(String name,int age){
         super(name,age);
     }
     //重写父类的抽象方法，给出具体实现
    @Override
    public void print (){
        System.out.println("这只狗叫" + name + "，今年" + age + "岁");
    }
}


public class JiCheng {
     public static void main(String[] args){
//         Pet pet=new Pet("beb",20);错误原因：不能实例化抽象类，里面有抽象方法并未实现。只要一个类有abstract这个抽象方法就不能被实例化。
         Dog2 dog=new Dog2("bei",20);
         dog.print();

     }
}
