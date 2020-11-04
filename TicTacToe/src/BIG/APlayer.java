package BIG;

import java.util.*;

public class APlayer
{
	//------------------FIELD-------------------
	
    protected Game g;				// game player is playing
    protected char symbol; 			// character player uses

    //---------------CONSTRUCTORS----------------
    
    protected APlayer(){			//empty constructor
    } 

    protected APlayer(Game g, char symbol){
        this.g = g;					
        this.symbol = symbol;
    }

    //-------------------METHODS-----------------
    
    public char getSymbol(){
        return this.symbol;
    }

    public Move pickMove(){
        return null;
    }
}
