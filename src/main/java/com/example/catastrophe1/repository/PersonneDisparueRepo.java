package com.example.catastrophe1.repository;

import com.example.catastrophe1.model.Catastrophe;
import com.example.catastrophe1.model.PersonneDisparue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonneDisparueRepo extends JpaRepository<PersonneDisparue,Long> {

    @Query("SELECT c FROM PersonneDisparue c WHERE c.catastrophe.nom_catastrophe = :nomCatastrophe ")
    List<PersonneDisparue> findByCatastropheNom(@Param("nomCatastrophe") String nomCatastrophe);









}
