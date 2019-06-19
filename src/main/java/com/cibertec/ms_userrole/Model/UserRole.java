package com.cibertec.ms_userrole.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "userrole")
public class UserRole {

   @Column(name = "num_role_id", nullable = false)
   private Integer num_role_id;

   @Id
   @Column(name = "num_user_id")
   private Integer num_user_id;

}
