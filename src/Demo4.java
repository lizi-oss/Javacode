class Point{
    private int x=0;
    private int y=0;

    public Point(){}
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void getX(int x){
        this.x=x;
    }
    public int setX(){
        return x;
    }
    public void getY(int y){
        this.y=y;
    }
    public int setY(){
        return y;
    }

}
class Circle{
    private Point p;
    private int r;

    public Circle(){}
    public Circle(Point p,int r){
        this.p=p;
        this.r=r;
    }

    public void getR(int r){
        this.r=r;
    }
    public int setR(){
        return r;
    }
    public void getP(Point p){
        this.p=p;
    }
    public Point setP(){
        return p;
    }

    //计算两个圆的相对位置，圆的面积
}




public class Demo4 {
    public static void main(String[] args){

    }
}
