/**
Programm um die Funktionalitaet der in Circle, Square und Triangle implementierten Methoden
und Interfaces zu testen.
@author David Nancekievill MATRIKELNUMMER Gruppe 9c
*/
public class Test {

    /**
    Main-Methode
    @param args Standard Eingabeparameter
    */
    public static void main(String[] args) {
    
        Square square = new Square(42);
        
        // System.out.println(square.printType());
        
        try {
            if (square.clone().getArea() != 1764.0) {
                System.err.println("square: wrong area");
            }
        } catch (CloneNotSupportedException e) {
            System.out.println("Objekt kann nicht geklont werden!");
        }
        try {
            if (square.clone().getPerimeter() != 168.0) {
                System.err.println("square: wrong perimeter");
            }
        } catch (CloneNotSupportedException e) {
            System.out.println("Objekt kann nicht geklont werden!");
        }
        try {
            if (!square.equals(square.clone())) {
                System.err.println("square: wrong equals or clone");
            }
        } catch (CloneNotSupportedException e) {
            System.out.println("Objekt kann nicht geklont werden!");
        }
            
        Triangle triangle = new Triangle(56);
        
        try {
            if (triangle.getPerimeter() != square.getPerimeter()) {
                System.err.println("triangle: wrong perimeter");
            }
            if (triangle.getArea() != 1357.9278331339997) {
                System.err.println("triangle: wrong area");
            }
            if (triangle.compareTo(square) >= 0) {
                System.err.println("wrong compareTo");
            }
        } catch (IllegalArgumentException e) {
        
            System.out.println("Objekt kann nicht geklont werden!");
        
        }
            
    }
}
