import java.util.Random;//随机数需要导入这个包

class Animal{
    private String kind;
    public Animal(){}
    public Animal(String kind){
        this.kind=kind;//忘记给kind属性赋值了，若果创建属性，那么在构造方法里，必须给属性赋值。
        System.out.println(kind+"发出叫声:");
    }
    public void cry(){System.out.println("动物发出叫声");}
    public String getKind(){return kind;}
}
class Dog3 extends Animal{
    public Dog3(){
        super("Dog");
    }
    @Override
    public void cry(){
        System.out.println("汪汪汪");
    }
}
class Cat extends Animal{
    public Cat(){
        super("Cat");
    }
    @Override
    public void cry(){
        System.out.println("小猫喵喵叫");
    }
}
class Sheep extends Animal{
    public Sheep(){
        super("Sheep");
    }
    @Override
    public void cry(){
        System.out.println("小羊咩咩叫");
    }
}
class Chicken extends Animal{
    public Chicken(){
        super("Chicken");
    }
    @Override
    public void cry(){
        System.out.println("小鸡叽叽叫");
    }
}
public class java{
    public static void makeSound(Animal a){
        a.cry();
    }
    public static void main(String[] args){
        Animal[] animals=new Animal[5];
        Random random=new Random();//随机数工具
        for(int i=0;i<animals.length;i++){
            int num=random.nextInt(4);
            if(num==0){
                animals[i]=new Cat();
            }
            if(num==1){
                animals[i]=new Dog3();
            }
            if(num==2){
                animals[i]=new Sheep();
            }
            if(num==3){
                animals[i]=new Chicken();
            }
        }
        for(Animal a:animals){
           a.cry();
        }
        for(int i=0;i<animals.length;i++){
            makeSound(animals[i]);//假设这个方法里面还有其他的内容就可以直接使用
            System.out.println(animals[i].getKind());
        }


    }
}