package BIG;

import java.util.*;

public class Game{
	
	//------------------FIELD-------------------
	
	char[][] board;									// array representing game
    
	int nrows;										// number of rows on the board
    int ncols;										// number of columns on the board
    
    APlayer[] players = new APlayer[2];				// represents the game as matrix
    
    final char SYMBOL_BLANK = ' '; 					// represents empty spot on board
    final char SYMBOL_HUMAN = 'X';					// represents human spot on board
    final char SYMBOL_CPU = 'O';					// represents computer spot on board 
    
    //---------------CONSTRUCTORS----------------
    
    public Game(int n){								// n by n size board
        this.nrows = n;								// n rows
        this.ncols = n;								// n columns
        this.board = new char [this.nrows][this.ncols];
    }
    
    //-------------------METHODS-----------------
    
    public void initializeBoard(){					// makes board with all empty spots
        for(int i = 0; i < this.nrows; i++){
            for(int j = 0; j < this.ncols; j++){
                this.board[i][j] = SYMBOL_BLANK; 
            }
        }
    }
    
    protected void resetGame(){						// re-initalize the board
        initializeBoard();
    }
    

    public int getBoardSize(){						// return n
        return nrows;
    }

    protected boolean executeMove(Move move, char symbol){
        this.board[move.row - 1][move.col - 1] = symbol;
        return true;								// marks spot
    } 

    public char getGameStatus(){
        char numX = 0;
        char numO = 0;
        
        //---------rows---------

        for(int i = 0; i < nrows; i++){				// go through every row			
            for(int j = 0; j < ncols; j++){			// check every spot in row
                if(board[i][j] == 'X'){				// if there's an X 
                    numX++;							// increase X's
                }
                if(board[i][j] == 'O'){				// if there's an O
                    numO++;							// increase O's
                }
            }
            
            if(numX == nrows){						// X's fill row
                return 'X';
            }
            
            if(numO == nrows){						// O's fill row
                return 'O';
            }
            
            numX = 0;								// reset for next row
            numO = 0;								// reset for next row
        }

        
        //-------columns--------

        for(int i = 0; i < ncols; i++){				// go through every column			
            for(int j = 0; j < nrows; j++){			// check every spot in row
                if(board[i][j] == 'X'){				// if there's an X 
                    numX++;							// increase X's
                }
                if(board[i][j] == 'O'){				// if there's an O
                    numO++;							// increase O's
                }
            }
            
            if(numX == ncols){						// X's fill column
                return 'X';
            }
            
            if(numO == ncols){						// O's fill column
                return 'O';
            }
            
            numX = 0;								// reset for next column
            numO = 0;								// reset for next column
        }
        
        //-------right diagonal (the one that goes like "\")--------

        for(int i = 0; i < ncols; i++){				// go through right diagonal	
    		if(board[i][i] == 'X'){					// if there's an X 
                numX++;								// increase X's
            }
            if(board[i][i] == 'O'){					// if there's an O
                numO++;								// increase O's
            }							
        }
        
        if(numX == ncols){							// X's wins
            return 'X';
        }
        
        if(numO == ncols){							// O's wins
            return 'O';
        }
        
        numX = 0;									// reset for next diagonal
        numO = 0;									// reset for next diagonal
        
        //-------left diagonal (the one that goes like "/")--------

        int colcounter = 0;
        for(int i = nrows - 1; i > -1; i--){		// go through left diagonal		
    		if(board[i][colcounter] == 'X'){		// if there's an X 
                numX++;								// increase X's
            }
            if(board[i][colcounter] == 'O'){		// if there's an O
                numO++;								// increase O's
            }	
            colcounter++;
        }
        
        if(numX == ncols){							// X's wins
            return 'X';
        }
        
        if(numO == ncols){							// O's wins
            return 'O';
        }
        
        //----------checks if board has any spaces left----------
        
        for(int i=0; i < nrows; i++){
            for(int j=0; j < ncols; j++){
                if(board[i][j] == ' '){
                    return '?';						// not finished
                }  
            }
        }
        
        return 'T';									// ties
    }

    
    public char playSingleGame(){					// plays one game
        this.choosePlayer();						// pick random player
        
        while(getGameStatus() == '?'){
        	System.out.println("------------------------");
        	System.out.println("        PLAYER ONE      ");
        	
            //if(players[0] )
        	Move m1 = this.players[0].pickMove();
            
            if(m1 == null){
                return 'Q';
            }
            
            this.executeMove(m1, players[0].getSymbol());
            
            players[0].getSymbol();
            System.out.println(this);
            
            System.out.println("------------------------");
        	System.out.println("       PLAYER TWO       ");
            
            Move m2 = this.players[1].pickMove();
            if(m2 == null){
                return 'Q';
            }
            
            this.executeMove(m2, players[1].getSymbol());
            players[1].getSymbol();
            System.out.println(this);
        
        }

        char result = ' ';
        if(getGameStatus() == 'X'){
        	System.out.println("------------------------");
        	System.out.println("       WOW YOU WON!     ");
        	System.out.println("------------------------");
            result = 'H';
        }
        else if(getGameStatus() == 'O'){
        	System.out.println("------------------------");
        	System.out.println("     OH NO YOU LOST!    ");
        	System.out.println("------------------------");
            result = 'C';
        }
        else if(getGameStatus() == 'T'){
        	System.out.println("------------------------");
        	System.out.println("   IT'S OK IT'S A TIE   ");
        	System.out.println("------------------------");
            result = 'T';
        }
        return result; 
    }


