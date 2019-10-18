package testPackage;

public class Playground {

    public void play(){

        WrapperInt[] wrapperInts = WrapperInt.generate(10);

        new MergeSort().sort(wrapperInts);
        
    }

}

/*
Process:
1. psuedocode quicksort
2. implement quicksort with ints
3. change ints to custom type with overridden comparator
 */