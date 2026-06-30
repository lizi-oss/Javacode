import java.util.*;
import java.util.Scanner;
import java.util.HashMap;

class User{
    private String username;
    private String password;

    User(){}
    User(String un,String pw){
        username=un;
        password=pw;
    }

    public void setUsername(String un) {
        username = un;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String pw) {
        password = pw;
    }
    public String getPassword(){
        return password;
    }

    public boolean checkLogin(String un,String pw){
        if(username.equals(un)&&password.equals(pw))return true;
        return false;
    }
}

public class Test01 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        HashMap<String,User>map=new HashMap<>();
        User u1=new User("admin","123456");
        map.put("admin",u1);
        User u2=new User("user","123456");
        map.put("user",u2);

        System.out.println("请输入用户名:");
        String un=sc.next();
        System.out.println("请输入密码:");
        String pw=sc.next();

        User u=map.get(un);
        if(u!= null&&u.checkLogin(un,pw)){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }
    }
}
