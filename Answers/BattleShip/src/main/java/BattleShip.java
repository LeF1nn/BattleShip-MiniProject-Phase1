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