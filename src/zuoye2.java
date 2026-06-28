import java.util.Scanner;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

abstract class Employee{
    private String id;
    private String name;
    private String department;
    private String hireDate;
    protected double performance;

    public Employee(){}
    public Employee(String id, String name, String department, String hireDate){
        this.id=id;
        this.name=name;
        this.department=department;
        this.hireDate=hireDate;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public String getHireDate(){
        return hireDate;
    }
    public void setHireDate(String hireDate){
        this.hireDate=hireDate;
    }
    public abstract void calculatePerformance();
    public double getPerformance() {
        return performance;
    }
}

class TechnicalStaff extends Employee{
    private double projectsCompleted;
    private double innovations;
    private double overtimeHours;
    public TechnicalStaff(){}
    public TechnicalStaff(String id, String name, String department, String hireDate,double projectsCompleted,double innovations,double overtimeHours){
        super(id, name, department,hireDate);
        this.projectsCompleted=projectsCompleted;
        this.innovations=innovations;
        this.overtimeHours=overtimeHours;
    }
    public double getProjectsCompleted(){
        return projectsCompleted;
    }
    public void setProjectsCompleted(double projectsCompleted){
        this.projectsCompleted=projectsCompleted;
    }
    public double getInnovations(){
        return innovations;
    }
    public void setInnovations(double innovations){
        this.innovations=innovations;
    }
    public double getOvertimeHours(){
        return overtimeHours;
    }
    public void setOvertimeHours(double overtimeHours){
        this.overtimeHours=overtimeHours;
    }
    @Override
    public void calculatePerformance(){
        double score = projectsCompleted*0.4+innovations*0.3+overtimeHours*0.3;
        this.performance = score;
    }
}

class ServiceStaff extends Employee{
    private double satisfactionScore;
    private double serviceCount;
    private double praiseCount;

    public ServiceStaff(){}

    public ServiceStaff(String id, String name, String department, String hireDate,double satisfactionScore,double serviceCount,double praiseCount){
        super(id, name, department,hireDate);
        this.satisfactionScore=satisfactionScore;
        this.serviceCount=serviceCount;
        this.praiseCount=praiseCount;
    }
    public double getSatisfactionScore(){
        return satisfactionScore;
    }
    public void setSatisfactionScore(double satisfactionScore){
        this.satisfactionScore=satisfactionScore;
    }
    public double getServiceCount(){
        return serviceCount;
    }
    public void setServiceCount(double serviceCount){
        this.serviceCount=serviceCount;
    }
    public double getPraiseCount(){
        return praiseCount;
    }
    public void setPraiseCount(double praiseCount){
        this.praiseCount=praiseCount;
    }
    @Override
    public void calculatePerformance(){
        double score = satisfactionScore*0.5+serviceCount*0.3+praiseCount*0.2;
        this.performance = score;
    }
}

public class zuoye2 {
    static List<Employee> employees = new ArrayList<>();

