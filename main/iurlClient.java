import java.rmi.*;

public class iurlClient{
	public static void main(String args[])
	{
	try{
	iurl c;
	c=(iurl)Naming.lookup("rmi://192.168.56.1/stats");
	System.out.println(c.returnStats(args[0]));
	}
	catch(Exception e){System.out.println(e);}
	}
}