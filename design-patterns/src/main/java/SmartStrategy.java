import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {
    private List<StringRecipe> orders;

    public SmartStrategy() {
        this.orders = new ArrayList<>();
    }

    public void wants(StringRecipe recipe, StringBar bar) {

        if (bar.isHappyHour()) {
            bar.order(recipe);
        }
        else {
            orders.add(recipe);
        }
    }

    public void happyHourStarted(StringBar bar) {
        while (!orders.isEmpty()) {
            bar.order(orders.get(0));
            orders.remove(0);
        }
    }

    public void happyHourEnded(StringBar bar) { }
}
