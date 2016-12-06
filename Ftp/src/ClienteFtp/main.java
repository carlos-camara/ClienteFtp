package ClienteFtp;

import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		client redes = new client("speedtest.tele2.net", 21);
		redes.customerManagement();
	}

}
