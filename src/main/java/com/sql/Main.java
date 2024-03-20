package com.sql;


import com.sql.core.executors.ExecutorsFactory;
import com.sql.core.executors.SqlConnectionExtended;
import com.sql.core.executors.SqlConnectionFactory;
import com.sql.core.executors.SqlExecutors;
import com.sql.core.maker.SqlMaker;
import com.sql.data.executors.ConnFactory;
import com.sql.data.executors.ExecutorsFactoryData;
import com.sql.data.maker.SqlGenFactory;
import com.sql.data.pa.RepositoryData;
import com.sql.hello.ReTeste;

public class Main {
    public static void main(String[] args) {
        SqlGenFactory factory = new SqlGenFactory();
        SqlConnectionFactory confactory = new ConnFactory();
        ExecutorsFactory exeFactory = new ExecutorsFactoryData();

        SqlMaker sqlMaker = factory.createSqlMakerExtended(null);
        SqlConnectionExtended conn = confactory.createSqlConnectionExtended();
        SqlExecutors executor = exeFactory.createExcutors(sqlMaker, conn);

        ReTeste t = RepositoryData.createProxy(ReTeste.class);
        t.delete(null);

    }
}