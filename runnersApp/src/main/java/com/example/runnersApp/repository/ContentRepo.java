package com.example.runnersApp.repository;

import com.example.runnersApp.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepo extends JpaRepository<Content, Integer> {
}
