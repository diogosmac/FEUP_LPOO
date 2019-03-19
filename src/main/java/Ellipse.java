public class Ellipse implements AreaShape {
    private Integer x_radius;
    private Integer y_radius;

    public Ellipse(int x_radius, int y_radius) {
        this.x_radius = x_radius;
        this.y_radius = y_radius;
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

    public void draw() {
        System.out.println("Ellipse");
    }
}
