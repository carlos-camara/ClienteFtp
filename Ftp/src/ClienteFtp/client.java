package ClienteFtp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {

	private Socket clientSocket, passiveClientSocket;
	private PrintWriter pw;
	private BufferedReader input, passiveInput;
	private String urlServer, answer;

	public client(String urlServer, int port) {
		this.urlServer = urlServer;
		try {
			clientSocket = new Socket(urlServer, port);
		} catch (IOException error) {
			System.out.println("Connection error");
		}
	}

	public void customerManagement() throws IOException {

		input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		pw = new PrintWriter(clientSocket.getOutputStream());

		managementRequest("BEGIN");

		managementRequest("USER anonymous");

		managementRequest("PASS");

		managementRequest("PASV");

		passiveClientSocket = new Socket(urlServer, getPort(answer));
		passiveInput = new BufferedReader(new InputStreamReader(passiveClientSocket.getInputStream()));

		managementRequest("LIST");

		while ((answer = passiveInput.readLine()) != null) {
			System.out.println(answer);
		}

	}

	public void managementRequest(String opcion) {

		System.out.print("Sending message to server: ");

		if (opcion.equals("BEGIN")) {
			System.out.print("\n");
		} else {
			System.out.println(opcion);
			pw.write(opcion + "\n");
			pw.flush();
		}

		try {
			answer = input.readLine();
			System.out.println("Returned message: " + answer);
		} catch (Exception e) {
			System.out.println("Error reading data");
		}

	}

	private int getPort(String message) {
		int i = message.indexOf("(") + 1;
		int j = message.indexOf(")");
		String[] arrayPasv = message.substring(i, j).split(",");
		int p1 = Integer.parseInt(arrayPasv[4]);
		int p2 = Integer.parseInt(arrayPasv[5]);
		return Integer.decode("0x" + Integer.toHexString(p1) + Integer.toHexString(p2));
	}

}
