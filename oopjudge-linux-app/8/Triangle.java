import java.text.DecimalFormat;

public class Triangle extends Shape {
    // public Triangle() {
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

    public Triangle(double length) {
        super(length);
    }

    @Override
    public void setLength(double length) {
        super.length = length;
    }

    @Override
    public double getArea() {
        return formatDoubleOutput(0.25 * Math.sqrt(3) * super.length * super.length);
    }

    @Override
    public double getPerimeter() {
        return formatDoubleOutput(3 * super.length);
    }
}
