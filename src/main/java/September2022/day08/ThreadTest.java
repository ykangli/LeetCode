package September2022.day08;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/13 19:06
 */
public class ThreadTest {
    public static void main(String[] args) {

        Minus thread1 = new Minus();
        Minus thread2 = new Minus();
        Minus thread3 = new Minus();

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Minus extends Thread {
    private static int num = 9;
    private static Object object = new Object();

    @Override
    public void run() {
        while(true) {
            synchronized (object) {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票号：" + num);
                    num--;
                } else {
                    System.out.println("数字为0，结束递减");
                    break;
                }
            }
        }
    }
}
