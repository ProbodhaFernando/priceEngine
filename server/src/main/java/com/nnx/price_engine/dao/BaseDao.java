package com.nnx.price_engine.dao;

import java.util.Collection;

public interface BaseDao<T> {

    Collection<T> getAll();
}
