package com.vmoacademy.freshermanager.service;

import com.vmoacademy.freshermanager.entity.Fresher;

import java.util.List;

public interface FresherService {
    List<Fresher> findAll();

    Fresher findById(int id);

    Fresher save(Fresher fresher);

    void deleteById(int id);

    List<Fresher> findByName(String fresherName);

    List<Fresher> findByEmail(String email);

    void caculatedPoint(int id);
}
