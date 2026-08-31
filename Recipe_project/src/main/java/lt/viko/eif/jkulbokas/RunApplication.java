package lt.viko.eif.jkulbokas;

import lt.viko.eif.jkulbokas.console.MainMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Runs the program
 */
@SpringBootApplication
public class RunApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);

        new MainMenu().start();
    }
}
