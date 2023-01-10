package com.dimicon.Dimicon_crypto_simulator.entiteti;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double bitcoin;
    private double dodge;
    private double ethereum;
    private double shiba;


    public Market(int bitcoin, int dodge, int ethereum, int shiba) {
        this.bitcoin = bitcoin;
        this.dodge = dodge;
        this.ethereum = ethereum;
        this.shiba = shiba;
    }

    public double getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(double bitcoin) {
        this.bitcoin = bitcoin;
    }

    public double getDodge() {
        return dodge;
    }

    public void setDodge(double dodge) {
        this.dodge = dodge;
    }

    public double getEthereum() {
        return ethereum;
    }

    public void setEthereum(double ethereum) {
        this.ethereum = ethereum;
    }

    public double getShiba() {
        return shiba;
    }

    public void setShiba(double shiba) {
        this.shiba = shiba;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Market{" +
                "bitcoin= " +  bitcoin + "%.7" + "/n"+
                ", dodge=" + dodge +
                ", ethereum=" + ethereum +
                ", shiba=" + shiba +
                '}';
    }

    public void prikaziVrednostNovcica() {

        System.out.println();
        System.out.println("*--------------------------------*");
        System.out.println("| BTC ima vrednost: " + bitcoin + "$");
        System.out.println("| ETH ima vrednost: " + ethereum + "$");
        System.out.println("| Dodge ima vrednost: " + dodge + "$");
        System.out.println("| Shiba ima vrednost: " + shiba + "$");
        System.out.println("*--------------------------------*");
    }
}