    public String toString(){
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        char a = 'A';
        int numCols = 0;

        for(int j = 0; j < board[0].length; j++){
            numCols++;
            if(j == 0){
                s3 += "  " + numCols + "  ";
            }else if(j == board[0].length-1){
                s3 += " " + numCols + " " + "\n";  
            }else{
                s3 += " " + numCols + "  ";
            }
        }
        s4 += s3;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(i == board.length-1){
                    if (j == 0){
                        s1 += ((char)(a + i)) + " " + board[i][j] + " |"; 
                    }
                    else if(j == board[0].length-1){
                        s1 += " " + board[i][j] + " "; 
                    } else{
                        s1 += " " + board[i][j] + " |";
                    }
                }
                else if(j == 0){
                    s1 += ((char)(a + i)) + " " + board[i][j] + " |"; 
                    s2 += " " + "---|";
                }
                else if(j == board[0].length-1){
                    s1 += " " + board[i][j] + " " + "\n";
                    s2 += "---" + "\n";
                } else{
                    s1 += " " + board[i][j] + " " + "|";
                    s2 += "---|";
                }
            } 

            s4 += s1 + s2;
            s1 = "";
            s2 = "";
        }
        return s4;
    }

    public void choosePlayer(){
        APlayer human = new HumanPlayer(this, 'X');
        APlayer computer = new CpuPlayer(this, 'O');

        if (Math.random() < 0.5){
            this.players[0] = human;
            this.players[1] = computer;
        }
        else{
            this.players[0] = computer;
            this.players[1] = human;
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner (System.in);

        System.out.println("Welcome to Tic-tac-toe!");
        System.out.println("------------------------");
        
        int n;

        try {
            n = Integer.parseInt(args[0]); 
            if(n < 1 || n > 9){
                n = 3;   
            }
        } catch(Exception e){
            n = 3;
            if(e instanceof NumberFormatException){
                System.out.println("Error: Invalid board size :(");
            }
        }
        
        GameStats playerone = new GameStats(0,0,0); 
        Game g = new Game(n);
        char result;
        String play;
        while(true) {
            g.initializeBoard();
            System.out.println(g);
            result = g.playSingleGame();
            if(result == 'H') {
            	playerone.recordWin();
            }
            else if(result == 'C') {
            	playerone.recordLoss();
            }
            else {
            	playerone.recordTie();
            }
            System.out.println("Want to play again, please enter y or Y: ");
            play = s.next();
            if(play.equals("y") || play.equals("Y")) {
            	continue;
            }
            System.out.println("Thanks for playing! Here are your stats: ");
            System.out.println(playerone.toString());
            break;
        }
    }   
}
