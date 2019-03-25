public interface Facility {
    String getName();
    String toString();
    int getCapacity();
    boolean canEnter(User user);
}
