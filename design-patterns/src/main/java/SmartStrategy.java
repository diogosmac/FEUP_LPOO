import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {
    private boolean happyHour;
    private List<StringRecipe> orders;

    public SmartStrategy() {
        this.happyHour = false;
        this.orders = new ArrayList<>();
    }

    public void wants(StringRecipe recipe, StringBar bar) {

        if (happyHour) {
            bar.order(recipe);
        }
        else {
            orders.add(recipe);
        }
    }

    public void happyHourStarted(StringBar bar) {
        happyHour = true;
        for (StringRecipe order : orders) {
            bar.order(order);
        }
    }

    public void happyHourEnded(StringBar bar) {
        happyHour = false;
    }
}
