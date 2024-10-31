package com.vmoacademy.freshermanager.service;

import com.vmoacademy.freshermanager.dao.FresherDAO;
import com.vmoacademy.freshermanager.dao.FresherRepository;
import com.vmoacademy.freshermanager.entity.Fresher;
import com.vmoacademy.freshermanager.exceptionHandler.FresherNotFoundException;
import com.vmoacademy.freshermanager.exceptionHandler.NullFresherPointException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FresherServiceImpl implements FresherService{
    private FresherRepository fresherRepository;

    @Autowired
    public FresherServiceImpl(FresherRepository fresherRepository) {
        this.fresherRepository = fresherRepository;
    }

    @Override
    public List<Fresher> findAll() {
        return fresherRepository.findAll();
    }

    @Override
    public Fresher findById(int id) {
        Optional<Fresher> fresher =  fresherRepository.findById(id);
        Fresher theFresher = null;
        if(fresher.isPresent()){
            theFresher = fresher.get();
        }
        if(theFresher == null){
            throw new FresherNotFoundException("Fresher id not found - "+id);
        }
        return theFresher;
    }

    @Override
    public Fresher save(Fresher fresher) {
        return fresherRepository.save(fresher);
    }

    @Override
    public void deleteById(int id) {
        Fresher fresher = this.findById(id);
        fresherRepository.delete(fresher);
    }
    @Override
    public List<Fresher> findByName(String fresherName) {
        List<Fresher> freshers = fresherRepository.findByFresherName(fresherName);
        if(freshers.isEmpty()){
            throw new FresherNotFoundException("Fresher name not found - "+fresherName);
        }
        return freshers;
    }
    @Override
    public List<Fresher> findByEmail(String email) {
        List<Fresher> freshers = fresherRepository.findByEmail(email);
        if(freshers.isEmpty()){
            throw new FresherNotFoundException("Fresher email not found - "+email);
        }
        return freshers;
    }

    @Override
    public void caculatedPoint(int id) {
        Fresher theFresher = this.findById(id);
        if(theFresher.getPoint1()==null || theFresher.getPoint2() == null || theFresher.getPoint3()== null){
            throw new NullFresherPointException("Fresher point is null." +
                    " id: " + theFresher.getId()
                    +", Fresher Name: "+ theFresher.getFresherName()
                    +", Point 1: "+ theFresher.getPoint1()
                    +", Point 2: "+ theFresher.getPoint2()
                    +", Point 3: "+ theFresher.getPoint3());
        }
        theFresher.setAvgPoint((theFresher.getPoint1()+ theFresher.getPoint2()+ theFresher.getPoint3())/3);
        fresherRepository.save(theFresher);
    }

//    @Transactional
//    @Override
//    public List<Fresher> caculatedPoint() {
//        List<Fresher> freshers = this.findAll();
//        for(Fresher f : freshers){
//            if(f.getPoint1()==null || f.getPoint2()== null || f.getPoint3() == null){
//                throw new NullFresherPointException("Fresher point is null: " + f.getPoint1() +" - "+ f.getPoint2()+" - "+f.getPoint3());
//
//            }
//            f.setAvgPoint((f.getPoint1()+f.getPoint2()+ f.getPoint3())/3);
//            this.save(f);
//        }
//        return freshers;
//    }
}
