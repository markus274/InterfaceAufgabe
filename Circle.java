public class Circle implements Geometry {

    double r;

    public static double getArea() {
    
    double area = Math.pi() * this.r * this.r;
    return area;
    }
    
    public static double getPerimeter() {
    
    double perimeter = Math.pi() * 2 * this.r;
    return perimeter;
    }
    
    public static String printType() {
    }
    
}
