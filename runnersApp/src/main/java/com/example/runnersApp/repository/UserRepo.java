package com.example.runnersApp.repository;

import com.example.runnersApp.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    //get all users paginated
    Page<User> findAll(Pageable pageable);
}
