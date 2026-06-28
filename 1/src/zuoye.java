import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private String className;
    private double chinese;
    private double math;
    private double english;

    public Student() {}
    public Student(String id, String name, String className, double chinese, double math, double english) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public double getChinese() {
        return chinese;
    }
    public void setChinese(double chinese) {
        this.chinese = chinese;
    }
    public double getMath() {
        return math;
    }
    public void setMath(double math) {
        this.math = math;
    }

    public double getEnglish() {
        return english;
    }
    public void setEnglish(double english) {
        this.english = english;
    }
    public double getTotal() {
        return chinese + math + english;
    }
    public String toFileLine(){
        return id+","+name+","+className+","+chinese+","+math+","+english;
    }
    public static Student parseFromLine(String line){
        String[] arr= line.split(",");
        String id =arr[0];
        String name =arr[1];
        String cls =arr[2];
        double chinese =Double.parseDouble(arr[3]);
        double math =Double.parseDouble(arr[4]);
        double english =Double.parseDouble(arr[5]);
        return new Student(id,name,cls,chinese,math,english);
    }
}
class StudentManager{
    private  static final String FILE_NAME="student.txt";
    private List<Student>studentList;
}