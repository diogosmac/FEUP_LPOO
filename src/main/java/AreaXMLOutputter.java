public class AreaXMLOutputter {
    private AreaAggregator aggregator;

    public AreaXMLOutputter(AreaAggregator aggregator) {
        this.aggregator = aggregator;
    }

    public String outputXML() {
        return "<area>" + aggregator.sum() + "</area>";
    }

}
