import java.text.DecimalFormat;

public class Square extends Shape {
    // public Square() {
    // super();
    // }

    /**
     * Formats the double to round to two digits, and makes zero 0.0.
     *
     * @param rawDouble The to be formatted double.
     * @return A formatted double.
     */
    private Double formatDoubleOutput(double rawDouble) {
        DecimalFormat outputDoubleFormat = new DecimalFormat("0.0#");
        return Double.parseDouble(outputDoubleFormat.format(rawDouble));
    }

    public Square(double length) {
        super(length);
    }

    @Override
    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return formatDoubleOutput(super.length * super.length);
    }

    @Override
    public double getPerimeter() {
        return formatDoubleOutput(4 * super.length);
    }

}
