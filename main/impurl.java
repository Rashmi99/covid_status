import java.io.*; 
import java.net.URL; 
import java.net.MalformedURLException; 
import java.rmi.*;
import java.rmi.server.*;
import java.io.RandomAccessFile;

public class impurl extends UnicastRemoteObject implements iurl
{
public impurl() throws RemoteException
{
	try { 
		URL url = new URL("https://www.statista.com/statistics/1043366/novel-coronavirus-2019ncov-cases-worldwide-by-country/"); 

		BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream())); 
		 
		BufferedWriter writer = new BufferedWriter(new FileWriter("downloadedPageWorld1.html")); 	
		
		String line;	 
			while ((line = readr.readLine()) != null) { 
				writer.write(line); 
			} 
		readr.close(); 
		writer.close(); 
					
		} 

		catch (MalformedURLException mue) { 
			System.out.println("Malformed URL Exception raised"); 
		} 
		catch (IOException ie) { 
			System.out.println("IOException raised"); 
		}
}

public String returnStats(String country) throws RemoteException
{
	try{
			RandomAccessFile rf=new RandomAccessFile("downloadedPageWorld1.html", "r");
			
			byte[] content=new byte[(int)rf.length()];
			rf.readFully(content, 0, content.length);
			String line=new String(content);
			rf.close();
			
			return line.split(country+"</td>",3)[1].split("</td>",3)[0].substring(4);
			
		}
		catch(Exception e) {System.out.println(e);}
	return "Country not found";
} 
}
