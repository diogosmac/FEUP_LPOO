public class Line implements Shape {
    private Integer length;

    public Line(int l) { this.length = l; }

    public Integer getLength() {
        return length;
    }

    public void draw() {
        System.out.println("Line");
    }
}
