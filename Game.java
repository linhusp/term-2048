import java.util.Scanner;

public class Game {

    public static void cls() {
        try {
            Runtime.getRuntime().exec("cls");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Term2048 n= new Term2048();
        n.drawBoard();

        // Scanner scanner= new Scanner(System.in);

        for(int i= 0; i<3; i++) {
            n.dropNewTile();
        }

        System.out.println();
        n.drawBoard();

        // String input= scanner.nextLine();
        
        // if(input.equals("w\n")) {
        //     n.keyUp();
        // }

        for(int i= 0; i<40; i++) {
            n.dropNewTile();
            System.out.println();
            n.drawBoard();
            n.keyUp();
            n.drawBoard(); 

            // n.dropNewTile();
            // System.out.println();
            // n.drawBoard();
            // n.keyDown();
            // n.drawBoard();

            n.dropNewTile();
            System.out.println();
            n.drawBoard();
            n.keyLeft();
            n.drawBoard();

            n.dropNewTile();
            System.out.println();
            n.drawBoard();
            n.keyRight();
            n.drawBoard();
        }

        // n.dropNewTile();
        // while(true) {
        //     n.dropNewTile();
        //     // cls();
        //     n.drawBoard();
        //     n.getKey();
        //     // cls();
        //     n.drawBoard();
        // }
    }
}
