package lt.viko.eif.jkulbokas;

import lt.viko.eif.jkulbokas.Server_client.Client;
import lt.viko.eif.jkulbokas.Server_client.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunProgram implements CommandLineRunner {

    private final Server server;
    private final Client client;

    public RunProgram(Client client, Server server) {
        this.client = client;
        this.server = server;
    }

    @Override
    public void run(String... args) throws Exception {
        new Thread(() -> {
            try {
                server.startServer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);

        client.startClient();

        client.performTask();
    }
}
