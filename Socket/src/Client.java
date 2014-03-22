import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		String host = "127.0.0.1";

		PrintWriter out = null; 
		BufferedReader netIn = null; 

		try {
			Socket skt = new Socket(host, 6001);
			netIn = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(skt.getOutputStream());
			System.out.println("Connesso al server");
			while (true) {
				System.out.println("Scrivi qualcosa:");
				String line = userIn.readLine();
				
				if (line.equals(".")) break;
				out.println(line);
				out.flush();
				System.out.println(netIn.readLine());
			}
			skt.close();
		}
			catch (IOException ex) {System.err.println(ex.toString());}
			finally {
				try {
					if (netIn != null) netIn.close();
					if (out != null) out.close();
				}
				catch (IOException ex) {System.out.println("IOException ex");}
			}	
		
	}
}

