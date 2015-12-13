package tetofedes;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Tetofedes extends JFrame implements ActionListener, Printable {

	private static final long serialVersionUID = 1L;

	public static Rectangle middleFramePosition = framePosition();

	private JPanel mainPanel = new JPanel();
	private JTextArea resultsTextArea = new JTextArea();
	private String[] nyomtatando;

	private JMenuBar menuBar = new JMenuBar();
	private JMenu startMenu = new JMenu("Start");
	private JMenu ujMenu = new JMenu("�j tet�");
	private JMenu ujTetoreszMenu = new JMenu("�j tet�r�sz");
	private JMenuItem nyomtatMenuItem = new JMenuItem("Nyomtat...");
	private JMenuItem kilepMenuItem = new JMenuItem("Kil�p�s");
	private JMenuItem satorMenuItem = new JMenuItem("S�tortet�...");
	private JMenuItem nyeregMenuItem = new JMenuItem("Nyeregtet�...");
	private JMenuItem haromszogMenuItem = new JMenuItem("Tet�h�romsz�g...");
	private JMenuItem teglalapMenuItem = new JMenuItem("Tet�t�glalap...");
	private JMenu kinezetMenu = new JMenu("St�lus");
	private JMenu sugoMenu = new JMenu("S�g�");
	private JMenuItem nevjegyMenuItem = new JMenuItem("N�vjegy");
	private JRadioButtonMenuItem skin2 = new JRadioButtonMenuItem("Metal", true);
	private JRadioButtonMenuItem skin3 = new JRadioButtonMenuItem("Motif");
	private JRadioButtonMenuItem skin4 = new JRadioButtonMenuItem("Nimbus");
	private JRadioButtonMenuItem skin5 = new JRadioButtonMenuItem("Windows");
	private JRadioButtonMenuItem skin6 = new JRadioButtonMenuItem("WindowsClassic");
	private ButtonGroup kinezetGroup = new ButtonGroup();

	{
		resultsTextArea.setEditable(false);
		kinezetGroup.add(skin2);
		kinezetGroup.add(skin3);
		kinezetGroup.add(skin4);
		kinezetGroup.add(skin5);
		kinezetGroup.add(skin6);
		setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	}

	public Tetofedes() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tet�lemez kalkul�tor 1.02");
		setBounds(middleFramePosition);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(middleFramePosition.getSize());
		setResizable(true);

		setJMenuBar(menuBar);
		menuBar.add(startMenu);
		menuBar.add(kinezetMenu);
		menuBar.add(sugoMenu);
		startMenu.add(ujMenu);
		startMenu.add(ujTetoreszMenu);
		startMenu.addSeparator();
		startMenu.add(nyomtatMenuItem);
		startMenu.addSeparator();
		startMenu.add(kilepMenuItem);
		sugoMenu.add(nevjegyMenuItem);
		ujMenu.add(satorMenuItem);
		ujMenu.add(nyeregMenuItem);
		ujTetoreszMenu.add(haromszogMenuItem);
		ujTetoreszMenu.add(teglalapMenuItem);
		kinezetMenu.add(skin2);
		kinezetMenu.add(skin3);
		kinezetMenu.add(skin4);
		kinezetMenu.add(skin5);
		kinezetMenu.add(skin6);

		Container contentPane = getContentPane();
		contentPane.add(mainPanel);
		contentPane.add(new JScrollPane(resultsTextArea));

		setVisible(true);

		skin2.addActionListener(this);
		skin3.addActionListener(this);
		skin4.addActionListener(this);
		skin5.addActionListener(this);
		skin6.addActionListener(this);
		satorMenuItem.addActionListener(this);
		nyeregMenuItem.addActionListener(this);
		haromszogMenuItem.addActionListener(this);
		teglalapMenuItem.addActionListener(this);
		nyomtatMenuItem.addActionListener(this);
		kilepMenuItem.addActionListener(this);
		nevjegyMenuItem.addActionListener(this);
	}

	private static Rectangle framePosition() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int width = 0;
		int height = 0;
		if(System.getProperty("os.name").equals("Linux")) {
			width = 835;
			height = 385;
		} else {
			width = 685;
			height = 385;
		}
		int x = (screenSize.width - width) / 2;
		int y = (screenSize.height - height) / 2;
		return (new Rectangle(x, y, width, height));
	}

	public void setLookAndFeel(String lookAndFeel) {
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception ex) {
		}
	}

	public void setTextSatorteto(int oldal1, int oldal2, int tetoEl, int lemezTakaras, int lemezHasznos, int toldas, int minhossz, boolean kotegEgyben) {
		TreeSet<Lemez> lemezek = new TreeSet<Lemez>();
		Iterator<Lemez> iter;
		int szuksegesLemezek = 0;
		float terulet = 0;
		String szoveg = "A tet� adatai:\n\tT�pusa: s�tortet�\n\tEgyik oldal hossza: "
				+ oldal1 + " mm\n\tM�sik oldal hossza: ";
		if (oldal2 == 0)
			szoveg += oldal1;
		else
			szoveg += oldal2;
		szoveg += " mm\n\tTet��l hossza: " + tetoEl + " mm\n\tLemezek teljes sz�less�ge: "
				+ lemezTakaras + " mm\n\tLemezek hasznos takar�sa: "
				+ lemezHasznos + " mm\n\tTold�s m�rt�ke: ";
		if (toldas == 0)
			szoveg += "nincs told�s";
		else
			szoveg += toldas + " mm";
		szoveg += " \n\tMinim�lis lemezhossz�s�g: ";
		if (minhossz == 0)
			szoveg += "nincs megadva";
		else
			szoveg += minhossz + " mm";
		resultsTextArea.setText(szoveg);
		resultsTextArea.append("\n\nA sz�ks�ges lemezek adatai:\n\tA sz�ks�ges lemezek sz�ma: ");
		HaromszogOldal egyik = new HaromszogOldal(oldal1, tetoEl, tetoEl, lemezTakaras, lemezHasznos, toldas, minhossz);
		lemezek.addAll(egyik.getLemezek());
		if (oldal2 == 0 || oldal1 == oldal2) { 									//ha egyenl� oldal� a tet�
			iter = lemezek.iterator();
			while (iter.hasNext()) {
				Lemez lemez = iter.next();
				lemez.novelDb(4, true);											//4-szeres db mennyis�g hiszen 4 egyenl� oldal
				szuksegesLemezek += lemez.getDb();
				terulet += lemez.getTerulet();
			}
			resultsTextArea.append(szuksegesLemezek + " db (" + lemezek.size()
					+ " k�l�nb�z� m�retben)\n\tA lemezek �sszter�lete: "
					+ terulet + " m2\n\tLemezek t�telesen:");
			if(kotegEgyben) {
				iter = lemezek.iterator();
				while(iter.hasNext())
					resultsTextArea.append("\n\t\t" + iter.next());
			} else {
				for(int i = 0; i < 4; i++) {
					iter = egyik.getLemezek().iterator();
					resultsTextArea.append("\n\t Oldal " + (i+1) + " lemezei:");
					while(iter.hasNext())
						resultsTextArea.append("\n\t\t" + iter.next());
				}
			}
		} else { 																//ha nem egyenl� oldal� a tet�
			HaromszogOldal masik = new HaromszogOldal(oldal2, tetoEl, tetoEl, lemezTakaras, lemezHasznos, toldas, minhossz);
			iter = lemezek.iterator();
			while(iter.hasNext()) {
				Lemez regi = iter.next();
				regi.novelDb(2, true);											//2-szeres db menyis�g mert 2 egyenl� oldal
			}
			Iterator<Lemez> iterMasik = masik.getLemezek().iterator();
			while(iterMasik.hasNext()) {
				Lemez uj = iterMasik.next();
				uj.novelDb(2, true);											//2-szeres db menyis�g mert 2 egyenl� oldal
				if(!lemezek.add(uj)) {
					while (iter.hasNext()) {
						Lemez regi = iter.next();
						if(regi.equals(uj))
							regi.novelDb(uj.getDb(), false);
					}
				}
			}
			iter = lemezek.iterator();
			while(iter.hasNext()) {
				Lemez lemez = iter.next();
				szuksegesLemezek += lemez.getDb();
				terulet += lemez.getTerulet();
			}
			resultsTextArea.append(szuksegesLemezek + " db (" + lemezek.size()
					+ " k�l�nb�z� m�retben)\n\tA lemezek �sszter�lete: "
					+ terulet + " m2\n\tLemezek t�telesen:");
			if(kotegEgyben) {
				iter = lemezek.iterator();
				while(iter.hasNext())
					resultsTextArea.append("\n\t\t" + iter.next());
			} else {
				for(int i = 0; i < 2; i++) {
					iter = egyik.getLemezek().iterator();
					resultsTextArea.append("\n\t Oldal " + (i+1) + " (" + oldal1 + " mm) lemezei:");
					while(iter.hasNext())
						resultsTextArea.append("\n\t\t" + iter.next());
				}
				for(int i = 2; i <4; i++) {
					iter = masik.getLemezek().iterator();
					resultsTextArea.append("\n\t Oldal " + (i+1) + " (" + oldal2 + " mm) lemezei:");
					while(iter.hasNext())
						resultsTextArea.append("\n\t\t" + iter.next());
				}
			}
		}
	}
	
	public void setTextTetoHaromszog(int alap, int szar1, int szar2, int lemezTakaras, int lemezHasznos, int toldas, int minhossz) {
		HaromszogOldal oldal = new HaromszogOldal(alap, szar1, szar2, lemezTakaras, lemezHasznos, toldas, minhossz);
		Iterator<Lemez> iter;
		int szuksegesLemezek = 0;
		float terulet = 0;
		String szoveg = "A tet�r�sz adatai:\n\tT�pusa: tet�h�romsz�g\n\tEgyik sz�r hossza: "
				+ szar1 + " mm\n\tM�sik sz�r hossza: " + szar2 + " mm\n\tAlap hossza: " + alap + " mm\n\tLemezek teljes sz�less�ge: "
				+ lemezTakaras + " mm\n\tLemezek hasznos takar�sa: " + lemezHasznos + " mm\n\tTold�s m�rt�ke: ";
		if (toldas == 0)
			szoveg += "nincs told�s";
		else
			szoveg += toldas + " mm";
		szoveg += " \n\tMinim�lis lemezhossz�s�g: ";
		if (minhossz == 0)
			szoveg += "nincs megadva";
		else
			szoveg += minhossz + " mm";
		resultsTextArea.setText(szoveg);
		resultsTextArea.append("\n\nA sz�ks�ges lemezek adatai:\n\tA sz�ks�ges lemezek sz�ma: ");
		iter = oldal.getLemezek().iterator();
		while(iter.hasNext()) {
			Lemez lemez = iter.next();														
			szuksegesLemezek += lemez.getDb();
			terulet += lemez.getTerulet();
		}
		resultsTextArea.append(szuksegesLemezek + " db (" + oldal.getLemezek().size() + " k�l�nb�z� m�retben)\n\tA lemezek �sszter�lete: "
				+ terulet + " m2\n\tLemezek t�telesen:");
		iter = oldal.getLemezek().iterator();
		while(iter.hasNext()) {
			resultsTextArea.append("\n\t\t" + iter.next());
		}
	}
	
	public void setTextNyeregteto(int tetoHossz, int tetoElHossz, int tetoElMasikHossz, int lemezSzelesseg, int lemezHasznos, int toldas, int minHossz) {
		String szoveg = "A tet� adatai:\n\tT�pusa: Nyeregtet�\n\tTet� hossza: "
			+ tetoHossz + " mm\n\tEgyik tet��l hossza: " + tetoElHossz + " mm\n\tM�sik tet��l hossza: " + tetoElMasikHossz + " mm\n\tLemezek teljes sz�less�ge: "
			+ lemezSzelesseg + " mm\n\tLemezek hasznos takar�sa: " + lemezHasznos + " mm\n\tTold�s m�rt�ke: ";
		if (toldas == 0)
			szoveg += "nincs told�s";
		else
			szoveg += toldas + " mm";
		szoveg += " \n\tMinim�lis lemezhossz�s�g: ";
		if (minHossz == 0)
			szoveg += "nincs megadva";
		else
			szoveg += minHossz + " mm";
		szoveg += "\n\nA sz�ks�ges lemezek adatai:\n\tA sz�ks�ges lemezek sz�ma: ";
		resultsTextArea.setText(szoveg);
		TeglalapOldal teglalap1 = new TeglalapOldal(tetoHossz, tetoElHossz, lemezSzelesseg, lemezHasznos, toldas, minHossz);
		if(tetoElHossz == tetoElMasikHossz) {									//ha a k�t tet��l azonos hossz�s�g�
			Lemez lemez = teglalap1.getLemez();
			lemez.novelDb(2, true);
			resultsTextArea.append("" + lemez.getDb() + " db\n\tA lemezek �sszter�lete: " + lemez.getTerulet() 
					+ " m2\n\tLemezek t�telesen:\n\t\t" + lemez.toString());
		} else {																//ha a k�t tet��l nem azonos hossz�s�g�
			TeglalapOldal teglalap2 = new TeglalapOldal(tetoHossz, tetoElMasikHossz, lemezSzelesseg, lemezHasznos, toldas, minHossz);
			Lemez lemez1 = teglalap1.getLemez();
			Lemez lemez2 = teglalap2.getLemez();
			resultsTextArea.append("" + (lemez1.getDb() + lemez2.getDb()) + " db\n\tA lemezek �sszter�lete: " 
					+ (lemez1.getTerulet() + lemez2.getTerulet()) + " m2\n\tLemezek t�telesen:\n\t\t" 
					+ lemez1.toString() + "\n\t\t" + lemez2.toString());
		}
			
	}
	
	public void setTextTetoTeglalap(int tetoHossz, int tetoElHossz, int lemezSzelesseg, int lemezHasznos, int toldas, int minHossz) {
		TeglalapOldal teglalap = new TeglalapOldal(tetoHossz, tetoElHossz, lemezSzelesseg, lemezHasznos, toldas, minHossz);
		String szoveg = "A tet�r�sz adatai:\n\tT�pusa: Tet�t�glalap\n\tTet� hossza: "
			+ tetoHossz + " mm\n\tTet��l hossza: " + tetoElHossz + " mm\n\tLemezek teljes sz�less�ge: "
			+ lemezSzelesseg + " mm\n\tLemezek hasznos takar�sa: " + lemezHasznos + " mm\n\tTold�s m�rt�ke: ";
		if (toldas == 0)
			szoveg += "nincs told�s";
		else
			szoveg += toldas + " mm";
		szoveg += " \n\tMinim�lis lemezhossz�s�g: ";
		if (minHossz == 0)
			szoveg += "nincs megadva";
		else
			szoveg += minHossz + " mm";
		szoveg += "\n\nA sz�ks�ges lemezek adatai:\n\tA sz�ks�ges lemezek sz�ma: " + teglalap.getLemez().getDb() 
			+ " db\n\tA lemezek �sszter�lete: " + teglalap.getLemez().getTerulet() + " m2\n\tLemezek t�telesen:\n\t\t"
			+ teglalap.getLemez().toString();
		resultsTextArea.setText(szoveg);
	}

	public int print(Graphics gr, PageFormat pf, int pageIndex) throws PrinterException {
		if(pageIndex > nyomtatando.length/40)
			return NO_SUCH_PAGE;
		int x = 90;
		int y = 90;
		try {
			for(int i = pageIndex * 40; i < pageIndex * 40 + 40; i++) {
				gr.drawString(nyomtatando[i], x, y);
				y += 17;
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			return PAGE_EXISTS;
		}
		return PAGE_EXISTS;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == satorMenuItem) {							//nem lehet �jat nyitni m�g az el�z� nincs bez�rva
			if (SatortetoDialog.getLetezikE() || TetoHaromszogDialog.getLetezikE() || NyeregtetoDialog.getLetezikE() || TetoTeglalapDialog.getLetezikE()) {
				JOptionPane.showMessageDialog(this, "M�r nyitva van egy be�ll�t�sok dial�gus!\n�j dial�gus nyit�s�hoz be kell z�rni az el�z�t!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			} else
				new SatortetoDialog(this);
				return;
		}
		if (e.getSource() == nyeregMenuItem) {							//nem lehet �jat nyitni m�g az el�z� nincs bez�rva
			if (SatortetoDialog.getLetezikE() || TetoHaromszogDialog.getLetezikE() || NyeregtetoDialog.getLetezikE() || TetoTeglalapDialog.getLetezikE()) {
				JOptionPane.showMessageDialog(this, "M�r nyitva van egy be�ll�t�sok dial�gus!\n�j dial�gus nyit�s�hoz be kell z�rni az el�z�t!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			} else
				new NyeregtetoDialog(this);
				return;
		}
		if (e.getSource() == haromszogMenuItem) {						//nem lehet �jat nyitni m�g az el�z� nincs bez�rva
			if (SatortetoDialog.getLetezikE() || TetoHaromszogDialog.getLetezikE() || NyeregtetoDialog.getLetezikE() || TetoTeglalapDialog.getLetezikE()) {
				JOptionPane.showMessageDialog(this, "M�r nyitva van egy be�ll�t�sok dial�gus!\n�j dial�gus nyit�s�hoz be kell z�rni az el�z�t!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			} else
				new TetoHaromszogDialog(this);
				return;
		}
		if (e.getSource() == teglalapMenuItem) {						//nem lehet �jat nyitni m�g az el�z� nincs bez�rva
			if (SatortetoDialog.getLetezikE() || TetoHaromszogDialog.getLetezikE() || NyeregtetoDialog.getLetezikE() || TetoTeglalapDialog.getLetezikE()) {
				JOptionPane.showMessageDialog(this, "M�r nyitva van egy be�ll�t�sok dial�gus!\n�j dial�gus nyit�s�hoz be kell z�rni az el�z�t!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			} else
				new TetoTeglalapDialog(this);
				return;
		}
		if (e.getSource() == nyomtatMenuItem) {
			if(resultsTextArea.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Nincs mit kinyomtatni!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			PrinterJob nyomtato = PrinterJob.getPrinterJob();
			nyomtato.setPrintable(this);
			StringTokenizer st = new StringTokenizer(resultsTextArea.getText(), "\n");
			nyomtatando = new String[st.countTokens()];
			for(int i = 0; i < nyomtatando.length; i++)
				nyomtatando[i] = st.nextToken();
			if(nyomtato.printDialog()) {
				try {
					nyomtato.print();
				} catch (PrinterException e1) {
					JOptionPane.showMessageDialog(this, "Nyomtat�si hiba!", "Hiba", JOptionPane.ERROR_MESSAGE);
				}
			}
			return;
		}
		if (e.getSource() == kilepMenuItem)
			System.exit(EXIT_ON_CLOSE);
		if (e.getSource() == skin2) {
			setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			return;
		}
		if (e.getSource() == skin3) {
			setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			return;
		}
		if (e.getSource() == skin4) {
			setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			return;
		}
		if (e.getSource() == skin5) {
			setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			return;
		}
		if (e.getSource() == skin6) {
			setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
			return;
		}
		if (e.getSource() == nevjegyMenuItem) {
			new NevjegyDialog(this);
			return;
		}
	}

	public static void main(String[] args) {
		new Tetofedes();
	}

}
