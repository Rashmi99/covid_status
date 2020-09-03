import java.rmi.*;
import java.rmi.server.*;
public interface iurl extends Remote{
	public String returnStats(String country) throws RemoteException;
	
}