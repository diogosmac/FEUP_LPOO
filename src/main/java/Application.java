public class Application {
    public static void main(String[] args) {
        System.out.println();

        AreaAggregator aggregator = new AreaAggregator();
        Circle first = new Circle(2);
        Ellipse second = new Ellipse(1, 2);
        Rectangle third = new Rectangle(1, 2);
        Square fourth = new Square(4);
        Triangle fifth = new Triangle(3, 2);

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);

        aggregator.addShape(first);
        System.out.println(stringOutputter.output());
        aggregator.addShape(second);
        System.out.println(stringOutputter.output());
        aggregator.addShape(third);
        System.out.println(stringOutputter.output());
        aggregator.addShape(fourth);
        System.out.println(stringOutputter.output());
        aggregator.addShape(fifth);
        System.out.println(stringOutputter.output());

        Line sixth = new Line(3);
        System.out.println("Line length: " + sixth.getLength());
        // aggregator.addShape(sixth);
        // ^^^ CAN'T BE DONE ^^^

        House seventh = new House(350);
        aggregator.addShape(seventh);
        System.out.println(stringOutputter.output());

        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);
        System.out.println(xmlOutputter.outputXML());
    }
}
