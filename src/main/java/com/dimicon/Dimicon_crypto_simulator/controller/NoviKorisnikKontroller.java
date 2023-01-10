package com.dimicon.Dimicon_crypto_simulator.controller;
import com.dimicon.Dimicon_crypto_simulator.entiteti.Korisnici;
import com.dimicon.Dimicon_crypto_simulator.entiteti.Novcanik;
import com.dimicon.Dimicon_crypto_simulator.servisi.NapraviKorisnika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoviKorisnikKontroller {

    @GetMapping("/registracija")
    public String register(Model model){

        model.addAttribute("korisnik", new Korisnici());
        return "registracija";
    }
    @Autowired
    private NapraviKorisnika napraviKorisnika;

    @PostMapping(value = "/noviKorinsik")
    public String noviKorinsik(Korisnici korisnik,  String ime,  String prezime, String email, String sifra, Novcanik novcanik){

        napraviKorisnika.napraviKorisnika(korisnik, ime, prezime, email, sifra, novcanik);
        return "redirect:/";
    }
}
