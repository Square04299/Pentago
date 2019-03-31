package G45502.Pentago.model;

import G45502.Pentago.exception.UnavailablePlace;

/**
 *
 * @author G45502
 */
public class Quadrant {

    private final int[][] quadrant;
    private final int MAX_SIZE;

    /**
     * Builder of Quadrant
     */
    public Quadrant() {
        this.MAX_SIZE = 3;
        this.quadrant = new int[MAX_SIZE][MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                this.quadrant[i][j] = -1;
            }

        }
    }

    /**
     * Getter of Quadrant
     *
     * @return 2d Array of int
     */
    public int[][] getQuadrant() {
        int[][] returnQ = quadrant;
        return returnQ;
    }

    /**
     * Get the value of a point in the array
     *
     * @param x x axis
     * @param y yaxis
     * @return the value of the cell
     */
    public int getPoint(int x, int y) {
        return this.quadrant[x][y];
    }

    void addPiece(int x, int y, Marble color) {
        if (quadrant[x][y] == -1) {
            this.quadrant[x][y] = color.getValue();
        } else {
            throw new UnavailablePlace("A Marble is already in this slot");
        }
    }

    void rotateLeft() {
        for (int j = 0; j < 2; j++) {
            int temp = this.quadrant[0][j]; //Save [0][0]
            this.quadrant[0][j] = this.quadrant[j][MAX_SIZE - 1]; //Move [0][2] to [0][0]
            this.quadrant[j][MAX_SIZE - 1] = this.quadrant[MAX_SIZE - 1][MAX_SIZE - 1 - j];
            this.quadrant[MAX_SIZE - 1][MAX_SIZE - 1 - j] = this.quadrant[MAX_SIZE - 1 - j][0];
            this.quadrant[MAX_SIZE - 1 - j][0] = temp;
        }
    }

    void rotateRight() {
        for (int i = 0; i < 3; i++) {
            this.rotateLeft();
        }
    }

    boolean isEmpty() {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (this.quadrant[i][j] == -1) {
                    return true;
                }
            }
        }
        return false;
    }
}
