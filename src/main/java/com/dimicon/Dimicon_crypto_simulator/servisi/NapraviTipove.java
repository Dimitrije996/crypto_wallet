package com.dimicon.Dimicon_crypto_simulator.servisi;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Tip;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.TipRepozitorijum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NapraviTipove {

    private final TipRepozitorijum tipRepozitorijum;

    public NapraviTipove(TipRepozitorijum tipRepozitorijum) {
        this.tipRepozitorijum = tipRepozitorijum;
    }

    public boolean napraviTipove(){
        List<Tip> tip = tipRepozitorijum.findAll();

        if (tip.isEmpty()){
        Tip admin = new Tip();
        admin.setId(1);
        admin.setIme("ADMIN");

        Tip editor = new Tip();
        editor.setId(2);
        editor.setIme("EDITOR");

        Tip korisnik = new Tip();
        korisnik.setId(3);
        korisnik.setIme("KORISNIK");

            tipRepozitorijum.save(admin);
            tipRepozitorijum.save(editor);
            tipRepozitorijum.save(korisnik);

        return true;


        }
         return false;
    }
}
