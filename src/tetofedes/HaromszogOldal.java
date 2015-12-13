package tetofedes;

import java.util.TreeSet;
import java.util.Iterator;

public class HaromszogOldal {

	private double alap;
	private double szar1;
	private double szar2;
	private double lemezTakaras;
	private double lemezHasznos; 
	private int toldas; 
	private int minhossz; 
	private double magassagpont;
	private double magassag;
	private int lemezDb;
	private double szogSzar1;
	private double szogSzar2;
	private TreeSet<Lemez> lemezek = new TreeSet<Lemez>();

	public HaromszogOldal(double alap, double szar1, double szar2, double lemezTakaras, double lemezHasznos, int toldas, int minhossz) {
		this.alap = alap;
		this.szar1 = szar1;
		this.szar2 = szar2;
		this.lemezTakaras = lemezTakaras;
		this.lemezHasznos = lemezHasznos;
		this.toldas = toldas;
		this.minhossz = minhossz;
		magassagpont = magassagpontSzamol();
		magassag = magassagSzamol();
		lemezDb = lemezDbSzamol();
		szogSzar1 = szogSzar1Szamol();
		szogSzar2 = szogSzar2Szamol();
		lemezekKeszitese();
	}

	public int getLemezDb() {
		return lemezDb;
	}

	public TreeSet<Lemez> getLemezek() {
		TreeSet<Lemez> atad = new TreeSet<Lemez>();
		Iterator<Lemez> iter = lemezek.iterator();
		while(iter.hasNext()) {
			Lemez berak = iter.next();
			atad.add((Lemez)berak.clone());
		}
		return atad;
	}

	private double magassagpontSzamol() {
		if(szar1 == szar2)
			return alap / 2;
		return (Math.pow(alap, 2) - Math.pow(szar2, 2) + Math.pow(szar1, 2)) / (2 * alap);
	}
	
	private double magassagSzamol() {
		return Math.sqrt(Math.pow(szar1, 2) - Math.pow(magassagpont, 2));
	}

	private int lemezDbSzamol() {
		return (int) Math.ceil(alap / lemezHasznos);
	}

	// radiánban adja vissza az alap és oldal közrezárt szögét
	private double szogSzar1Szamol() {
		return Math.acos(magassagpont / szar1);
	}
	
	private double szogSzar2Szamol() {
		if(szar1 == szar2)
			return szogSzar1;
		return Math.acos(((Math.pow(alap, 2) + Math.pow(szar2, 2) - Math.pow(szar1, 2)) / (2 * alap)) / szar2);
	}

	private void lemezekKeszitese() {
		Lemez uj;
		Iterator<Lemez> iter;
		double pont = 0;
		double fixOldal = Math.tan(szogSzar1) * lemezHasznos;
		double lemezMagassag = fixOldal;
		while (pont <= (magassagpont - lemezHasznos)) {
			if (lemezMagassag + toldas < minhossz)
				uj = new Lemez(lemezTakaras, minhossz);
			else
				uj = new Lemez(lemezTakaras, lemezMagassag + toldas);
			if (!lemezek.add(uj)) {
				iter = lemezek.iterator();
				while (iter.hasNext()) {
					Lemez kovetkezo = iter.next();
					if (kovetkezo.equals(uj))
						kovetkezo.novelDb(1, false);
				}
			}
			pont += lemezHasznos;
			lemezMagassag += fixOldal;
		}
		if (magassag + toldas < minhossz)
			uj = new Lemez(lemezTakaras, minhossz);
		else
			uj = new Lemez(lemezTakaras, magassag + toldas);
		if (!lemezek.add(uj)) {
			iter = lemezek.iterator();
			while (iter.hasNext()) {
				Lemez kovetkezo = iter.next();
				if (kovetkezo.equals(uj))
					kovetkezo.novelDb(1, false);
			}
		}
		pont += lemezHasznos;
		lemezMagassag = Math.tan(szogSzar2) * (alap - pont);
		fixOldal = Math.tan(szogSzar2) * lemezHasznos;
		while (pont < alap) {
			if (lemezMagassag + toldas < minhossz)
				uj = new Lemez(lemezTakaras, minhossz);
			else
				uj = new Lemez(lemezTakaras, lemezMagassag + toldas);
			if (!lemezek.add(uj)) {
				iter = lemezek.iterator();
				while (iter.hasNext()) {
					Lemez kovetkezo = iter.next();
					if (kovetkezo.equals(uj))
						kovetkezo.novelDb(1, false);
				}
			}
			pont += lemezHasznos;
			lemezMagassag -= fixOldal;
		}
	}

	public String toString() {
		return lemezek.toString();
	}

}