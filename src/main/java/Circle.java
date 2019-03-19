public class Circle implements Shape {
    private Integer radius;

    public Circle(int r) { this.radius = r; }

    public Integer getRadius() { return radius; }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}
