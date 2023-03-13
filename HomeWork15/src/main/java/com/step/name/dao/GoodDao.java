package com.step.name.dao;

import com.step.name.model.Good;

import java.util.List;
import java.util.Optional;

public interface GoodDao {
    Optional<Good> getByTittle(String tittle);

    Optional<Good> getById(long id);

    List<Good> getAll();

}
