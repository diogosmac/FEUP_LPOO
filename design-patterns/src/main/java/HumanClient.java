public class HumanClient implements Client {
    private OrderingStrategy strategy;

    public HumanClient(OrderingStrategy strategy) {
        this.strategy = strategy;
    }

    public void happyHourStarted(Bar bar) {
        strategy.happyHourStarted((StringBar)bar);
    }

    public void happyHourEnded(Bar bar) {
        strategy.happyHourEnded((StringBar)bar);
    }

    public void wants(StringRecipe recipe, StringBar bar) {
        bar.addObserver(this);
        bar.notifyObservers();

        strategy.wants(recipe, bar);
    }
}
