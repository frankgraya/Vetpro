package com.vet.Vetpro.Service;


import com.vet.Vetpro.Models.Role;
import com.vet.Vetpro.Repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    /**
     * @param role
     * @return
     */
    @Override
    public Role saveRole(Role role) {
        log.info("Se guardo Role con exito ");
        return roleRepository.save(role);
    }

    /**
     * @param id
     */
    @Override
    public void deleteRole(long id) {
        log.info("Se borro Role con exito " + id);
        roleRepository.deleteById(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Role findByIdRole(long id) {
        log.info("Se busco Role con exito " + id);

        Optional<Role> optional = roleRepository.findById(id);
        Role role = null;
        if (optional.isPresent()) {
            role = optional.get();
        } else {
            throw new RuntimeException(" Role no se encontro por id :: " + id);
        }
        return role;
    }

    /**
     * @return
     */
    @Override
    public List<Role> findAllRole() {
        log.info("Se Busco todos los roles con exito ");
        return (List<Role>) roleRepository.findAll();
    }
}
