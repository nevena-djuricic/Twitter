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
	 * @throws java.lang.RuntimeException 
	 * 				ako je uneti naziv korisnika null ili prazan String
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
	 * @throws java.lang.RuntimeException 
	 * 				ako je uneta poruka null ili String koji ima vise od 140 karaktera
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 karaktera");
		this.poruka = poruka;
	}
	
	/**
	 * Metoda koja vraca String sa svim parametrima klase.
	 */
	public String toString(){
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof TwitterPoruka) {
			TwitterPoruka tp = (TwitterPoruka) (o);
			
			if (korisnik.equals(tp.getKorisnik()) && poruka.equals(tp.getPoruka()))
				return true;
		}
		return false;
	}
	
}