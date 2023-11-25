package com.exam.managment;

import com.exam.client.Client;
import com.exam.service.Service;

import java.util.Objects;
import java.util.Scanner;

public class ClientManager extends Manager {
    public ClientManager(Service service) {
        super(service);
    }

    @Override
    public void performAction(String command) {
        if(command.startsWith("Add")){
            Client client = this.service.readClient();
            if(client != null){
                this.service.addClient(client);
            }
            System.out.println("Invalid input! Try again!");
        }else if(command.startsWith("Update")){
            this.service.updateClient();
        } else if (command.startsWith("View")) {
            this.service.viewAll();
        } else if (command.startsWith("Remove")) {
            String[] commands = command.split(" ");
            if(commands.length == 3){
                int idClient = Integer.parseInt(commands[2]);
                this.service.removeClient(idClient);
            }
        }else if(command.equals("Exit")){
            this.service.saveData();
        } else if (command.equals("Load")) {
            this.service.loadData();
        } else if (command.startsWith("Search")) {
            String[] commands = command.split(" ");
            if(Objects.equals(commands[1], "Name")){
                String name =commands[2];
                for(int i = 3;i< commands.length;i++){
                    name += " " + commands[i];
                }
                this.service.searchByName(name);
            }else if(Objects.equals(commands[1], "ID")){
                this.service.searchByID(Integer.parseInt(commands[2]));
            } else if (Objects.equals(commands[1], "Industry")) {
                String industry =commands[2];
                for(int i = 3;i< commands.length;i++){
                    industry += " " + commands[i];
                }
                this.service.searchByIndustry(industry);
            }
        }
    }
}
