import java.util.ls;

public class Battleship {
    public static void main(String[] args) {
        System.out.println("Welcome to Battleship!\n");
        Scanner scanner = new Scanner(System.in);
        String player1 = "Player 1";
        String player2 = "Player 2";

        char[][] ship1 = createArray();
        char[][] ship2 = createArray();
        char[][] hitBoard1 = createArray();
        char[][] hitBoard2 = createArray();

        // users enter ships
        getUserInput(scanner, ship1, player1);
        printBattleShip(ship1);
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
        getUserInput(scanner, ship2, player2);
        printBattleShip(ship2);
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
        boolean player1Won = false;
        boolean player2Won = false;

        while(!player1Won && !player2Won){
            playerHit(scanner, ship2, hitBoard2, player1, player2);
            printBattleShip(hitBoard2);
            System.out.println();
            player1Won = checkWin(ship2, player1);
            if(player1Won) break;

            playerHit(scanner, ship1, hitBoard1, player2, player1);
            printBattleShip(hitBoard1);
            System.out.println();
            player2Won = checkWin(ship1, player2);
            if(player2Won) break;
        }
        System.out.println("Final boards:\n");
        printFinalBoard(ship1, hitBoard1);
        System.out.println();
        printFinalBoard(ship2, hitBoard2);
    }


    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }

    private static void getUserInput(Scanner scanner, char[][]  shipArray, String player){
        int count = 1;
        System.out.println(player.toUpperCase() + ", ENTER YOUR SHIPS’ COORDINATES.");
        int firstCoordinate = 0;
        int secondCoordinate = 0;
       do{
           System.out.println("Enter ship " + count + " location:");
           if(scanner.hasNextInt()){
               firstCoordinate = scanner.nextInt();
               if(scanner.hasNextInt()){
                   secondCoordinate = scanner.nextInt();
                   if(firstCoordinate > 4 || secondCoordinate > 4){
                       System.out.println("Invalid coordinates. Choose different coordinates.");
                   }
                   else if(shipArray[firstCoordinate][secondCoordinate] == '@'){
                       System.out.println("You already have a ship there. Choose different coordinates.");
                   }
                   else{
                       shipArray[firstCoordinate][secondCoordinate] = '@';
                       count++;
                   }
               }
           }
           else{
               scanner.next();
               System.out.println("Invalid coordinates. Choose different coordinates.");
           }
        }  while(count < 6);
       //return shipArray;
    }


    private static void playerHit(Scanner scanner, char[][]  shipArray, char[][] boardArray, String hitter, String hit){
        boolean coordinatesEnetered = false;

        int firstCoordinate = 0;
        int secondCoordinate = 0;
        do{
            System.out.println(hitter + ", enter hit row/column:");
            if(scanner.hasNextInt()){
                firstCoordinate = scanner.nextInt();
                if(scanner.hasNextInt()){
                    secondCoordinate = scanner.nextInt();
                    if(firstCoordinate > 4 || secondCoordinate > 4){
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                    }
                    else if(boardArray[firstCoordinate][secondCoordinate] == 'O' || boardArray[firstCoordinate][secondCoordinate] == 'X'){
                        System.out.println("You already fired on this spot. Choose different coordinates.");
                    }
                    else{
                        if(shipArray[firstCoordinate][secondCoordinate] == '@') {
                            System.out.println(hitter.toUpperCase() + " HIT " + hit.toUpperCase() +"’s SHIP!");
                            shipArray[firstCoordinate][secondCoordinate] = 'X';
                            boardArray[firstCoordinate][secondCoordinate] = 'X';
                        }
                        else{
                            System.out.println(hitter.toUpperCase() + " MISSED!");
                            boardArray[firstCoordinate][secondCoordinate] = 'O';
                        }
                        coordinatesEnetered = true;
                    }
                }
                else{
                    scanner.next();
                }
            }
            else{
                scanner.next();
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }
        }  while(!coordinatesEnetered);
        //return shipArray;
    }

    private static char[][] createArray(){
        char[][] player = new char[5][5];
        for(int i = 0; i < player.length; i++){
            for(int j = 0; j < player[0].length; j++){
                player[i][j] = '-';
            }
        }
        return player;
    }

    private static boolean checkWin(char[][] ar, String player){
        for(int i = 0; i < ar.length; i++){
            for(int j = 0; j < ar[0].length; j++){
                if(ar[i][j] == '@'){
                    return false;
                }
            }
        }
        System.out.println(player.toUpperCase() + " WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n");
        return true;
    }

    private static void printFinalBoard(char[][] ship, char[][] hitBoard){
        for(int i = 0; i < ship.length; i++){
            for(int j = 0; j < ship[0].length; j++) {
                if (ship[i][j] == '@' && (hitBoard[i][j] == '-')) {
                    hitBoard[i][j] = '@';
                }
            }
        }
        printBattleShip(hitBoard);
    }
}


