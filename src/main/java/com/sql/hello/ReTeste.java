package com.sql.hello;

import java.util.List;

import com.sql.Teste;
import com.sql.core.pa.RepositoryBase;

public interface ReTeste extends RepositoryBase<Teste, Long>{
    Teste findByNome();
}
    