public class Rectangle implements AreaShape {
    private Integer width;
    private Integer height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public void draw() {
        System.out.println("Rectangle");
    }
}
