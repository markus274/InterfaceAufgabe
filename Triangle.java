/**
Die Klasse Triangle erzeugt ein gleichseitiges Dreieck und implementiert das Geometry-Interface.
*/
public class Triangle implements Geometry {

    /**
    Laenge eines einzelnen Schenkels.
    */
    private double length;

    /**
    Methode des Comparable Interfaces, die ein Objekt der Klasse Triangle mit dem uebergebenen Objekt b vergleicht.
    @param Objekt einer Klasse, die das Geometry-Interface implementiert.
    @return 0, wenn die Flaeche und Umfang gleich sind.
    @return negativer Wert, wenn das aktuelle Objekt kleiner ist als das uebergebene Objekt b.
    @retrun positiver Wert, wenn das aktuelle Objekt grosser ist als das uebergebene Objekt b.
    @param Objekt, welches das Geometry-Interface implementiert hat. Ist das nicht der Fall, wird eine
    IllegalArgumentException geworfen.
    */
    public int compareTo(Geometry b) {                      //wie wird ein allgemeines Objekt übergeben?

        double areaDifference, perimeterDifference, eps = 0.0001;

        areaDifference = this.getArea() - b.getArea();
        perimeterDifference = this.getPerimeter() - b.getPerimeter();
        
        if (Math.abs(perimeterDifference) < eps) {              //Umfang ist gleich
            if (Math.abs(areaDifference) < eps) {               //Umfang und Flaeche sind gleich
                return 0;
            } else if (areaDifference > eps) {                     //Umfang gleich, Flaeche von b kleiner
                return 1;
            } else {                                              //Umfang gleich, Flaeche von b groesser
                return -1;
            } 
        } else {
            if (perimeterDifference > eps) {                    //Umfang von b kleiner
                return 1;
            } else {                                              //Umfang von b groesser
                return -1;
            }
        }    
    }
    //Die IllegalArgumentExeption muss noch implementiert werden.

    /**
    Klont das Triangle-Objekt
    @return 
    */
    
    public Triangle clone() {
    
    }
    
    public static double getArea() {
    
    double area = (this.length * Math.sqrt(4)) / 3;
    return area;
    }
    
    public static double getPerimeter() {
    
    double perimeter = 3 * this.length;
    return perimeter;
    }
    
    public static String printType() {
    }
}
