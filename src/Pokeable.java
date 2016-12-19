import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI-LAN - PACKAGE_NAME
 * Created by matthew on 19/12/16.
 */
public interface Pokeable extends Remote
{
    void poke() throws RemoteException;
}
