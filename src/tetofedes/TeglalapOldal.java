package tetofedes;

public class TeglalapOldal {

	private long tetoHossz;
	private long tetoElHossz;
	private long lemezSzelesseg;
	private long lemezHasznos;
	
	private int lemezDb;
	private Lemez lemez;

	public TeglalapOldal(long tetoHossz, long tetoElHossz, long lemezSzelesseg, long lemezHasznos, long toldas, long minHossz) {
		this.tetoHossz = tetoHossz;
		this.tetoElHossz = tetoElHossz + toldas;
		if(minHossz > this.tetoElHossz)
			this.tetoElHossz = minHossz;
		this.lemezSzelesseg = lemezSzelesseg;
		this.lemezHasznos = lemezHasznos;
		
		lemezDb = lemezDbSzamol();
		lemez = lemezKeszitese();
	}
	
	private int lemezDbSzamol() {
		return (int)Math.ceil((double)tetoHossz/lemezHasznos);
	}
	
	private Lemez lemezKeszitese() {
		Lemez lemez = new Lemez(lemezSzelesseg, tetoElHossz);
		lemez.novelDb(lemezDb, true);
		return lemez;
	}
	
	public Lemez getLemez() {
		return (Lemez)lemez.clone();
	}
	
}