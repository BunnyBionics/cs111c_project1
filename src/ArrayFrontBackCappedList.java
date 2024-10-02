import java.util.Arrays;

public class ArrayFrontBackCappedList<T> implements FrontBackCappedList<T> {

    private T[] list;
    private int numberOfElements;

    public ArrayFrontBackCappedList(int capacity) {
        list = (T[]) new Object[capacity];
        numberOfElements = 0;
    }

    public String toString() {
        String s = "size=%d; capacity=%d;\t[".formatted(numberOfElements, list.length);
        for (int i = 0; i < numberOfElements; i++) {
            s += list[i].toString();
            if (i == numberOfElements - 1) {
                continue;
            }

            s += ", ";
        }

        s += "]";
        return s;
    }

    @Override
    public boolean addFront(T newEntry) {
        if (isFull()) {
            return false;
        }

        for (int i = numberOfElements; i > 0; i--) {
            list[i] = list[i - 1];
        }

        list[0] = newEntry;
        numberOfElements++;
        return true;
    }

    @Override
    public boolean addBack(T newEntry) {
        if (isFull()) {
            return false;
        }

        list[numberOfElements++] = newEntry;
        return true;
    }

    @Override
    public T removeFront() {
        if (isEmpty()) {
            return null;
        }

        T removed = list[0];
        for (int i = 0; i < numberOfElements - 1; i++) {
            list[i] = list[i + 1];
        }

        list[numberOfElements-- - 1] = null;
        return removed;
    }

    @Override
    public T removeBack() {
        if (isEmpty()) {
            return null;
        }

        T removed = list[numberOfElements - 1];
        list[numberOfElements-- - 1] = null;
        return removed;
    }

    @Override
    public void clear() {
        list = (T[]) new Object[list.length];
        numberOfElements = 0;
    }

    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition < 0 || givenPosition >= numberOfElements) {
            return null;
        }

        return list[givenPosition];
    }

    @Override
    public int indexOf(T anEntry) {
        if (isEmpty()) {
            return -1;
        }

        for (int i = 0; i < numberOfElements; i++) {
            if (list[i].equals(anEntry)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(T anEntry) {
        if (isEmpty()) {
            return -1;
        }

        for (int i = numberOfElements - 1; i > - 1; i--) {
            if (list[i].equals(anEntry)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean contains(T anEntry) {
        return indexOf(anEntry) > -1;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements < 1;
    }

    @Override
    public boolean isFull() {
        return numberOfElements == list.length;
    }
}