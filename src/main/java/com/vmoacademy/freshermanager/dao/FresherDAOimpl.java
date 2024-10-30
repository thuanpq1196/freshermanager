package com.vmoacademy.freshermanager.dao;

import com.vmoacademy.freshermanager.entity.Fresher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FresherDAOimpl implements FresherDAO{
    private EntityManager entityManager;

    @Autowired
    public FresherDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Fresher> findAll() {
        TypedQuery<Fresher> theQuery = entityManager.createQuery(" FROM Fresher", Fresher.class);
        List<Fresher> freshers = theQuery.getResultList();
        return freshers;
    }

    @Override
    public Fresher findById(int id) {
        return entityManager.find(Fresher.class,id);
    }

    @Override
    public Fresher save(Fresher fresher) {
        return entityManager.merge(fresher);
    }

    @Override
    public void deleteById(int id) {
        Fresher dbFresher = entityManager.find(Fresher.class, id);
        entityManager.remove(dbFresher);
    }
}
