import java.util.ArrayList;
import java.util.List;

public class Event {
    private String title;
    private String date;
    private String description;
    private List<Person> audience;

    public Event(String title) {
        this(title, "");
    }

    public Event(String title, String date) {
        this(title, date, "");
    }

    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.audience = new ArrayList<>();
    }

    public Event(Event e) {
        this(e.getTitle(), e.getDate(), e.getDescription());
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
            this.description = description;
    }

    @Override
    public String toString() {
        return title + " is a " + description + " and will be held at " + date + ".";
    }

    public boolean equals(Event e) {
        return (title.equals(e.getTitle()) && date.equals(e.getDate()) && description.equals(e.getDescription()));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Event o = (Event) obj;
        return this.equals(o);
    }

    public void addPerson(Person person) {
        for (Person p : audience) {
            if (p.getName().equals(person.getName())) {
                return;
            }
        }
        audience.add(person);
    }

    public int getAudienceCount() {
        return audience.size();
    }

    public List<Person> getAudience() {
        return audience;
    }
}
