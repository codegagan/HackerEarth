/**
 * Created by gagan on 2/4/16.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Criminal {

    public static void main(String... args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        for (int i = 0; i < testCases; i++) {// Each Test Case
            int noOfPackets = Integer.parseInt(br.readLine());
            BigInteger[] packets = new BigInteger[noOfPackets];
            for(int j =0;j<noOfPackets;j++){
                packets[j]=new BigInteger(br.readLine());
            }
            Arrays.sort(packets);
            System.out.println(Arrays.toString(packets));
            int minimumBoxes=1;
            BigInteger lastPacket = null;
            BigInteger lastLastPacket = null;
            for(BigInteger packet:packets){
                if(lastPacket==null){
                    //First component
                } else if(packet.equals(lastPacket)){
                    minimumBoxes+=1;
                }

                if(packet.equals(lastPacket) && lastPacket.equals(lastLastPacket)) {
                    if (minimumBoxes > 1) {
                        minimumBoxes -= 1;
                    }
                }
                lastLastPacket= lastPacket;
                lastPacket = packet;
            }
            System.out.println(Math.max(1,minimumBoxes));
        }
    }
}
