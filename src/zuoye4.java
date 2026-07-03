import java.util.*;
import java.io.*;

public class zuoye4 {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String filePath = "D:\\zhengshujihe.txt";

        // 写入文件
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            System.out.println("输入数字，输入x停止：");
            boolean first = true;
            while (true) {
                String input = sc.next();
                if ("x".equals(input)) break;

                if (!first) {
                    bw.write(",");
                }
                bw.write(input);
                first = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 读取文件存入集合去重
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                for (String s : arr) {
                    String temp = s.trim();
                    if (temp.isEmpty()) continue;
                    int num = Integer.parseInt(temp);
                    hs.add(num);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 打印去重结果，解决末尾逗号
        System.out.println("去重后数字：");
        List<Integer> list = new ArrayList<>(hs);
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) System.out.print(",");
            System.out.print(list.get(i));
        }
        sc.close();
    }
}