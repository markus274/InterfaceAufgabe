/**
Interface Geometry, erbt von den Interfaces Comparable und Cloneable.
@author David Nancekievill MATRIKELNUMMER Gruppe 9c
*/
public interface Geometry extends Comparable, Cloneable {
    
    /**
    Berechnet Flaeche des Objektes.
    @return Gibt die Fläche des Objektes als double zurueck.
    */
    public double getArea();
    
    /**
    Berechnet Umfang des Objektes.
    @return Gibt den Umfang des Objektes als double zurueck.
    */
    public double getPerimeter();
    
    /**
    Gibt Klassennamen als String zurück.
    @return Gibt die Klassennamen des Objektes als String zurueck.
    */
    public String printType();
}
