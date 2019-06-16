package com.cibertec.ms_userrole.Controller;

import com.cibertec.ms_userrole.Model.UserRole;
import com.cibertec.ms_userrole.Service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping(path = "/customer")
    public ResponseEntity<Object> retriveAll() {
        return userRoleService.getAll();
    }

    @GetMapping(path = "/customer/{user_id}")
    public ResponseEntity<Object> retriveOne(@PathVariable Integer user_id) {
        return userRoleService.getById(user_id);
    }

    @PostMapping(path = "/customer")
    public ResponseEntity<Object> create(@RequestBody UserRole userRole) {
        return userRoleService.insert(userRole);
    }

    @PutMapping(path = "/customer/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer user_id, @RequestBody UserRole userRole) {
        return userRoleService.update(user_id, userRole);
    }

    @DeleteMapping(path = "/customer/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer user_id) {
        return userRoleService.delete(user_id);
    }
}
