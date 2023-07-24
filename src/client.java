import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class client {

    public static void  main (String[] args) {

        try {
            // Create a socket to connect to the server
            int port = 1238;
            Socket clientSocket = new Socket("localhost", 1238);
            System.out.println("Connected to server on port: " + port);

            Scanner scanner = new Scanner(clientSocket.getInputStream());
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            Scanner consoleScanner = new Scanner(System.in);
            System.out.println("Enter a number of your choosing: ");
            int userInput = consoleScanner.nextInt();
            writer.println(userInput);

            String response = scanner.nextLine();
            System.out.println("Server response: " + response);

            scanner.close();
            writer.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}



