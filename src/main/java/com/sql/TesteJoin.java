package com.sql;

import com.sql.anotations.Entity;
import com.sql.anotations.Id;

@Entity
public class TesteJoin {

    @Id
    private long id_testJoin;

    private SubJoin sjoin;
}
