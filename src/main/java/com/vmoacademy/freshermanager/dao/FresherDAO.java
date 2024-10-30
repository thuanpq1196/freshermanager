package com.vmoacademy.freshermanager.dao;

import com.vmoacademy.freshermanager.entity.Fresher;

import java.util.List;

public interface FresherDAO {
    List<Fresher> findAll();

    Fresher findById(int id);

    Fresher save(Fresher fresher);

    void deleteById(int id);
}
