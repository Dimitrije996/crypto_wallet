package com.dimicon.Dimicon_crypto_simulator.servisi;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Market;
import com.dimicon.Dimicon_crypto_simulator.entiteti.Novcanik;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.NovcanikRepozitorijum;
import org.springframework.stereotype.Service;


@Service
public class UpravljanjeTransakcijama {

    private final NovcanikRepozitorijum novcanikRepozitorijum;

    public UpravljanjeTransakcijama( NovcanikRepozitorijum novcanikRepozitorijum) {
        this.novcanikRepozitorijum = novcanikRepozitorijum;
    }

    public Novcanik kupiBtc(Market market, Novcanik novcanik, double iznos){

        if (iznos > novcanik.getSredstva()){
            System.out.println("Nemate dovoljno para na racunu");
        }else {
            novcanik.setSredstva(novcanik.getSredstva() - iznos);
            novcanik.setBitcoin(novcanik.getBitcoin() + (iznos / market.getBitcoin()));

            novcanikRepozitorijum.save(novcanik);
        }
        return novcanik;
    }
    public Novcanik kupiEth(Market market, Novcanik novcanik, double iznos){

        if (iznos > novcanik.getSredstva()){
            System.out.println("Nemate dovoljno para na racunu");
        }else {
            novcanik.setSredstva(novcanik.getSredstva() - iznos);
            novcanik.setEthereum(novcanik.getEthereum() + (iznos / market.getEthereum()));

            novcanikRepozitorijum.save(novcanik);
        }
        return novcanik;
    }
    public Novcanik kupiDodge(Market market, Novcanik novcanik, double iznos){

        if (iznos > novcanik.getSredstva()){
            System.out.println("Nemate dovoljno para na racunu");
        }else {
            novcanik.setSredstva(novcanik.getSredstva() - iznos);
            novcanik.setDodge(novcanik.getDodge() + (iznos / market.getDodge()));

            novcanikRepozitorijum.save(novcanik);
        }
        return novcanik;
    }
    public Novcanik kupiShibu(Market market, Novcanik novcanik, double iznos){

        if (iznos > novcanik.getSredstva()){
            System.out.println("Nemate dovoljno para na racunu");
        }else {
            novcanik.setSredstva(novcanik.getSredstva() - iznos);
            novcanik.setShiba(novcanik.getShiba() + (iznos / market.getShiba()));

            novcanikRepozitorijum.save(novcanik);
        }
        return novcanik;
    }
    public Novcanik prodajBtc(Market market, Novcanik novcanik, double iznos){

        if (iznos > novcanik.getBitcoin()){
            System.out.println("Nemate dovoljno Btc za prodati");
        }else {
            novcanik.setSredstva(novcanik.getSredstva() + (market.getBitcoin()) * iznos);
            novcanik.setBitcoin(novcanik.getBitcoin() - iznos);

            novcanikRepozitorijum.save(novcanik);
        }
        return novcanik;
    }
    public Novcanik prodajEth(Market market, Novcanik novcanik, double iznos){

        if (iznos > novcanik.getEthereum()){
            System.out.println("Nemate dovoljno Eth za prodati");
        }else {
            novcanik.setSredstva(novcanik.getSredstva() + (market.getEthereum()) * iznos);
            novcanik.setEthereum(novcanik.getEthereum() - iznos);

            novcanikRepozitorijum.save(novcanik);
        }
        return novcanik;
    }
    public Novcanik prodajDodge(Market market, Novcanik novcanik, double iznos){

        if (iznos > novcanik.getDodge()){
            System.out.println("Nemate dovoljno Dodge za prodati");
        }else {
            novcanik.setSredstva(novcanik.getSredstva() + (market.getDodge()) * iznos);
            novcanik.setDodge(novcanik.getDodge() - iznos);

            novcanikRepozitorijum.save(novcanik);
        }
        return novcanik;
    }
    public Novcanik prodajShibu(Market market, Novcanik novcanik, double iznos){

        if (iznos > novcanik.getShiba()){
            System.out.println("Nemate dovoljno Shibe za prodati");
        }else {
            novcanik.setSredstva(novcanik.getSredstva() + (market.getShiba()) * iznos);
            novcanik.setShiba(novcanik.getShiba() - iznos);

            novcanikRepozitorijum.save(novcanik);
        }
        return novcanik;
    }
}
