import java.text.DecimalFormat;

public class SimpleCalculator {
    private String plusOperator = "+";
    private String minusOperator = "-";
    private String multiplyOperator = "*";
    private String divideOperator = "/";

    private int calCount = 0;

    private double result = 0;
    private double value;
    private String operator = null;

    /**
     * Parses the command and set new result. If command is not valid, throws an
     * UnknownCmdException contained the error message.
     *
     * @param cmd The input command, composed of “operator” and “value” separated by
     *            a space.
     * @throws UnknownCmdException Thrown if the command is invalid.
     */
    public void calResult(String cmd) throws UnknownCmdException {
        parseCmd(cmd);

        if (this.operator.equals(plusOperator)) {
            this.result += this.value;
        } else if (this.operator.equals(minusOperator)) {
            this.result -= this.value;
        } else if (this.operator.equals(multiplyOperator)) {
            this.result *= this.value;
        } else if (this.operator.equals(divideOperator)) {
            this.result /= this.value;
        } else {
            throw new UnknownCmdException(String.format("%s is an unknown operator", this.operator));
        }

        this.calCount += 1;

    }

    /**
     * Outputs the message of the result of this step. The output message depends on
     * the calculation count.
     *
     * @return The message of the result of this step
     */
    public String getMsg() {

        DecimalFormat outputDoubleFormat = new DecimalFormat("0.00");
        String formattedResult = outputDoubleFormat.format(this.result);
        String formattedValue = outputDoubleFormat.format(this.value);
        String message = null;

        if (this.calCount == 0) {
            message = String.format("Calculator is on. Result = %s", formattedResult);
        } else if (this.calCount == 1) {
            message = String.format("Result %s %s = %s. New result = %s", this.operator, formattedValue,
                    formattedResult, formattedResult);
        } else if (this.calCount > 1) {
            message = String.format("Result %s %s = %s. Updated result = %s", this.operator, formattedValue,
                    formattedResult, formattedResult);
        } else {
            message = String.format("Final result = %s", formattedResult);
        }

        return message;
    }

    /**
     * Determines whether calculation comes to the end or not.
     *
     * @param cmd
     * @return
     */
    public boolean endCalc(String cmd) {
        if (cmd.equals("r") || cmd.equals("R")) {
            this.calCount = -1;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Parses value from String.
     *
     * @param value The input String value.
     * @return A Double parsed from String.
     * @throws NumberFormatException Thrown if the string is not convertable.
     */
    private Double parseValue(String value) throws NumberFormatException {
        return Double.parseDouble(value);
    }

    /**
     * Checks if the operator is valid.
     *
     * @param operator The input operator string.
     * @return If the input operator is valid.
     */
    private boolean isValidOperator(String operator) {
        if (operator.equals(plusOperator) || operator.equals(minusOperator) || operator.equals(multiplyOperator)
                || operator.equals(divideOperator)) {

        } else {
            return false;
        }

        return true;
    }

    /**
     * Parses the command and sets value and operator.
     *
     * @param cmd The raw input command.
     * @throws UnknownCmdException Thrown if the command is invalid.
     */
    private void parseCmd(String cmd) throws UnknownCmdException {
        String[] cmdElements = cmd.split(" ");

        if (cmdElements.length != 2) {
            throw new UnknownCmdException("Please enter 1 operator and 1 value separated by 1 space");

        } else {
            boolean isValidOperator = isValidOperator(cmdElements[0]);
            boolean isValidValue;
            double parsedValue = 0;

            try {
                parsedValue = parseValue(cmdElements[1]);
                isValidValue = true;
            } catch (NumberFormatException numberFormatException) {
                isValidValue = false;
            }

            if (isValidOperator && isValidValue) {
                if (cmdElements[0].equals("/") && parsedValue == 0) {
                    throw new UnknownCmdException("Can not divide by 0");
                } else {
                    this.operator = cmdElements[0];
                    this.value = parsedValue;
                }

            } else if (!isValidOperator && isValidValue) {
                throw new UnknownCmdException(String.format("%s is an unknown operator", cmdElements[0]));
            } else if (isValidOperator && !isValidValue) {
                throw new UnknownCmdException(String.format("%s is an unknown value", cmdElements[1]));
            } else {
                throw new UnknownCmdException(String.format("%s is an unknown operator and %s is an unknown value",
                        cmdElements[0], cmdElements[1]));
            }

        }
    }

}
