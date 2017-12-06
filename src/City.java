public class City {

    private int city;
    private int neighbour1;
    private int neighbour2;
    private int group;

    public City(int city){
        this.city = city;
    }

    public int getNeighbour1() {
        return neighbour1;
    }

    public void setNeighbour1(int neighbour1) {
        this.neighbour1 = neighbour1;
    }

    public int getNeighbour2() {
        return neighbour2;
    }

    public void setNeighbour2(int neighbour2) {
        this.neighbour2 = neighbour2;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getCity() {
        return city;
    }
}
