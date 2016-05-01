/**
 * Created by gagan on 27/3/16.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;


public class TestClass {
    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running
*/

            // HackerEarth Oz paintings
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            //System.out.println("hello world");
            String values[] = br.readLine().split(" ");
            BigInteger x = new BigInteger(values[0]);
            BigInteger y = new BigInteger(values[1]);
            BigInteger z = new BigInteger(values[2]);

            BigInteger noOfPaintings;

            BigInteger[] xPaintings = x.divideAndRemainder(new BigInteger("3"));
            BigInteger[] yPaintings = y.divideAndRemainder(new BigInteger("3"));
            BigInteger[] zPaintings = z.divideAndRemainder(new BigInteger("3"));

            noOfPaintings=xPaintings[0].add(yPaintings[0]).add(zPaintings[0]);

            int xRemainings =xPaintings[1].intValue();
            int yRemainings =yPaintings[1].intValue();
            int zRemainings =zPaintings[1].intValue();

            while(xRemainings>0 && yRemainings>0 && zRemainings>0){
                noOfPaintings= noOfPaintings.add(new BigInteger("1"));
                xRemainings-=1;
                yRemainings-=1;
                zRemainings-=1;
            }

            System.out.println(noOfPaintings);
        }

        br.close();

        // -------------------------------------------------
        /* HackerEarth

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        for (int i = 0; i < testCases; i++) {
            //System.out.println("hello world");
            Coordinates a = new Coordinates(br.readLine());
            Coordinates b = new Coordinates(br.readLine());
            Coordinates c = new Coordinates(br.readLine());
            Coordinates d = new Coordinates(br.readLine());

            // Eliminating cases
            Equation eq1 = new Equation(a, c);
            Equation eq2 = new Equation(b, d);

            Coordinates intersection = eq1.getIntersection(eq2);

            if (intersection.equals(a) || intersection.equals(b) || intersection.equals(c) || intersection.equals(d)) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
            continue;
            // all on same line

        }
        -------------------------------------------------------------------*/

        br.close();


        //     System.out.println("Hello World!");
    }
}

class Coordinates {
    public int getX() {
        return x;
    }


    int x;

    public int getY() {
        return y;
    }


    int y;

    public Coordinates(String coordinates) {
        x = Integer.parseInt(coordinates.split(" ")[0]);
        y = Integer.parseInt(coordinates.split(" ")[1]);
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
@Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Coordinates)){ return false;}

        if (this.getX() == ((Coordinates)other).getX() && this.getY() == ((Coordinates)other).getY()) {
            return true;
        }
        return false;
    }
}

class Equation {
    double slope;

    public double getSlope() {
        return slope;
    }

    public double getIntercept() {
        return intercept;
    }

    double intercept;

    public Equation(Coordinates a, Coordinates b) {
        slope = (b.getY() - a.getY()) / (b.getX() - a.getX());

        intercept = a.getY() - (slope * a.getX());
    }
@Override
    public String toString() {
        return "Y = " + slope + "X + " + intercept;
    }

    public Coordinates getIntersection(Equation otherLine) {
        double x;
        double y;
        x = (otherLine.getIntercept() - this.getIntercept()) / (this.getSlope() - otherLine.getSlope());
        y = (this.getSlope() * x) + this.getIntercept();
        return new Coordinates((int) x, (int) y);
    }

}
