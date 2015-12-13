package tetofedes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SatortetoDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	Tetofedes tulaj;
	
	private static boolean letezikE = false;
	
	private JPanel mainPanel = new JPanel();
	private JPanel settings1Panel = new JPanel();
	private JPanel settings2Panel = new JPanel();
	private JPanel megsemOkPanel = new JPanel();
	
	private OnlyNumberTextField oldal1TF = new OnlyNumberTextField(9);
	private OnlyNumberTextField oldal2TF = new OnlyNumberTextField(9);
	private OnlyNumberTextField tetoElTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField lemezTakarasTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField lemezHasznosTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField toldasTF = new OnlyNumberTextField(9);
	private OnlyNumberTextField minhosszTF = new OnlyNumberTextField(9);
	
	private JRadioButton nemAzonosRB = new JRadioButton("Oldalai nem azonosak", true);
	private JRadioButton azonosRB = new JRadioButton("Oldalai azonosak", false);
	private ButtonGroup szabalyosBG = new ButtonGroup();
	
	private JRadioButton toldasIgenRB = new JRadioButton("Legyen toldás", true);
	private JRadioButton toldasNemRB = new JRadioButton("Ne legyen toldás", false);
	private ButtonGroup toldasBG = new ButtonGroup();
	
	private JRadioButton minhosszIgenRB = new JRadioButton("Be kell állítani", true);
	private JRadioButton minhosszNemRB = new JRadioButton("Nem kell beállítani", false);
	private ButtonGroup minhosszBG = new ButtonGroup();
	
	private JRadioButton kotegEgybenRB = new JRadioButton("Egyben az egész", true);
	private JRadioButton kotegKulonRB = new JRadioButton("Oldalanként külön", false);
	private ButtonGroup kotegBG = new ButtonGroup();
	
	private JButton megsemButton = new JButton("Mégsem");
	private JButton okButton = new JButton("Ok");
	
	{
		szabalyosBG.add(nemAzonosRB);
		szabalyosBG.add(azonosRB);
		toldasBG.add(toldasIgenRB);
		toldasBG.add(toldasNemRB);
		minhosszBG.add(minhosszIgenRB);
		minhosszBG.add(minhosszNemRB);
		kotegBG.add(kotegEgybenRB);
		kotegBG.add(kotegKulonRB);
		mainPanel.setLayout(new BorderLayout());
		settings1Panel.setLayout(new GridLayout(7,2));
		settings1Panel.setBorder(BorderFactory.createTitledBorder("Méretek"));
		settings2Panel.setLayout(new GridLayout(4,1));
		megsemOkPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
	}
	
	@SuppressWarnings("serial")
	public SatortetoDialog(Frame owner) {
		letezikE = true;
		tulaj = (Tetofedes)owner;
		
		setTitle("Sátortetõ");
		setBounds(Tetofedes.middleFramePosition);
		setModal(false);
		setResizable(false);
		
		getContentPane().add(mainPanel);
		
		mainPanel.add(settings1Panel, "West");
		mainPanel.add(settings2Panel, "Center");
		mainPanel.add(megsemOkPanel, "South");
		
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Tetõ oldala:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(oldal1TF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Tetõ másik oldala:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(oldal2TF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Tetõél hossza:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(tetoElTF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Lemezek teljes szélessége:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(lemezTakarasTF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Lemezek hasznos takarása:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(lemezHasznosTF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Biztonsági toldás a lemezekhez:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(toldasTF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT, 20, 2));
						add(new JLabel("Minimális lemezhosszúság:"));
					}
				});
			}
		});
		settings1Panel.add(new JPanel() {
			{
				setLayout(new BorderLayout());
				add(new JPanel() {
					{
						setLayout(new FlowLayout(FlowLayout.LEFT));
						add(minhosszTF);
						add(new JLabel("mm"));
					}
				});
			}
		});
		
		settings2Panel.add(new JPanel() {
			{
				setLayout(new GridLayout(2,1));
				setBorder(BorderFactory.createTitledBorder("Szabályos sátortetõ"));
				add(nemAzonosRB);
				add(azonosRB);
			}
		});
		settings2Panel.add(new JPanel() {
			{
				setLayout(new GridLayout(2,1));
				setBorder(BorderFactory.createTitledBorder("Biztonsági toldás a lemezekhez"));
				add(toldasIgenRB);
				add(toldasNemRB);
			}
		});
		settings2Panel.add(new JPanel() {
			{
				setLayout(new GridLayout(2,1));
				setBorder(BorderFactory.createTitledBorder("Minimális lemezhossz beállítása"));
				add(minhosszIgenRB);
				add(minhosszNemRB);
			}
		});
		settings2Panel.add(new JPanel() {
			{
				setLayout(new GridLayout(2,1));
				setBorder(BorderFactory.createTitledBorder("Lemezek kötegelése"));
				add(kotegEgybenRB);
				add(kotegKulonRB);
			}
		});
		
		megsemOkPanel.setBorder(BorderFactory.createEtchedBorder());
		megsemOkPanel.add(megsemButton, "South");
		megsemOkPanel.add(okButton, "South");
		
		azonosRB.addActionListener(this);
		nemAzonosRB.addActionListener(this);
		toldasIgenRB.addActionListener(this);
		toldasNemRB.addActionListener(this);
		minhosszIgenRB.addActionListener(this);
		minhosszNemRB.addActionListener(this);
		megsemButton.addActionListener(this);
		okButton.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				letezikE = false;
			}
		});
		
		setVisible(true);
	}

	public static boolean getLetezikE() {
		return letezikE;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == megsemButton) {
			setVisible(false);
			letezikE = false;
		}
		if (e.getSource() == azonosRB)
			oldal2TF.setEnabled(false);
		if (e.getSource() == nemAzonosRB)
			oldal2TF.setEnabled(true);
		if (e.getSource() == toldasIgenRB)
			toldasTF.setEnabled(true);
		if (e.getSource() == toldasNemRB)
			toldasTF.setEnabled(false);
		if (e.getSource() == minhosszIgenRB)
			minhosszTF.setEnabled(true);
		if (e.getSource() == minhosszNemRB)
			minhosszTF.setEnabled(false);
		if (e.getSource() == okButton) {
			int oldal1 = 0;
			int oldal2 = 0; 
			int tetoEl = 0;
			int lemezTakaras = 0;
			int lemezHasznos = 0;
			int toldas = 0;
			int minhossz = 0;
			try {
				oldal1 = Integer.parseInt(oldal1TF.getText());
				if (oldal2TF.isEnabled())
					oldal2 = Integer.parseInt(oldal2TF.getText());
				tetoEl = Integer.parseInt(tetoElTF.getText());
				lemezTakaras = Integer.parseInt(lemezTakarasTF.getText());
				lemezHasznos = Integer.parseInt(lemezHasznosTF.getText());
				if (toldasTF.isEnabled())
					toldas = Integer.parseInt(toldasTF.getText());
				if (minhosszTF.isEnabled())
					minhossz = Integer.parseInt(minhosszTF.getText());
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Hibás bevitel!\nHiányzó adat.", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(oldal1 == 0 || (oldal2TF.isEnabled() & oldal2 == 0) || tetoEl == 0 || lemezTakaras == 0 || lemezHasznos == 0 || (toldasTF.isEnabled() & toldas == 0) || (minhosszTF.isEnabled() & minhossz == 0)) {
				JOptionPane.showMessageDialog(this, "Hibás bevitel!\nA 0 érték nem elfogadható!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			} 
			if((oldal1 >= (tetoEl * 2)) || (oldal2 >= (tetoEl * 2))) {
				JOptionPane.showMessageDialog(this, "Hibás bevitel!\nBármelyik oldalnak kisebbnek kell lennie mint a tetõél kétszerese!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(lemezTakaras < lemezHasznos) {
				JOptionPane.showMessageDialog(this, "Hibás bevitel!\nA lemezek teljes szélessége nem lehet kisebb, mint a hasznos takarásuk!", "Hiba", JOptionPane.ERROR_MESSAGE);
				return;
			}
			tulaj.setTextSatorteto(oldal1, oldal2, tetoEl, lemezTakaras, lemezHasznos, toldas, minhossz, kotegEgybenRB.isSelected());
		}
	}
}
