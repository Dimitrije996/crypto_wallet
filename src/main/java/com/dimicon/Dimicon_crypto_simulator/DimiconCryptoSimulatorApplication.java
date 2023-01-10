package com.dimicon.Dimicon_crypto_simulator;

import com.dimicon.Dimicon_crypto_simulator.entiteti.Market;
import com.dimicon.Dimicon_crypto_simulator.repozitorijum.MarketRepozitorijum;
import com.dimicon.Dimicon_crypto_simulator.servisi.KonsolaMarket;
import com.dimicon.Dimicon_crypto_simulator.servisi.NapraviKorisnika;
import com.dimicon.Dimicon_crypto_simulator.servisi.NapraviMarket;
import com.dimicon.Dimicon_crypto_simulator.servisi.NapraviTipove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class DimiconCryptoSimulatorApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(DimiconCryptoSimulatorApplication.class, args);
	}
	@Autowired
	private KonsolaMarket consolaMarket;
	@Autowired
	private NapraviMarket napraviMarket;

	@Autowired
	private NapraviKorisnika napraviKorisnika;

	@Autowired
	private NapraviTipove napraviTipove;
	private final MarketRepozitorijum marketRepozitorijum;

	public DimiconCryptoSimulatorApplication(MarketRepozitorijum marketRepozitorijum) {
		this.marketRepozitorijum = marketRepozitorijum;

	}

	@Override
	public void run(String... args) throws Exception {


			napraviTipove.napraviTipove();
			napraviKorisnika.napraviAdmina();
			napraviMarket.napraviMarket();


				Market market = consolaMarket.prikaziNovcice();
		int counter = 0;


		for (;;){
			counter++;
			market.setBitcoin( (Math.random() * 80000) + 1);
			market.setEthereum( (Math.random() * 3500) + 1);
			market.setDodge( (Math.random() * 10) + 1);
			market.setShiba( (Math.random() * 5) + 1);

			marketRepozitorijum.save(market);
			market.prikaziVrednostNovcica();
			System.out.println("Counter: " + counter);
			try {

				Thread.sleep(15000);

			}catch (ArithmeticException e){
				e.printStackTrace();
			}
		}
	}
}
