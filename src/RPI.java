import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

/**
 * RMI-LAN - PACKAGE_NAME
 * Created by matthew on 19/12/16.
 */
public class RPI
{

    public RPI(String hostname, int port) throws RemoteException, NotBoundException
    {
        Registry registry = LocateRegistry.getRegistry(hostname,port);
        System.out.println(Arrays.toString(registry.list()));
        Pokeable pokeable = (Pokeable) registry.lookup("matt");
        pokeable.poke();
    }

    public static void main(String[] args) throws RemoteException, NotBoundException
    {
        String hostname = "192.168.1.201";
        int port = Registry.REGISTRY_PORT;
        System.setProperty("java.rmi.server.hostname", hostname) ;

        new RPI(hostname, port);
    }
}
