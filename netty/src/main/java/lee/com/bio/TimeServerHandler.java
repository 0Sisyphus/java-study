package lee.com.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Author: lidong
 * Date: 2025/3/10 14:33
 */
public class TimeServerHandler implements Runnable{


    private final Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){
            while (true) {
                String body = in.readLine();
                if (body == null) {
                    break;
                }
                System.out.println("the time server receive order : " + body);
                String currentTime = "query time order".equalsIgnoreCase(body) ? new java.util.Date(System.currentTimeMillis()).toString() : "bad order";
                out.println(currentTime);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
