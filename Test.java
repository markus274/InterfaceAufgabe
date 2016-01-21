public class Test {
    public static void main(String[] args) {
        Square square = new Square(42);
        System.out.println(square.printType());
        /*if (square.clone().getArea() != 1764.0)
            System.err.println("square: wrong area");
        if (square.clone().getPerimeter() != 168.0)
            System.err.println("square: wrong perimeter");
        if (!square.equals(square.clone()))
            System.err.println("square: wrong equals or clone");
        Triangle triangle = new Triangle(56);
        if (triangle.getPerimeter() != square.getPerimeter())
            System.err.println("triangle: wrong perimeter");
        if (triangle.getArea() != 1357.9278331339997)
            System.err.println("triangle: wrong area");
        if (triangle.compareTo(square) >= 0)
            System.err.println("wrong compareTo");*/
    }
}
