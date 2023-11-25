package com.exam.fileHandling;

import com.exam.client.Client;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderCSV implements IReader {

    @Override
    public List<Client> read(String filename) {
        try{
            CSVReader reader = new CSVReader(new FileReader(filename));
            List<String[]> lines;
            reader.readNext();
            lines = reader.readAll();

            List<Client> clients = new ArrayList<Client>();

            for(int i = 0; i<lines.size();i++){
                String[] l = lines.get(i);
                String[] arrays = l[0].split(", ");
                Client client = new Client(Integer.parseInt(arrays[0]), arrays[1], arrays[2], arrays[3], Double.parseDouble(arrays[4]));
                clients.add(client);
            }


            return clients;

        } catch (Exception e) {
            e.getStackTrace();
        }
        return new ArrayList<Client>();
    }
}
