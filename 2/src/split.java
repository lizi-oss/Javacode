import java.util.Arrays;

public class split {
    public static void main(String[] args){
        String data="11.4,756.8,99.80, ,22.5";

        String[] arr=data.split(",");
        double sum =0.0;
        for(String s:arr){
           if(s.contains(".")){
               System.out.println(s+"是小数格式");
           }
           if(" ".equals(s)){
               System.out.println("检测到非法文本"+s);
           }
           try{
               double num=Double.parseDouble(s);
               sum+=num;
               System.out.println("转换成功，数字："+num);
           }catch(NumberFormatException e){
               System.out.println("转换失败，文本："+s);
           }
        }
        System.out.println("\n所有合法数字总和="+sum);
    }
}
