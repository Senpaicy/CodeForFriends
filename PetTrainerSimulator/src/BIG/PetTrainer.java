package BIG;

import java.util.Scanner;


public class PetTrainer{

    public static void pickAndRunAction(Pet pet){ 
    	Scanner s = new Scanner(System.in); // instantiate a reader's input 
    	
    	System.out.println("---------------------------------------------------");
    	System.out.print("Do you want to feed or walk " + pet.getName() + "? "); // easier to read, feed or walk (your pet's name)
         
        String action = s.next();
        action.toLowerCase(); 

        while(true) {
	        if(action.compareTo("feed") == 0) {					// user inputed feed
	        	System.out.println("---------------------------------------------------");
	        	pet.feed();										// feed pet (dog or cat)
	        	System.out.println("---------------------------------------------------");
	        	break;
	        }
	        else if (action.compareTo("walk") == 0){			// user inputed walk
	            System.out.println("---------------------------------------------------");
	        	pet.walk();										// walk pet (dog or cat)
	        	System.out.println("---------------------------------------------------");
	        	break;
	        }
	        else{
	            System.out.print("Meow, Woof, what? ");		// when user is being an idiot
	            action = s.next();							// asks for another input
	            action.toLowerCase();
	        } 
    	}
    }

    public static void main(String[] args){
        System.out.println("Welcome to the pet trainer game!");

        Scanner s = new Scanner(System.in); 

        System.out.println("---------------------------------------------------");
        System.out.print("What is your cat's name?  ");
        String catName = s.next();

        System.out.print("What is your cat's color? ");
        String color = s.next();

        Cat cat = new Cat(catName, 5, 5, 5, color);

        System.out.print("What is your dog's name?  ");
        String dogName = s.next();

        System.out.print("What is your dog's breed? ");
        String breed = s.next(); 

        Dog dog = new Dog(dogName, 5, 5, 5, breed);

        for(int i = 0; i < 5; i++){
            pickAndRunAction(cat);
            pickAndRunAction(dog);
        }
    }
}
