package com.sql;

import com.sql.anotations.Entity;
import com.sql.anotations.Id;

@Entity
public class SubJoin {

    @Id
    private long id_SubJoin;

    private String nome;
}
