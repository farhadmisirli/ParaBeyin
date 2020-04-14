package com.parabeyin.api.repository;
/* Created by Farhad on 2020-03-31 */

import com.parabeyin.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

    public boolean existsByUsername(String username);

    public boolean existsByEmail(String email);

    public User findById(long id);

    public User findByEmail(String email);


}