    // 从employees.txt读取员工数据
    public static void readFormFile(){
        File file=new File("employees.txt");
        if(!file.exists()){
            System.out.println("员工文件不存在，跳过读取");
            return;
        }
        try(BufferedReader br=new BufferedReader(new FileReader(file))){
            String line;
            while((line=br.readLine())!=null){
                String[] arr=line.split(",");
                String type=arr[0];
                String id=arr[1];
                String name=arr[2];
                String department=arr[3];
                String hireDate=arr[4];
                if("Technical".equals(type)){
                    double p1=Double.parseDouble(arr[5]);
                    double p2=Double.parseDouble(arr[6]);
                    double p3=Double.parseDouble(arr[7]);
                    TechnicalStaff ts=new TechnicalStaff(id, name, department, hireDate, p1, p2, p3);
                    employees.add(ts);
                }else if("Service".equals(type)){
                    double p1=Double.parseDouble(arr[5]);
                    double p2=Double.parseDouble(arr[6]);
                    double p3=Double.parseDouble(arr[7]);
                    ServiceStaff ss=new ServiceStaff(id, name, department, hireDate, p1, p2, p3);
                    employees.add(ss);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    // 将部门排名+员工前10名写入文件
    public static void writeRankFile(){
        if(employees.isEmpty()){
            System.out.println("无员工数据");
            return;
        }
        // 全员计算绩效
        for(Employee e:employees){
            e.calculatePerformance();
        }
        // 分组统计部门总分与人数
        Map<String,double[]> map=new HashMap<>();
        for(Employee emp:employees){
            String d=emp.getDepartment();
            double score=emp.getPerformance();
            if(map.containsKey(d)){
                double[] data=map.get(d);
                data[0]+=score;
                data[1]++;
            }else{
                map.put(d,new double[]{score,1});
            }
        }
        // 部门集合排序
        List<String[]> deptList=new ArrayList<>();
        for(String dept:map.keySet()){
            double[] arr=map.get(dept);
            double avg=arr[0]/arr[1];
            deptList.add(new String[]{dept,avg+""});
        }
        deptList.sort((a,b)->Double.compare(Double.parseDouble(b[1]),Double.parseDouble(a[1])));

        // 员工降序，截取前10
        List<Employee> empList=new ArrayList<>(employees);
        empList.sort((e1,e2)->Double.compare(e2.getPerformance(),e1.getPerformance()));

        // 写入txt
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("performance_ranking.txt"))){
            bw.write("====部门绩效排名====");
            bw.newLine();
            for(int i=0;i<deptList.size();i++){
                bw.write((i+1)+". "+deptList.get(i)[0]+" 平均分："+deptList.get(i)[1]);
                bw.newLine();
            }
            bw.newLine();
            bw.write("====员工绩效前10名====");
            bw.newLine();
            int top=Math.min(10,empList.size());
            for(int i=0;i<top;i++){
                Employee e=empList.get(i);
                bw.write((i+1)+". "+e.getName()+" | 绩效："+e.getPerformance());
                bw.newLine();
            }
            System.out.println("排名文件生成完毕！");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void addEmployee(Scanner sc){
        System.out.print("员工编号：");
        String id=sc.next();
        System.out.print("员工姓名：");
        String name=sc.next();
        System.out.print("员工部门：");
        String department=sc.next();
        System.out.print("员工入职时间：");
        String hireDate=sc.next();
        System.out.print("岗位类型（Technical / Service）：");
        String position=sc.next();
        if(position.equals("Technical")){
            System.out.print("项目完成数：");
            double projectsCompleted=sc.nextDouble();
            System.out.print("创新指数：");
            double innovations=sc.nextDouble();
            System.out.print("加班小时数：");
            double overtimeHours=sc.nextDouble();
            TechnicalStaff emp=new TechnicalStaff(id, name, department, hireDate, projectsCompleted, innovations, overtimeHours);
            employees.add(emp);
            System.out.println("技术员工添加成功!");
        }else if(position.equals("Service")){
            System.out.print("客户满意度：");
            double satisfactionScore=sc.nextDouble();
            System.out.print("服务次数：");
            double serviceCount=sc.nextDouble();
            System.out.print("好评数：");
            double praiseCount=sc.nextDouble();
            ServiceStaff emp=new ServiceStaff(id, name, department, hireDate, satisfactionScore, serviceCount, praiseCount);
            employees.add(emp);
            System.out.println("服务员工添加成功!");
        }else{
            System.out.println("无效的岗位类型！");
        }
    }

    public static void calcDeptAvg(Scanner sc){
        System.out.print("请输入要统计的部门名称：");
        String targetDept=sc.next();
        double sum=0;
        int count=0;
        for(Employee emp:employees){
            if(emp.getDepartment().equals(targetDept)){
                emp.calculatePerformance();
                sum+=emp.getPerformance();
                count++;
            }
        }
        if(count ==0){
            System.out.println("部门不存在！");
            return;
        }
        double avg=sum/count;
        System.out.println("部门"+targetDept+"的平均绩效为："+avg);
    }

    public static void starEmployee() {
        if(employees.isEmpty()){
            System.out.println("无员工数据");
            return;
        }
        for(Employee e:employees){
            e.calculatePerformance();
        }
        List<Employee>tempList=new ArrayList<>(employees);
        tempList.sort((e1,e2)->Double.compare(e2.getPerformance(),e1.getPerformance()));
        int total=tempList.size();
        int starNum=(int)(total*0.1);
        if(starNum<=0){
            starNum=1;
        }
        System.out.println("====爱岗敬业之星======");
        for(int i=0;i<starNum;i++){
            Employee e=tempList.get(i);
            System.out.println(e.getName()+"，绩效："+e.getPerformance());
        }
    }

    public static void queryDeptEmp(Scanner sc){
       System.out.println("请输入查询部门：");
       String dept=sc.next();
       boolean hasData=false;
       System.out.println("===部门员工信息====");
       for(Employee emp:employees){
           if(emp.getDepartment().equals(dept)){
               hasData=true;
               System.out.println(emp.getName()+" | "+emp.getDepartment()+" | "+emp.getHireDate());
           }
       }
        if(!hasData){
            System.out.println("无员工数据！");
        }
    }

    public static void main(String[] args){
        readFromFile();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("=======程序功能=======\n" +
                    "1.添加员工\n"+
                    "2.计算部门平均绩效\n"+
                    "3.生成爱岗敬业之星\n"+
                    "4.查询指定部门员工信息\n"+
                    "6.生成绩效排名写入文件\n"+
                    "5.退出程序\n");
            System.out.print("请输入操作序号：");
            int op=sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    calcDeptAvg(sc);
                    break;
                case 3:
                    starEmployee();
                    break;
                case 4:
                    queryDeptEmp(sc);
                    break;
                case 6:
                    writeRankFile();
                    break;
                case 5:
                    System.out.println("程序退出");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入序号错误！");
            }
        }
    }
}