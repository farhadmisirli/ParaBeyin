package com.parabeyin.api.repository;
/* Created by Farhad on 2020-03-30 */

import com.parabeyin.api.entity.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {

    DAOUser findByUsername(String username);

}
