
public class ATM_Exception extends Exception {

    /**
     * Types of exception.
     */
    public enum ExceptionTYPE {
        BALANCE_NOT_ENOUGH, AMOUNT_INVALID
    }

    /**
     * Records the detail of exception raised.
     */
    private ExceptionTYPE exceptionCondition;

    /**
     * Constructor
     *
     * @param exceptionType The type of ATM_Exception to be raised.
     */
    public ATM_Exception(ExceptionTYPE exceptionType) {
        super(String.format("%s", exceptionType));
        this.exceptionCondition = exceptionType;
    }
}
