public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Thread thread = new Thread(new Thread1(bank));
        thread.start();
        Thread thread2 = new Thread(new Thread2(bank));
        thread2.start();

        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        //Synchronized threads always add up to 20000
        System.out.println(bank.getAccount());
    }
}