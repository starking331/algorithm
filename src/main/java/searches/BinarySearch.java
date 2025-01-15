package searches;

import java.util.List;

public class BinarySearch {
    public <T extends Comparable<T>> int find(T value, List<T> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comp = value.compareTo(list.get(mid));
            if (comp == 0) {
                return mid;
            } else if (comp < 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public <T extends Comparable<T>> int recurseFind(T value, List<T> list) {
        return search(value, list, 0, list.size() - 1);
    }

    private <T extends Comparable<T>> int search(T value, List<T> list, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int comp = value.compareTo(list.get(mid));
        if (comp == 0) {
            return mid;
        } else if (comp < 0) {
            return search(value, list, left, mid);
        } else {
            return search(value, list, mid + 1, right);
        }
    }
}
