package lt.viko.eif.jkulbokas.Server_client;

import org.springframework.stereotype.Component;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.*;

@Component
public class Server {

    public void startServer() throws Exception {

            ServerSocket serverSocket = new ServerSocket(8095);
            System.out.println("Waiting for client to connect\n");
            Thread.sleep(1000);

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.\n");
            Thread.sleep(1000);

            File xmlFile = new File("src/main/java/lt/viko/eif/jkulbokas/xml_files/library.xml");
            FileInputStream fileInputStream = new FileInputStream(xmlFile);
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[1024];

            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.flush();
            fileInputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();

            System.out.println("File sent successfully.");
            Thread.sleep(1000);
    }
}