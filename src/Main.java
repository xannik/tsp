import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
       new Main(args[0]);

    }

    Main(String filename){
        run(filename);
    }

    public void run(String filename){

        FileHandler fileHandler = new FileHandler();
        List<int[]> cityList = fileHandler.readFile(filename);
        List<City> list = new ArrayList<>();
        Long startTime = System.currentTimeMillis();
        TwoOpt twoOpt = new TwoOpt(cityList);
        list = twoOpt.findPath(cityList);
        list = twoOpt.twoOptSearch();
        Long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime/1000);
        fileHandler.writeFile(list);


    }
}
