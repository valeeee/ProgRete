import java.net.*;
import java.io.*;

public class Server1 {
	public static void main (String[] args){
		try {
			ServerSocket server = new ServerSocket(6001);
			System.out.println("Aspetto connessione!");
			Socket connection = server.accept();
			BufferedReader connectionIn = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			PrintWriter out = new PrintWriter(connection.getOutputStream());
			System.out.println("Connesso qualcuno!!! " + connection.getRemoteSocketAddress().toString());
			
			while (true) {
				
				out.write("RISPOSTA: " + connectionIn.readLine()+"\r\n");
				out.flush();
				
			}
			//connection.close( );
		}
		catch (IOException ex ) {
			System.err.println(ex.toString());
		}


	}
}

