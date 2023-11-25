package com.exam.fileHandling;

import com.exam.client.Client;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVWriter;

public class WriterCSV implements IWriter{

    @Override
    public void writer(List<Client> client, String filename) {
        try(CSVWriter csvWriter = new CSVWriter(new FileWriter(filename))){
            String[] headers = {"ID", "Name", "Industry", "ContactPerson", "Revenue"};
            csvWriter.writeNext(headers);

            for (int i = 0; i < client.size(); i++) {
                Client client1 = client.get(i);
                String data = client1.toCSVString();
                String[] arr = new String[1];
                arr[0]=data;
                csvWriter.writeNext(arr);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
