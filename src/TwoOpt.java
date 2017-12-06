import java.util.ArrayList;
import java.util.List;

public class TwoOpt {
    private List<int[]> cityList;

    public TwoOpt(List<int[]> cityList){
        this.cityList = cityList;
    }

    public List<City> findPath(List<int[]> cityList){
        List<City> cities = new ArrayList<>();
        int[] currentRow = cityList.get(0);
        int group = 1;
        int currentCity = 1;
        int nextCity;
        City e = new City(currentCity);
        cities.add(e);
        int i = 1;
        while(cities.size() != currentRow.length) {

            nextCity = findShortest(currentRow);

                if(!cityExist(cities,nextCity)) {
                   // System.out.println(i + ": " + e.getCity() + " -> " + nextCity)
                    e.setNextCity(nextCity);
                    currentRow = cityList.get(nextCity-1);
                    currentCity = nextCity;
                    e = new City(currentCity);
                    cities.add(e);

                }else{
                    currentRow[nextCity-1] = -1;
                   // System.out.println("city already exist");

                }
            //System.out.println(nextCity);

        }
        //System.out.println(checkTrue(cities));
        e = cities.get(cities.size()-1);
        e.setNextCity(1);
        printPath(cities);
        System.out.println("Pathcost: " + sumPath(cities));
        return cities;
    }
    public void printPath(List<City> list){
        for(City e : list){
            System.out.println("current City: " + e.getCity() + " -> To city: " + e.getNextCity());
        }

    }
    public void twoOptSearch(){

    }
    private int findShortest(int[] row){
        int minDistance = Integer.MAX_VALUE;
        int currentDistance;
        int city = 0;
        for(int i = 0; i < row.length; i++) {

            if(row[i] == 0 || row[i] == -1) {
                continue;
            }else{
                currentDistance = row[i];
                if(minDistance > currentDistance){
                    minDistance = currentDistance;
                    city = i;
                }
            }
        }
        //System.out.println("city index: " + city);
        return city+1;
    }
    private int sumPath(List<City> list){
        int sum = 0;
        int[] row;
        for(City e : list){
            row = cityList.get(e.getCity()-1);
            sum += row[e.getNextCity()-1];
        }
        return sum;
    }
    private boolean cityExist(List<City> list, int city){
        for(City e : list){
            if(e.getCity() == city)
                return true;
        }
        return false;
    }
    private boolean checkTrue(List<City> list){

        for(int i = 1; i < 1000; i++){
            if(!cityExist(list,i)){
                return false;
            }
        }
        return true;
    }


}
