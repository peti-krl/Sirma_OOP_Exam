import com.exam.fileHandling.ReaderCSV;
import com.exam.fileHandling.WriterCSV;
import com.exam.managment.ClientManager;
import com.exam.managment.Manager;
import com.exam.service.ClientService;
import com.exam.service.Service;

import java.util.Scanner;

public class ClientManagementApp {

    public static void displayOptions(){
        System.out.println("Options that you may find helpful");
        System.out.println("Add Client - input client details");
        System.out.println("Update Client - change existing client details: example: ID, new Name, new Industry, new Contact Person, new Revenue");
        System.out.println("Remove Client - mark the client as inactive in the system");
        System.out.println("View - show a list of all current clients with their details");
        System.out.println("Load - load from file");
        System.out.println("Search - search for clients by name, ID, or industry");
        System.out.println("Exit - save and exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Implement file operations for XML/SQLite
        ReaderCSV fileReader = new ReaderCSV();
        WriterCSV fileWriter = new WriterCSV();
        Service service = new ClientService(fileReader, fileWriter);
        Manager manager = new ClientManager(service);
        System.out.println("Welcome to the Client Management System");
        displayOptions();
        String command;
        boolean active = true;
        while (active) {
            command = scanner.nextLine();
            manager.performAction(command);
            if(command.equals("Exit")){
                active=false;
            }
// Add Client
// 1, Oceanic Enterprises, Finance, Sarah Smith, 500000.00
// Update Client
// 1, Oceanic Enterprises, Tech, Sarah Smith, 750000.00
// View Clients
// Search Industry Tech
// Search ID 1
// Remove Client 1
// Search Name Oceanic
// Save &amp; Exit
        }
    }
}
