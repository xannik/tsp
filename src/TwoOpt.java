import java.util.ArrayList;
import java.util.List;

public class TwoOpt {


    public void findPath(List<int[]> cityList){
        List<City> cities = new ArrayList<>();
        int[] currentRow = cityList.get(0);
        double totalPair = currentRow.length * 0.5;

        while(totalPair != 1) {

            
            for (int i = 1; i < currentRow.length; i++) {
                City e = new City(i);

                cities.add(e);
            }

        }
    }
}
