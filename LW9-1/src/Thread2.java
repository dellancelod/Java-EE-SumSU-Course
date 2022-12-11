public class Thread2 implements Runnable{
    private final Bank account;

    public Thread2(Bank bank) {
        this.account = bank;
    }

    @Override
    public void run() {
        synchronized (account){
            account.dec();
        }
    }
}
