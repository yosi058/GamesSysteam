package MainGame;


public interface Iobserable {
//    LinkedList<MainGame.Observer> observers= new LinkedList<>();

    void addObserver(Observer o);
    void notifyall();



}
