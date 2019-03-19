public class AreaXMLOutputter {
    private SumProvider provider;

    public AreaXMLOutputter(SumProvider provider) {
        this.provider = provider;
    }

    public String outputXML() {
        return "<area>" + provider.sum() + "</area>";
    }

}
