package testPackage;

import java.util.Random;

public class WrapperInt implements Comparable<WrapperInt> {

    private int value;

    @Override
    public int compareTo(WrapperInt o) {
        if(this.value > o.value)
            return 1;
        else if(this.value < o.value)
            return -1;
        return 0;
    }

    public static WrapperInt[] generate(int numObjects){

        WrapperInt[] wrapperInts = new WrapperInt[numObjects];

        Random r = new Random();
        for(int i = 0; i < numObjects; i++){
            WrapperInt wrapperInt = new WrapperInt();
            wrapperInt.value = r.nextInt(100);
            wrapperInts[i] = wrapperInt;
        }
        return wrapperInts;
    }

}


