package com.sql;

import com.sql.anotations.Entity;
import com.sql.anotations.Id;

@Entity
public class Ciclo {
    
    @Id
    private long id_ciclo;

    private String nome;

    private SubJoin join;

}
