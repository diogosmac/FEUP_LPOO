public class Triangle implements Shape {
    private Integer base;
    private Integer height;

    public Triangle(int b, int h) {
        this.base = b;
        this.height = h;
    }

    public double getArea() {
        return base * height / 2;
    }
}
