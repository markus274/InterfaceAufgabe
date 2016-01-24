/**
Die Klasse Triangle erzeugt ein gleichseitiges Dreieck und implementiert das Geometry-Interface.
@author David Nancekievill MATRIKELNUMMER Gruppe 9c
*/
public class Triangle implements Geometry {

    /**
    Laenge eines einzelnen Schenkels.
    */
    private double length;
    
    /**
    Methode des Geometry-Interfaces - Berechnet den Flaecheninhalt.
    @return gibt den Flaecheninhalt als double zurueck.
    */
    public double getArea() {
    
        double area = (this.length * this.length * Math.sqrt(3)) / 4;
        
        return area;
        
    }
    
    /**
    Methode des Geometry-Interfaces - Berechnet den Umfang.
    @return gibt den Umfang als double zurueck.
    */    
    public double getPerimeter() {
    
        double perimeter = 3 * this.length;
        
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
    Konstruktor, der die Laenge der Schenkel setzt.
    @param newLength Seitenlaenge mit der das Objekt initialisiert werden soll.
    */
    public Triangle(double newLength) {

        this.length = newLength;
        
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
        // Geometry c = (Geometry) b;

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

        if ( !(b instanceof Triangle) ) {
            return false;
        } else {
            Triangle c = (Triangle) b;
            objectDifference = this.length - c.length;
            
            return (objectDifference < eps);
        }
    }
    
    /**
    Klont das Circle-Objekt
    @return gibt das geklonte Object zurueck
    @throws CloneNotSupportedException Objekt kann nicht geklont werden
    */  
    public Triangle clone() throws CloneNotSupportedException {

        if ( !(this instanceof Cloneable) ) {
            throw new CloneNotSupportedException();
        } else {
            Triangle a = new Triangle(this.length);
            return a;
        }
    }
}
