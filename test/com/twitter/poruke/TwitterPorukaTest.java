package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {

	private TwitterPoruka tvit;
	
	@Before
	public void setUp() throws Exception {
		tvit = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tvit = null;
	}

	@Test
	public void testSetKorisnik() {
		tvit.setKorisnik("Mika");
		
		assertEquals("Mika", tvit.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tvit.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmptyString() {
		tvit.setKorisnik("");
	}

	@Test
	public void testSetPoruka() {
		tvit.setPoruka("Danas je lep dan");
		
		assertEquals("Danas je lep dan", tvit.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tvit.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaLength() {
		tvit.setPoruka("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Morbi ex ante, consectetur non nunc ut, porttitor aliquam odio. "
				+ "Vestibulum in velit vel tellus vehicula aliquam vel sed enim. "
				+ "Ut et maximus metus. Curabitur sed imperdiet nisl. Nulla facilisi.");
	}

	@Test
	public void testToString() {
		tvit.setKorisnik("Vlada");
		tvit.setPoruka("Sto je danas lep i suncan dan");
		
		assertEquals("KORISNIK:" + "Vlada" + " PORUKA:" + "Sto je danas lep i suncan dan", tvit.toString());
	}

}
