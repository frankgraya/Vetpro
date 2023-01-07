package com.vet.Vetpro.Service;

import com.vet.Vetpro.Models.User;

import java.util.List;

public interface UserService {


    public User saveUser(User user);

    public void deleteUser(long id);

    public User findByIdUser(long id);

    public List<User> findAllUser();

}
