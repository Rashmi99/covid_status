import java.io.*; 
import java.net.URL; 
import java.net.MalformedURLException; 
import java.rmi.*;
import java.rmi.server.*;
public class iurlmain{
	public static void main(String args[])
	{
	try
	{
		impurl Px=new impurl();
		Naming.bind("/stats",Px);
	}
	
	catch(Exception e){}
	}
}