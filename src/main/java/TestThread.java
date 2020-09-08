/**
 * TestThread
 *
 * @author 奕超
 */
public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        TestThread t = new TestThread();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                t.testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                t.testMethod();
            }
        }, "b");

        a.start();
        a.join();
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }


    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
