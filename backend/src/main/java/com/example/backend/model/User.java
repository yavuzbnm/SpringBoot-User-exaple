package com.example.backend.model;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //otomatik artan id
    //repositoryle haberleşicek
    private long id;

    @Column(name = "first_name ",nullable = false,length = 50)
    private String firstname;

    @Column(name = "last_name ",nullable = false,length = 50)
    private String lastname;

    public User(String firstname, String lastname) {
        this.id = id;
        this.firstname=firstname;
        this.lastname=lastname;

    }


}
