package testPackage;

public class QuickSort <T extends Comparable<T>> implements Sort {

    @Override
    public Comparable[] sort(Comparable[] array) {
        return quicksort(array, 0, array.length - 1);
    }

    public Comparable[] quicksort(Comparable[] array, int left, int right){

        //does this make sense to me?
        if(left >= right)
            return array;

        //the pivot is the value you're comparing to
        //it's not just the length of the array over 2...
        //because it might be the same array being passed in.
        //technically i could do the array/2 if i wanted to pass
        //a new array into the method every time.
        Comparable pivot = array[(left+right)/2];

        //partition is our method of switching everything to the left side
        //that should be on the left side and switching everything to the
        //right side that should be on the right side.
        int index = partition(array, left, right, pivot);

        //these two quicksorts basically take the first half and the
        //second half of the array back into the method.
        quicksort(array, left, index -1);
        quicksort(array, index, right);

        return null;
    }

    public int partition(Comparable[] array, int left, int right, Comparable pivot){

        while(left <= right){

            while(pivot.compareTo(array[left]) > 0)
                left++;

            while(pivot.compareTo(array[right]) < 0)
                right--;

            //one extra check
            if(left <= right) {
                swap(array, left, right);
                right--;
                left++;
            }
        }
        return left;
    }

    public void swap(Comparable[] array, int left, int right) {
        Comparable tempFirst = array[left];
        array[left] = array[right];
        array[right] = tempFirst;
    }

}
