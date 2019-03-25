import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

public class Room implements Facility {
    private Building building;
    private String number;
    private String name;
    private int floor;
    private int capacity;
    private List<User> authorized;

    public Room(Building building, String number, int floor) throws IllegalArgumentException, DuplicateRoomException {
        this(building, number, floor, 0);
    }

    public Room(Building building, String number, int floor, int capacity) throws IllegalArgumentException, DuplicateRoomException {
        if (floor > building.getMaxFloor() || floor < building.getMinFloor()) {
            throw new IllegalArgumentException();
        }

        this.building = building;
        this.number = number;
        this.name = building.getName() + number;
        this.floor = floor;
        this.capacity = capacity;
        this.authorized = new ArrayList<>();

        if (!this.building.addRoom(this)) {
            throw new DuplicateRoomException();
        }
    }

    public Building getBuilding() {
        return building;
    }

    public int getFloor() {
        return floor;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void authorize(User user) {
        this.authorized.add(user);
    }

    public boolean canEnter(User user) {
        for (User u : authorized) {
            if (user.equals(u)) return true;
        }
        return false;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override public String toString() {
        return "Room(" + this.building.getName() + "," + this.number + ")";
    }

}
