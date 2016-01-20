public interface Geometry extends Comparable, Cloneable {
    
    /**
    Berechnet Flaeche des Objektes.
    */
    double getArea();
    
    /**
    Berechnet Umfang des Objektes.
    */
    double getPerimeter();
    /**
    Gibt Klassennamen als String zurück.
    */
    default String printType() {
        return this.getClass().getSimpleName();
    }
}
