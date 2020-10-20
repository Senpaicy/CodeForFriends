package BIG;

public class Dog extends Pet{
    String breed;

    Dog(String name, int health, int energy, int happiness, String breed){
        super(name, health, energy, happiness); 
        this.breed = breed;
    }

    public String toString(){
        String s = breed + " " + name + " " + "(health = " + health + ", energy = " + 
            energy + ", happiness = " + happiness + ")";
        return s;
    }
    
    @Override
    public void feed(){
    	super.feed();
        if(this.energy >= 7 && this.health < 6){
            this.health -= 2;
            this.happiness -= 2;
            System.out.println("Feeding... \n....Uh oh! " + name + " ate a bad chocolate chip cookie :(. -2 health, -2 happiness.");
        }
        else{
            this.health += 2;
            this.happiness += 2;
            System.out.println("Feeding... \n...." + name + " ate all of the cookies! Yay! +2 health, +2 happiness."); 
 
        }
    }

    @Override
    public void walk(){
    	super.walk();
        if(this.energy <= 5){
            this.health -= 1;
            this.happiness -= 3;
            System.out.println("Walking... \n ....Oh no! " + name + " is exhausted from walking."
            		+"\n| STATS:          |\n|  Health: -1     |\n|  Happiness: -3  |");
        }
        else{
            this.health += 2;
            this.happiness += 2;
            this.energy -= 1;
            System.out.println( "Walking... \n...." + name + " had a great walk! "
            		+"\n| STATS:          |\n|  Health: +2     |\n|  Energy: -1     |\n|  Happiness: +2  |"); 
        }
    }
}