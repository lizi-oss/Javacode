class Car {
    private int site = 4; // 座位数，私有成员变量

    // 父类无参构造方法
    Car(){
        System.out.println ("载客量是"+site+"人");
    }

    // 公共setter方法，修改私有变量site
    public void setSite(int site){
        this.site = site;
    }

    // 打印方法
    void print(){
        System.out.print("载客量是"+site+"人");
    }
}
class Bus extends Car {
    // 子类带参构造方法
    Bus(int site){
        setSite(site); // 调用父类的setter方法修改site，一开始不懂是因为这，这个地方怎么调用的父类的方法后来懂了。
    }
}

public class wo {
    public static void main(String[] args) {
        Bus bus = new Bus(20);
        bus.print();//
    }
}
