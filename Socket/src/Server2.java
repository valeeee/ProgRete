import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Logger;

public class Server2 {
	static Logger logger = Logger.getLogger("global");
	public static void main (String[] args) {
		try{
			ServerSocket serverSocket = new ServerSocket (9000);
			logger.info("Socket istanziato, accetto connessioni...");
			Socket socket = serverSocket.accept();
			logger.info("Accettata una connessione...attendo comandi");
			ObjectOutputStream outStream = new ObjectOutputStream (socket.getOutputStream());
			ObjectInputStream inStream = new ObjectInputStream (socket.getInputStream());
			String nome = (String) inStream.readObject();
			logger.info("Ricevuto:" + nome);
			outStream.writeObject("Hello" + nome);
			socket.close();
		}
		catch (EOFException e){
			logger.severe("Problemi con la connesssione:" + e.getMessage());
			e.printStackTrace();
		}
		catch (Throwable t){
			logger.severe("Lanciata throwable:" + t.getMessage());
			t.printStackTrace();
		}
	}

}
