package com.example.springboot.repository;

import com.example.springboot.beans.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    @Query("SELECT g from Goal g where g.profil.id = ?1")
    Goal getGoalByProfilId(final long profilId);
}