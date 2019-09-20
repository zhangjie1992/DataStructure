package lanchong.iloveu.concurrent.deadlock;

public class User {

    public int id;
    public int balance;


    /**
     * 使用 {@link Allocator}的方式会导致无谓的CPU消耗
     * 效率低下，不推荐
     */
    public void transfer(User to, int amt) {
        while (!Allocator.getInstance().apply(this, to)){
        }
        try {
            synchronized (this){
                synchronized (to){
                    balance -= amt;
                    to.balance += amt;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Allocator.getInstance().release(this, to);
        }
    }


    /**
     * 使用 {@link Allocator2}的方式会导致无谓的CPU消耗
     * 效率低下，不推荐
     */
    public void transfer2(User to, int amt) {
        try {
            Allocator2.getInstance().apply(this, to);
            synchronized (this){
                synchronized (to){
                    balance -= amt;
                    to.balance += amt;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Allocator2.getInstance().release(this, to);
        }
    }

}
