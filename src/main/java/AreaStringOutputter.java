public class AreaStringOutputter {
    private SumProvider provider;

    public AreaStringOutputter(SumProvider provider) {
        this.provider = provider;
    }

    public String output() {
        return "Sum of areas: " + provider.sum();
    }
}
