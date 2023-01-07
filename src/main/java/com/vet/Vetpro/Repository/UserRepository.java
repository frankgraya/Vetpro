package com.vet.Vetpro.Repository;


import com.vet.Vetpro.Models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    @Query("SELECT u from User u Where u.email = :email")
    public User findByEmail(@Param("email") String email);

}
