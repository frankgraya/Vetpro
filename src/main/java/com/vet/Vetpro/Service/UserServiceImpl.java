package com.vet.Vetpro.Service;

import com.vet.Vetpro.Models.User;
import com.vet.Vetpro.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    /**
     * @param user
     * @return
     */
    @Override
    public User saveUser(User user) {
        log.info("Se guardo Usuario Correctamente");
        return userRepository.save(user);
    }

    /**
     * @param id
     */
    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
        log.info("Se borro usuario con exito");
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User findByIdUser(long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" Usuario no se encontro por id : " + id);
        }

        log.info("Se busco Usuario con exito " + id);
        return user;
    }

    /**
     * @return
     */
    @Override
    public List<User> findAllUser() {
        log.info("Se busco a todos los roles con exito");
        return (List<User>) userRepository.findAll();
    }
}
