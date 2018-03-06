import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Term2048 {

    private int[][] board;
    private Random rand= new Random();

    public Term2048() {
        board= new int[4][4];
    }

    public void drawBoard() {
        for(int x= 0; x<4; x++) {
            for(int y= 0; y<4; y++) {
                System.out.print(board[x][y]+"\t");
            }
            System.out.println();
        }
    }
    
    public void dropNewTile() {
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

    public void getKey() {
        Scanner scanner= new Scanner(System.in);
        String input= new String("");
        while(input!="w\n" || input!="s\n" || input!="a\n" || input!="d\n") {
            input= scanner.nextLine();
        }
        scanner.close();

        switch (input) {
            case "w\n":
                keyUp();
                break;
            case "s\n":
                keyDown();
                break;
            case "a\n":
                keyLeft();
                break;
            case "d\n":
                keyRight();
                break;
            default:
                break;
        }

    }

    public void keyUp() {
        System.out.println("key up");
        for(int y= 0; y<4; y++) {
            boolean[] isCombined= {false, false, false, false};
            for(int x= 1; x<4; x++) {
                if(board[x][y]!=0) {
                    int tileValue= board[x][y];
                    int xd= x-1;

                    while(xd>=0 && board[xd][y]==0) {
                        xd--;
                    }

                    board[x][y]= 0;
                    if(xd==-1 || board[xd][y]!=tileValue || isCombined[xd]) {
                        board[xd+1][y]= tileValue;
                    }
                    else {
                        board[xd][y]*= 2;
                        isCombined[xd]= true;
                    }
                }
            }
        }
    }

    public void keyDown() {
        System.out.println("key down");
        for(int y= 0; y<4; y++) {
            boolean[] isCombined= {false, false, false, false};
            for(int x= 2; x>-1; x--) {
                if(board[x][y]!=0) {
                    int tileValue= board[x][y];
                    int xd= x+1;

                    while(xd<=3 && board[xd][y]==0) {
                        xd++;
                    }
                    
                    board[x][y]= 0;
                    if(xd==4 || board[xd][y]!=tileValue || isCombined[xd]) {
                        board[xd-1][y]= tileValue;
                    }
                    else {
                        board[xd][y]*= 2;
                        isCombined[xd]= true;
                    }
                }
            }
        }
    }

    public void keyLeft() {
        System.out.println("key left");
        for(int x= 0; x<4; x++) {
            boolean[] isCombined= {false, false, false, false};
            for(int y= 1; y<4; y++) {
                if(board[x][y]!=0) {
                    int tileValue= board[x][y];
                    int yd= y-1;

                    while(yd>=0 && board[x][yd]==0) {
                        yd--;
                    }
                    
                    board[x][y]= 0;
                    if(yd==-1 || board[x][yd]!=tileValue || isCombined[yd]) {
                        board[x][yd+1]= tileValue;
                    }
                    else {
                        board[x][yd]*= 2;
                        isCombined[yd]= true;
                    }
                }
            }
        }
    }

    public void keyRight() {
        System.out.println("key right");
        for(int x= 0; x<4; x++) {
            boolean[] isCombined= {false, false, false, false};
            for(int y= 2; y>-1; y--) {
                if(board[x][y]!=0) {
                    int tileValue= board[x][y];
                    int yd= y+1;

                    while(yd<=3 && board[x][yd]==0) {
                        yd++;
                    }

                    board[x][y]= 0;
                    if(yd==4 || board[x][yd]!=tileValue || isCombined[yd]) {
                        board[x][yd-1]= tileValue;
                    }
                    else {
                        board[x][yd]*= 2;
                        isCombined[yd]= true;
                    }
                }
            }
        }
    }
}
