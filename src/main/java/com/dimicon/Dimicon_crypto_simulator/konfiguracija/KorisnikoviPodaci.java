package com.dimicon.Dimicon_crypto_simulator.konfiguracija;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Korisnici;
import com.dimicon.Dimicon_crypto_simulator.entiteti.Novcanik;
import com.dimicon.Dimicon_crypto_simulator.entiteti.Tip;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class KorisnikoviPodaci implements UserDetails {

    private Korisnici korisnik;
    public KorisnikoviPodaci(Korisnici korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Tip> tipKorisnika = korisnik.getTipKorisnika();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Tip tipKorisnikas: tipKorisnika){
            authorities.add(new SimpleGrantedAuthority(tipKorisnikas.getIme()));
        }

        return authorities;
    }


    public Long getId(){
        return this.korisnik.getId();
    }

    @Override
    public String getPassword() {
        return this.korisnik.getSifra();
    }

    @Override
    public String getUsername() {
        return this.korisnik.getIme();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean imaTip (String imeTipa){

        return this.korisnik.imaTip(imeTipa);
    }

    public String getEmail(){
        return this.korisnik.getEmail();
    }

    public Novcanik getNovcanikId(){
       return this.korisnik.getNovcanik_id();
    }
}
