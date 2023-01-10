package com.dimicon.Dimicon_crypto_simulator.repozitorijum;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Korisnici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
@Transactional
public interface KorisniciRepozitorijum extends JpaRepository<Korisnici,Long> {
    @Query("select k from Korisnici k where k.email =?1")
    Korisnici pronadjiKorisnikaPoEmail(String email);
    @Query("select k from Korisnici  k where k.id=?1")
    Korisnici pronadjiKorisnikaPoId(long id);

    @Modifying
    @Query("update Korisnici set ime =?2 where id=?1")
    void izmeniIme(long id, String ime);

    @Modifying
    @Query("update Korisnici set prezime =?2 where id=?1")
    void izmeniPrezime(long id, String prezime);

    @Modifying
    @Query("update Korisnici set email =?2 where id=?1")
    void izmeniEmail(long id, String email);
}
