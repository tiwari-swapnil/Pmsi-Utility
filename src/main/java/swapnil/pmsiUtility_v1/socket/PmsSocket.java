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
    private boolean isConnected;

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
            isConnected = true;

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);


            new Thread(this :: readerThread).start();
            writeCommand("LS");
            new Thread(this :: writerThread).start();

        } catch (Exception e) {
            log.error("PMSSocket :: Exception occurred while establishing socket connection : ", e);
        }
    }

    private void writerThread() {
        try{
            while(isConnected){
                out.println("LA");
                //todo need to check time to send link active
                Thread.sleep(5_000);

            }
        }
        catch (Exception e){
            log.error("PMSSocket :: Exception occurred in writer thread : ", e);
        }
    }


    private void readerThread() {
        try{

            String message;
            while (isConnected && (Objects.nonNull(message = in.readLine()))) {
                log.info("PMSSocket :: Data read from client : " + message);
                processMessage(message);
            }
        }
        catch (Exception e){
            log.error("PMSSocket :: Exception occurred in reader thread : ", e);
        }
    }

    private void processMessage(String message) {
        try {
            if ("LA".equalsIgnoreCase(message)) {
                out.println("LA");
            }
        } catch (Exception e) {
            log.error("PMSSocket :: Exception occurred while processing message : ", e);
        }
    }

    public void writeCommand(String command){
        try {
            if(isConnected)
                out.println(command);
        }
        catch (Exception e){
            log.error("PMSSocket :: Exception occurred while writing command on socket : ", e);
        }
    }
}
