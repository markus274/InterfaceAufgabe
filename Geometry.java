public interface Geometry extends Comparable, Cloneable {
    public double getArea();
    public double getPerimeter();
    public default String printType() {
        return this.getClass().getSimpleName();
    }
}
