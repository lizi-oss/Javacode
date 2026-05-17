class Person1{
    private  String name="未知";
    private int age=0;
    private String sex="未知";

    public Person1(){
        System.out.println("无参构造初始化的内容，姓名："+name+"年龄："+age+"性别："+sex);
    }
    public Person1(String name,int age,String sex){
        this.name=name;
        this.age=age;
        this.sex=sex;
    }

    public void shouInfo(){
        System.out.println("已知人类的信息，姓名："+name+"年龄："+age+"性别："+sex);
    }
}

class Student extends  Person1{
    private int xuehao=0000000;

    public Student(){}
    public Student(String name,int age,String sex,int xuehao){
        super(name,age,sex);
        this.xuehao=xuehao;
    }

    @Override
    public void shouInfo(){
        super.shouInfo();
        System.out.println("已知学生的学号："+xuehao);
    }

}
public class text2 {
    public static void main(String[] args){

        Person1 P1 =new Person1();
        P1.shouInfo();
        Person1 P2 =new Person1("pp",23,"男");
        P2.shouInfo();

        Student s1=new Student();
        s1.shouInfo();
        Student s2=new Student("yy",18,"女",202858678);
        s2.shouInfo();

    }
}
