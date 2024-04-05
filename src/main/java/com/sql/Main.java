package com.sql;


import com.sql.core.maker.SqlMaker;
import com.sql.data.maker.SqlGenFactory;

public class Main {
    public static void main(String[] args) {
        SqlGenFactory factory = new SqlGenFactory();
        SqlMaker sqlMaker = factory.createSqlMakerExtended(null);

        sqlMaker.generateSelectSql(null, "OR", "username", "email");
        
    }
}