package com.example.catastrophe1.repository;

import com.example.catastrophe1.model.Victime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VictimeRepo extends JpaRepository<Victime,Long> {
}
