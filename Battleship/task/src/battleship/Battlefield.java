package battleship;

public class Battlefield {

    private final int x;
    private final int y;
    private boolean[][] fieldStatus;
    private Player player;

    public Battlefield() {
        this.x = 10;
        this.y = 10;
        this.fieldStatus = new boolean[this.x+1][this.y+1];

    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean[][] getFieldStatus() {
        return fieldStatus;
    }

    public void setFieldStatus(boolean[][] fieldStatus) {
        this.fieldStatus = fieldStatus;
    }



    public void createField() {
        for (int i = 0; i <= this.x; i++) {
            for (int j = 0; j <= this.y; j++) {
                if (i == 0 && j > 0) {
                    System.out.print("  " + j);
                }
                int alpha = 'A';
                if (i > 0 && j == 0) {
                    alpha = alpha + i -1 ; // -1 because of the empty corner
                    System.out.print((char) alpha);
                }
                if (i > 0 && j > 0 && !fieldStatus[i][j]) {
                    System.out.print(" ~ ");
                }
                if (i > 0 && j > 0 && fieldStatus[i][j]) {
                    System.out.print(" 0 ");
                }
            }
            System.out.print("\n");
        }
    }

    public void shipPosition(int yBeginning, int xBeginning, int yEnding, int xEnding) {
        for (int i = yBeginning; i <= yEnding; i++) {
            for (int j = xBeginning; j <= xEnding; j++) {
                this.fieldStatus[i][j] = true;
            }
        }
        // If the endposition is placed first by the player then the beginning will be the ending and vice versa
        for (int i = yBeginning; i >= yEnding; i--) {
            for (int j = xBeginning; j >= xEnding; j--) {
                this.fieldStatus[i][j] = true;
            }
        }


    }


    public void addPlayer(Player player) {
        if (player == null) {
            this.player = player;
        }
    }

}
