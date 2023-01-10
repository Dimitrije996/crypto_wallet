package com.dimicon.Dimicon_crypto_simulator.servisi;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Market;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.MarketRepozitorijum;
import org.springframework.stereotype.Service;

@Service
public class KonsolaMarket {
    private final int MARKET_ID = 1;
    private final MarketRepozitorijum marketRepozitorijum;

    public KonsolaMarket(MarketRepozitorijum marketRepozitorijum) {
        this.marketRepozitorijum = marketRepozitorijum;
    }
    public Market prikaziNovcice(){
        Market market = marketRepozitorijum.pronadjiMarketPoId(MARKET_ID);
        market.toString();
        return market;
    }
}
