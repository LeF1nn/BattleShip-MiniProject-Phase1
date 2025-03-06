public class BattleShip {
    public static void main(String[] args) {
        int gameBoardLenght = 10;
        char water = '~';
        char ship = 's';
        char hit = 'X';
        char miss = 'O';
        int shipNum = 4;


        char[][] gameBoard = createGameBoard(gameBoardLenght, water, ship, shipNum);
        printGameBoard(gameBoard, water, ship);
        int undetectedShipNum = shipNum;
        while (undetectedShipNum > 0) {
            int[] guessCordinates = getUserCordinate(gameBoardLenght);
            char locatianviewUpdate = evaluateGuessAndGetTheTarget(guessCordinates, gameBoard, ship, water, hit, miss);
            if (locatianviewUpdate == hit) {
                undetectedShipNum--;
            }
            gameBoard = uptadeGameboard(gameBoard, guessCordinates, locatianviewUpdate);
            printGameBoard(gameBoard, water, ship);
        }
    }

    private static char[][] uptadeGameboard(char[][] gameBoard, int[] guessCordinates, char locatianviewUpdate) {
        int row = guessCordinates[0];
        int col = guessCordinates[1];
        gameBoard[row][col] = locatianviewUpdate;
        return gameBoard;
    }

    private static char evaluateGuessAndGetTheTarget(int[] guessCordinates, char[][] gameBoard, char ship, char water, char hit, char miss) {
        String messege;
        int row = guessCordinates[0];
        int col = guessCordinates[1];
        char target = gameBoard[row][col];
        if (target == ship) {
            messege = "Hit!";
            target = 'X';

        } else if (target == water) {
            messege = "Miss";
            target = 'O';


        } else {
            messege = "Already hit";
        }
        System.out.println(messege);
        return target;
    }

    private static int[] getUserCordinate(int gameBoardLenght) {
        int row;
        int col;

        do {
            System.out.print("row: ");
            row = new Scanner(System.in).nextInt();
        } while (row < 0 || row > +gameBoardLenght + 1);
        do {
            System.out.print("col: ");
            col = new Scanner(System.in).nextInt();
        } while (col < 0 || col > gameBoardLenght + 1);
        return new int[]{row, col};
    }

    private static void printGameBoard(char[][] gameBoard, char water, char ship) {
        int gameBoardLenght = gameBoard.length;
        System.out.print(" ");
        for (int i = 0; i < gameBoardLenght; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int row = 1; row < gameBoardLenght; row++) {
            System.out.print(row + " ");
            for (int col = 1; col < gameBoardLenght; col++) {
                char possition = gameBoard[row][col];
                if (possition == water) {
                    System.out.print(water + " ");
                } else {
                    System.out.print(possition + " ");
                }

            }
            System.out.println();
        }
        //System.out.println();
    }