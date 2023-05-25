package com.example.springboot.repository;

import com.example.springboot.beans.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, UUID> {
    Optional<Profil> findProfilById(UUID id);

    @Query("SELECT p from Profil p where p.user.id = ?1")
    Profil findProfilByUserId(UUID id);
}