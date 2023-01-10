package com.dimicon.Dimicon_crypto_simulator.repozitorijum;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Obavestenja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ObavestenjaRepozitorijum extends JpaRepository<Obavestenja, Long> {
    @Query("select n from Obavestenja  n where n.id =?1")
    Obavestenja nadjiPoId(long id);
}
