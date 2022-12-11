public class Thread1 implements Runnable {
    private final Bank account;

    public Thread1(Bank bank) {
        this.account = bank;
    }

    @Override
    public void run() {
        synchronized (account){
            account.inc();
        }
    }
}
