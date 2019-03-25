import java.util.ArrayList;
import java.util.List;

public class Party extends Event {
    private List<Event> events = new ArrayList<>();

    public Party(String title) {
        super(title);
    }

    public Party(String title, String date) {
        super(title, date);
    }

    public Party(String title, String date, String description) {
        super(title, date, description);
    }

    public void addEvent(Event event) {
        events.add(event);
        for (Person person : event.getAudience())
            this.addPerson(person);
    }

}
