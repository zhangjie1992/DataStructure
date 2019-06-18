package lanchong.iloveu.concurrent.deadlock;

import java.util.ArrayList;

/**
 *
 * Allocator基础版本
 * 通过破坏"占用且等待"条件来规避死锁问题
 * {@code Allocator2}使用等待-通知机制实现
 * 该方案性能优
 *
 * @see Allocator
 * @author jaxonZhang
 * @date 2019/6/18
 */
public class Allocator2 {

    private ArrayList<User> list = new ArrayList<>();

    /**
     * 外部调用 {@code apply}方法获取所对应的资源
     * @param from
     * @param to
     */
    public synchronized void apply(User from,User to) throws InterruptedException {
        //#####范例:while(条件不满足) { wait(); }
        while (list.contains(from)||list.contains(to)){
            //释放锁Allocator2.this ,允许其他线程抢占该锁
            wait();
        }
        //#####

        list.add(from);
        list.add(to);
    }

    /**
     * 外部调用 {@code release}方法释放持有的资源
     * @param from
     * @param to
     */
    public synchronized void release(User from,User to){
        list.remove(from);
        list.remove(to);
        //唤醒所有waiting的线程
        notifyAll();
    }




    private Allocator2(){}
    private static class Holder{
        private static Allocator2 SINSTANCE = new Allocator2();
    }
    public static Allocator2 getInstance(){
        return Allocator2.Holder.SINSTANCE;
    }




}
