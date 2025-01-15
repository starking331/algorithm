package searches;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    @Test
    void testBinarySearchFound() {
        testBinarySearch(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 2, 1);
    }

    @Test
    void testBinarySearchNotFound() {
        testBinarySearch(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 22, -1);
    }

    @Test
    void testBinaryFirstElement() {
        testBinarySearch(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 1, 0);
    }

    @Test
    void testBinaryLastElement() {
        testBinarySearch(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10, 9);
    }

    @Test
    void testBinarySingleElementCollectionFound() {
        testBinarySearch(List.of(1), 1, 0);
    }

    @Test
    void testBinarySingleElementCollectionNotFound() {
        testBinarySearch(List.of(1), 11, -1);
    }

    @Test
    void testBinarySingleEmptyCollection() {
        testBinarySearch(List.of(), 11, -1);
    }

    @Test
    void testBinarySingleLargeCollection() {
        List<Integer> list = IntStream.range(0, 1_000_000)
                .boxed()
                .collect(Collectors.toList());
        testBinarySearch(list, 999999, 999999);
    }

    private void testBinarySearch(List<Integer> list, int value, int expectedIndex) {
        BinarySearch binarySearch = new BinarySearch();
        assertEquals(expectedIndex, binarySearch.find(value, list));
        assertEquals(expectedIndex, binarySearch.recurseFind(value, list));
    }
}
