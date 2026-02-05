package fr.pompey.cda24060.tp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="id_users")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id_users;

    @Column(name="user_first_name")
    private String user_first_name;

    @Column(name="user_last_name")
    private String user_last_name;
}
