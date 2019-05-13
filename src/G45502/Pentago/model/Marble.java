package G45502.Pentago.model;

/**
 * Marble that will be placed on the board
 *
 * @author G45502
 */
public enum Marble {

    /**
     * Color of the Marble, with a value of 0
     */
    BLACK(0),
    /**
     * Color of the Marble, with a value of 1
     */
    WHITE(1),
    /**
     * Color of the Marble, with a value of 2
     */
    GREY(2),
    /**
     * Default color of a board, with a value of -1
     */
    EMPTY(-1);

    private final int value;

    private Marble(int value_) {
        this.value = value_;
    }

    /**
     * Getter of value
     *
     * @return Value of the Marble
     */
    public int getValue() {
        return value;
    }

}
