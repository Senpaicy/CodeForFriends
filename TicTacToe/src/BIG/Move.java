package BIG;

public class Move{
    int row;
    int col;

    public Move(int row, int col){
        this.row = row;
        this.col = col;
    }

    public Boolean isItEmpty(Game g){
        if(g.board[row-1][col-1] == ' '){
            return true;
        } 
        return false;
    }
    
}

