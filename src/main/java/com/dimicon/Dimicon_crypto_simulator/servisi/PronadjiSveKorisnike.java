package com.dimicon.Dimicon_crypto_simulator.servisi;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Korisnici;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.KorisniciRepozitorijum;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PronadjiSveKorisnike {

    private final KorisniciRepozitorijum korisniciRepozitorijum;

    public PronadjiSveKorisnike(KorisniciRepozitorijum korisniciRepozitorijum) {
        this.korisniciRepozitorijum = korisniciRepozitorijum;
    }

    public List<Korisnici> listaKorisnika(){

        return korisniciRepozitorijum.findAll();
    }
}
