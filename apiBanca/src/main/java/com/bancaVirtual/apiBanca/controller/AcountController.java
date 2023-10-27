package com.bancaVirtual.apiBanca.controller;


import com.bancaVirtual.apiBanca.AcountService;
import com.bancaVirtual.apiBanca.model.Acount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/acount")
public class AcountController {
    @Autowired
    private AcountService acountService;

    @PostMapping
    public Acount createAcount(@RequestBody Acount acount){
        return acountService.createAcount(acount);
    }

    @GetMapping("{id}")
    public Acount searchAcountById(@PathVariable("id") UUID id_acount){
        return acountService.getAcountById(id_acount);
    }
    @DeleteMapping("{id}")
    public void deleteAcountById(@PathVariable("id") UUID id_account){
        acountService.deleteAcount(id_account);
    }

    @GetMapping
    public List<Acount> getAllAcount(){
        return acountService.getAllAcount();
    }
}
