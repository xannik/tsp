import java.util.ArrayList;
import java.util.List;

public class TwoOpt {
    private List<int[]> cityList;
    private List<City> cities;
    public TwoOpt(List<int[]> cityList){
        this.cityList = cityList;
        this.cities = new ArrayList<>();
    }

    public List<City> findPath(List<int[]> cityList){

        int[] currentRow = cityList.get(0);
        int currentCity = 1;
        int nextCity;
        City e = new City(currentCity);
        cities.add(e);
        while(cities.size() != currentRow.length) {

            nextCity = findShortest(currentRow);

                if(!cityExist(cities,nextCity)) {
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
       // printPath(cities);
       // System.out.println("Pathcost: " + sumPath(cities));
        return cities;
    }
    public void printPath(List<City> list){
        for(City e : list){
            System.out.println("current City: " + e.getCity() + " -> To city: " + e.getNextCity());
        }

    }
    public List<City> twoOptSearch(){

        List<City> newList = new ArrayList<>();

        int size = cities.size();
        for(int i = 1; i < size-1; i++){
            newList.add(cities.get(i));
        }
        long end = System.currentTimeMillis() + 24000;
        double bestDistance = twoOptSum(newList);
        double newDistance;

        while(System.currentTimeMillis() < end){
           System.out.println("best distance: " + bestDistance);
            for(int i = 1; i < newList.size() - 1; i++){
                for(int k = i + 1; k < newList.size(); k++){
                    twoOptSwap(i, k, newList.size(), newList);
                    newDistance = reOrderList(newList);

                    if(newDistance < bestDistance){

                        for(int j = 0; j < newList.size(); j++){
                            cities.set(j, newList.get(j));
                        }
                        bestDistance = newDistance;
                    }
                }
            }
        }

        return cities;
    }

    private void twoOptSwap(int i, int k, int size, List<City> newList) {
        for(int c = 0; c <= i - 1; ++c){
            newList.set(c, cities.get(c));
        }

        int dec = 0;
        for(int c = i; c <= k; ++c){
            newList.set(c, cities.get(k-dec));
            dec++;
        }
        for(int c = k + 1; c < size; ++c){
            newList.set(c, cities.get(c));

        }
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
    private int twoOptSum(List<City> list){
        int sum = 0;
        int[] row;

        for(City e : list){
            row = cityList.get(e.getCity()-1);
            sum += row[e.getNextCity()-1];
        }
        row = cityList.get(0);
        City e = list.get(0);
        City f = list.get(list.size()-1);
        //System.out.println( "e: " + e.getCity() + "   " + "f: " + f.getCity());
        sum += row[e.getCity()] + row[f.getCity()-1];

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
    private int reOrderList(List<City> list){
        int sum = 0;
        int[] row;

        for(int i = 0; i < list.size()-1; i++){

            City current = list.get(i);
            City next = list.get(i+1);
            current.setNextCity(next.getCity());

            row = cityList.get(current.getCity()-1);
            sum += row[current.getNextCity()-1];
        }
       return sum;
    }


}
