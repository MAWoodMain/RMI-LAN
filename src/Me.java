import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * RMI-LAN - PACKAGE_NAME
 * Created by matthew on 19/12/16.
 */
public class Me implements Pokeable
{

    Me(String hostname, int port) throws RemoteException
    {
        Registry registry = LocateRegistry.getRegistry(hostname,port);
        registry.rebind("matt", UnicastRemoteObject.exportObject(this,0));
    }

    @Override
    public void poke() throws RemoteException
    {
        System.out.println("oi");
    }

    public static void main(String[] args) throws RemoteException
    {
        String hostname = "192.168.1.201";
        int port = Registry.REGISTRY_PORT;
        System.setProperty("java.rmi.server.hostname", hostname) ;
        Registry reg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        new Me(hostname,port);
    }
}
