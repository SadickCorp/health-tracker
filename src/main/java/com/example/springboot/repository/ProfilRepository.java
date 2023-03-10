package com.example.springboot.repository;

import com.example.springboot.beans.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {
    Optional<Profil> findProfilById(Long id);

    @Query("SELECT p from Profil p where p.user.id = ?1")
    Profil findProfilByUserId(long id);
}