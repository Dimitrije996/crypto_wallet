package com.dimicon.Dimicon_crypto_simulator.repozitorijum;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Novcanik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
@Repository
@Transactional

public interface NovcanikRepozitorijum extends JpaRepository<Novcanik, Long> {
    @Query("select n from Novcanik n where n.id =?1")
    Novcanik pronadjiNovcanikPoId(long id);
}