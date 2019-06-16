package com.cibertec.ms_userrole.Service;

import com.cibertec.ms_userrole.Model.UserRole;
import org.springframework.http.ResponseEntity;

public interface UserRoleService {

    ResponseEntity<Object> getAll();

    ResponseEntity<Object> getById(Integer user_id);

    ResponseEntity<Object> insert(UserRole userRole);

    ResponseEntity<Object> update(Integer user_id, UserRole userRole);

    ResponseEntity<Object> delete(Integer user_id);
}
