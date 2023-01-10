package com.dimicon.Dimicon_crypto_simulator.repozitorijum;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepozitorijum extends JpaRepository<Market, Integer> {
    @Query("select m from Market m where m.id =?1")
    Market pronadjiMarketPoId(int id);
}
