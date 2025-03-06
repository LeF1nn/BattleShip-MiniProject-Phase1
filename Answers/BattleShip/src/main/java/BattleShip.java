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