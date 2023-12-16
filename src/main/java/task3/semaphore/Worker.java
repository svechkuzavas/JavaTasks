package task3.semaphore;

public class Worker extends Thread {

    private final MySemaphore mSemaphore;
    private final int mNum;

    public Worker(MySemaphore semaphore, int num) {
        mSemaphore = semaphore;
        mNum = num;
    }

    @Override
    public void run() {
        try {
            mSemaphore.take();
            System.out.println("Worker " + mNum + " начал работу");

            sleep(500);
            mSemaphore.release();
            System.out.println("Worker " + mNum + " завершил работу");
        } catch (InterruptedException ignored) {

        }
    }
}
