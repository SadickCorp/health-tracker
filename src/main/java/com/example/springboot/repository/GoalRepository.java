package com.example.springboot.repository;

import com.example.springboot.beans.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GoalRepository extends JpaRepository<Goal, UUID> {
    @Query("SELECT g from Goal g where g.user.id = ?1")
    Goal getGoalByUserId(final UUID userId);
}
