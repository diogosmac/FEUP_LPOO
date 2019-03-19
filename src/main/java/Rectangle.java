public class Rectangle implements Shape {
    private Integer width;
    private Integer height;

    public Rectangle(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public double getArea() {
        return width * height;
    }
}
