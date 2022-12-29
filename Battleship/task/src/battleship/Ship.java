package battleship;

public class Ship {
    private String shipName;
    private int size;
    private boolean destroyed;
    private boolean placed;


    public Ship(String shipName, int size) {
        this.shipName = shipName;
        this.size = size;
    }

    public String getShipName() {
        return this.shipName;
    }

    public int getSize(){
        return this.size;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }
}