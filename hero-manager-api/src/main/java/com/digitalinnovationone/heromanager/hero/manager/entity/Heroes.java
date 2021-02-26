package com.digitalinnovationone.heromanager.hero.manager.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Heroes {

    @Id
    @Column(nullable = false,unique = true)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String universo;

    @Column(nullable = false)
    private String filmes;
    
    public Heroes(Long id, String name, String universo, String filmes) {
        this.id = id;
        this.name = name;
        this.universo = universo;
        this.filmes = filmes;
    }
}
