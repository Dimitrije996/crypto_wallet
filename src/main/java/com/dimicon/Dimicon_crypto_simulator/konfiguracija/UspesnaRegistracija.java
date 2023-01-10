package com.dimicon.Dimicon_crypto_simulator.konfiguracija;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class UspesnaRegistracija extends SavedRequestAwareAuthenticationSuccessHandler {

    public UspesnaRegistracija() {
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        KorisnikoviPodaci korisnikoviPodaci = (KorisnikoviPodaci) authentication.getPrincipal();

        String preusmeriURL;

        if (korisnikoviPodaci.imaTip("ADMIN")) {
            preusmeriURL = "adminHome";
        } else if (korisnikoviPodaci.imaTip("EDITOR")) {
            preusmeriURL = "editorHome";
        } else if (korisnikoviPodaci.imaTip("KORISNIK")) {
            preusmeriURL = "korisnikHome";
        } else

            preusmeriURL = "";

        response.sendRedirect(preusmeriURL);

    }
}