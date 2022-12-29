package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private List<Ship> ships;
    private String name;

    private Battlefield battlefield;

    public Player(String name) {
        this.ships = new ArrayList<>();
        addShips();
        this.name= name;
    }

    public void setBattlefield(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    public void addShips() {
        ships.add(new Ship("Aircraft Carrier",5));
        ships.add(new Ship("Battleship", 4));
        ships.add(new Ship("Submarine", 3));
        ships.add(new Ship("Cruiser", 3));
        ships.add(new Ship("Destroyer", 2));
    }

    public void shipDestroyed(String shipname) {
        for (Ship ship : ships) {
            if (ship.getShipName().toLowerCase().equals(shipname.toLowerCase())) {
                ship.setDestroyed(true);
            }
        }
    }

    public void positionShip() {

        Scanner scanner = new Scanner(System.in);
        String firstCoord = scanner.next();
        String secondCoord = scanner.next();

        int yPositionBeginning = firstCoord.charAt(0) - 'A' + 1; //must consider the numbering of the field
        int xPositionBeginning = Integer.parseInt(firstCoord.replaceAll("[^0-9]",""));

        System.out.println("yPositionBeginning: " + yPositionBeginning);
        System.out.println("xPositionBeginning: " + xPositionBeginning);

        int yPositionEnding = (secondCoord.charAt(0)) - 'A' + 1;
        int xPositionEnding = Integer.parseInt(secondCoord.replaceAll("[^0-9]",""));
        System.out.println("yPositionEnding: " + yPositionEnding);
        System.out.println("xPositionEnding: " + xPositionEnding);


        battlefield.shipPosition(yPositionBeginning, xPositionBeginning, yPositionEnding, xPositionEnding);
        battlefield.createField();
    }

    public void shipPlacement(Ship ship) {
        System.out.println("Enter the coordinates of the " + ship.getShipName() + "(" + ship.getSize() + " cells)");
    }

    public boolean shipTooBig(Ship ship, int yBegin, int xBegin, int yEnd, int xEnd) {
        int shipLength = ship.getSize();
        if ((shipLength + yEnd) > 10 || (shipLength + xEnd) > 10) {
            System.out.println("Ship is too big to be placed here!");
            return true;
        } else {
            return false;
        }
    }

    public boolean outOfBound(int yBeginning, int xBeginning, int yEnding, int xEnding) {
        boolean outOfBound = false;
        if (yBeginning < 1 || xBeginning < 1 || yEnding < 1 || xEnding < 1 || yBeginning > 10 || xBeginning > 10 || yEnding > 10 || xEnding > 10) {
            System.out.println("Out of Bound");
            outOfBound = true;
        }
        return outOfBound;
    }

    public boolean wrongAxis(int yBegin, int xBegin, int yEnd, int xEnd) {
        if ((yBegin == yEnd) || (xBegin == xEnd)) {
            return false;
        } else {
            System.out.println("Axis not correct, must be horizontal or vertical");
            return true;
        }
    }

    public boolean tooClose(int yBegin, int xBegin, int yEnd, int xEnd) {
        boolean[][] field = battlefield.getFieldStatus();
        for (int i = yBegin; i <= yEnd; i++) {
            for (int j = xBegin; j <= xEnd; j++) {
                if (field[i][j] || field[i+1][j] || field[i-1][j] || field[i][j+1] ||field[i][j-1] ) {
                    System.out.println("Wrong position, field already taken or too close!");
                    return true;
                }
            }
        } return false;
    }

    public boolean doChecks(Ship ship, int yBegin, int xBegin, int yEnd, int xEnd) {
        boolean shipSize = shipTooBig(ship, yBegin, xBegin, yEnd, xEnd);
        boolean outOfBound = outOfBound(yBegin, yEnd, xBegin., xEnd);
        boolean wrongAxis = wrongAxis(yBegin, xBegin, yEnd, xEnd);
        boolean tooClose = tooClose (yBegin, xBegin, yEnd, xEnd);

        return shipSize && outOfBound && wrongAxis && tooClose;

    }
}