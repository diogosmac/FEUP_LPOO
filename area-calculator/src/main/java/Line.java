public class Line implements Shape {
    private Integer length;

    public Line(int length) { this.length = length; }

    public Integer getLength() {
        return length;
    }

    public void draw() {
        System.out.println("Line");
    }
}
