/*

// Specification :
Un broker est un intermédiaire qui permet à des tâches de communiquer entre elles via des canaux (Channel). 
Chaque tâche peut accepter des connexions entrantes ou établir des connexions sortantes vers d'autres brokers. 
Les canaux permettent la lecture et l'écriture de données entre les tâches.
En plus un broker est associé à une tâche (Task) qui exécute une fonction spécifique.
Chaque tâche peut obtenir son broker associé via une méthode statique.
et les tâches sont exécutées de manière concurrente en utilisant des threads. 
Un accept de broker s'il échoue doit lancer une RuntimeException bloquante. et un connect de broker s'il échoue doit lancer une Exception bloquante.
la lecture et l'écriture sur un canal doivent retourner le nombre d'occtets lus ou écrits.
une connexion bidirectionnelle est établie entre deux tâches via un canal.peut être assuré par le protocole TCP/UDP(On privillégie TCP).
Dans le cas ou on choisi unididirectionnelle, on peut utiliser deux canaux pour chaque direction. et chacun des deux doit faire le accept et le connect.
un read ou write sur un canal déconnecté doit lancer une RuntimeException bloquante.,tant que ce n'est pas bloquant on peut continuer de read et write .
Pour les numéros de port, on peut utiliser des entiers positifs non nuls,  si le numéro de port est invalide (négatif ou nul), une RuntimeException bloquante doit être lancée. ou si le port est déjà utilisé par un autre broker, une RuntimeException bloquante doit être lancée.
Une nouveelle communication  impliquere la création d'un nouveau broker et d'une nouvelle tâche. et un nouveau canal.dans le cas  ou  on souhaite communiquer avec  


// Classe abstraite Broker qui permet de créer des canaux de communication (Channell) entre des tâches.
abstract class Broker {
    Broker(String name); // Constructeur qui initialise le broker avec un nom.
    Channel accept(int port); // Méthode qui accepte une connexion entrante sur un port en argument et on retourne un canal de communication (Channel).-> runtimeException bloquant
    Channel connect(String name, int port);// Méthode qui établit une connexion sortante vers un broker distant identifié par son nom et un port en argument, et on retourne un canal de communication (Channel).->exception bloquant
    }

// Classe abstraite Channel qui permet de lire et écrire des données sur un canal de communication.
abstract class Channel {
    int read(byte[] bytes, int offset, int length);// Méthode qui lit des données depuis le canal dans un tableau d'octets (bytes) à partir d'un offset donné et pour une longueur spécifiée, et retourne le nombre d'octets lus.
    int write(byte[] bytes, int offset, int length); // Méthode qui écrit des données dans le canal à partir d'un tableau d'octets (bytes) à partir d'un offset donné et pour une longueur spécifiée, et retourne le nombre d'octets écrits.
    void disconnect();// Méthode qui ferme la connexion du  canal.
    boolean disconnected(); // Méthode qui retourne true si le canal est déconnecté, false sinon.
    }

// Classe abstraite Task qui permet de créer des tâches concurrentes.
abstract class Task extends Thread {
    Task(Broker b, Runnable r);// Constructeur qui initialise la tâche avec un broker et une fonction exécutable .//Surrement la logique de la tâche
    static Broker getBroker();// Méthode statique qui retourne le broker associé à la tâche courante.
    }



*/

//////////////////Runnable  de Task serveur//////////////////

/*Broker b = Task.getBroker();
    Channel ch = b.accept(1234);

    byte[] buffer = new byte[256];
    int n = ch.read(buffer, 0, buffer.length);
    System.out.println("Serveur a reçu: " + new String(buffer, 0, n));

    ch.write(buffer, 0, n);
    System.out.println("Serveur a renvoyé: " + new String(buffer, 0, n));
*/


///////////////////////////////////////////runnable task client///////////
// Broker b = Task.getBroker();
//     Channel ch = b.connect("localhost", 1234);

//     String msg = "Bonjour serveur!";
//     ch.write(msg.getBytes(), 0, msg.length());
//     System.out.println("Client a envoyé: " + msg);

//     byte[] buffer = new byte[256];
//     int n = ch.read(buffer, 0, buffer.length);
//     System.out.println("Client a reçu: " + new String(buffer, 0, n));



// Write a usecase/test: echo server


// public class EchoServer {

//     public static void main(String[] args) {
//         Broker broker = new LocalBroker("broker1");

//        
//         Runnable serveurLogic = () -> {
//             Channel ch = broker.accept(1234);
//             System.out.println("connexion acceptée !");

//             byte[] buffer = new byte[256];
//             int n = ch.read(buffer, 0, buffer.length);
//             String message = new String(buffer, 0, n);
//             System.out.println("Serveur a reçu:   " +   message);

//             
//             ch.write(buffer, 0, n);
//             System.out.println("Serveur a renvoyé:   " +  message);
//         };

//       
//         Runnable clientLogic = () -> {
//             Channel ch = broker.connect("localhost",  1234);

//             String msg = "Bonjour Echo!";
//             ch.write(msg.getBytes(), 0, msg.length());
//             System.out.println("Client a envoyé: " +  msg);

//             byte[] buffer = new byte[256];
//             int n = ch.read(buffer, 0, buffer.length);
//             System.out.println("Client a reçu: " + new String(buffer, 0, n));
//         };

//         
//         Task serveur = new Task(broker, serveurLogic) {};
//         Task client  = new Task(broker, clientLogic) {};

//         
//         serveur.start();
//         client.start();
//     }
// }



