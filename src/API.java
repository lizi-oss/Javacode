import java.util.List;


public class API {
    public static void main(String[] args){
        String str1="zifuchuan";
        String str2="";
        int len=str1.length();
        String s="hello";
        String str11=new String();
        String str22=new String("hello");
        char [] charArry=new char[]{};
        String str33=new String(charArry);
        byte[] byteArry=new byte[]{99,87,78};
        String str44=new String(byteArry);
        String S="hello";
        System.out.println("字符串的长度:"+s.length());
        System.out.println("字符串是否为空:"+s.isEmpty());
        System.out.println("字符串是否相等:"+s.equals(str1));
        System.out.println(s.charAt(0));
        System.out.println(s.indexOf('h'));
        System.out.println(s.lastIndexOf('l'));
        System.out.println(str1.charAt(0));
        System.out.println(str1.substring(0,2));
        System.out.println(str1.toUpperCase());
    }
}
