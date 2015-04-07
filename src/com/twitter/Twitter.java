package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa Twitter sadrzi metode kojima unosimo novu poruku tvita u postojecu listu poruka i 
 * trazimo tvitove koji sadrze odredjeni tag.
 * 
 * @author Nevena
 *
 */
public class Twitter {

	/**
	 * Inicijalizovana lista klase TwitterPoruka koja sadrzi poruke postojecih tvitova.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	/**
	 * Metoda koja vraca sve poruke iz liste poruka.
	 * 
	 * @return sve poruke iz liste poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	
	/**
	 * Metoda koja unosi u listu novu poruku korisnika.
	 * 
	 * @param korisnik 
	 * 			korisnik koji unosi poruku
	 * @param poruka
	 * 			poruka koju je korisnik uneo
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Metoda vraca odredjeni broj poruka koje sadrze odredjeni tag.
	 * 
	 * @param maxBroj
	 * 			maksimalan broj poruka koje ce metoda vratiti kao rezultat
	 * @param tag
	 * 			tag koji treba da sadrze sve poruke koje vracamo
	 * @return trazeni broj poruka koje sadrze trazeni tag
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		
		//Pomocni niz koji predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1]=poruke.get(i);
					brojac++;
				}
				else break;
		
		return rezultat;
	}
}