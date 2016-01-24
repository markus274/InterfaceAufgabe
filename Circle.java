/**
Klasse Circle erbt Geometry. Instanziiert einen Kreis der ueber seinen Radius r definiert ist.
@author David Nancekievill MATRIKELNUMMER Gruppe 9c
*/

public class Circle implements Geometry {

    /**
    Radius des Kreises, double
    */
    private double r;

    /**
    Konstruktor, der den Radius setzt.
    @param newR Erwartet Radius als Double
    */
    public Circle(double newR) {
    
        this.r = newR;
        
    }

    /**
    Methode des Geometry-Interfaces - Berechnet den Flaecheninhalt.
    @return gibt den Flaecheninhalt als double zurueck.
    */
    public double getArea() {
    
        double area = Math.PI * this.r * this.r;
        
        return area;
    }

    /**
    Methode des Geometry-Interfaces - Berechnet den Umfang.
    @return gibt den Umfang als double zurueck.
    */
    public double getPerimeter() {
    
        double perimeter = Math.PI * 2 * this.r;

        return perimeter;
    }
    
    /**
    Methode gibt den Klassennamen des Objektes als String zurueck.
    @return Klassenname als String
    */
    public String printType() {
    
        return this.getClass().getSimpleName();
        
    }
        
    /**
    Methode des Comparable Interfaces, die ein Objekt der Klasse Circle mit dem uebergebenen Objekt b
    vergleicht, welches das Geometry-Interface implementiert hat. Ist das nicht der Fall, wird eine
    IllegalArgumentException geworfen.
    @param b einer Klasse, die das Geometry-Interface implementiert.
    @return 0, wenn die Flaeche und Umfang gleich sind,
    negativer Wert, wenn das aktuelle Objekt kleiner ist als das uebergebene Objekt b,
    positiver Wert, wenn das aktuelle Objekt grosser ist als das uebergebene Objekt b.
    @throws IllegalArgumentException Objekt kann nicht verglichen werden
    */
    public int compareTo(Object b) throws IllegalArgumentException {

        double areaDifference, perimeterDifference, eps = 0.0001;

        if ( !(b instanceof Geometry) ) {

            throw new IllegalArgumentException("Die Objekte sind nicht vergleichbar");
            
        } else {
        
            Geometry c = (Geometry) b;

            areaDifference = this.getArea() - c.getArea();
            perimeterDifference = this.getPerimeter() - c.getPerimeter();
            
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
    }
    
    /**
    Vergleicht zwei Objekte
    @param b Objekt mit dem die aufrufende Circle Instanz verglichen werden soll 
    @return false falls die Objekte sich nicht gleichen, true falls doch.
    */
    public boolean equals(Object b) {
        
        double eps = 0.0001, objectDifference;

        if ( !(b instanceof Circle) ) {
            return false;
        } else {
            Circle c = (Circle) b;
            objectDifference = this.r - c.r;
            
            return (objectDifference < eps);
        }
    }
        
    /**
    Klont das Circle-Objekt
    @return gibt das geklonte Object zurueck
    @throws CloneNotSupportedException Objekt kann nicht geklont werden
    */      
    public Circle clone() throws CloneNotSupportedException {

        if ( !(this instanceof Cloneable) ) {
            throw new CloneNotSupportedException();
        } else {
            Circle a = new Circle(this.r);
            return a;
        }
    }    
}
