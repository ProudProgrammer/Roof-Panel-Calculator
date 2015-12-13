package tetofedes;

public class Lemez implements Comparable<Lemez>, Cloneable {
	
	private int szelesseg; //mm-ben
	private int hosszusag; //mm-ben
	private int db;
	
	public Lemez(double szelesseg, double hosszusag) {
		this.szelesseg = (int)(Math.ceil(szelesseg));
		this.hosszusag = (int)(Math.ceil(hosszusag));
		this.db = 1;
	}

	public int getSzelesseg() {
		return szelesseg;
	}

	public int getHosszusag() {
		return hosszusag;
	}
	
	public int getDb() {
		return db;
	}
	
	public void novelDb(int mennyivel, boolean szorzat) {
		if (szorzat)
			db = db * mennyivel;
		else
			db = db + mennyivel;
	}
	
	public float getTerulet() { //m2-ben
		return ((szelesseg/1000F) * (hosszusag/1000F) * db);
	}
	
	public String toString() {
		return "[ " + szelesseg + " mm ; " + hosszusag + " mm ; " + db + " db ]";
	}

	public int compareTo(Lemez arg0) {
		Integer a = new Integer(this.hosszusag);
		Integer b = new Integer(arg0.hosszusag);
		return a.compareTo(b);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hosszusag;
		result = prime * result + szelesseg;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lemez other = (Lemez) obj;
		if (hosszusag != other.hosszusag)
			return false;
		if (szelesseg != other.szelesseg)
			return false;
		return true;
	}
	
	public Object clone() {
		Lemez klonozott = new Lemez(this.szelesseg, this.hosszusag);
		klonozott.db = this.db;
		return klonozott;
	}
	
	
	

}
