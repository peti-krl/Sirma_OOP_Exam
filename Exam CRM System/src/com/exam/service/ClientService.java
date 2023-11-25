package com.exam.service;

import com.exam.client.Client;
import com.exam.fileHandling.IReader;
import com.exam.fileHandling.IWriter;

import java.util.List;
import java.util.Scanner;

public class ClientService extends Service{

    public ClientService(IReader fileReader, IWriter fileWriter) {
        super(fileReader, fileWriter);
    }

    @Override
    public Client readClient() {
        try {
            Scanner scanner = new Scanner(System.in);
            String[] data = scanner.nextLine().split(", ");
            Client client = new Client(Integer.parseInt(data[0]), data[1], data[2], data[3], Double.parseDouble(data[4]));
            return client;
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public void addClient(Client client) {
        this.clients.add(client);
    }

    @Override
    public void updateClient() {
        Client client = readClient();
        if(client != null){
            int idClient = client.getId();

            for(int i = 0; i<this.clients.size();i++) {
                if (this.clients.get(i).getId() == idClient) {
                    this.clients.set(i, client);
                    break;
                }
            }
       }else{
            System.out.println("Invalid input! Try again!");
        }
    }

    @Override
    public void viewAll() {
        for(int i =0; i < this.clients.size(); i++){
            if(this.clients.get(i).isActive()){
                System.out.println(this.clients.get(i));
            }
        }
    }

    @Override
    public void removeClient(int id) {
        for(int i = 0; i<this.clients.size();i++) {
            if (this.clients.get(i).getId() == id) {
                Client client = this.clients.get(i);
                client.setActive(false);
                this.clients.set(i,client);
                break;
            }
        }
    }

    @Override
    public void saveData() {
        this.fileWriter.writer(clients,"clients.csv");
    }

    @Override
    public void loadData() {
        List<Client> clients = this.fileReader.read("clients.csv");
        clients.forEach(System.out::println);
        this.clients = clients;
    }

    @Override
    public void searchByID(int id) {
        for (int i = 0; i < this.clients.size(); i++) {
            if(this.clients.get(i).getId()==id){
                System.out.println(this.clients.get(i));
                break;
            }
        }
    }

    @Override
    public void searchByName(String name) {
        for (int i = 0; i < this.clients.size(); i++) {
            if(this.clients.get(i).getName().startsWith(name)){
                System.out.println(this.clients.get(i));
            }
        }
    }

    @Override
    public void searchByIndustry(String industry) {
        for (int i = 0; i < this.clients.size(); i++) {
            if(this.clients.get(i).getIndustry().startsWith(industry)){
                System.out.println(this.clients.get(i));
            }
        }
    }
}
