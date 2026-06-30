import java.io.*;
import java.util.*;

public class zifuzijieliu {
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        //字符流只读写纯文本
        FileWriter fw=new FileWriter("D:\\a.txt");
        fw.write("hello.word");
        fw.write('\n');
        fw.write('z');
        fw.write('\n');
        fw.write(12);
        fw.write('\n');
        char[] ch={'a','b','c'};
        fw.write(ch);
        fw.flush();//刷新缓冲区
        fw.close();//关闭流
        FileReader fr=new FileReader("D:\\a.txt");
        int c;
        while((c=fr.read())!=-1){
            System.out.print((char)c);
        }
        fr.close();
        FileReader fr2=new FileReader("D:\\a.txt");
        char[] ch2=new char[1024];
        int len;
        while((len=fr2.read(ch2))!=-1){
            System.out.print(new String(ch2,0,len));
        }
        fr2.close();
        //字节流只读写二进制数据，其实是因为图片音频什么的都是二进制数据存在
        FileOutputStream fos=new FileOutputStream("D:\\b.txt");
        fos.write("hello.word".getBytes());
        fos.write('\n');
        fos.close();

        //字符读取方式2
        FileReader fr3=new FileReader("D:\\a.txt");
        char[]buf=new char[1024];
        int len1;
        while((len1=fr3.read(buf))!=-1){
            System.out.println(new String(buf,0,len1));
        }
        fr3.close();

    }

}
