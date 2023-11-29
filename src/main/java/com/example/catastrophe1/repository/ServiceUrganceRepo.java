package com.example.catastrophe1.repository;

import com.example.catastrophe1.model.ServiceUrgence;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceUrganceRepo extends JpaRepository<ServiceUrgence,Long> {
}
