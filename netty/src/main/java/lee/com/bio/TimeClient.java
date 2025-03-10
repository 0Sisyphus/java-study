package lee.com.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Author: lidong
 * Date: 2025/3/10 14:38
 */
public class TimeClient {


    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                //
            }
        }

        try (Socket socket = new Socket("127.0.0.1", port);
              BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){
            out.println("query time order");
            System.out.println("send order server succeed");
            String resp = in.readLine();
            System.out.println("now is : " + resp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
