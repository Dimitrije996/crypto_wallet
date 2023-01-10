package com.dimicon.Dimicon_crypto_simulator.konfiguracija;

import com.dimicon.Dimicon_crypto_simulator.repozitorijum.KorisniciRepozitorijum;
import com.dimicon.Dimicon_crypto_simulator.servisi.PronadjiKorisnika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class DozvolePristupa extends WebSecurityConfigurerAdapter {
    @Autowired
    private UspesnaRegistracija uspesnaRegistracija;
    private final KorisniciRepozitorijum korisniciRepozitorijum;
    public DozvolePristupa(UspesnaRegistracija uspesnaRegistracija, KorisniciRepozitorijum korisniciRepozitorijum){
        this.uspesnaRegistracija = uspesnaRegistracija;
        this.korisniciRepozitorijum = korisniciRepozitorijum;
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return new PronadjiKorisnika();
    }
    @Bean
    public BCryptPasswordEncoder koriptovanaSifra() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider dap() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(koriptovanaSifra());
        return authenticationProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(dap());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/adminHome/**").hasAuthority("ADMIN")
                .antMatchers("/tip/**").hasAuthority("ADMIN")
                .antMatchers("/lista/**").hasAuthority("ADMIN")
                .antMatchers("/obavestenja/**").hasAnyAuthority("ADMIN", "EDITOR")
                .antMatchers("/editorHome/**").hasAnyAuthority("ADMIN", "EDITOR")
                .antMatchers("/korisnikHome/**").hasAnyAuthority( "KORISNIK")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/perform_login")
                .usernameParameter("email")
                .passwordParameter("sifra")
                .successHandler(uspesnaRegistracija)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .logoutSuccessUrl("/").permitAll();
    }
}
