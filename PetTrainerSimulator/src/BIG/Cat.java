package BIG;

import java.lang.Math;

public class Cat extends Pet{
    String color;   
    
    Cat(String name, int health, int energy, int happiness, String color){
    	super(name, health, energy, happiness); 
        this.color = color;
    }

    public String toString(){
        String s = color + " " + "cat" + " " + name + " (health = " + health +
            ", energy = " + energy + ", happiness = " + happiness + ")";
        return s; 
    }

    
    @Override
    public void feed(){
    	super.feed();
        double number = Math.random();
        if (number <= 0.5){
            this.happiness -= 2; 
            System.out.println("Feeding... \n       ... Uh oh! " + name + " rejected the food you gave them. New happiness = " + 
                this.happiness + ".");
        }
        else{
            this.happiness += 2;
            System.out.println("Feeding... \n       ...Yay! " + name + " ate the food! New happiness = " + this.happiness + ".");
        }
    }
    
    @Override
    public void walk(){
    	super.walk();
        double number = Math.random();
        if(number <= 0.5){
            this.health -= 2;
            this.energy += 3;
            this.happiness += 2;
            System.out.println("Walking... \n       ...Well, " + name + 
                " was just not in the mood for a walk and ate a snack instead."
                +"\n| STATS:          |\n|  Health: -2     |\n|  Energy: +3     |\n|  Happiness: +2  |");
        }
        else{
            if(this.energy < 5){
                this.happiness -= 2;
                this.health += 1;
                System.out.println("Walking... \n       ...Oh no. " + name + " tripped and fell on the walk. "
                		+"\n| STATS:          |\n|  Health: +1     |\n|  Happiness: -2  |");
            }
            else{
                this.happiness += 3;
                this.energy -= 1;
                System.out.println("Walking...\n       ...The walk went well for " + name 
                		+"\n| STATS:          |\n|  Energy: -1     |\n|  Happiness: +3  |");
            }
        }
    }
    
}  
