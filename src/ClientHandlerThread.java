import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 */

/**
 * @author Calle
 *
 */
public class ClientHandlerThread extends Thread{
	
	private Socket clientSocket;
	
	public ClientHandlerThread(Socket socket){
		clientSocket=socket;
		
	}

	@Override
	public void run() {
		try(
			PrintWriter out =
			    new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
			    new InputStreamReader(clientSocket.getInputStream()));
				){
			String inputLine, outputLine;
            
			// Initiate conversation with client
			//KnockKnockProtocol kkp = new KnockKnockProtocol();
			//outputLine = kkp.processInput(null);
			outputLine = "teststräng från server";
			out.println(outputLine);
	
			while ((inputLine = in.readLine()) != null) {
			    outputLine = "Ja, " + inputLine + "\n Låter bra!";
			    out.println(outputLine);
			    if (outputLine.equals("Bye.")){
			      	break;
			    }
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
