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
    
    void rotateRight(){
        for (int j = 0; j < MAX_SIZE / 2; j++) {
            int temp = this.quadrant[0][j];
            this.quadrant[0][j] = this.quadrant[j][MAX_SIZE - 1];
            this.quadrant[j][MAX_SIZE - 1] = this.quadrant[MAX_SIZE - 1][MAX_SIZE - 1 - j];
            this.quadrant[MAX_SIZE - 1][MAX_SIZE - 1 - j] = this.quadrant[MAX_SIZE - 1 - j][0];
            this.quadrant[MAX_SIZE - 1 - j][0] = temp;
        }
    }
    
    void rotateLeft(){
        for (int i = 0; i < 3; i++) {
            this.rotateRight();
        }
    }
}
