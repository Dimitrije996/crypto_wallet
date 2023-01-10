package com.dimicon.Dimicon_crypto_simulator.repozitorijum;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Tip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TipRepozitorijum extends JpaRepository<Tip, Integer> {
    @Query("select t from Tip t where t.id =?1")
    Tip pronadjiTipPoID(int id);
}
