package com.exam.managment;

import com.exam.service.Service;

public abstract class Manager {
    protected Service service;

    public Manager(Service service){
        this.service=service;
    }

    public abstract void performAction(String command);
}
