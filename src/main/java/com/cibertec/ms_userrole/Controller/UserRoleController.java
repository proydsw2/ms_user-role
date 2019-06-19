package com.cibertec.ms_userrole.Controller;

import com.cibertec.ms_userrole.Model.UserRole;
import com.cibertec.ms_userrole.Service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserRoleController {

   @Autowired
   private UserRoleService userRoleService;

   @GetMapping(path = "/userrole")
   public ResponseEntity<Object> retriveAll() {
      return userRoleService.getAll();
   }

   @GetMapping(path = "/userrole/{user_id}")
   public ResponseEntity<Object> retriveOne(@PathVariable Integer user_id) {
      return userRoleService.getById(user_id);
   }

   @PostMapping(path = "/userrole")
   public ResponseEntity<Object> create(@RequestBody UserRole userRole) {
      return userRoleService.insert(userRole);
   }

   @PutMapping(path = "/userrole/{id}")
   public ResponseEntity<Object> update(@PathVariable Integer user_id, @RequestBody UserRole userRole) {
      return userRoleService.update(user_id, userRole);
   }

   @DeleteMapping(path = "/userrole/{id}")
   public ResponseEntity<Object> delete(@PathVariable Integer user_id) {
      return userRoleService.delete(user_id);
   }
}
