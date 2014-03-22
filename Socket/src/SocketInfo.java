import java.net.Socket;
import java.io.*;


public class SocketInfo {
	public static void main (String[] args){
		for (int i=0; i<args.length; i++){
			try {
				Socket skt = new Socket (args [i], 80); 
				System.out.println ("Connesso a " + skt.getInetAddress() + " porta " + 
				skt.getPort() + "," + " dalla porta " + skt.getLocalPort() + 
				" di " + skt.getLocalAddress());
			
			}
			catch (IOException ex){
				System.err.println(ex);
			}
		}
	}

}
