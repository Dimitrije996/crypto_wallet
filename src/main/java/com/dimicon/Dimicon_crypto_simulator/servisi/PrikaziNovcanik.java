package com.dimicon.Dimicon_crypto_simulator.servisi;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Novcanik;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.NovcanikRepozitorijum;
import org.springframework.stereotype.Service;
@Service
public class PrikaziNovcanik {
    private final NovcanikRepozitorijum novcanikRepozitorijum;

    public PrikaziNovcanik(NovcanikRepozitorijum novcanikRepozitorijum) {
        this.novcanikRepozitorijum = novcanikRepozitorijum;
    }
    public Novcanik prikaziNovcanik(Novcanik novcanik, double sredstva, double bitcoin, double ethereum, double shiba, double dodge){

        novcanik.getSredstva();
        novcanik.getBitcoin();
        novcanik.getShiba();
        novcanik.getDodge();

        return novcanik;
    }
}
