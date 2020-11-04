package BIG;

public class CpuPlayer extends APlayer{

    public CpuPlayer(Game g, char symbol){
        this.g = g;
        this.symbol = symbol;
    }
    public Move pickMove(){
        while(true){
            int r = (int)(Math.random()* (g.nrows) + 1);
            int c = (int)(Math.random()* (g.nrows) + 1);
            Move m = new Move(r, c);

            if(m.isItEmpty(g)){
                return m;
            }
        }
    }

    public char getSymbol(){
        return 'O';
    }
}

