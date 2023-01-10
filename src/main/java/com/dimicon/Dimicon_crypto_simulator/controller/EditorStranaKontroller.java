package com.dimicon.Dimicon_crypto_simulator.controller;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Korisnici;
import com.dimicon.Dimicon_crypto_simulator.entiteti.Market;
import com.dimicon.Dimicon_crypto_simulator.entiteti.Novcanik;
import com.dimicon.Dimicon_crypto_simulator.entiteti.Obavestenja;
import com.dimicon.Dimicon_crypto_simulator.konfiguracija.KorisnikoviPodaci;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.KorisniciRepozitorijum;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.MarketRepozitorijum;
import com.dimicon.Dimicon_crypto_simulator.servisi.PrikaziNovcanik;
import com.dimicon.Dimicon_crypto_simulator.servisi.UpravljajObavestenjima;
import com.dimicon.Dimicon_crypto_simulator.servisi.UpravljanjeTransakcijama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Controller
public class EditorStranaKontroller implements WebMvcConfigurer {

    private final KorisniciRepozitorijum korisniciRepozitorijum;
    private final MarketRepozitorijum marketRepozitorijum;
    @Autowired
    private PrikaziNovcanik prikaziNovcanik;
    @Autowired
    private UpravljajObavestenjima upravljajObavestenjima;
    @Autowired
    private UpravljanjeTransakcijama upravljanjeTransakcijama;

    public EditorStranaKontroller(KorisniciRepozitorijum korisniciRepozitorijum, MarketRepozitorijum marketRepozitorijum) {
        this.korisniciRepozitorijum = korisniciRepozitorijum;
        this.marketRepozitorijum = marketRepozitorijum;
    }


    @GetMapping("editorHome")
    public String editorHome(@AuthenticationPrincipal KorisnikoviPodaci korisnikoviPodaci, Model model){
        String email = korisnikoviPodaci.getEmail();
        Market market = marketRepozitorijum.pronadjiMarketPoId(1);
        Novcanik novcanik = korisnikoviPodaci.getNovcanikId();
        Korisnici korisnik = korisniciRepozitorijum.pronadjiKorisnikaPoEmail(email);
        List<Obavestenja> obavestenja = upravljajObavestenjima.prikaziObavestenja();
        model.addAttribute("korisnik", korisnik);
        model.addAttribute("novcanik", novcanik);
        model.addAttribute("market", market);
        model.addAttribute("obavestenja", obavestenja);
        return"editorHome";
    }

    @PostMapping("kupiBtc_e")
    public String kupiBtc(  @AuthenticationPrincipal KorisnikoviPodaci korisnikoviPodaci, double sredstva){

        String email = korisnikoviPodaci.getEmail();
        Market market = marketRepozitorijum.pronadjiMarketPoId(1);
        Korisnici  korisnik = korisniciRepozitorijum.pronadjiKorisnikaPoEmail(email);
        Novcanik novcanik = korisnikoviPodaci.getNovcanikId();
        upravljanjeTransakcijama.kupiBtc(market, novcanik, sredstva);

        korisniciRepozitorijum.save(korisnik);

        return "redirect:/editorHome";
    }

    @PostMapping("prodajBtc_e")
    public String prodajBtc(  @AuthenticationPrincipal KorisnikoviPodaci korisnikoviPodaci,double bitcoin){

        String email = korisnikoviPodaci.getEmail();
        Market market = marketRepozitorijum.pronadjiMarketPoId(1);
        Korisnici  korisnik = korisniciRepozitorijum.pronadjiKorisnikaPoEmail(email);
        Novcanik novcanik = korisnikoviPodaci.getNovcanikId();
        upravljanjeTransakcijama.prodajBtc(market, novcanik, bitcoin);

        korisniciRepozitorijum.save(korisnik);

        return "redirect:/editorHome";
    }

    @PostMapping("kupiEth_e")
    public String kupiEth(  @AuthenticationPrincipal KorisnikoviPodaci korisnikoviPodaci, double sredstva){

        String email = korisnikoviPodaci.getEmail();
        Market market = marketRepozitorijum.pronadjiMarketPoId(1);
        Korisnici  korisnik = korisniciRepozitorijum.pronadjiKorisnikaPoEmail(email);
        Novcanik novcanik = korisnikoviPodaci.getNovcanikId();
        upravljanjeTransakcijama.kupiEth(market, novcanik, sredstva);

        korisniciRepozitorijum.save(korisnik);

        return "redirect:/editorHome";
    }

