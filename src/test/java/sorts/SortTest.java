package sorts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public abstract class SortTest {
    abstract Sort getSort();
    @Test
    void sortEmptyArray() {
        Integer[] array = new Integer[] {};
        Integer[] expected = new Integer[] {};
        Integer[] sorted = getSort().sort(array);

        assertArrayEquals(expected, sorted);
    }

    @Test
    void sortOneElementArray() {
        Integer[] array = new Integer[] {1};
        Integer[] expected = new Integer[] {1};
        Integer[] sorted = getSort().sort(array);

        assertArrayEquals(expected, sorted);
    }

    @Test
    void sortAllPositiveArray() {
        Integer[] array = new Integer[] {60, 7, 55, 9, 999, 3};
        Integer[] expected = new Integer[] {3, 7, 9, 55, 60, 999};
        Integer[] sorted = getSort().sort(array);

        assertArrayEquals(expected, sorted);
    }

    @Test
    void sortAllNegativeArray() {
        Integer[] array = new Integer[] {-60, -7, -55, -9, -999, -3};
        Integer[] expected = new Integer[] {-999, -60, -55, -9, -7, -3};
        Integer[] sorted = getSort().sort(array);

        assertArrayEquals(expected, sorted);
    }

    @Test
    void sortRealNumberArray() {
        Integer[] array = new Integer[] {60, -7, 55, 9, -999, -3};
        Integer[] expected = new Integer[] {-999, -7, -3, 9, 55, 60};
        Integer[] sorted = getSort().sort(array);

        assertArrayEquals(expected, sorted);
    }

    @Test
    void sortWithDuplicateNumberArray() {
        Integer[] array = new Integer[] {60, 7, 55, 55, 999, 3};
        Integer[] expected = new Integer[] {3, 7, 55, 55, 60, 999};
        Integer[] sorted = getSort().sort(array);

        assertArrayEquals(expected, sorted);
    }

    @Test
    void sortStringArray() {
        String[] array = new String[] {"z", "a", "x", "b", "y"};
        String[] expected = new String[] {"a", "b", "x", "y", "z"};
        String[] sorted = getSort().sort(array);

        assertArrayEquals(expected, sorted);
    }

    @Test
    public void sortAllIdenticalValues() {
        Integer[] array = {1, 1, 1, 1};
        Integer[] sorted = getSort().sort(array);
        assertArrayEquals(array, sorted);
    }

    @Test
    public void sortMixedValues() {
        Integer[] array = {-1, 3, -2, 5, 0};
        Integer[] expected = {-2, -1, 0, 3, 5};
        Integer[] sorted = getSort().sort(array);
        assertArrayEquals(expected, sorted);
    }

    @Test
    public void sortArrayWithEmptyStrings() {
        String[] array = {"apple", "", "banana", ""};
        String[] sortedArray = getSort().sort(array);
        assertArrayEquals(new String[] {"", "", "apple", "banana"}, sortedArray);
    }

    @Test
    public void sortArrayOfFloatingPointNumbers() {
        Double[] array = {3.3, 2.2, 1.1, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        Double[] sortedArray = getSort().sort(array);
        assertArrayEquals(new Double[] {Double.NEGATIVE_INFINITY, 1.1, 2.2, 3.3, Double.POSITIVE_INFINITY, Double.NaN}, sortedArray);
    }

    @Test
    public void shouldHandleArrayWithNullValues() {
        Integer[] array = {3, null, 2, null, 1};
        org.junit.jupiter.api.Assertions.assertThrows(NullPointerException.class, () -> getSort().sort(array));
    }

    @Test
    public void shouldAcceptWhenArrayWithMixedCaseStringsIsPassed() {
        String[] array = {"apple", "Banana", "cherry", "Date"};
        String[] sortedArray = getSort().sort(array);
        assertArrayEquals(new String[] {"Banana", "Date", "apple", "cherry"}, sortedArray);
    }
}
