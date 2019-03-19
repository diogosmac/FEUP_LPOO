public class Circle implements AreaShape {
    private Integer radius;

    public Circle(int r) { this.radius = r; }

    public Integer getRadius() { return radius; }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void draw() {
        System.out.println("Circle");
    }
}
