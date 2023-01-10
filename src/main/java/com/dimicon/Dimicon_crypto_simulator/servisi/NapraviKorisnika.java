package com.dimicon.Dimicon_crypto_simulator.servisi;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Korisnici;
import com.dimicon.Dimicon_crypto_simulator.entiteti.Novcanik;
import com.dimicon.Dimicon_crypto_simulator.entiteti.Tip;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.KorisniciRepozitorijum;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.NovcanikRepozitorijum;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.TipRepozitorijum;
import org.springframework.stereotype.Service;
@Service
public class NapraviKorisnika {
    private final int POCETNA_SREDSTVA = 150;
    private final int POCETNA_SREDSTVA_ADMINA = 80000;
    private final int POCETNA_VREDNOST_NOVCICA = 0;
    private final int TIP_ADMIN_ID = 1;
    private final int TIP_EDITOR_ID = 2;
    private final int TIP_KORISNIK_ID = 3;
    private final KorisniciRepozitorijum korisniciRepozitorijum;
    private final TipRepozitorijum tipRepository;
   private final NovcanikRepozitorijum novcanikRepository;
    public NapraviKorisnika(KorisniciRepozitorijum korisniciRepozitorijum, TipRepozitorijum tipRepository, NovcanikRepozitorijum novcanikRepository) {
        this.korisniciRepozitorijum = korisniciRepozitorijum;
        this.tipRepository = tipRepository;
        this.novcanikRepository = novcanikRepository;
    }
    //Pri prvom pokretanju pravi se admin sa svim privilegijama
    public boolean napraviAdmina(){
        Korisnici postojeciKorisnik = korisniciRepozitorijum.pronadjiKorisnikaPoEmail("admin@gmail.com");
       Korisnici korisnik = new Korisnici();
        if (postojeciKorisnik == null){
            Novcanik novcanik = new Novcanik();
            novcanik.setSredstva(POCETNA_SREDSTVA_ADMINA);
            novcanik.setBitcoin(POCETNA_VREDNOST_NOVCICA);
            novcanik.setEthereum(POCETNA_VREDNOST_NOVCICA);
            novcanik.setDodge(POCETNA_VREDNOST_NOVCICA);
            novcanik.setShiba(POCETNA_VREDNOST_NOVCICA);
            korisnik.setIme("admin");
            korisnik.setPrezime("admin");
            korisnik.setEmail("admin@gmail.com");
            korisnik.setSifra("admin");
            korisnik.setNovcanik_id(novcanik);
            Tip tipKorisnikID = tipRepository.pronadjiTipPoID(TIP_KORISNIK_ID);
            korisnik.dodajTip(tipKorisnikID);
            Tip tipEditorID = tipRepository.pronadjiTipPoID(TIP_EDITOR_ID);
            korisnik.dodajTip(tipEditorID);
            Tip tipAdminID = tipRepository.pronadjiTipPoID(TIP_ADMIN_ID);
            korisnik.dodajTip(tipAdminID);
            novcanikRepository.save(novcanik);
            korisniciRepozitorijum.save(korisnik);
            return true;
        }return  false;
    }
    public boolean napraviKorisnika(Korisnici korisnik, String ime, String prezime, String email, String sifra, Novcanik novcanik){
        Korisnici postojeciKorisnik = korisniciRepozitorijum.pronadjiKorisnikaPoEmail(email);
        if (postojeciKorisnik == null){
            novcanik.setSredstva(POCETNA_SREDSTVA);
            novcanik.setBitcoin(POCETNA_VREDNOST_NOVCICA);
            novcanik.setEthereum(POCETNA_VREDNOST_NOVCICA);
            novcanik.setDodge(POCETNA_VREDNOST_NOVCICA);
            novcanik.setShiba(POCETNA_VREDNOST_NOVCICA);
            korisnik.setIme(ime);
            korisnik.setPrezime(prezime);
            korisnik.setEmail(email);
            korisnik.setSifra(sifra);
            korisnik.setNovcanik_id(novcanik);
            Tip tipKorisnikID = tipRepository.pronadjiTipPoID(TIP_KORISNIK_ID);
            korisnik.dodajTip(tipKorisnikID);
            novcanikRepository.save(novcanik);
            korisniciRepozitorijum.save(korisnik);  return true;
        }
        return false;
    }
    public boolean izmeniKorisnika(long id, String ime, String prezime, String email){
        Korisnici postojeciKorisnik = korisniciRepozitorijum.pronadjiKorisnikaPoId(id);
                String staroIme = postojeciKorisnik.getIme();
        String staroPrezime = postojeciKorisnik.getPrezime();
        String stariEmail = postojeciKorisnik.getEmail();
        if (postojeciKorisnik != null){
            if (ime.equals("")) {
                ime = staroIme;
            }
            korisniciRepozitorijum.izmeniIme(id, ime);
         if (prezime.equals("")){
                prezime = staroPrezime;
            }
         korisniciRepozitorijum.izmeniPrezime(id, prezime);
         if (email.equals("")){
                email = stariEmail;
            }
         korisniciRepozitorijum.izmeniEmail(id, email);
            return true;
        } return false;
    }
    private boolean izbrisiKorisnika(Long id){
        Korisnici korisnik = korisniciRepozitorijum.pronadjiKorisnikaPoId(id);
        Novcanik novcanik = novcanikRepository.pronadjiNovcanikPoId(id);
        if (korisnik != null && novcanik != null){
            korisniciRepozitorijum.delete(korisnik);
            novcanikRepository.delete(novcanik);
            return true;
        }
        return false;
    }
   //Ukoliko korisnik sa admin privilegijom koji pokusa da izbrise samog sebe metoda se necec izvrsiti
    public boolean proveraDaLiSeBriseTrenutniKorisnik(long ulogovanKorisnikId, long idZaBrisanje){
        if (ulogovanKorisnikId != idZaBrisanje){
            izbrisiKorisnika(idZaBrisanje);
            return true;
        }
        return false;
    }
}
