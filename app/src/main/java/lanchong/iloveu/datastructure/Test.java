package lanchong.iloveu.datastructure;

public class Test {

    public static void main(String[] args) {
        new Test().test();
    }

    private boolean run = true;
//    private volatile boolean run = true;

    public void test() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (run) {
                    System.out.println("run");
                }
                System.out.println("=========");
            }
        });
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        run = false;
    }


}
