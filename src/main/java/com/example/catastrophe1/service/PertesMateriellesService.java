package com.example.catastrophe1.service;


import com.example.catastrophe1.repository.PertesMateriellesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PertesMateriellesService {
    private final PertesMateriellesRepo pertesMateriellesRepo ;


    @Autowired
    public PertesMateriellesService(PertesMateriellesRepo pertesMateriellesRepo){
        this.pertesMateriellesRepo=pertesMateriellesRepo;
    }
}
