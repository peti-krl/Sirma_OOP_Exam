package com.exam.fileHandling;

import com.exam.client.Client;

import java.util.List;

public interface IWriter {
    void writer(List<Client> client, String filename);
}
