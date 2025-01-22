package sorts;

public class SelectionSort implements Sort {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = getMinIndex(array, i);
            SortUtils.swap(array, i, minIndex);
        }
        return array;
    }

    private <T extends Comparable<T>> int getMinIndex(T[] array, int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex + 1; i < array.length; i++) {
            if (array[i].compareTo(array[minIndex]) < 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
