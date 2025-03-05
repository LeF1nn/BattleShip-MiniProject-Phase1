public class BattleShip {
    public static void main(String[] args) {
        int boardSize = 10;
        char water = '~';
        char ship = 'S';
        char hit = 'X';
        int miss = 'O';
        int shipNum = 4;

        char[][] view  = Map(boardSize , water ,ship , shipNum);

    }
}