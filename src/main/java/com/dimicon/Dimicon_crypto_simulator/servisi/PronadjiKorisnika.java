package com.dimicon.Dimicon_crypto_simulator.servisi;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Korisnici;
import com.dimicon.Dimicon_crypto_simulator.konfiguracija.KorisnikoviPodaci;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.KorisniciRepozitorijum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
public class PronadjiKorisnika implements UserDetailsService {
    @Autowired
    private KorisniciRepozitorijum korisniciRepozitorijum;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Korisnici korisnik = korisniciRepozitorijum.pronadjiKorisnikaPoEmail(email);

        if (korisnik == null){
            throw new UsernameNotFoundException("Nismo nasli korisnika sa emailom " + email);
        }

        return new KorisnikoviPodaci(korisnik);
    }
}
