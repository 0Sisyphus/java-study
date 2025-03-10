package lee.com.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: lidong
 * Date: 2025/3/10 14:30
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }
        try (ServerSocket server = new ServerSocket(port)){
            System.out.println("The time server is start in port : " + port);
            while (true) {
                //当没有客户端请求时，程序会一直阻塞在accept方法上
                Socket socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        }
    }
}
