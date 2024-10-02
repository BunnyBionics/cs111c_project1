import java.util.ArrayList;
import java.util.List;

public class ListFrontBackCappedList<T> implements FrontBackCappedList<T> {

    private List<T> list;
    private int capacity;

    public ListFrontBackCappedList(int capacity) {
        list = new ArrayList<T>(capacity);
        this.capacity = capacity;
    }

    public String toString() {
        return "size=%d; capacity=%d;\t%s".formatted(size(), capacity, list.toString());
    }

    @Override
    public boolean addFront(T newEntry) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            return list.add(newEntry);
        }

        list.add(list.getLast());
        for (int i = list.size() - 1; i > 0; i--) {
            list.set(i, list.get(i - 1));
        }

        list.set(0, newEntry);
        return true;
    }

    @Override
    public boolean addBack(T newEntry) {
        if (isFull()) {
            return false;
        }

        list.add(newEntry);
        return true;
    }

    @Override
    public T removeFront() {
        if (isEmpty()) {
            return null;
        }

        return list.remove(0);
    }

    @Override
    public T removeBack() {
        if (isEmpty()) {
            return null;
        }

        return list.remove(size() - 1);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition < 0 || givenPosition > size() - 1) {
            return null;
        }

        return list.get(givenPosition);
    }

    @Override
    public int indexOf(T anEntry) {
        return list.indexOf(anEntry);
    }

    @Override
    public int lastIndexOf(T anEntry) {
        return list.lastIndexOf(anEntry);
    }

    @Override
    public boolean contains(T anEntry) {
        return list.contains(anEntry);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return list.size() == capacity;
    }
}