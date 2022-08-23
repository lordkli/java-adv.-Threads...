package you_threads;

public class Islemler implements Runnable {
    String name;

    public Islemler(String name) {
        this.name = name;
        System.out.println(name +" islem olustu!");
    }

    @Override
    public void run() {
        for (int i = 5; i >0; i--) {
            System.out.println(name + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " islem bitti");
    }
}
