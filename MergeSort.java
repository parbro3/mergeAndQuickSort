package testPackage;

public class MergeSort <T extends Comparable<T>> implements Sort {

    @Override
    public Comparable[] sort(Comparable[] array) {
        Comparable[] newArray = new Comparable[array.length];
        return mergesort(array, newArray, 0, array.length - 1);
    }

    public Comparable[] mergesort(Comparable[] array, Comparable[] completed, int leftStart, int rightEnd) {

        //so we're given our initial array and the left and right bounds of it.
        if(leftStart >= rightEnd)
            return null;

        //so call merge sort on both halves
        int middle = (leftStart + rightEnd)/2;
        mergesort(array, completed, leftStart, middle);
        mergesort(array, completed,middle + 1, rightEnd);

        //then merge the two halves.
        merge(array, completed, leftStart, rightEnd);

        return null;
    }

    public void merge(Comparable[] array, Comparable[] completedArray, int leftStart, int rightEnd) {

        //get the other ends of each half
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        //get the moving indices
        int leftMoving = leftStart;
        int rightMoving = rightStart;

        //get the index of the newArray which will be leftStart
        int indexNewArray = leftStart;


        //okay now copy everything over!
        while(leftMoving <= leftEnd && rightMoving <= rightEnd){

            //check which one is bigger
            if(array[leftMoving].compareTo(array[rightMoving]) <= 0){
                //copy over the left one!
                completedArray[indexNewArray] = array[leftMoving];
                leftMoving++;
            } else {
                completedArray[indexNewArray] = array[rightMoving];
                rightMoving++;
            }
            indexNewArray++;
        }

        //loop through each of the remaining ones..
        //even though only one will be executed!
        while(leftMoving <= leftEnd){
            completedArray[indexNewArray] = array[leftMoving];
            indexNewArray++;
            leftMoving++;
        }
        while(rightMoving <= rightEnd){
            completedArray[indexNewArray] = array[rightMoving];
            indexNewArray++;
            rightMoving++;
        }

        for(int i = leftStart; i < array.length; i++){
            if(completedArray[i] != null)
                array[i] = completedArray[i];
        }

    }

}
