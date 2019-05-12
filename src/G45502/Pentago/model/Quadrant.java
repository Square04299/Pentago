package G45502.Pentago.model;

import G45502.Pentago.exception.UnavailablePlace;

/**
 * One of the 4 square of the board
 *
 * @author G45502
 */
public class Quadrant {

    private final Marble[][] quadrant;
    private final int MAX_SIZE;

    /**
     * Builder of Quadrant
     */
    public Quadrant() {
        this.MAX_SIZE = 3;
        this.quadrant = new Marble[MAX_SIZE][MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                this.quadrant[i][j] = Marble.EMPTY;
            }

        }
    }

    /**
     * Getter of Quadrant
     *
     * @return 2d Array of Marble
     */
    public Marble[][] getQuadrant() {
        Marble[][] returnQ = quadrant;
        return returnQ;
    }

    /**
     * Get the value of a point in the array
     *
     * @param x x axis
     * @param y y axis
     * @return the value of the cell
     */
    public Marble getPoint(int x, int y) {
        return this.quadrant[x][y];
    }

    void addPiece(int x, int y, Marble color) {
        if (quadrant[x][y] != Marble.EMPTY) {
            throw new UnavailablePlace("A Marble is already in this slot");
        }
        this.quadrant[x][y] = color;
    }

    void rotateRight() {
        for (int j = 0; j < MAX_SIZE - 1; j++) {
            Marble temp = this.quadrant[0][j]; //Save [0][0]
            this.quadrant[0][j] = this.quadrant[j][MAX_SIZE - 1]; //Move [0][2] to [0][0]
            this.quadrant[j][MAX_SIZE - 1] = this.quadrant[MAX_SIZE - 1][MAX_SIZE - 1 - j]; //Move [2][2] to [0][2]
            this.quadrant[MAX_SIZE - 1][MAX_SIZE - 1 - j] = this.quadrant[MAX_SIZE - 1 - j][0]; //Move [2][0] to [2][2]
            this.quadrant[MAX_SIZE - 1 - j][0] = temp; //Move [0][0] to [2][0]
        }
    }

    void rotateLeft() {
        for (int i = 0; i < 3; i++) {
            this.rotateRight();
        }
    }

    boolean isEmpty() {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (this.quadrant[i][j] == Marble.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }
}
