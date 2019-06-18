package lanchong.iloveu.concurrent.deadlock;

import java.util.ArrayList;

/**
 *
 * 资源统一分配者,需要单例实现
 *
 * Allocator基础版本
 * 通过破坏"占用且等待"条件来规避死锁问题
 * {@code Allocator}通过一次性获取全部资源实现
 * 该方案性能差
 *
 * @see Allocator2
 * @see User
 * @author jaxonZhang
 * @date 2019/6/18
 */
public class Allocator {

    private ArrayList<User> list = new ArrayList<>();

    /**
     * 外部调用 {@code apply}方法获取所对应的资源
     * @param from
     * @param to
     */
    public synchronized boolean apply(User from,User to){
        if (list.contains(from)||list.contains(to)){
            return false;
        }
        list.add(from);
        list.add(to);
        return true;
    }

    /**
     * 外部调用 {@code release}方法释放持有的资源
     * @param from
     * @param to
     */
    public synchronized void release(User from,User to){
        list.remove(from);
        list.remove(to);
    }




    private Allocator(){}
    private static class Holder{
        private static Allocator SINSTANCE = new Allocator();
    }
    public static Allocator getInstance(){
        return Holder.SINSTANCE;
    }


}
