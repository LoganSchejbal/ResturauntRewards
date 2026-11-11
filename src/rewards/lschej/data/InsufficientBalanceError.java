package rewards.lschej.data;

public class InsufficientBalanceError extends RuntimeException {

    public InsufficientBalanceError(String message) {
        super(message);
    }
}
