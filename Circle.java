public class Circle implements Geometry {

    double r;

    /**
    Konstruktor, der den Radius setzt.
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
    
    /*
    public static String printType() {
    }
    */
    
    /**
    Methode des Comparable Interfaces, die ein Objekt der Klasse Circle mit dem uebergebenen Objekt b vergleicht.
    @param Objekt einer Klasse, die das Geometry-Interface implementiert.
    @return 0, wenn die Flaeche und Umfang gleich sind.
    @return negativer Wert, wenn das aktuelle Objekt kleiner ist als das uebergebene Objekt b.
    @retrun positiver Wert, wenn das aktuelle Objekt grosser ist als das uebergebene Objekt b.
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
    */      
    public Circle clone() throws CloneNotSupportedException {

        if ( !(this instanceof Cloneable) ) {
            throw new CloneNotSupportedException();
        } else {
            Circle A = new Circle(this.r);
            return A;
        }
    }    
}
