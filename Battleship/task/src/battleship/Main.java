package battleship;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Write your code here
        Battlefield battlefield = new Battlefield();
        Player player = new Player("Dominik");
        player.setBattlefield(battlefield);
        player.positionShip();

    }
}