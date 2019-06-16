package com.cibertec.ms_userrole.Service.Implement;

import com.cibertec.ms_userrole.Model.UserRole;
import com.cibertec.ms_userrole.Repository.UserRoleRepository;
import com.cibertec.ms_userrole.Service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {


    @PersistenceContext
    private EntityManager em;

    @Autowired
    UserRoleRepository userRoleRepository;

    public ResponseEntity<Object> getAll() {
        try {
            List<UserRole> userRoles = userRoleRepository.findAll();

            if (userRoles == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(userRoles);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> getById(Integer user_id) {
        try {
            Optional<UserRole> userRole = userRoleRepository.findById(user_id);

            if (!userRole.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(userRole);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> insert(UserRole userRole) {
        try {
            UserRole entity = userRoleRepository.save(userRole);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(entity.getNum_role_id()).toUri();

            return ResponseEntity.ok().body(entity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> update(Integer user_id, UserRole userRole) {
        try {
            Optional<UserRole> entity = userRoleRepository.findById(user_id);

            if (!entity.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            userRole.setNum_user_id(user_id);
            UserRole cust = userRoleRepository.save(userRole);
            return ResponseEntity.ok().body(cust);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> delete(Integer user_id) {

        try {
            Optional<UserRole> userRole = userRoleRepository.findById(user_id);
            if (!userRole.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            userRoleRepository.deleteById(user_id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
