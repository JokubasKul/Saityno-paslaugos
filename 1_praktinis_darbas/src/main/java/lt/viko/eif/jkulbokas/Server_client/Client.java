package lt.viko.eif.jkulbokas.Server_client;

import lt.viko.eif.jkulbokas.Database_files.LibraryService;
import lt.viko.eif.jkulbokas.POJO_classes.Library;
import lt.viko.eif.jkulbokas.TransformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

@Component
public class Client {

    @Autowired
    LibraryService libraryService;

    @Autowired
    TransformService transformService;

    public void startClient() throws Exception{

        Socket socket = new Socket("localhost", 8095);
        System.out.println("\nConnected to server.\n");
        Thread.sleep(1000);

        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("received_file.xml");

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, bytesRead);
        }

        fileOutputStream.close();
        inputStream.close();
        socket.close();

        System.out.println("File received successfully. \n");
        Thread.sleep(1000);
    }

    public void performTask() throws Exception {
        File xmlFile= new File("received_file.xml");
        File xsdFile= new File("src/main/java/lt/viko/eif/jkulbokas/xml_files/library.xsd");

        Library library = transformService.transformToPOJO(xmlFile, xsdFile);

        libraryService.saveLibrary(library);
        System.out.println();
        System.out.println();
        System.out.println("Unmarshalled data saved to database. \n");

        Thread.sleep(2000);
        System.out.println();
        System.out.println();
        System.out.println("               Marshalled");
        System.out.println();
        transformService.transformToXml(library);

    }
}
