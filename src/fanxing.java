import java.util.ArrayList;
//T(任意类型）/E（集合内元素）/K（键）/V（值）
class Box<T>{
    private T data;
    public T getData(){
        return data;
    }
    public void setData(T data){ // 修正参数名大小写不一致问题
        this.data=data;
    }
}
//泛型方法
class Test{
    public static <T> void print(T c){ // <T>前后加空格，规范格式
        System.out.println(c);
    }
}
class Fanxing { // 主类名大驼峰，和文件名一致
    public static void main(String[] args){
        ArrayList list=new ArrayList();
        list.add("苹果");
        list.add(100);
        list.add(new Object());
        String fruit=(String)list.get(0);
        // 下面这行运行会报错，注释提示
        // String num=(String)list.get(1);
        //以上没有加上泛型，这里需要每次都手动强转，代码冗余；

        ArrayList<String>strList=new ArrayList<>();
        strList.add("测试");
        // strList.add(123);  //这里会报错，因为类型不对。所以<>限制的是类型，限制类型写在<>里面

        ArrayList<Integer>numList=new ArrayList<>();
        // ArrayList<T>stulist=new ArrayList<>();
        // 错误：T是泛型占位符，创建对象时必须写实际类型，不能直接用T
        ArrayList<Object>stulist=new ArrayList<>();

        Box<String> strBox=new Box<>();
        strBox.setData("笔记本"); // 修正中文分号；为英文;
        Box<Integer>numBox=new Box<>();
        numBox.setData(999);

        // 调用泛型方法测试
        Test.print("泛型方法测试");
        Test.print(666);
    }
}