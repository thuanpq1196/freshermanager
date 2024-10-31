package com.vmoacademy.freshermanager.dao;

import com.vmoacademy.freshermanager.entity.Fresher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FresherRepository extends JpaRepository<Fresher,Integer> {
    List<Fresher> findByFresherName(String fresherName);
    List<Fresher> findByEmail(String email);
}
