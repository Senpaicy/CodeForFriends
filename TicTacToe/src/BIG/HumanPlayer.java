package BIG;

import java.util.*;

public class HumanPlayer extends APlayer{
	
	//-------------------FIELD------------------
	
    Game g;
    
    //----------------CONSTRUCTOR-------------------

    public HumanPlayer(Game g, char symbol){
        this.g = g;
        this.symbol = symbol;
    }
    
    //------------------METHOD------------------
    
    public char getSymbol(){
        return 'X';
    }
    
    public Move pickMove(){
        Scanner s = new Scanner(System.in);
        
        int r;
        int c;
        
        while(true){
            String a = s.next();
            a.toLowerCase();

            if(a.equals("quit") || a.equals("Quit")){
                return null;
            }

            if(a.length() != 2){
            	System.out.println("Invalid input, Try Again: ");
            	continue;
            }
            
            r = ((int) a.charAt(0)) - 96;
            c = ((int) a.charAt(1)) - 48;
            
            if(r < 0) {
            	r+=32;
            }
            
            System.out.println("R: " + r + " C: " + c);

            if(r > g.nrows || c > g.ncols) {
            	System.out.println("Invalid input, Try Again: "); 
            	continue;
            }
            
            Move m = new Move(r, c);
            
            if(!m.isItEmpty(g)) {
            	System.out.println("Uh oh! That space is occupied, Try Again: ");
            	continue;
            }
            
            return m;  
        }
    } 
}