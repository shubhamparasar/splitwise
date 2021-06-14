package com.splitwise.repositories;

import com.splitwise.models.User;

import java.util.List;
import java.util.Optional;

public interface userRepository extends IRepository<User,Long>{
    public Optional<User> findByUserName(String userName);

}
