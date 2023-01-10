package com.dimicon.Dimicon_crypto_simulator.servisi;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Market;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.MarketRepozitorijum;
import org.springframework.stereotype.Service;

@Service
public class NapraviMarket {

    private final int  MARKET_ID = 1;
    private final  int POCETNA_VREDNOST_NOVCICA = 0;
    
    private final MarketRepozitorijum marketRepozitorijum;

    public NapraviMarket(MarketRepozitorijum marketRepozitorijum) {
        this.marketRepozitorijum = marketRepozitorijum;
    }


    public boolean napraviMarket(){

       Market stariMarket = marketRepozitorijum.pronadjiMarketPoId(MARKET_ID);
       Market market = new Market();

        if (stariMarket == null){
            market.setId(MARKET_ID);
            market.setBitcoin(POCETNA_VREDNOST_NOVCICA);
            market.setEthereum(POCETNA_VREDNOST_NOVCICA);
            market.setShiba(POCETNA_VREDNOST_NOVCICA);
            market.setDodge(POCETNA_VREDNOST_NOVCICA);

            marketRepozitorijum.save(market);

            return true;

        }

        return false;
    }
}
