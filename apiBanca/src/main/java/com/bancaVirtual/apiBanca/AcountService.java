package com.bancaVirtual.apiBanca;


import com.bancaVirtual.apiBanca.model.Acount;
import com.bancaVirtual.apiBanca.repository.AcountRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AcountService {
    @Autowired
    private AcountRepositori acountRepositori;

    public Acount createAcount(Acount acount){
        //return userRepositori.save(user);
        acount.setId_acount(String.valueOf(UUID.randomUUID()));
        try {
            return acountRepositori.save(acount);
        } catch (Exception e) {
            // Manejar la excepción (puedes imprimir logs, lanzar una excepción personalizada, etc.)
            e.printStackTrace();
            throw new RuntimeException("Error al crear el usuario"+ e);
        }
    }

    public Acount getAcountById(UUID id_acount){
        Optional<Acount> optionalUser= acountRepositori.findById(id_acount);
        return optionalUser.get();
    }
    public void deleteAcount(UUID id_acount){
        acountRepositori.deleteById(id_acount);
    }
    public List<Acount> getAllAcount(){
        return acountRepositori.findAll();
    }

}
