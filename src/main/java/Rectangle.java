public class Rectangle implements AreaShape {
    private Integer width;
    private Integer height;

    public Rectangle(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public double getArea() {
        return width * height;
    }

    public void draw() {
        System.out.println("Rectangle");
    }
}
