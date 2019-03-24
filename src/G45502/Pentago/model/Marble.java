package G45502.Pentago.model;

/**
 *
 * @author G45502
 */
public enum Marble {
    BLACK(0), WHITE(1);

    private final int value;

    private Marble(int value_) {
        this.value = value_;
    }

    public int getValue() {
        return value;
    }
}
