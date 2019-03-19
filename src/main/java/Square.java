public class Square implements Shape {
    private Integer side;

    public Square(int s) { this.side = s; }

    public Integer getSide() { return side; }

    public double getArea() {
        return side * side;
    }
}
