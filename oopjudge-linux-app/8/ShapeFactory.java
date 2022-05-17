
public class ShapeFactory {
    public enum Type {
        Triangle, Circle, Square
    }

    /**
     * Creates instance of all shapes refer to 𝚃𝚢𝚙𝚎 parameter.
     * @param shapeType The shape's type.
     * @param length The length of the shape.
     * @return A instance of the shape.
     */
    public Shape createShape(ShapeFactory.Type shapeType, double length) {
        if (shapeType == ShapeFactory.Type.Triangle) {
            Triangle triangle = new Triangle(length);
            return triangle;
        } else if (shapeType == ShapeFactory.Type.Circle) {
            Circle circle = new Circle(length);
            return circle;
        } else {
            Square square = new Square(length);
            return square;
        }
    }
}
