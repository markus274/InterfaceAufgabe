public class Square implements Geometry {

    double a,b;

    /**
    Konstruktor, der die Laenge der Seiten setzt.
    */
    public Square(double newA) {
        this.a = newA;
        this.b = newA;
    }

    /**
    Methode des Geometry-Interfaces - Berechnet den Flaecheninhalt.
    @return gibt den Flaecheninhalt als double zurueck.
    */
    public static double getArea() {
    
    double area = this.a * this.b;
    return area;
    }

    /**
    Methode des Geometry-Interfaces - Berechnet den Umfang.
    @return gibt den Umfang als double zurueck.
    */     
    public static double getPerimeter() {
    
    double perimeter = 2 * this.a + 2 * this.b;
    return perimeter;
    }
    
    public static String printType() {
    }
    
    /**
    Methode des Comparable Interfaces, die ein Objekt der Klasse Square mit dem uebergebenen Objekt b vergleicht.
    @param Objekt einer Klasse, die das Geometry-Interface implementiert.
    @return 0, wenn die Flaeche und Umfang gleich sind.
    @return negativer Wert, wenn das aktuelle Objekt kleiner ist als das uebergebene Objekt b.
    @retrun positiver Wert, wenn das aktuelle Objekt grosser ist als das uebergebene Objekt b.
    @param Objekt, welches das Geometry-Interface implementiert hat. Ist das nicht der Fall, wird eine
    IllegalArgumentException geworfen.
    */
    public int compareTo(Object b) {                      //wie wird ein allgemeines Objekt übergeben?

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

    public boolean equals(Object b) {

        if ( !(b instanceof Triangle) ) {
        return false;
        } else {
        return (this.length == b.length);
        }
    }

    /**
    Klont das Square-Objekt
    @return gibt das geklone Square-Object zurueck
    */      
    public Square clone() {
        Square A = new Square();
        A = this.Square;
        return A;
    }

}
