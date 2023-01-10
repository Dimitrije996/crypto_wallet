package com.dimicon.Dimicon_crypto_simulator.controller;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Korisnici;
import com.dimicon.Dimicon_crypto_simulator.konfiguracija.KorisnikoviPodaci;
import com.dimicon.Dimicon_crypto_simulator.servisi.NapraviKorisnika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IzmeniKorisnika {

    @RequestMapping(value = "azuriranjeKorisnika", method = RequestMethod.GET)
    public String tipPocetna(Model model){

        model.addAttribute("korisnik", new Korisnici());

        return "izmeniKorisnika";
    }
    @Autowired
   private NapraviKorisnika napraviKorisnika;

    @RequestMapping(method = RequestMethod.POST,value = "izmeniKorisnika")
    public String izmeniKorinsika(  String ime, String prezime,  String email,  Long id){

        napraviKorisnika.izmeniKorisnika(id, ime, prezime, email);
        return "redirect:/adminHome";
    }

    @PostMapping(value = "/izbrisiKorisnika")
    public String izbrisiKorisnika(@AuthenticationPrincipal KorisnikoviPodaci korisnikoviPodaci, Long id){

        long id1 = korisnikoviPodaci.getId();

        napraviKorisnika.proveraDaLiSeBriseTrenutniKorisnik(id1,id);

        return "redirect:/adminHome";
    }
}
