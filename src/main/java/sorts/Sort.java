package sorts;

public interface Sort {
    <T extends Comparable<T>> T[] sort(T[] array);
}
