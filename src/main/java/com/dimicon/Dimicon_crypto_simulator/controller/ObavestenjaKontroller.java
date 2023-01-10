package com.dimicon.Dimicon_crypto_simulator.controller;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Obavestenja;
import com.dimicon.Dimicon_crypto_simulator.servisi.UpravljajObavestenjima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ObavestenjaKontroller {

    @GetMapping("/obavestenja")
    public String register(Model model){

        model.addAttribute("obavestenja", new Obavestenja());
        return "/obavestenja";
    }

    @Autowired
    private UpravljajObavestenjima upravljajObavestenjima;

    @RequestMapping(method = RequestMethod.POST,value = "/novoObavestenje")
    public String novoObavestenje(Obavestenja obavestenja, String naslov, String tekst){

        upravljajObavestenjima.dodajObavestenje(obavestenja, naslov, tekst);

        return "redirect:/editorHome";
    }

    @PostMapping(value = "/izbrisiObavestenje")
    public String izbrisiObavestenje(long id){
        upravljajObavestenjima.izbrisiObavestenje(id);

        return "redirect:/editorHome";
    }

    @PostMapping(value = "/izmeniObavestenje")
    public String izmeniObavestenje(long id, String naslov, String tekst){
        upravljajObavestenjima.izmeniObavestenje(id, naslov, tekst);

        return "redirect:/editorHome";
    }


}
