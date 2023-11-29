package com.example.catastrophe1.service;

import com.example.catastrophe1.repository.ServiceUrganceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUrganceService {
    private final ServiceUrganceRepo serviceUrganceRepo ;
    @Autowired
    public ServiceUrganceService(ServiceUrganceRepo serviceUrganceRepo) {
        this.serviceUrganceRepo = serviceUrganceRepo;
    }
}
