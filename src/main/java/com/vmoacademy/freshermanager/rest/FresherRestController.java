package com.vmoacademy.freshermanager.rest;

import com.vmoacademy.freshermanager.entity.Fresher;
import com.vmoacademy.freshermanager.exceptionHandler.FresherNotFoundException;
import com.vmoacademy.freshermanager.service.FresherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fresher")
public class FresherRestController {
    private FresherService fresherService;

    @Autowired
    public FresherRestController(FresherService fresherService) {
        this.fresherService = fresherService;
    }

    @GetMapping
    public int countAll(){
        return fresherService.findAll().size();
    }

    @GetMapping("/byid/{id}")
    public Fresher findById(@PathVariable int id){
        return fresherService.findById(id);
    }

    @PostMapping
    public Fresher addFresher(@RequestBody Fresher theFresher){
        Fresher fresher = fresherService.save(theFresher);
        return fresher;
    }
    @PutMapping
    public Fresher updateFresher(@RequestBody Fresher theFresher){
        Fresher dbFresher = fresherService.findById(theFresher.getId());
        if(dbFresher == null){
            throw new FresherNotFoundException("Fresher id not found - "+theFresher.getId());
        }
        Fresher updatedFresher = fresherService.save(theFresher);
        return updatedFresher;
    }
    @DeleteMapping("/byid/{id}")
    public String deleteFresher(@PathVariable int id){
        fresherService.deleteById(id);
        return "Delete fresher with id: " +id;
    }
    @PutMapping("/byid/{id}")
    public String caculatedPoint(@PathVariable int id){
        fresherService.caculatedPoint(id);
        return "Caculated AVG point for fresher with id: "+id+" - "+id;
    }
    @GetMapping("/byname/{name}")
    public List<Fresher> findByName(@PathVariable String name){
        return fresherService.findByName(name);
    }

    @GetMapping("/byemail/{email}")
    public List<Fresher> findByEmail(@PathVariable String email){
        return fresherService.findByEmail(email);
    }
}
