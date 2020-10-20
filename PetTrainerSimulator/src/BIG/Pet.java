package BIG;

public class Pet{
	
    String name;
    int health;
    int energy;
    int happiness;

    Pet(String name, int health, int energy, int happiness){
        this.name = name;
        this.health = health;
        this.energy = energy;
        this.happiness = happiness;
    }

    public String toString(){
        String s = "Pet " + name + " (health = " + health + ", energy " + energy +
            ", happiness = " + happiness + ")";
        return s;
    }
    
    public String getName() {
    	return this.name;
    }

    public void feed(){
    }

    public void walk(){
    }
}
