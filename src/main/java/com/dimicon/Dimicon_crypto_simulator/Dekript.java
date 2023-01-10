package com.dimicon.Dimicon_crypto_simulator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Dekript {

    public static void main(String[] args) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String sifra = "admin";

        System.out.println(bCryptPasswordEncoder.encode(sifra));
    }

}
