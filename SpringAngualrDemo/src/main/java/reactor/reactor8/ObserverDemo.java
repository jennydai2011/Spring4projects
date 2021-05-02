package reactor.reactor8;

import java.util.Observable;

public class ObserverDemo extends Observable {
    public static void main(String[] args) {
        ObserverDemo observer = new ObserverDemo();

        //add observer
        observer.addObserver((o, arg) -> {
            System.out.println("1");
        });

        observer.addObserver((o, arg) -> {
            System.out.println("2");
        });

        observer.setChanged(); // got the change

        observer.notifyObservers(); //notify
    }
}
