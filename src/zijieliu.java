import java.io.*;
import java.util.*;

public class zijieliu {
    public static void main(String[] arg){
        // 1. 写入文件 try-with-resources 自动关流
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\employees.txt"))){
            bw.write("Technical,001,张三,研发部,2026-01-01,10,5,20");
            bw.newLine();
            bw.flush();
        }catch(IOException e){
            e.printStackTrace();
        }

        // 2. 读取文件
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\employees.txt"))){
            String line;
            while((line=br.readLine())!=null){
                String[] arr=line.split(",");
                System.out.println("类型"+arr[0]+" 姓名"+arr[2]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}