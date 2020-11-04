package BIG;

public class GameStats
{
	//-------------------FIELD------------------
	
    int nwins; 					// amount wins total
    int nties;					// amount ties total
    int nlosses;				// amount losses total
    
    
    //----------------CONSTRUCTOR-------------------
    
    public GameStats(int nwins, int nties, int nlosses) {
    	this.nwins = 0;			// this game stats (W's)
    	this.nties = 0;			// this game stats (ties)
    	this.nlosses = 0;		// this game stats (L's)
    }

    //------------------METHOD------------------
    
    public void recordWin() {
        this.nwins++;			// increase number of W's
    }
    
    public void recordTie() {
        this.nties++;			// increase number of ties
    }
    
    public void recordLoss() {
        this.nlosses++;			// increase number of L's
    }
    
    public String toString(){
       String s = "Game statistics: " + 
    		   "number of wins: " + this.nwins + 
    		   ", number of ties: " + this.nties + 
    		   ", number of losses: " + this.nlosses;
       return s;				// returns ALL STATS
    }
}
