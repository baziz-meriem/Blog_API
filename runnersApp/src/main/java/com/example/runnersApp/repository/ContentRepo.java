package com.example.runnersApp.repository;

import com.example.runnersApp.model.Content;
import com.example.runnersApp.model.Status;
import com.example.runnersApp.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepo extends JpaRepository<Content, Integer> {

    // Get all content paginated
    Page<Content> findAll(Pageable pageable);

    List<Content> findByUserId(Integer userId);

    // Get number of contents by type for a user
    long countByUserIdAndContentType(Integer userId, Type type);

    // Get number of contents by status
    long countByStatus(Status status);
}
