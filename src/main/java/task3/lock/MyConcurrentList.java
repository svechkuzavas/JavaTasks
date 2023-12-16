package task3.lock;

import java.util.ArrayList;
import java.util.List;

public class MyConcurrentList<T> {

    private MyReadWriteLock lock = new MyReadWriteLock();
    private List<T> innerList = new ArrayList<>();

    public void add(T element) {
        try {
            lock.lockWrite();
            Thread.sleep(1000); // для демонстрации
            innerList.add(element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlockWrite();
        }
    }

    public T getElement(int index) {
        try {
            lock.lockRead();
            Thread.sleep(1000); // для демонстрации
            return innerList.get(index);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlockRead();
        }
    }
}
