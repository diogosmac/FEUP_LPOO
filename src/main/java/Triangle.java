public class Triangle implements AreaShape {
    private Integer base;
    private Integer height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return base * height / 2;
    }

    public void draw() {
        System.out.println("Triangle");
    }
}
