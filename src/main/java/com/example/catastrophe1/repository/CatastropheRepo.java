package com.example.catastrophe1.repository;

import com.example.catastrophe1.model.Catastrophe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatastropheRepo extends JpaRepository<Catastrophe,Long> {


    @Query("SELECT c FROM Catastrophe c WHERE c.pays = :country")
    List<Catastrophe> findByPays(@Param("country") String pays);


    @Query("SELECT c FROM Catastrophe c WHERE c.gouvernoument = :gouvernement")
    List<Catastrophe> findByGouvernoument(@Param("gouvernement") String gouvernement);


    @Query("SELECT c FROM Catastrophe c WHERE c.statut = :statut")
    List<Catastrophe> findByStatut(@Param("statut") String statut);




}
