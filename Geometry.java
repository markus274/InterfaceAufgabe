public interface Geometry extends Comparable, Cloneable {
    
    /**
    Berechnet Flaeche des Objektes.
    */
    public double getArea();
    
    /**
    Berechnet Umfang des Objektes.
    */
    public double getPerimeter();
    /**
    Gibt Klassennamen als String zurück.
    */
    public default String printType() {
        return this.getClass().getSimpleName();
    }
}
