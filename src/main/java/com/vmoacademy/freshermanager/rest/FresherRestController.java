package com.vmoacademy.freshermanager.rest;

import com.vmoacademy.freshermanager.entity.Fresher;
import com.vmoacademy.freshermanager.exceptionHandler.FresherNotFoundException;
import com.vmoacademy.freshermanager.service.FresherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FresherRestController {
    private FresherService fresherService;

    @Autowired
    public FresherRestController(FresherService fresherService) {
        this.fresherService = fresherService;
    }

    @GetMapping("/fresher")
    public List<Fresher> findAll(){
        return fresherService.findAll();
    }

    @GetMapping("/fresher/{id}")
    public Fresher findById(@PathVariable int id){
        Fresher fresher = fresherService.findById(id);
        if(fresher == null){
            throw new FresherNotFoundException("Fresher id not found - "+id);
        }
        return fresher;
    }

    @PostMapping("/fresher")
    public Fresher addFresher(@RequestBody Fresher theFresher){
        theFresher.setId(0);
        Fresher fresher = fresherService.save(theFresher);
        return fresher;
    }
    @PutMapping("/fresher")
    public Fresher updateFresher(@RequestBody Fresher theFresher){
        Fresher dbFresher = fresherService.findById(theFresher.getId());
        if(dbFresher == null){
            throw new FresherNotFoundException("Fresher id not found - "+theFresher.getId());
        }
        Fresher updatedFresher = fresherService.save(theFresher);
        return updatedFresher;
    }
    @DeleteMapping("/fresher/{id}")
    public String deleteFresher(@PathVariable int id){
        Fresher fresher = fresherService.findById(id);
        if(fresher == null){
            throw new FresherNotFoundException("Fresher id not found - "+id);
        }
        fresherService.deleteById(id);
        return "Delete fresher with id: " +id;
    }
}
