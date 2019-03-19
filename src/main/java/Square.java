public class Square implements AreaShape {
    private Integer side;

    public Square(int s) { this.side = s; }

    public Integer getSide() { return side; }

    public double getArea() {
        return side * side;
    }

    public void draw() {
        System.out.println("Square");
    }
}
