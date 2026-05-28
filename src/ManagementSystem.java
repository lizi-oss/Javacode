class  Notcar{
    private String color;
    private String  brand;
    private int wheel;
    private int chair;
    public Notcar(){
        //如果父类有默认值,写在无参构造里面。
        this.color = "red";
        this.brand = "天宇";
        this.wheel = 4;
        this.chair = 2;
    };
    public Notcar(String color,String brand,int wheel,int chair){
        this.color=color;
        this.brand=brand;
        this.wheel=wheel;
        this.chair=chair;
    }
    public String getColor(){return color;}
    public String getBrand(){return brand;}
    public int getWheel(){return wheel;}
    public int getChair(){return chair;}

    public void setColor(String color) {this.color = color;}
    public void setBrand(String brand) {this.brand = brand;}
    public void setWheel(int wheel) {this.wheel = wheel;}
    public void setChair(int chair) {this.chair = chair;}

    public void show(){
        System.out.println("这是一辆" + color + "颜色的，" + brand + "，有" + wheel + "个轮子，有" + chair + "个座椅");
    }
}
class Cycle extends Notcar{
    public Cycle(String color,String brand){
        super(color,brand,2,1);
    }
    @Override
    public void show(){
        System.out.println("这是一辆" + getColor() + "颜色的，" + getBrand() + "的自行车");
    }
}
class Electricvehicle extends Notcar{
    private String batteryBrand;
    public Electricvehicle(String color,String brand,String batteryBrand) {
        super(color,brand,2,1);
        this.batteryBrand=batteryBrand;
    }
    @Override
    public void show(){
        System.out.println("这是一辆使用" + batteryBrand + "牌电池的电动车");
    }
}
class Tricycle extends Notcar{
    public Tricycle (String color,String brand,int chair){
        super(color,brand,3,chair);
    }
    @Override
    public void show(){
        System.out.println("三轮车是一款有" + getWheel() + "个轮子的非机动车");
    }

}

public class ManagementSystem {
    public static void main(String args[]){
        Notcar n=new Notcar();
        n.show();
        Cycle c=new Cycle("yellow","捷安特牌的自行车");
        c.show();
        Electricvehicle e=new Electricvehicle("white","特斯拉的电动车","飞鸽");
        e.show();
        Tricycle t=new Tricycle("lan","moupinpai",1);
        t.show();
    }
}
