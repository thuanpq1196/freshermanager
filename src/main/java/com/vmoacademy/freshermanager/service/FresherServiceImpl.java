package com.vmoacademy.freshermanager.service;

import com.vmoacademy.freshermanager.dao.FresherDAO;
import com.vmoacademy.freshermanager.entity.Fresher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class FresherServiceImpl implements FresherService{
    private FresherDAO fresherDAO;

    @Autowired
    public FresherServiceImpl(FresherDAO fresherDAO) {
        this.fresherDAO = fresherDAO;
    }

    @Override
    public List<Fresher> findAll() {
        return fresherDAO.findAll();
    }

    @Override
    public Fresher findById(int id) {
        return fresherDAO.findById(id);
    }

    @Transactional
    @Override
    public Fresher save(Fresher fresher) {
        return fresherDAO.save(fresher);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        fresherDAO.deleteById(id);
    }
}
