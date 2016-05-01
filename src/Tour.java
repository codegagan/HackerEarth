import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gagan on 2/4/16.
 */
public class Tour {
    public static void main(String... args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        BigInteger distance=new BigInteger("0");
        int distinctCities = Integer.parseInt(line);
        Map<String,Integer> cities = new HashMap<>();
        for (int i = 0; i < distinctCities; i++) {
            cities.put(br.readLine(),i+1);
        }
        BigInteger[][] distanceMatrix = new BigInteger[distinctCities][distinctCities];

        for (int i = 0; i < distinctCities; i++) {
            line =br.readLine();
            int j =0;
            for(String column: line.split(" ")){
                distanceMatrix[i][j]=new BigInteger(column);
                j++;
            }
        }

        int visits =Integer.parseInt(br.readLine());
int lastCityIndex=1;
        for(int i = 0; i < visits; i++){
            String city =br.readLine();
            int visitingCityIndex = cities.get(city);
            distance = distance.add(distanceMatrix[lastCityIndex-1][visitingCityIndex-1]);
            lastCityIndex=visitingCityIndex;
        }

        System.out.println(distance);

    }

}
