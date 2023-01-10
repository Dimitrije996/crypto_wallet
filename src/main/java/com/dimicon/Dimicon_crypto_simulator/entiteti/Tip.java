package com.dimicon.Dimicon_crypto_simulator.entiteti;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Tip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ime;
    @ManyToMany(mappedBy = "tipKorisnika", cascade = CascadeType.ALL)
    private Set<Korisnici> korisniciSet = new HashSet<>();
    public Tip(String ime, Set<Korisnici> korisniciSet) {
        this.ime = ime;
        this.korisniciSet = korisniciSet;
    }
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tip tip = (Tip) o;

        return getId() == tip.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return ime;
    }
}
