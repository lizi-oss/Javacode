import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

class Student1{
    private String number;
    private String name;
    private String classhouse;
    private double yuwen;
    private double shuxue;
    private double yingyu;

    Student1(){}
    Student1(String number,String name,String classhouse,double yuwen,double shuxue,double yingyu){
        this.number=number;
        this.name=name;
        this.classhouse=classhouse;
        this.yuwen=yuwen;
        this.shuxue=shuxue;
        this.yingyu=yingyu;
    }

    // 正确get
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number=number;
    }

    public String getClasshouse(){
        return classhouse;
    }
    public void setClasshouse(String classhouse){
        this.classhouse=classhouse;
    }

    public double getYuwen(){
        return yuwen;
    }
    public void setYuwen(double yuwen){
        this.yuwen=yuwen;
    }

    public double getYingyu(){
        return yingyu;
    }
    public void setYingyu(double yingyu){
        this.yingyu=yingyu;
    }

    public double getShuxue(){
        return shuxue;
    }
    public void setShuxue(double shuxue){
        this.shuxue=shuxue;
    }

    public String toFileLine(){
        return number+","+name+","+classhouse+","+yuwen+","+shuxue+","+yingyu;
    }
    // 修正拼写parseFromLine
    public static Student1 parseFromLine(String line){
        String[] arr=line.split(",");
        String number=arr[0];
        String name=arr[1];
        String classhouse=arr[2];
        double yuwen=Double.parseDouble(arr[3]);
        double shuxue=Double.parseDouble(arr[4]);
        double yingyu=Double.parseDouble(arr[5]);
        return new Student1(number,name,classhouse,yuwen,shuxue,yingyu);
    }
}

class StudentManager{
    private static final String FILE_NAME="student.txt";
    private List<Student1> list;

    public StudentManager(){
        list=new ArrayList<>();
        loadFromFile();
    }

    // 移出嵌套，平级方法
    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("文件不存在，已自动创建");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        try(BufferedReader br=new BufferedReader(new FileReader(file))){
            String line;
            while((line=br.readLine())!=null && !line.trim().isEmpty()){
                Student1 stu=Student1.parseFromLine(line);
                list.add(stu);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void saveToFile(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for(Student1 s:list){
                bw.write(s.toFileLine());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("保存文件失败：" + e.getMessage());
        }
    }

    public List<Student1> getAllStudents(){
        return new ArrayList<>(list);
    }

    public boolean addStudent(Student1 newStu){
        for(Student1 s:list){
            if(s.getNumber().equals(newStu.getNumber())){
                return false;
            }
        }
        list.add(newStu);
        saveToFile();
        return true;
    }
}

public class zuoye {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while(true){
            System.out.println("\n菜单功能");
            System.out.println("1.显示所有学生");
            System.out.println("2.添加新学生");
            System.out.println("3.删除学生");
            System.out.println("4.修改成绩");
            System.out.println("5.查询学生");
            System.out.println("6.统计功能");
            System.out.println("7.排序并显示排名");
            System.out.println("0.退出程序");
            System.out.print("请输入操作：");

            int op;
            try {
                op=sc.nextInt();
                sc.nextLine();
            }catch (Exception e){
                System.out.println("输入数字错误！");
                sc.nextLine();
                continue;
            }

            switch(op){
                case 0:
                    System.out.println("程序退出");
                    sc.close();
                    return;
                case 1:
                    List<Student1> data = manager.getAllStudents();
                    if(data.isEmpty()){
                        System.out.println("暂无学生数据");
                        break;
                    }
                    // 表格打印
                    System.out.printf("%-10s%-8s%-8s%-6s%-6s%-6s%n","学号","姓名","班级","语文","数学","英语");
                    for(Student1 s : data){
                        System.out.printf("%-10s%-8s%-8s%-6.1f%-6.1f%-6.1f%n",
                                s.getNumber(),s.getName(),s.getClasshouse(),
                                s.getYuwen(),s.getShuxue(),s.getYingyu());
                    }
                    break;
                case 2:
                    System.out.print("学生学号：");
                    String nn=sc.nextLine();
                    System.out.print("学生姓名：");
                    String na=sc.nextLine();
                    System.out.print("学生班级：");
                    String cn=sc.nextLine();
                    System.out.print("学生语文成绩：");
                    double yw=sc.nextDouble();
                    System.out.print("学生数学成绩：");
                    double sx=sc.nextDouble();
                    System.out.print("学生英语成绩：");
                    double yy=sc.nextDouble();
                    sc.nextLine();
                    Student1 a=new Student1(nn,na,cn,yw,sx,yy);
                    boolean res = manager.addStudent(a);
                    if(res) System.out.println("添加成功");
                    else System.out.println("学号重复，添加失败");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    System.out.println("该功能暂未实现");
                    break;
                default:
                    System.out.println("输入序号无效");
            }
        }
    }
}