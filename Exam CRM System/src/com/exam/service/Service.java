package com.exam.service;

import com.exam.client.Client;
import com.exam.fileHandling.IReader;
import com.exam.fileHandling.IWriter;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public abstract class Service {

    protected IReader fileReader;
    protected IWriter fileWriter;
    protected List<Client> clients;

    public Service(IReader fileReader, IWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.clients = new ArrayList<Client>();
    }

    public abstract Client readClient();

    public abstract void addClient(Client client);

    public abstract void updateClient();

    public abstract void viewAll();
    public abstract void removeClient(int id);
    public abstract void saveData();
    public abstract void loadData();
    public abstract void searchByID(int id);
    public abstract void searchByName(String name);
    public abstract void searchByIndustry(String industry);
}
