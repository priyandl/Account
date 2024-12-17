package com.banking.bankManagement.Repository;

import com.banking.bankManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>

    {
        // Custom query methods can be added here if needed, for example:

        // Find user by username
        User findByUsername(String username);

        // Find user by email
        User findByEmail(String email);
    }
