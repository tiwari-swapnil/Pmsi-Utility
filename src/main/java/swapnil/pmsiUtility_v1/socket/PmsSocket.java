package swapnil.pmsiUtility_v1.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

@Slf4j
@Component
public class PmsSocket implements ApplicationRunner {

    Scanner sc = new Scanner(System.in);
    int port;
    BufferedReader in;
    PrintWriter out;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        init();
    }

    public void init() {
        try {
            establishConnection();
        } catch (Exception e) {
            log.error("PMSSocket :: Exception occurred while getting port details : ", e);
        }
    }

    private void establishConnection() {
        try (ServerSocket serverSocket = new ServerSocket(50000)) {
            Socket socket = serverSocket.accept();
            log.info("PMSSocket :: Client connected: " + socket.getInetAddress());

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((Objects.nonNull(message = in.readLine()))) {
                log.info("PMSSocket :: Data read from client : " + message);
                processMessage(message);
            }

            socket.close();
        } catch (Exception e) {
            log.error("PMSSocket :: Exception occurred while establishing socket connection : ", e);
        }
    }

    private void processMessage(String message) {
        try {
            if ("LS".equalsIgnoreCase(message)) {
                out.println("LA");
            }
        } catch (Exception e) {
            log.error("PMSSocket :: Exception occurred while processing message : ", e);
        }
    }
}
