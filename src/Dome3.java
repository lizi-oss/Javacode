import java.util.*;

public class Dome3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("总头数");
        int a=sc.nextInt();
        System.out.println("总腿数");
        int b=sc.nextInt();
        int c=(b-a*2)/2;
        System.out.println("总共有"+c+"只兔子");
        int d=(b-4*c)/2;
        System.out.println("总共有"+d+"只鸡");
        sc.close();
    }
}
