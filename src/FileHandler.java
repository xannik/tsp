import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {


   public List<int[]> readFile(String file) {
        List<int[]> cities = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(file)));
            try {
                String line;
                int[] row;
                String[] distances;

                while ((line = br.readLine()) != null) {

                    distances = line.split(",");
                    row = new int[distances.length];

                    for (int j = 0; j < row.length; j++) {
                        row[j] = Integer.parseInt(distances[j]);
                    }

                    cities.add(row);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }
    public void writeFile(List<City> city){
        try{
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Output.txt")));
            try{
                int i = 0;

                for(City e: city){
                    pw.print(e.getCity());
                    if(i < city.size()-1) {
                        pw.print(",");
                    }
                    i++;
                }
                City e = city.get(city.size()-1);
                pw.print("," + e.getNextCity());


            }catch(Exception e){
                e.printStackTrace();
            }finally {
                pw.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
