
public class client implements Runnable{
    Broker broker;
    public void run(){
        System.out.println("Client started");
        broker =Task.getBroker();
        Channel ch = broker.connect("localhost", 1234);
    }


}
