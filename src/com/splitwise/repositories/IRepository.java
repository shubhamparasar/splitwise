package com.splitwise.repositories;

import com.splitwise.models.User;

import java.util.List;
import java.util.Optional;

public interface IRepository<E, Id> {
    public void create(E obj);// create

    public Optional<User> findById(Id id); // read

    public List<User> findAll(); // read

    public void Save(E obj); // update

    public void Delete(Id id);// delete
}
