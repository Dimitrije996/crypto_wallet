package com.dimicon.Dimicon_crypto_simulator.servisi;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Obavestenja;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.ObavestenjaRepozitorijum;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UpravljajObavestenjima {

private final ObavestenjaRepozitorijum obavestenjaRepozitorijum;

    public UpravljajObavestenjima(ObavestenjaRepozitorijum obavestenjaRepozitorijum) {
        this.obavestenjaRepozitorijum = obavestenjaRepozitorijum;
    }
    public Obavestenja dodajObavestenje(Obavestenja obavestenja, String naslov, String tekst){

        obavestenja.setNaslov(naslov);
        obavestenja.setTekst(tekst);

        return  obavestenjaRepozitorijum.save(obavestenja);
    }
    public List<Obavestenja> prikaziObavestenja(){

        return obavestenjaRepozitorijum.findAll();
    }
    public boolean izmeniObavestenje(long id, String naslov,  String tekst){

        Obavestenja post = obavestenjaRepozitorijum.nadjiPoId(id);
        String stariNaslov = post.getNaslov();
        String stariTekst = post.getTekst();

        if (post != null){
            if (naslov.equals("")){
                naslov = stariNaslov;
            }

            if (tekst.equals("")){
                tekst = stariTekst;
            }
            dodajObavestenje(post, naslov, tekst);
            return true;
        }
        return false;
    }
    public boolean izbrisiObavestenje(long id){

        Obavestenja post = obavestenjaRepozitorijum.nadjiPoId(id);
        if (post != null){
            obavestenjaRepozitorijum.delete(post);
        }

        return false;
    }
}
