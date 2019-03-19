public class Ellipse implements Shape {
    private Integer x_radius;
    private Integer y_radius;

    public Ellipse(int x, int y) {
        this.x_radius = x;
        this.y_radius = x;
    }

    public Integer getX_radius() {
        return x_radius;
    }

    public Integer getY_radius() {
        return y_radius;
    }

    public double getArea() {
        return Math.PI * x_radius * y_radius;
    }
}
