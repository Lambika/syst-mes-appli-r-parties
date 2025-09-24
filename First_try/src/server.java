
public class server implements Runnable{
    Broker broker;
    public void run(){
        System.out.println("Server started");
        Broker broker =Task.getBroker();
        Channel ch = broker.accept(1234);
    }



}
