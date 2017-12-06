import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main program = new Main(args[0]);

    }

    Main(String filename){
        run(filename);
    }

    public void run(String filename){

        FileHandler fileHandler = new FileHandler();
        TwoOpt twoOpt = new TwoOpt();


        List<int[]> cityList = fileHandler.readFile(filename);
        twoOpt.findPath(cityList);



    }
}
