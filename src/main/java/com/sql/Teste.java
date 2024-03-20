package com.sql;

import java.util.List;
import com.sql.anotations.Collunm;
import com.sql.anotations.Entity;
import com.sql.anotations.Id;
import com.sql.anotations.OrderBy;

@Entity
public class Teste {
    
    @Id
    private long id_teste;

    @Collunm(CollumName = "colunaNome")
    private String nome;

    @Collunm
    private String idade;

    private List<String> roles;

    private TesteJoin teste;

    private Ciclo ciclo;


}
