package com.cibertec.ms_userrole.Model;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Table(name = "userrole")
public class UserRole {

    @Id
    @Column(name = "num_role_id")
    private Integer num_role_id;

    @Id
    @Column(name = "num_user_id" )
    private Integer num_user_id;

}
