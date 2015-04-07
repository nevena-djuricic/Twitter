package com.twitter.poruke;

/**
 * Klasa TwitterPoruka je klasa sa get i set i toString metodama za svoje atribute.
 * 
 * @author Nevena
 *
 */
public class TwitterPoruka {

	/**
	 * Atribut korisnik je tipa String i govori nam ko postavlja poruku tvita.
	 */
	private String korisnik;
	
	/**
	 * Atribut poruka je tipa String i sadrzi poruku tvita koji korsnik postavlja.
	 */
	private String poruka;

	/**
	 * Metoda koja vraca naziv korisnika.
	 * 
	 * @return naziv korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda koja postavlja naziv korisnika na vrednost unetu kao ulazni parametar.
	 * Metoda sadrzi logicku kontrolu unetog parametra koji:
	 * 		<ul>
	 * 			<li> korisnik ne sme biti null;
	 * 			<li> korisnik ne sme biti prazan String.
	 * 		</ul>
	 * 
	 * @param korisnik
	 * 				naziv korisnika koji postavlja tvit
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.equals(""))
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda koja vraca poruku tvita.
	 * 
	 * @return poruka tvita
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * Metoda koja postavlja poruku tvita na vrednost unetog ulaznog parametra.
	 * Metoda sadrzi logicku kontrolu unetog parametra koji.
	 * 		<ul>
	 * 			<li> poruka ne sme biti null;
	 * 			<li> duzina poruke ne sme biti veca od 140 karaktera.
	 * 		</ul>
	 * 
	 * @param poruka
	 * 				tekst poruke tvita koji zelimo da unesemo
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Metoda koja vraca String sa svim parametrima klase.
	 */
	public String toString(){
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
	
}