    @PostMapping("prodajEth_e")
    public String prodajEth(  @AuthenticationPrincipal KorisnikoviPodaci korisnikoviPodaci, double ethereum){

        String email = korisnikoviPodaci.getEmail();
        Market market = marketRepozitorijum.pronadjiMarketPoId(1);
        Korisnici  korisnik = korisniciRepozitorijum.pronadjiKorisnikaPoEmail(email);
        Novcanik novcanik = korisnikoviPodaci.getNovcanikId();
        upravljanjeTransakcijama.prodajEth(market, novcanik, ethereum);

        korisniciRepozitorijum.save(korisnik);

        return "redirect:/editorHome";
    }

    @PostMapping("kupiDodge_e")
    public String kupiDodge(  @AuthenticationPrincipal KorisnikoviPodaci korisnikoviPodaci, double sredstva){

        String email = korisnikoviPodaci.getEmail();
        Market market = marketRepozitorijum.pronadjiMarketPoId(1);
        Korisnici  korisnik = korisniciRepozitorijum.pronadjiKorisnikaPoEmail(email);
        Novcanik novcanik = korisnikoviPodaci.getNovcanikId();
        upravljanjeTransakcijama.kupiDodge(market, novcanik, sredstva);

        korisniciRepozitorijum.save(korisnik);

        return "redirect:/editorHome";
    }

    @PostMapping("prodajDodge_e")
    public String prodajDodge(  @AuthenticationPrincipal KorisnikoviPodaci korisnikoviPodaci, double dodge){

        String email = korisnikoviPodaci.getEmail();
        Market market = marketRepozitorijum.pronadjiMarketPoId(1);
        Korisnici  korisnik = korisniciRepozitorijum.pronadjiKorisnikaPoEmail(email);
        Novcanik novcanik = korisnikoviPodaci.getNovcanikId();
        upravljanjeTransakcijama.prodajDodge(market, novcanik, dodge);

        korisniciRepozitorijum.save(korisnik);

        return "redirect:/editorHome";
    }

    @PostMapping("kupiShibu_e")
    public String kupiShibu(  @AuthenticationPrincipal KorisnikoviPodaci korisnikoviPodaci, double sredstva){

        String email = korisnikoviPodaci.getEmail();
        Market market = marketRepozitorijum.pronadjiMarketPoId(1);
        Korisnici  korisnik = korisniciRepozitorijum.pronadjiKorisnikaPoEmail(email);
        Novcanik novcanik = korisnikoviPodaci.getNovcanikId();
        upravljanjeTransakcijama.kupiShibu(market, novcanik, sredstva);

        korisniciRepozitorijum.save(korisnik);

        return "redirect:/editorHome";
    }

    @PostMapping("prodajShibu_e")
    public String prodajShibu(  @AuthenticationPrincipal KorisnikoviPodaci korisnikoviPodaci, double shiba){

        String email = korisnikoviPodaci.getEmail();
        Market market = marketRepozitorijum.pronadjiMarketPoId(1);
        Korisnici  korisnik = korisniciRepozitorijum.pronadjiKorisnikaPoEmail(email);
        Novcanik novcanik = korisnikoviPodaci.getNovcanikId();
        upravljanjeTransakcijama.prodajShibu(market, novcanik, shiba);

        korisniciRepozitorijum.save(korisnik);

        return "redirect:/editorHome";
    }

    @GetMapping("/novcanik_e")
    public String prikaziNovcanik(@AuthenticationPrincipal KorisnikoviPodaci korisnikoviPodaci,  double sredstva,  double bitcoin,  double ethereum,  double shiba, double dodge){

        Novcanik novcanik = korisnikoviPodaci.getNovcanikId();

        prikaziNovcanik.prikaziNovcanik(novcanik,sredstva, bitcoin, ethereum, shiba, dodge);
        return "adminHome";
    }


}
