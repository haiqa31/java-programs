import java.util.Scanner;
public class Fighter {
    String name;
    int health;
    int attackpower;
    public Fighter(String name,int health,int attackpower) {
        this.name=name;
        this.health=health;
        this.attackpower=attackpower;
    }
    
    public void attack(Fighteropponent) {
        oppenent.health-=this.attackpower;
        System.out.println(this.name +"attacks" +opponent.name +"for" + this.attackpower +"damage");
        
    }
    public boolean isAlive(){
        return health>0;
    } 
}
public class Main{
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Ali health");
        int health =sc.nextInt();
        System.out.println("Enter Ali attack power");
        int attackpower =sc.nextInt();
        System.out.println("Enter Ayesha health");
        int health1 =sc.nextInt();
        System.out.println("Enter Ayesha attack power");
        int attackpower1=sc.nextInt();
        
        Fighter fighter1= new Fighter("Ali",health,attackpower);
        Fighter fighter2= new Fighter("Ayesha",health1,attackpower1);
        sc.close();
        while(fighter1.isAlive() && fighter2.isAlive()){
             fighter1.attack(fighter2);
             fighter2.attack(fighter1);
             System.out.println("Remining hp of" +fighter1.name +":" +fighter1.health);
             System.out.println("Remining hp of" +fighter2.name +":" +fighter2.health);
        }
        if (fighter1.isAlive()){
            System.out.println(fighter1.name +"wins the game");
        } else {
            System.out.println(fighter2.name +"wins the game");
        }
    }
}
