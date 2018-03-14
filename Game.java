import java.util.Scanner;

public class Game {

    public static void cls() {
        // clear screen
        try {
            final String os= System.getProperty("os.name");
            if(os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Term2048 n= new Term2048();
        n.dropNewTile();
        n.dropNewTile();
        n.dropNewTile();
        n.drawBoard();

        Scanner scanner= new Scanner(System.in);
        String input;
        int[][] oldBoard= new int[4][4];
        
        // main game loop
        while(!n.isFullBoard()) {
            for(int x= 0; x<4; x++) {
                for(int y= 0; y<4; y++) {
                    oldBoard[x][y]= n.getBoard()[x][y];
                }
            }
            
            input= scanner.next();
            
            if(input.equals("w")) {
                n.keyUp();
            }
            else if(input.equals("s")) {
                n.keyDown();
            }
            else if(input.equals("a")) {
                n.keyLeft();
            }
            else if(input.equals("d")) {
                n.keyRight();
            }
            
            if(!oldBoard.equals(n.getBoard())) {
                n.dropNewTile();
            }
            
            // cls();
            n.drawBoard();
        }
    }
}
