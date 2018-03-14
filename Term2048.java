import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Term2048 {
    // our algorithm

    private int[][] board;
    private Random rand= new Random();
    private int score;

    public Term2048() {
        board= new int[4][4];
    }

    public int[][] getBoard() {
        return board;
    }

    public int getScore() {
        return score;
    }

    public void drawBoard() {
        //draw new string board
        String[][] strBoard= new String[4][4];
        for(int x= 0; x<4; x++) {
            for(int y= 0; y<4; y++) {
                if(board[x][y]==0) {
                    strBoard[x][y]= ".";
                }
                else {
                    strBoard[x][y]= ""+board[x][y];
                }
            }
        }
        
        String line= "---------------------------------";
        System.out.println(line);
        for(int x= 0; x<4; x++) {
            for(int y= 0; y<4; y++) {
                System.out.print("|"+strBoard[x][y]+"\t");
            }
            System.out.println("|");
        }
        System.out.println(line);
    }

    public boolean isFullBoard() {
        // check if the board is full of tiles
        for(int x= 0; x<4; x++) {
            for(int y= 0; y<4; y++) {
                if(board[x][y]==0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isOldBoard(int[][] oldBoard) {
        // check if has the board changed after move
        for(int x= 0; x<4; x++) {
            for(int y= 0; y<4; y++) {
                if(oldBoard[x][y]!=board[x][y]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void dropNewTile() {
        // drop a random tile after move
        ArrayList<Integer> emptyTilesX= new ArrayList<Integer>();
        ArrayList<Integer> emptyTilesY= new ArrayList<Integer>();

        for(int x= 0; x<4; x++) {
            for(int y= 0; y<4; y++) {
                if(board[x][y]==0) {
                    emptyTilesX.add(x);
                    emptyTilesY.add(y);
                }
            }
        }

        int randTile= rand.nextInt(emptyTilesX.size());
        int percent= rand.nextInt(20);
        int newTileNumber= 2;
        if(percent==0 || percent==1 || percent==2) {
            newTileNumber= 4;
        }
        
        int dropX= emptyTilesX.get(randTile);
        int dropY= emptyTilesY.get(randTile);
        board[dropX][dropY]= newTileNumber;
    }

    // key set system
    
    public void keyUp() {
        for(int y= 0; y<4; y++) {
            if(board[0][y]!=0 || board[1][y]!=0 || board[2][y]!=0 || board[3][y]!=0) {
                while(board[0][y]==0) {
                    board[0][y]= board[1][y];
                    board[1][y]= board[2][y];
                    board[2][y]= board[3][y];
                    board[3][y]= 0;
                }
                while(board[1][y]==0 && (board[2][y]!=0 || board[3][y]!=0)) {
                    board[1][y]= board[2][y];
                    board[2][y]= board[3][y];
                    board[3][y]= 0;
                }
                while(board[2][y]==0 && board[3][y]!=0) {
                    board[2][y]= board[3][y];
                    board[3][y]= 0;
                }

                if(board[0][y]==board[1][y]) {
                    board[0][y]*= 2;
                    board[1][y]= board[2][y];
                    board[2][y]= board[3][y];
                    board[3][y]= 0;
                    score+= board[0][y];
                }
                if(board[1][y]==board[2][y]) {
                    board[1][y]*= 2;
                    board[2][y]= board[3][y];
                    board[3][y]= 0;
                    score+= board[1][y];
                }
                if(board[2][y]==board[3][y]) {
                    board[2][y]*= 2;
                    board[3][y]= 0;
                    score+= board[2][y];
                }
            }
        }
    }

    public void keyDown() {
        for(int y= 0; y<4; y++) {
            if(board[0][y]!=0 || board[1][y]!=0 || board[2][y]!=0 || board[3][y]!=0) {
                while(board[3][y]==0) {
                    board[3][y]= board[2][y];
                    board[2][y]= board[1][y];
                    board[1][y]= board[0][y];
                    board[0][y]= 0;
                }
                while(board[2][y]==0 && (board[1][y]!=0 || board[0][y]!=0)) {
                    board[2][y]= board[1][y];
                    board[1][y]= board[0][y];
                    board[0][y]= 0;
                }
                while(board[1][y]==0 && board[0][y]!=0) {
                    board[1][y]= board[0][y];
                    board[0][y]= 0;
                }

                if(board[3][y]==board[2][y]) {
                    board[3][y]*= 2;
                    board[2][y]= board[1][y];
                    board[1][y]= board[0][y];
                    board[0][y]= 0;
                    score+= board[3][y];
                }
                if(board[2][y]==board[1][y]) {
                    board[2][y]*= 2;
                    board[1][y]= board[0][y];
                    board[0][y]= 0;
                    score+= board[2][y];
                }
                if(board[1][y]==board[0][y]) {
                    board[1][y]*= 2;
                    board[0][y]= 0;
                    score+= board[1][y];
                }
            }
        }
    }

    public void keyLeft() {
        for(int x= 0; x<4; x++) {
            if(board[x][0]!=0 || board[x][1]!=0 || board[x][2]!=0 || board[x][3]!=0) {
                while(board[x][0]==0) {
                    board[x][0]= board[x][1];
                    board[x][1]= board[x][2];
                    board[x][2]= board[x][3];
                    board[x][3]= 0;
                }
                while(board[x][1]==0 && (board[x][2]!=0 || board[x][3]!=0)) {
                    board[x][1]= board[x][2];
                    board[x][2]= board[x][3];
                    board[x][3]= 0;
                }
                while(board[x][2]==0 && board[x][3]!=0) {
                    board[x][2]= board[x][3];
                    board[x][3]= 0;
                }

                if(board[x][0]==board[x][1]) {
                    board[x][0]*= 2;
                    board[x][1]= board[x][2];
                    board[x][2]= board[x][3];
                    board[x][3]= 0;
                    score+= board[x][0];
                }
                if(board[x][1]==board[x][2]) {
                    board[x][1]*= 2;
                    board[x][2]= board[x][3];
                    board[x][3]= 0;
                    score+= board[x][1];
                }
                if(board[x][2]==board[x][3]) {
                    board[x][2]*= 2;
                    board[x][3]= 0;
                    score+= board[x][2];
                }
            }
        }
    }

    public void keyRight() {
        for(int x= 0; x<4; x++) {
            if(board[x][0]!=0 || board[x][1]!=0 || board[x][2]!=0 || board[x][3]!=0) {
                while(board[x][3]==0) {
                    board[x][3]= board[x][2];
                    board[x][2]= board[x][1];
                    board[x][1]= board[x][0];
                    board[x][0]= 0;
                }
                while(board[x][2]==0 && (board[x][1]!=0 || board[x][0]!=0)) {
                    board[x][2]= board[x][1];
                    board[x][1]= board[x][0];
                    board[x][0]= 0;
                }
                while(board[x][1]==0 && board[x][0]!=0) {
                    board[x][1]= board[x][0];
                    board[x][0]= 0;
                }
                
                if(board[x][3]==board[x][2]) {
                    board[x][3]*= 2;
                    board[x][2]= board[x][1];
                    board[x][1]= board[x][0];
                    board[x][0]= 0;
                    score+= board[x][3];
                }
                if(board[x][2]==board[x][1]) {
                    board[x][2]*= 2;
                    board[x][1]= board[x][0];
                    board[x][0]= 0;
                    score+= board[x][2];
                }
                if(board[x][1]==board[x][0]) {
                    board[x][1]*= 2;
                    board[x][0]= 0;
                    score+= board[x][1];
                }
            }
        }
    }
}
