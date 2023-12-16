package task3.semaphore;

public class MySemaphore {

    private int mAllowed;

    public MySemaphore(int allowed) {
        mAllowed = allowed;
    }

    public synchronized void take() throws InterruptedException {
        if (mAllowed <= 0)
            wait();
        mAllowed--;
    }

    public synchronized void release() {
        mAllowed++;
        if (mAllowed > 0)
            notify();
    }

}
