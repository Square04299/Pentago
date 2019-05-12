package G45502.Pentago.exception;

/**
 *
 * @author Square
 */
public class UnavailablePlace extends RuntimeException {

    /**
     * Creates a new instance of <code>UnavailablePlace</code> without detail
     * message.
     */
    public UnavailablePlace() {
    }

    /**
     * Constructs an instance of <code>UnavailablePlace</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UnavailablePlace(String msg) {
        super(msg);
    }
}
