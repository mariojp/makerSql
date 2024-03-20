package com.sql.core.pa;

import java.util.Collection;

public interface RepositoryBase<E, I> {
    void save(E entity);
    void delete(E entity);
    Collection<E> findAll();
    E findById(I id);
}
