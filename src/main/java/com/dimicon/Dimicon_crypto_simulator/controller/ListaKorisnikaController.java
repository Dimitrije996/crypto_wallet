package com.dimicon.Dimicon_crypto_simulator.controller;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Korisnici;
import com.dimicon.Dimicon_crypto_simulator.servisi.PronadjiSveKorisnike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class ListaKorisnikaController {
    @Autowired
    PronadjiSveKorisnike pronadjiKorisnika;

    @RequestMapping("lista")
    public String listaController(Model model){

        List<Korisnici> korisnici = pronadjiKorisnika.listaKorisnika();
        model.addAttribute("korisnici", korisnici);

        return "lista";
    }
}
