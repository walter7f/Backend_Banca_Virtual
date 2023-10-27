package com.bancaVirtual.apiBanca.repository;


import com.bancaVirtual.apiBanca.model.Acount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AcountRepositori extends JpaRepository<Acount, UUID> {

}
