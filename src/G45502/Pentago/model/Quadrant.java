package G45502.Pentago.model;


/**
 *
 * @author G45502
 */
public class Quadrant {
    
    private int[][] quadrant;
    private final int MAX_SIZE = 3;

    public Quadrant() {
        this.quadrant = new int[MAX_SIZE][MAX_SIZE];
    }

    public int[][] getQuadrant() {
        return quadrant;
    }

    void addPiece(int x, int y, Marble color){
        this.quadrant[x][y] = color.getValue();
    }
    
    void rotateLeft(){
        for (int j = 0; j < 2; j++) {
            int temp = this.quadrant[0][j]; //Save [0][0]
            this.quadrant[0][j] = this.quadrant[j][MAX_SIZE - 1]; //Move [0][2] to [0][0]
            this.quadrant[j][MAX_SIZE - 1] = this.quadrant[MAX_SIZE - 1][MAX_SIZE - 1 - j];
            this.quadrant[MAX_SIZE - 1][MAX_SIZE - 1 - j] = this.quadrant[MAX_SIZE - 1 - j][0];
            this.quadrant[MAX_SIZE - 1 - j][0] = temp;
        }
    }
    
    void rotateRight(){
        for (int i = 0; i < 3; i++) {
            this.rotateLeft();
        }
    }
}