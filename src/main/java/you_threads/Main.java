package you_threads;

public class Main {
    public static void main(String[] args) {


        Islemler i1 = new Islemler("ilk");
        Thread t1 = new Thread(i1);
//        i1.run();

        Islemler i2 = new Islemler("SON");
        Thread t2 = new Thread(i2);
//        i2.run();

        t1.start();
        t2.start();
    }
}
