package com.exam.fileHandling;

import com.exam.client.Client;

import java.util.List;

public interface IReader {
    List<Client> read(String filename);
}
