import java.util.ArrayList;
import java.util.List;

public class Building implements Facility {

    private String name;
    private int minFloor;
    private int maxFloor;
    private int capacity;
    private List<Room> rooms;
    private List<User> authorized;

    public Building(String name, int min, int max) throws IllegalArgumentException {
        if (min > max) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.minFloor = min;
        this.maxFloor = max;
        this.capacity = 0;
        this.rooms = new ArrayList<>();
        this.authorized = new ArrayList<>();
   }

    public String getName() {
        return name;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean canEnter(User user) {
        for (Room room : rooms) {
            if (room.canEnter(user)) return true;
        }
        return false;
    }

    public boolean addRoom(Room room) {
        for (Room r : rooms) {
            if (r.getNumber().equals(room.getNumber())) {
                return false;
            }
        }

        rooms.add(room);
        this.capacity += room.getCapacity();
        return true;
    }

    @Override public String toString() {
        return "Building(" + this.getName() + ")";
    }

}
