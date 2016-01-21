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
    public void setA(double a) {
    
        this.a = a;
    }
    
    public double getA() {
    
        return this.a;
    }
    
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
    
    public String printType() {
        return this.getClass().getSimpleName();
    }
    
    /**
    Methode des Comparable Interfaces, die ein Objekt der Klasse Square mit dem uebergebenen Objekt b vergleicht.
    @param Objekt einer Klasse, die das Geometry-Interface implementiert.
    @return 0, wenn die Flaeche und Umfang gleich sind.
    @return negativer Wert, wenn das aktuelle Objekt kleiner ist als das uebergebene Objekt b.
    @return positiver Wert, wenn das aktuelle Objekt grosser ist als das uebergebene Objekt b.
    @param Objekt, welches das Geometry-Interface implementiert hat. Ist das nicht der Fall, wird eine
    IllegalArgumentException geworfen.
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
    Klont das Square-Objekt
    @return gibt das geklone Square-Object zurueck
    */      
    public Square clone() throws CloneNotSupportedException {

        if ( !(this instanceof Cloneable) ) {
            throw new CloneNotSupportedException();
        } else {
            Square A = new Square(this.a);
            return A;
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

        if ( !(b instanceof Clonable) ) {
            throw new CloneNotSupportedException("Die Objekte können nicht geklont werden!");
        }
        Square A = new Square();
        A = this.Square;
        return A;
    }

}
