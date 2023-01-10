package com.dimicon.Dimicon_crypto_simulator.entiteti;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Korisnici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(updatable = true)
    private String ime;
    @Column(updatable = true)
    private String prezime;
    @Column(updatable = true)
    private String email;
    @Column(updatable = true)
    private String sifra;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "tip_korisnika",
            joinColumns = @JoinColumn(name = "korisnik_id"),
            inverseJoinColumns = @JoinColumn(name = "tip_id"))
    private Set<Tip> tipKorisnika = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "novcanik_id", referencedColumnName = "id", updatable = true)
    private Novcanik novcanik_id;


    public Korisnici(String ime, String prezime, String email, String sifra, Set<Tip> tipKorisnika, Novcanik novcanik_id) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.sifra = sifra;
        this.tipKorisnika = tipKorisnika;
        this.novcanik_id = novcanik_id;
    }



    public Set<Tip> getTipKorisnika() {
        return tipKorisnika;
    }

    public void setTipKorisnika(Set<Tip> tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
    }

    public boolean imaTip(String imeTipa){
        Iterator<Tip> iterator = this.tipKorisnika.iterator();
        while (iterator.hasNext()){
            Tip tipKorisnika = iterator.next();
            if (tipKorisnika.getIme().equals(imeTipa)){
                return true;

            }
        }
        return false;
    }

    public void setSifra(String sifra) {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();

        this.sifra = bc.encode(sifra);
    }

    public void dodajTip(Tip tip){
        this.tipKorisnika.add(tip);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnici korisnici = (Korisnici) o;
        return getId() == korisnici.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
