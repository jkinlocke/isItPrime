import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class server {
    public static void main (String[] args) {
        try {

            int port = 1238;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                Scanner scanner = new Scanner(clientSocket.getInputStream());
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                int userInput = scanner.nextInt();
                System.out.println();
                System.out.println("Number from client: " + userInput);

                boolean isPrime = checkPrime(userInput);

                writer.println(isPrime ? "Yes" : "No");

                scanner.close();
                writer.close();
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
   public static boolean checkPrime(int userInput){
            if(userInput <= 1) return false;
            for(int i = 2; i * i <= userInput; i++){
                if (userInput % i == 0){
                    return false;
                }
            }
            return true;
    }

    }

