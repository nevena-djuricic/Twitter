package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter tviter;
	private TwitterPoruka tvit;
	private LinkedList<TwitterPoruka> pomocnaLista;
	
	@Before
	public void setUp() throws Exception {
		tviter = new Twitter();
		tvit = new TwitterPoruka();
		pomocnaLista = new LinkedList<TwitterPoruka>();
	}

	@After
	public void tearDown() throws Exception {
		tviter = null;
		tvit = null;
		pomocnaLista = null;
	}

	@Test
	public void testVratiSvePorukeNull() {
		assertEquals(pomocnaLista, tviter.vratiSvePoruke());
	}
	
	public void testVratiSvePoruke1() {
		tvit.setKorisnik("Sting");
		tvit.setPoruka("Message in the bottle");
		
		tviter.unesi(tvit.getKorisnik(), tvit.getPoruka());
		pomocnaLista.addLast(tvit);
		
		assertEquals(pomocnaLista, tviter.vratiSvePoruke());
	}

	@Test
	public void testVratiSvePoruke2() {
		tvit.setKorisnik("Sting");
		tvit.setPoruka("Message in the bottle");
		
		TwitterPoruka tvit2 = new TwitterPoruka();
		tvit2.setKorisnik("Ariana Grande");
		tvit2.setPoruka("I've got one less problem without you");
		
		tviter.unesi(tvit.getKorisnik(), tvit.getPoruka());
		tviter.unesi(tvit2.getKorisnik(), tvit2.getPoruka());
		
		pomocnaLista.addLast(tvit);
		pomocnaLista.addLast(tvit2);
		
		assertEquals(pomocnaLista, tviter.vratiSvePoruke());
	}
	
	@Test
	public void testUnesi1() {
		tvit.setKorisnik("Sting");
		tvit.setPoruka("Message in the bottle");
		
		tviter.unesi(tvit.getKorisnik(), tvit.getPoruka());
		pomocnaLista.addLast(tvit);
		
		assertEquals(pomocnaLista, tviter.vratiSvePoruke());
		
		// uocena greska u metodi - kao korisnik se uvek unosi String "korisnik" umesto vrednosti ulaznog parametra korisnik
		// greska ispravljena
	}
	
	@Test
	public void testUnesi2() {
		tvit.setKorisnik("Sting");
		tvit.setPoruka("Message in the bottle");
		
		TwitterPoruka tvit2 = new TwitterPoruka();
		tvit2.setKorisnik("Ariana Grande");
		tvit2.setPoruka("I've got one less problem without you");
		
		tviter.unesi(tvit.getKorisnik(), tvit.getPoruka());
		tviter.unesi(tvit2.getKorisnik(), tvit2.getPoruka());
		
		pomocnaLista.addLast(tvit);
		pomocnaLista.addLast(tvit2);
		
		assertEquals(pomocnaLista, tviter.vratiSvePoruke());
	}
	
	@Test
	public void testVratiPoruke() {
		tvit.setKorisnik("Sting");
		tvit.setPoruka("Message in the bottle");
		
		TwitterPoruka tvit2 = new TwitterPoruka();
		tvit2.setKorisnik("Ariana Grande");
		tvit2.setPoruka("I've got one less problem without you");
		
		TwitterPoruka[] pomocniNiz = new TwitterPoruka[1];
		pomocniNiz[0] = tvit;
		tviter.unesi(tvit.getKorisnik(), tvit.getPoruka());
		tviter.unesi(tvit.getKorisnik(), tvit2.getPoruka());
		
		assertArrayEquals(pomocniNiz, tviter.vratiPoruke(1, "bottle"));
		
		// uocena greska u metodi - index je van granica zato sto se prvi elemenat u niz upisuje na mesto sa indexom 1 umesto sa 0
		// zbog [brojac+1]
		// greska ispravljena na [brojac]
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		tviter.vratiPoruke(100, null);
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagIsEmpty() {
		tviter.vratiPoruke(100, "");
	}
	
	@Test 
	public void testVratiPorukeMaxBrojNegativan() {
		tviter.vratiPoruke(-10, "hello");
	}
	
}
