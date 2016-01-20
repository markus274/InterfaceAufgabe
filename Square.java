public class Square implements Geometry {

    double a,b;

    public static double getArea() {
    
    double area = this.a * this.b;
    return area;
    }
    
    public static double getPerimeter() {
    
    double perimeter = 2 * this.a + 2 * this.b;
    return perimeter;
    }
    
    public static String printType() {
    }    
}
