class Pet{
    private String nickname;
    private int health;
    private int intimacy;
    private String breed;

    public Pet(){}//如果写继承一定要单独写一个无参构造否则会报错。
    public Pet(String nickname,int health,int intimacy,String breed){
        this.nickname=nickname;
        this.health=health;
        this.intimacy=intimacy;
        this.breed=breed;
    }

    public String getNickname(){return nickname;}
    public String getBreed(){return breed;}
    public int getIntimacy(){return intimacy;}
    public int getHealth(){return health;}

    public void setNickname(String nickname){this.nickname=nickname;}
    public void setBreed(String breed){this.breed=breed;}
    public void setHealth(int health){this.health=health;}
    public void setIntimacy(int intimacy){this.intimacy=intimacy;}

    public void Info(){
        System.out.println("昵称："+nickname+"健康度："+health+"亲密度："+intimacy+"品种："+breed);
    }

}

class Dog1 extends Pet{
    private String sound;

    public Dog1(){}
    public Dog1(String nickname,int health,int intimacy,String breed,String sound){
        super(nickname,health,intimacy,breed);
        this.sound=sound;
    }

    public String getSound(){return sound;}
    public void setSound(String sound){this.sound=sound;}

    @Override
    public void Info(){
        super.Info();
        System.out.println("叫声："+sound);
    }
}

class Penguin extends Pet{
    private String adress;

    public Penguin(){}
    public Penguin(String nickname,int health,int intimacy,String breed,String adress){
        super(nickname,health,intimacy,breed);
        this.adress=adress;
    }

    public String getAdress(){return adress;}
    public void setAdress(String adress){this.adress=adress;}

    @Override
    public void Info(){
        super.Info();
        System.out.println("地址："+adress);
    }
}

public class text {
    public static void main (String[] args){
        Dog1 dog=new Dog1("sbh",100,0,"边牧","汪汪叫");
        dog.Info();
        Penguin penguin=new Penguin("wry",100,100,"皇帝企鹅","南极");
        penguin.Info();
        penguin.setHealth(10000);
        penguin.Info();
    }
}
