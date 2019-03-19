public class Application {
    public static void main(String[] args) {
        System.out.println();

        AreaAggregator aggregator = new AreaAggregator();
        Circle first = new Circle(2);
        Square second = new Square(4);
        Ellipse third = new Ellipse(1, 2);
        aggregator.addShape(first);
        aggregator.addShape(second);
        aggregator.addShape(third);

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        System.out.println(stringOutputter.output());

        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);
        System.out.println(xmlOutputter.outputXML());
    }
}
