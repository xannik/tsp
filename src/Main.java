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
        TwoOpt twoOpt = new TwoOpt(cityList);
        List<City> cities = twoOpt.findPath(cityList);
        fileHandler.writeFile(cities);


    }
}
