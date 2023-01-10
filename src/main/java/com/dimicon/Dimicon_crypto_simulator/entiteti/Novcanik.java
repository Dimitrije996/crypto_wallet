package com.dimicon.Dimicon_crypto_simulator.entiteti;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Novcanik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private double sredstva;

    private double bitcoin;

    private double ethereum;

    private double dodge;

    private double shiba;

    @OneToOne(mappedBy = "novcanik_id", cascade = CascadeType.ALL)
    private Korisnici korisnici;

    public Novcanik(int sredstva, int bitcoin, int ethereum, int dodge, int shiba) {
        this.sredstva = sredstva;
        this.bitcoin = bitcoin;
        this.ethereum = ethereum;
        this.dodge = dodge;
        this.shiba = shiba;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Novcanik novcanik = (Novcanik) o;
        return getId() == novcanik.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
