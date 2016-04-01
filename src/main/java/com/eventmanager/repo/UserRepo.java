package com.eventmanager.repo;

import com.eventmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kjsiosan on 4/1/2016.
 */
@Repository("userRepo")
public interface UserRepo extends JpaRepository<User, Long> {
}
