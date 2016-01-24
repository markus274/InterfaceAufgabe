/**
Klasse Square, erbt von Geometry. Instanziiert ein Quadrat mit der Seitenlaenge a.
@author David Nancekievill MATRIKELNUMMER Gruppe 9c
*/
public class Square implements Geometry {

    /**
    Seitenlaenge des Quadrats.
    */
    private double a, b;

    /**
    Konstruktor, der die Laenge der Seiten setzt.
    @param newA Seitenlaenge mit der das Objekt initialisiert werden soll.
    */
    public Square(double newA) {
    
        this.a = newA;
        this.b = newA;
        
    }

    /**
    set-Methode für die Seitenlaenge a.
    @param a Erwartet Seitenlaenge a als double.
    */ 
    public void setA(double a) {
    
        this.a = a;
        
    }
    /**
    get-Methode für die Seitenlaenge a.
    @return gibt die Seitenlaenge als double zurueck.
    */
    public double getA() {
    
        return this.a;
        
    }
    
    /**
    Methode des Geometry-Interfaces - Berechnet den Flaecheninhalt.
    @return gibt den Flaecheninhalt als double zurueck.
    */  
    public double getArea() {
    
        double area = this.a * this.b;
        
        return area;
    }

    /**
    Methode des Geometry-Interfaces - Berechnet den Umfang.
    @return gibt den Umfang als double zurueck.
    */     
    public double getPerimeter() {
    
        double perimeter = 2 * this.a + 2 * this.b;
        
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

        if ( !(b instanceof Square) ) {
            return false;
        } else {
            Square c = (Square) b;
            objectDifference = this.getA() - c.getA();
            
            return (objectDifference < eps);
        }
    }

    /**
    Klont das Circle-Objekt
    @return gibt das geklonte Object zurueck
    @throws CloneNotSupportedException Objekt kann nicht geklont werden
    */   
    public Square clone() throws CloneNotSupportedException {

        if ( !(this instanceof Cloneable) ) {
            throw new CloneNotSupportedException();
        } else {
            Square a = new Square(this.a);
            return a;
        }
    }
}
