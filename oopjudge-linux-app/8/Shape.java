// import java.text.DecimalFormat;

public abstract class Shape {
    protected double length;

    public Shape() {
        this.length = 0;
    }

    public Shape(double length) {
        this.length = length;
    }

    public abstract void setLength(double length);

    public abstract double getArea();

    public abstract double getPerimeter();

    // public String getInfo() {
    // DecimalFormat outputDoubleFormat = new DecimalFormat("0.0#");
    // return String.format("Area = %s, Perimeter = %s",
    // outputDoubleFormat.format(this.getArea()),
    // outputDoubleFormat.format(this.getPerimeter())) ;
    // }

    public String getInfo() {
        return "Area = " + getArea() + ", Perimeter = " + getPerimeter();
    }
}
