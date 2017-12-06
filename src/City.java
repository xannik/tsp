public class City {

    private int city;
    private int nextCity;
    private int group;

    public City(int city){
        this.city = city;
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

    public int getNextCity() {
        return nextCity;
    }

    public void setNextCity(int nextCity) {
        this.nextCity = nextCity;
    }
}
